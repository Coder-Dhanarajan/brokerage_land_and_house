package property;

import java.util.ArrayList;

public class SearchCondition{

    public static boolean checkProperty(int i, ArrayList<PropertyData> property, String str) {
        return property.get(i).ownerName.toLowerCase().contains(str) ||
                property.get(i).ownerPhno.toLowerCase().contains(str) ||
                property.get(i).nearbyAreas.toLowerCase().contains(str) ||
                property.get(i).relationBetw_OwnerAndUser.toLowerCase().contains(str) ||
                property.get(i).budget.toLowerCase().contains(str) ||
                property.get(i).description.toLowerCase().contains(str) ||
                //property.get(i).bung_id.toLowerCase().contains(str) ||
                property.get(i).cottId.toLowerCase().contains(str) ||
                property.get(i).ordId.toLowerCase().contains(str) ||
                property.get(i).pgId.toLowerCase().contains(str) ||
                property.get(i).agriId.toLowerCase().contains(str) ||
                property.get(i).commId.toLowerCase().contains(str);
    }

    public static boolean checkBunglaw(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).bungId.equals("") &&
                (//property.get(i).bung_id.contains(str) ||
                        property.get(i).houseAddress.toLowerCase().contains(str) ||
                        property.get(i).bathroomType.toLowerCase().contains(str) ||
                        //property.get(i).ishall.toLowerCase().contains(str) ||
                        property.get(i).kitchensCount.toLowerCase().contains(str) ||
                        property.get(i).bedroomsCount.toLowerCase().contains(str) ||
                        property.get(i).bathroomsCount.toLowerCase().contains(str) ||
                        property.get(i).swimmingpoolCount.toLowerCase().contains(str) ||
                        property.get(i).acCount.toLowerCase().contains(str) ||
                        property.get(i).gardenSize.toLowerCase().contains(str) ||
                        property.get(i).noOfFloors.toLowerCase().contains(str));
    }
    public static boolean checkCottage(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).cottId.equals("") &&
                (//property.get(i).cott_id.contains(str) ||
                        property.get(i).houseAddress.toLowerCase().contains(str) ||
                        property.get(i).bathroomType.toLowerCase().contains(str) ||
                        property.get(i).isHall.toLowerCase().contains(str) ||
                        property.get(i).isKitchen.toLowerCase().contains(str) ||
                        property.get(i).isBedroom.toLowerCase().contains(str) ||
                        property.get(i).isBathroom.toLowerCase().contains(str));
    }
    public static boolean checkOrdinaryHouse(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).ordId.equals("") &&
                (//property.get(i).ord_id.contains(str) ||
                        property.get(i).houseAddress.toLowerCase().contains(str) ||
                        property.get(i).bathroomType.toLowerCase().contains(str) ||
                        //property.get(i).ishall.toLowerCase().contains(str) ||
                        property.get(i).kitchensCount.toLowerCase().contains(str) ||
                        property.get(i).bedroomsCount.toLowerCase().contains(str) ||
                        property.get(i).bathroomsCount.toLowerCase().contains(str) ||
                        property.get(i).acCount.toLowerCase().contains(str));
    }
    public static boolean checkPG(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).pgId.equals("") &&
                (//property.get(i).pg_id.contains(str) ||
                        property.get(i).houseAddress.toLowerCase().contains(str) ||
                        property.get(i).bathroomType.toLowerCase().contains(str) ||
                        property.get(i).noOfBeds.toLowerCase().contains(str) ||
                        property.get(i).isAc.toLowerCase().contains(str));
    }
    public static boolean checkAgriLand(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).agriId.equals("") &&
                (//property.get(i).agri_id.contains(str) ||
                        property.get(i).landAddress.toLowerCase().contains(str) ||
                        property.get(i).landSize.toLowerCase().contains(str));
    }
    public static boolean checkCommLand(int i, ArrayList<PropertyData> property, String str) {
        return !property.get(i).commId.equals("") &&
                (//property.get(i).land_address.contains(str) ||
                        property.get(i).landSize.toLowerCase().contains(str)
                        || property.get(i).commercialType.toLowerCase().contains(str));
    }

}