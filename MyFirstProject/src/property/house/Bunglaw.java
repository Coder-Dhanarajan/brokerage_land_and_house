package property.house;

import property.PropertyData;

import java.util.ArrayList;

public interface Bunglaw {
    PropertyData addBunglaw(int k);
    void updateBunglaw(int k, ArrayList<PropertyData> property);
    void printBung(int i, ArrayList<PropertyData> property);

}