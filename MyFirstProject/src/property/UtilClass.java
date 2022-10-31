package property;

import useraccount.HandleException;
import useraccount.UserValidation;
import java.util.*;

import static property.PropertyOperations.*;

public class UtilClass {
    static Scanner sc=new Scanner(System.in);
    public static boolean compare(String id,int index){
        return PropertyOperations.getThisProperty(index).bungId.equals(id) ||
                PropertyOperations.getThisProperty(index).cottId.equals(id) ||
                PropertyOperations.getThisProperty(index).ordId.equals(id) ||
                PropertyOperations.getThisProperty(index).pgId.equals(id) ||
                PropertyOperations.getThisProperty(index).agriId.equals(id) ||
                PropertyOperations.getThisProperty(index).commId.equals(id);
    }
    public static boolean checkAlreadyAddedWishList(String id,int userid){
        for(int i = 0; i< PropertyOperations.wishList.size(); i++){
            if(PropertyOperations.wishList.get(i).propId.equals(id) &&
                    PropertyOperations.wishList.get(i).userId ==userid){
                System.out.println("Already exists");
                return true;
            }
        }
        return false;
    }


    public static String relation(PropertyData dataMngr, String name){
        int opt = sc.nextInt();
        String relation_name="";
        switch (opt) {
            case 1 -> relation_name=name;
            case 2 -> {
                System.out.println("""
                        Enter the option:
                        1. Mother/Father
                        2. Uncle/Aunt
                        3. Grandparents
                        4. Brother/Sister
                        5. Cousins
                        Enter any integer if the above choices are not matched.. It will convert into 'Neighbours'""");
                int option = HandleException.correctInput();
                switch (option) {
                    case 1 -> dataMngr.relationBetw_OwnerAndUser = "Mother/Father";
                    case 2 -> dataMngr.relationBetw_OwnerAndUser = "Uncle/Aunt";
                    case 3 -> dataMngr.relationBetw_OwnerAndUser = "Grandparents";
                    case 4 -> dataMngr.relationBetw_OwnerAndUser = "Brother/Sister";
                    case 5 -> dataMngr.relationBetw_OwnerAndUser = "Cousins";
                    default -> dataMngr.relationBetw_OwnerAndUser = "Neighbours";
                }
                System.out.print("Enter the Owner name:\t");
                relation_name= UserValidation.propertyTextValidate();
            }
        }
        if(relation_name.equals("")) return relation(dataMngr, name);
        else return relation_name;
    }
    public static String optionTypeQuestion(int temp_data){
        return switch (temp_data) {
            case 1 -> "Only 1";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "Above 3";
            default -> "Not mentioned...";
        };
    }

    public static void filterHouse(int choice) {
        switch (choice) {
            case 1 -> Filter.filterBunglaw(property, bunglaw);
            case 2 -> Filter.filterCottage(property, cottage);
            case 3 -> Filter.filterOrdinaryHouse(property, ordinaryHouse);
            case 4 -> Filter.filterPG(property, pg);
            case 5 -> Filter.filterOnlyBookedHouse(property, bunglaw, cottage, ordinaryHouse, pg);
            case 6 -> Filter.filterOnlyAvailableHouse(property, bunglaw, cottage, ordinaryHouse, pg);
            case 7 -> Filter.filter1BHKHouse(property, bunglaw, ordinaryHouse,pg);
            case 8 -> Filter.filter2BHKHouse(property, bunglaw, ordinaryHouse,pg);
            case 9 -> Filter.filter3BHKHouse(property, bunglaw, ordinaryHouse,pg);
            case 10 -> Filter.filterAbove3BHKHouse(property, bunglaw, ordinaryHouse,pg);
            case 11 -> Filter.filterHouse(property, bunglaw, ordinaryHouse,pg,cottage);
            default -> System.out.println("Invalid choice");
        }

    }

    public static void filterLand(int choice) {
        switch (choice) {
            case 1 -> Filter.filterAgriculturalLand(property, agriculturalLand);
            case 2 -> Filter.filterCommercialLand(property, commercialLand);
            case 3 -> Filter.filterOnlyBookedLand(property, agriculturalLand, commercialLand);
            case 4 -> Filter.filterOnlyAvailableLand(property, agriculturalLand, commercialLand);
            case 5 -> Filter.filterLand(property, agriculturalLand, commercialLand);
            default -> System.out.println("Invalid choice");
        }
    }

    public static boolean CheckForSearchEngine(int i, String str) {
        return SearchCondition.checkProperty(i,property,str) ||
                SearchCondition.checkBunglaw(i,property,str)||
                SearchCondition.checkOrdinaryHouse(i,property,str)||
                SearchCondition.checkCottage(i,property,str) ||
                SearchCondition.checkPG(i,property,str) ||
                SearchCondition.checkAgriLand(i,property,str) ||
                SearchCondition.checkCommLand(i,property,str);
    }

    //CHECK THE PROPERTY TYPE THROUGH ITS ID
    public static boolean checkThisPropertyType(int i, String ch){
        return getThisProperty(i).bungId.equals(ch) || getThisProperty(i).cottId.equals(ch) || getThisProperty(i).ordId.equals(ch)
                || getThisProperty(i).pgId.equals(ch) || getThisProperty(i).agriId.equals(ch) ||
                getThisProperty(i).commId.equals(ch);
    }

}