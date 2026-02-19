package pt.isel.mpd.beverages;

import pt.isel.mpd.values.BeverageSize;
import pt.isel.mpd.values.Money;
import pt.isel.mpd.values.NutritionalInfo;

public interface Beverage {
    String id();
    double basePrice();
    NutritionalInfo nutInfo();
    String description();
    String descriptionDetail();
    BeverageSize size();
}
