package property.land;

import property.PropertyData;

import java.util.ArrayList;

public interface CommercialLand {
    PropertyData addCommercialLand(int k);
    void updateCommercialLand(int k, ArrayList<PropertyData> property);
    void printCommercialLand(int i, ArrayList<PropertyData> property);
}
