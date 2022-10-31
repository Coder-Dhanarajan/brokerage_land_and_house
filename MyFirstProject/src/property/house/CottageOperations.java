package property.house;

import property.PropertyOperations;
import property.PropertyData;

import java.util.*;
public class CottageOperations extends House implements Cottage{
    Scanner sc=new Scanner(System.in);
    static int id=3001;

    //ADD COTTAGE
    @Override
    public PropertyData addCottage(int userid){
        PropertyData dataMngr2 = addHouse();
        dataMngr2.cottId =userid+"CH"+ ++id;

        System.out.print("Is Hall? (Y/N)");
        String temp = sc.nextLine();
        dataMngr2.isHall = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";

        System.out.print("Is Bedroom? (Y/N)");
        temp=sc.nextLine();
        dataMngr2.isBedroom = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";

        System.out.print("Is Bathroom? (Y/N)");
        temp=sc.nextLine();
        dataMngr2.isBathroom = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";

        System.out.print("Is Kitchen? (Y/N)");
        temp=sc.nextLine();
        dataMngr2.isKitchen = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";

        return dataMngr2;
    }

    //UPDATE COTTAGE
    @Override
    public void updateCottage(int i, ArrayList<PropertyData> property) {
        updateHouse(i);
        System.out.println("Can I Update isHall? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Is Hall? (Y/N)");
            String temp = sc.nextLine();
            PropertyOperations.getThisProperty(i).isHall = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";
        }
        System.out.println("Can I Update iskitchen? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Is Kitchen? (Y/N)");
            String temp = sc.nextLine();
            PropertyOperations.getThisProperty(i).isKitchen = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";
        }
        System.out.println("Can I Update isBedroom? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Is Bedroom? (Y/N)");
            String temp = sc.nextLine();
            PropertyOperations.getThisProperty(i).isBedroom = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";
        }
        System.out.println("Can I Update isBathroom? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Is Bathroom? (Y/N)");
            String temp = sc.nextLine();
            PropertyOperations.getThisProperty(i).isBathroom = (temp.equals("Y") || temp.equals("y"))?"Yes":"No";
        }

    }

    //PRINT COTTAGE
    @Override
    public void printCottage(int i, ArrayList<PropertyData> property){
        System.out.println("*****************************");
        System.out.println("Property ID:" + PropertyOperations.getThisProperty(i).cottId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printHouse(i);
        System.out.println("Hall: " + PropertyOperations.getThisProperty(i).isHall
                + "\nBedroom: " + PropertyOperations.getThisProperty(i).isBedroom
                + "\nBathroom: " + PropertyOperations.getThisProperty(i).isBathroom
                + "\nKitchen: " + PropertyOperations.getThisProperty(i).isKitchen);
    }

}