package property.land;
import property.PropertyOperations;
import property.PropertyData;
import useraccount.UserValidation;

import java.util.*;
public abstract class Land{
    static Scanner sc=new Scanner(System.in);
    public static PropertyData addLand(){
        PropertyData dataMngr= PropertyOperations.addProperty();
        System.out.print("Land Address:");
        dataMngr.landAddress =UserValidation.propertyTextValidate();
        System.out.print("Land Size:");
        dataMngr.landSize = UserValidation.propertyTextValidate();
        return dataMngr;
    }
    public static void updateLand(int i){
        PropertyOperations.update(i);
        System.out.println("Can I Update Land Address? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Land Address:");
            PropertyOperations.getThisProperty(i).landAddress = UserValidation.propertyTextValidate();
        }
        System.out.println("Can I Update Land Size? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Land Size:");
            PropertyOperations.getThisProperty(i).landSize = UserValidation.propertyTextValidate();
        }
    }
    public static void printLand(int i) {
        System.out.println("House Address: " + PropertyOperations.getThisProperty(i).landAddress);
        System.out.println("Land Size: " + PropertyOperations.getThisProperty(i).landSize);
    }
}