package property.house;

import property.PropertyData;

import java.util.ArrayList;

public interface Cottage {
    PropertyData addCottage(int k);
    void updateCottage(int k, ArrayList<PropertyData> property);
    void printCottage(int i, ArrayList<PropertyData> property);

}