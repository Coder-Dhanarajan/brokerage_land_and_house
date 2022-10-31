package property.house;

import property.PropertyData;

import java.util.ArrayList;

public interface PG {
    PropertyData addPG(int k);
    void updatePG(int k, ArrayList<PropertyData> property);
    void printPG(int i, ArrayList<PropertyData> property);
}