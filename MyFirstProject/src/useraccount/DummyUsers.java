package useraccount;
import  java.util.*;
import property.*;
public class DummyUsers{
    public static void dummy(ArrayList<UserDataManager> data, int uid){
        data.add(new UserDataManager("Dhana","dhana@gmail.com","Dhana@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
        data.add(new UserDataManager("Rajan","rajan@gmail.com","Rajan@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
        data.add(new UserDataManager("Shiva","shiva123@gmail.com","Shiva@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
        data.add(new UserDataManager("Ram","ramvasu@gmail.com","Ram@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
        data.add(new UserDataManager("Divya","divi@gmail.com","Divya@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
        data.add(new UserDataManager("Lakshmi","lakshmi1990@gmail.com","Lakshmi@123",++uid));
        DummyProperty.addDummyProperty(PropertyOperations.property,uid);
    }
}