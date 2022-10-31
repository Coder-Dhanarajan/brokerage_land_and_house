package property.land;
import property.PropertyOperations;
import property.PropertyData;
import java.util.ArrayList;

public class AgriOperations extends Land implements AgriculturalLand{
    static int id=7001;
    @Override
    public PropertyData addAgriLand(int userid){
        PropertyData dataMngr6=addLand();
        dataMngr6.usId =userid;
        dataMngr6.agriId =userid+"AL"+ ++id;;
        return dataMngr6;
    }

    @Override
    public void updateAgriLand(int i, ArrayList<PropertyData> property){
        updateLand(i);
    }

    @Override
    public void printAgri(int i, ArrayList<PropertyData> property){
        System.out.println("*****************************");
        System.out.println("Property ID:" + PropertyOperations.getThisProperty(i).agriId);
        System.out.println("*****************************");
        PropertyOperations.printProperty(i);
        printLand(i);
    }




}