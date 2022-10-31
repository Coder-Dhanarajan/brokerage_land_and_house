package property.land;

import property.PropertyData;

import java.util.ArrayList;

public interface AgriculturalLand {
    PropertyData addAgriLand(int k);
    void updateAgriLand(int k, ArrayList<PropertyData> property);
    void printAgri(int i, ArrayList<PropertyData> property);
}