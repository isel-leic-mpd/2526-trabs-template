package pt.isel.mpd.comercial;

import pt.isel.mpd.beverages.Beverage;
import pt.isel.mpd.factories.BeverageFactory;
import pt.isel.mpd.factories.BeverageFactoryDictionary;
import pt.isel.mpd.values.BeverageSize;
import pt.isel.mpd.exceptions.InvalidOrderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Order sintax:
 *   {small | medium | large} {classic | vegan}  {coffee | chocolate}  and { chantilly | caramel}
 *   ex: large classic chocolate  and caramel
 */
public class OrderParser {
    private BeverageFactoryDictionary factories;
    public OrderParser(BeverageFactoryDictionary factories) {
        this.factories = factories;
    }

    public Beverage parseOrderLine(String orderLine) throws InvalidOrderException {

        String[] parts = orderLine.trim().split("\s+");
        if (parts.length > 5) {
            throw new InvalidOrderException();
        }
        BeverageFactory factory = switch(parts[1]) {
            case "vegan", "classic" -> factories.fromName(parts[1]);
            default ->  throw new InvalidOrderException();
        };

        BeverageSize size = switch(parts[0]) {
            case "small" -> BeverageSize.Small;
            case "medium" -> BeverageSize.Medium;
            case "large" -> BeverageSize.Large;
            default ->  throw new InvalidOrderException();
        };
        Beverage beverage = switch(parts[2]) {
            case "coffee" -> factory.createCoffee(size);
            case "chocolate" -> factory.createChocolate(size);
            default -> throw new InvalidOrderException();
        };

        Beverage withTopper = null;
        if (parts[3].equals("and")) {
            withTopper = switch(parts[4]) {
                case "chantilly" -> factory.createChantillyTopper(beverage);
                case "caramel" -> factory.createCaramelTopper(beverage);
                default -> throw new InvalidOrderException();
            };
        }
        return withTopper == null ? beverage : withTopper;
    }

    public List<Beverage> parseOrder(String order) throws InvalidOrderException, IOException {
        BufferedReader orderReader = new BufferedReader(new StringReader(order));
        var beverages = new ArrayList<Beverage>();

        String orderLine;
        while ((orderLine = orderReader.readLine()) != null) {
            beverages.add(parseOrderLine(orderLine));
        }
        return beverages;
    }
}
