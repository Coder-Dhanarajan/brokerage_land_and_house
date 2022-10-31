package property.house;

import property.PropertyOperations;
import property.UtilClass;
import property.PropertyData;
import useraccount.HandleException;

import java.util.*;
public class OrdinaryHouseOperations extends House implements OrdinaryHouse{
    Scanner sc=new Scanner(System.in);
    static int id=5001;

    //ADD ORDINARY HOUSE
    @Override
    public PropertyData addOrdinaryHouse(int userid){
        PropertyData dataMngr4=addHouse();

        dataMngr4.ordId =userid+"OH"+ ++id;

        System.out.print("Kitchens count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        int temp_data= HandleException.correctInput();
        dataMngr4.kitchensCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Bathrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr4.bathroomsCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Bedrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr4.bedroomsCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("AC count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr4.acCount = UtilClass.optionTypeQuestion(temp_data);

        return dataMngr4;

    }

    //UPDATE ORDINARY HOUSE
    @Override
    public void updateOrdHouse(int i, ArrayList<PropertyData> property) {
        updateHouse(i);
        System.out.println("Can I Update kitchens count? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Kitchens count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data= HandleException.correctInput();
            PropertyOperations.getThisProperty(i).kitchensCount = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update Bedrooms Count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Bedrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).bedroomsCount = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update Bathrooms Count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Bathrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).bathroomsCount = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update AC Count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("AC count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).acCount = UtilClass.optionTypeQuestion(temp_data);
        }
    }

    //PRINT ORDINARY HOUSE
    @Override
    public void printOrdinaryHouse(int i, ArrayList<PropertyData> property){
        System.out.println("*****************************");
        System.out.println("Property ID: " + PropertyOperations.getThisProperty(i).ordId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printHouse(i);
        System.out.println("Kitchens count: " + PropertyOperations.getThisProperty(i).kitchensCount
                + "\nNo of bedrooms: " + PropertyOperations.getThisProperty(i).bedroomsCount
                + "\nNo of bathrooms: " + PropertyOperations.getThisProperty(i).bathroomsCount
                + "\nAC count: " + PropertyOperations.getThisProperty(i).acCount);
    }


}