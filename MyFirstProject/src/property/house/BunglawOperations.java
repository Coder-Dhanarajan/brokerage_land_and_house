package property.house;

import property.PropertyOperations;
import property.UtilClass;
import property.PropertyData;
import useraccount.HandleException;
import useraccount.UserValidation;

import java.util.*;
public class BunglawOperations extends House implements Bunglaw{
    Scanner sc=new Scanner(System.in);
    static int id=2001;
    @Override
    public PropertyData addBunglaw(int userid){
        PropertyData dataMngr1 = addHouse();
        dataMngr1.bungId =userid+"BH"+ ++id;

        System.out.print("Kitchens count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        int temp_data=HandleException.correctInput();
        dataMngr1.kitchensCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Bathrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr1.bathroomsCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Bedrooms count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr1.bedroomsCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Swimming pool count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr1.swimmingpoolCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Number of Floors 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr1.noOfFloors = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("AC count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        temp_data=HandleException.correctInput();
        dataMngr1.acCount = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Garden size:");
        dataMngr1.gardenSize = UserValidation.propertyTextValidate();

        return dataMngr1;
    }

    //UPDATE BUNGLAW
    @Override
    public void updateBunglaw(int i, ArrayList<PropertyData> property) {
        updateHouse(i);
        System.out.println("Can I Update kitchens count? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Kitchens count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
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
        System.out.println("Can I Update Swimming pool count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Swimming pool count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).swimmingpoolCount = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update AC Count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).acCount = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update Garden size? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            PropertyOperations.getThisProperty(i).gardenSize =UserValidation.propertyTextValidate();
        }
        System.out.println("Can I Update Floors count? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Floors count 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).noOfFloors = UtilClass.optionTypeQuestion(temp_data);
        }
    }

    //DELETE BUNGLAW
    @Override
    public void printBung(int i, ArrayList<PropertyData> property) {
        System.out.println("*****************************");
        System.out.println("Property ID: " + PropertyOperations.getThisProperty(i).bungId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printHouse(i);
        System.out.println("Kitchens count: " + PropertyOperations.getThisProperty(i).kitchensCount
                + "\nNo of bedrooms: " + PropertyOperations.getThisProperty(i).bedroomsCount
                + "\nNo of bathrooms: " + PropertyOperations.getThisProperty(i).bathroomsCount
                + "\nSwimming pool count: " + PropertyOperations.getThisProperty(i).swimmingpoolCount
                + "\nNo of floors: " + PropertyOperations.getThisProperty(i).noOfFloors
                + "\nAC count: " + PropertyOperations.getThisProperty(i).acCount
                + "\nGarden size: " + PropertyOperations.getThisProperty(i).gardenSize);
    }
}