package pt.isel.pc;

import org.junit.jupiter.api.Test;
import pt.isel.mpd.beverages.Beverage;
import pt.isel.mpd.comercial.OrderParser;
import pt.isel.mpd.exceptions.InvalidOrderException;
import pt.isel.mpd.factories.BeverageFactoryDictionary;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {

    @Test
    public void beverageOrderParserTest() throws IOException, InvalidOrderException {
        String order =  """ 
                         medium classic  chocolate and caramel
                         large vegan coffee and chantilly
                         large classic coffee
                        """;
        BeverageFactoryDictionary fd = new BeverageFactoryDictionary();
        OrderParser parser = new OrderParser(fd);
        List<Beverage> beverages = parser.parseOrder(order);
        assertEquals(2, beverages.size());

        System.out.println(beverages.get(0));
        System.out.println(beverages.get(1));
    }
}
