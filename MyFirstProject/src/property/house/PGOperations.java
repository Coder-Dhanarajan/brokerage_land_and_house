package property.house;

import property.PropertyOperations;
import property.UtilClass;
import property.PropertyData;
import useraccount.HandleException;

import java.util.*;
public class PGOperations extends House implements PG{
    Scanner sc=new Scanner(System.in);
    static int id=4001;

    //ADD PG HOUSE
    @Override
    public PropertyData addPG(int userid){

        PropertyData dataMngr3= addHouse();

        dataMngr3.pgId =userid+"PGH"+ ++id;

        System.out.print("Number of beds 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
        int temp_data= HandleException.correctInput();
        dataMngr3.noOfBeds = UtilClass.optionTypeQuestion(temp_data);

        System.out.print("Is AC? (Y/N)");
        String temp=sc.nextLine();
        dataMngr3.isAc =(temp.equals("Y") || temp.equals("y"))?"Yes":"No";

        return dataMngr3;
    }

    //UPDATE PG HOUSE
    @Override
    public void updatePG(int i, ArrayList<PropertyData> property) {
        updateHouse(i);
        System.out.println("Can I Update Beds Count? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("No of beds 1.(Only 1)\t 2.(2)\t 3.(3) \t 4.(above 3):");
            int temp_data=HandleException.correctInput();
            PropertyOperations.getThisProperty(i).noOfBeds = UtilClass.optionTypeQuestion(temp_data);
        }
        System.out.println("Can I Update is AC? (Y/N)");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            String temp=sc.nextLine();
            PropertyOperations.getThisProperty(i).isAc =(temp.equals("Y") || temp.equals("y"))?"Yes":"No";
        }
    }

    //PRINT PG HOUSE
    @Override
    public void printPG(int i, ArrayList<PropertyData> property) {
        System.out.println("*****************************");
        System.out.println("Property ID:" + PropertyOperations.getThisProperty(i).pgId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printHouse(i);
        System.out.println("No of beds: " + PropertyOperations.getThisProperty(i).noOfBeds
                + "\nAC: " + PropertyOperations.getThisProperty(i).isAc);
    }


}