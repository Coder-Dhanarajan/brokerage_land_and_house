package property.house;
import property.PropertyOperations;
import property.PropertyData;
import useraccount.HandleException;
import useraccount.UserValidation;

import java.util.*;

public abstract class House{

    static Scanner sc=new Scanner(System.in);
    //ADD HOUSE
    public static PropertyData addHouse(){
        PropertyData dataMngr = PropertyOperations.addProperty();
        System.out.print("House Address:");
        dataMngr.houseAddress = UserValidation.propertyTextValidate();
        System.out.print("Bathroom type -> 1.Attached 2.Separated 3.Both:");
        int temp_data= HandleException.correctInput();
        if(temp_data==1)
            dataMngr.bathroomType ="Attached";
        else if(temp_data==2)
            dataMngr.bathroomType ="Separated";
        else if(temp_data==3)
            dataMngr.bathroomType ="Both attached and separated";
        return dataMngr;
    }

    //UPDATE HOUSE
    public static void updateHouse(int i){
        PropertyOperations.update(i);
        System.out.println("Can I Update House Address? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("House Address:");
            PropertyOperations.getThisProperty(i).houseAddress = UserValidation.propertyTextValidate();
        }

        System.out.println("Can I Update Bathroom type? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")){
            System.out.print("Bathroom type -> 1.Attached 2.Separated 3.Both:");
            int temp_data= HandleException.correctInput();
            if(temp_data==1)
                PropertyOperations.getThisProperty(i).bathroomType ="Attached";
            else if(temp_data==2)
                PropertyOperations.getThisProperty(i).bathroomType ="Separated";
            else if(temp_data==3)
                PropertyOperations.getThisProperty(i).bathroomType
                        ="Both attached and separated";
        }
    }

    //PRINT HOUSE
    public static void printHouse(int i) {
        System.out.println("House Address: " + PropertyOperations.getThisProperty(i).houseAddress);
        System.out.println("Bathroom type: " +
                PropertyOperations.getThisProperty(i).bathroomType);
    }

}