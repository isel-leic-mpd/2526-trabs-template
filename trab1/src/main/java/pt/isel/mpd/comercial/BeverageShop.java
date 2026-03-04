package pt.isel.mpd.comercial;

import pt.isel.mpd.exceptions.InvalidOrderException;
import pt.isel.mpd.factories.BeverageFactoryDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BeverageShop  {
    private final OrderParser parser;
    public BeverageShop(OrderParser parser) {
        this.parser = parser;
    }

    public void processOrder(Order order) {
        // TO IMPLEMENT
    }

    private void processError(Exception e, String cmd) {
        // Assume it is already implemented
    }

    public void processOrder(String cmd) {
        try {
            processOrder(new Order(parser.parseOrder(cmd)));
        }
        catch(InvalidOrderException | IOException  e ) {
            processError(e, cmd);
        }

    }

    private String convertToMultiline(String str) {
        // Assume it is already implemented
        return str;
    }

    static void main() throws IOException {
        BeverageFactoryDictionary fd = new BeverageFactoryDictionary();

        BeverageShop shop = new BeverageShop(new OrderParser(fd));

        System.out.println("shop opened");
        System.out.println();
        String cmd;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        while ((cmd = inputReader.readLine()) != null && !cmd.equals("bye")) {
            shop.processOrder((cmd));
        }
        System.out.println();
        System.out.println("shop closed");
    }

}
