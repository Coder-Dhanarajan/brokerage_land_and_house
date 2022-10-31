package property.land;

import property.PropertyOperations;
import property.PropertyData;
import useraccount.HandleException;

import java.util.*;
public class CommercialOperations extends Land implements CommercialLand{
    static int id=6001;
    static Scanner sc=new Scanner(System.in);
    @Override
    public PropertyData addCommercialLand(int userid) {

        PropertyData dataMngr5 = addLand();
        dataMngr5.usId = userid;
        dataMngr5.commId =userid+"CL"+ ++id;
        System.out.print("Commercial Type -> 1.Industry\t 2.Hospital\t 3.Educational institutions" +
                "\t 4.Apartments\t 5.Others:");
        int temp_data = HandleException.correctInput();
        if (temp_data == 1)
            dataMngr5.commercialType = "Industry";
        else if (temp_data == 2)
            dataMngr5.commercialType = "Hospital";
        else if (temp_data == 3)
            dataMngr5.commercialType = "Educational institutions";
        else if (temp_data == 4)
            dataMngr5.commercialType = "Apartments";
        else if (temp_data == 5){
            System.out.print("If Others, please enter the type: ");
            dataMngr5.commercialType = sc.nextLine();
        }
        return dataMngr5;
    }

    @Override
    public void updateCommercialLand(int i, ArrayList<PropertyData> property) {
        updateLand(i);
        System.out.println("Can I Update isHall? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Commercial Type -> 1.Industry\t 2.Hospital\t 3.Educational institutions" +
                    "\t 4.Apartments\t 5.Others:");
            int temp_data = HandleException.correctInput();
            if (temp_data == 1)
                PropertyOperations.getThisProperty(i).commercialType = "Industry";
            else if (temp_data == 2)
                PropertyOperations.getThisProperty(i).commercialType = "Hospital";
            else if (temp_data == 3)
                PropertyOperations.getThisProperty(i).commercialType = "Educational institutions";
            else if (temp_data == 4)
                PropertyOperations.getThisProperty(i).commercialType = "Apartments";
            else if (temp_data == 5){
                System.out.print("If Others, please enter the type: ");
                PropertyOperations.getThisProperty(i).commercialType = sc.nextLine();
            }
        }
    }

    @Override
    public void printCommercialLand(int i, ArrayList<PropertyData> property){
        System.out.println("*****************************");
        System.out.println("Property ID:" + PropertyOperations.getThisProperty(i).commId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printLand(i);
        System.out.println("Commercial Type: " + PropertyOperations.getThisProperty(i).commercialType);
    }


}