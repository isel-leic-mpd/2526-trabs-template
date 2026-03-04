package pt.isel.mpd.factories;

import java.util.HashMap;
import java.util.Map;

public class BeverageFactoryDictionary {
    private Map<String, BeverageFactory> factories;

    public BeverageFactoryDictionary() {
        factories = new HashMap<>();
        factories.put("classic", null /* to change */);
        factories.put("vegan", null /* to change */);
    }

    public BeverageFactory fromName(String name) {
        return factories.get(name);
    }

}
