package pt.isel.pc;

import org.junit.jupiter.api.Test;
import pt.isel.mpd.beverages.Beverage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BeverageTests {

    /**
     * to complete
     * consider the description of a beverage composed by the type and
     * size of the beverage (for example a Coffee in a Large cup should return the string
     * "Large coffee")
     */
    @Test
    public void assertCorrectBeverageDescription() {
        String expected = "Large coffee";
        Beverage beverage1 = null; // change to the desired instantiation
        assertEquals(expected, beverage1.description());
    }


    /**
     * to complete
     * Instantiate the beverages beverage1, beverage2 and beverage as 3 different
     * Beverage instances, in order the test succeed.
     *
     */
    @Test
    public void checkEqualityForThreeDifferentBeverages() {
        Beverage beverage1 = null; // change to the desired instantiation
        Beverage beverage2 = null; // change to the desired instantiation
        Beverage beverage3 = null; // change to the desired instantiation
        assertEquals(beverage1, beverage2);
        assertNotEquals(beverage1, beverage3);
        assertNotEquals(beverage2, beverage3);
    }

    @Test
    public void checkDescriptionOfDifferentBeverages() {
        Beverage beverage1 = null; // change to the desired instantiation
        Beverage beverage2 = null; // change to the desired instantiation
        Beverage beverage3 = null; // change to the desired instantiation

        String expectedDesc1 = "Small coffee";
        String expectedDesc2 = "Medium coffee";
        String expectedDesc3 = "Large coffee";

        assertEquals(expectedDesc1, beverage1.description());
        assertEquals(expectedDesc2, beverage2.description());
        assertEquals(expectedDesc3, beverage3.description());
    }

    @Test
    public void checkBasePriceOfDifferentBeverages() {
        Beverage beverage1 = null; // change to the desired instantiation
        Beverage beverage2 = null; // change to the desired instantiation
        Beverage beverage3 = null; // change to the desired instantiation

        double expectedDesc1 = 1.5;
        double expectedDesc2 = 3;
        double expectedDesc3 = 4.5;

        assertEquals(expectedDesc1, beverage1.basePrice());
        assertEquals(expectedDesc2, beverage2.basePrice());
        assertEquals(expectedDesc3, beverage3.basePrice());
    }

    private String normalize(String str) {
        return str.replaceAll("\\r?\\n", "");
    }

    @Test
    void checkBeverageDescriptionDetail() {
        Beverage b1 = null; // change to the desired instantiation


        String descriptionExpected =
                """
                Large chocolate
                NutritionalInfo[calories=48, sugar=12]
                Base price : Money[amount=4.5]""";
        descriptionExpected = normalize(descriptionExpected);

        String observed = normalize(b1.descriptionDetail());
        assertEquals(descriptionExpected, b1.descriptionDetail());
    }

}
