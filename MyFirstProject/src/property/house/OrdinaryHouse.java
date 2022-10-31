package property.house;

import property.PropertyData;

import java.util.ArrayList;

public interface OrdinaryHouse {
    PropertyData addOrdinaryHouse(int k);
    void updateOrdHouse(int k, ArrayList<PropertyData> property);
    void printOrdinaryHouse(int i, ArrayList<PropertyData> property);
}