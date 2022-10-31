package property;
import java.util.*;
import property.house.*;
import property.land.*;
import useraccount.HandleException;
import useraccount.UserValidation;

import static property.PropertyOptions.userid;

public class PropertyOperations {
    public static ArrayList<PropertyData> property = new ArrayList<>();
    static ArrayList<WishList> wishList = new ArrayList<>();
    public static String name;
    public static Bunglaw bunglaw=new BunglawOperations();
    public static Cottage cottage=new CottageOperations();
    public static OrdinaryHouse ordinaryHouse=new OrdinaryHouseOperations();
    public static PG pg=new PGOperations();
    public static AgriculturalLand agriculturalLand=new AgriOperations();
    public static CommercialLand commercialLand=new CommercialOperations();
    static Scanner sc=new Scanner(System.in);

    //GET CURRENT PROPERTY
    public static PropertyData getThisProperty(int index){
        return property.get(index);
    }

    //ADD
    public static PropertyData addProperty(){
        PropertyData dataMngr=new PropertyData();
        dataMngr.usId =userid;
        System.out.print("Owner Relation (If you are the owner, just enter '1'. else, enter '2'):\t");
        dataMngr.ownerName = UtilClass.relation(dataMngr,name);
        System.out.print("Owner Phno:\t");
        dataMngr.ownerPhno =UserValidation.propertyPhnoValidate();
        System.out.print("Nearby areas:\t");
        dataMngr.nearbyAreas =UserValidation.propertyTextValidate();
        System.out.print("Price (in Rs.):\t");
        dataMngr.budget=UserValidation.propertyTextValidate();
        System.out.print("Description(mandatory):\t");
        dataMngr.description=UserValidation.propertyTextValidate();
        return dataMngr;

    }
    //ADD BUNGLAW
    public static void add_bunglaw(int userid){
        property.add(bunglaw.addBunglaw(userid));
        System.out.println("Bunglaw House Added Successfully...");
    }
    //ADD COTTAGE
    public static void add_cottage(int userid){
        property.add(cottage.addCottage(userid));
        System.out.println("Cottage House Added Successfully...");
    }
    //ADD PG
    public static void add_pg(int userid){
        property.add(pg.addPG(userid));
        System.out.println("PG House Added Successfully...");
    }
    //ADD ORDINARY HOUSE
    public static void add_Ordinary(int userid){
        property.add(ordinaryHouse.addOrdinaryHouse(userid));
        System.out.println("Ordinary House Added Successfully...");
    }
    //ADD AGRI LAND
    public static void add_AgriLand(int userid){
        property.add(agriculturalLand.addAgriLand(userid));
        System.out.println("Agricultural Land Added Successfully...");
    }
    //ADD COMMERCIAL LAND
    public static void add_commercialLand(int userid){
        property.add(commercialLand.addCommercialLand(userid));
        System.out.println("Commercial Land Added Successfully...");
    }

    //UPDATE
    public static void update(int i) {
        System.out.println("Can I Update Owner Phone? ");
        String acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Owner Phone number: ");
            getThisProperty(i).ownerPhno = UserValidation.propertyPhnoValidate();
        }

        System.out.println("Can I Update Nearby areas? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Nearby areas: ");
            getThisProperty(i).nearbyAreas = UserValidation.propertyTextValidate();
        }

        System.out.println("Can I Update Price (in Rs.)? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Price (in Rs.): ");
            getThisProperty(i).budget = UserValidation.propertyTextValidate();
        }

        System.out.println("Can I Update Description(mandatory)? ");
        acknowledge=sc.nextLine();
        if(acknowledge.equals("YES")) {
            System.out.print("Description(mandatory): ");
            getThisProperty(i).description = UserValidation.propertyTextValidate();
        }
    }
    //STORE UPDATED USERNAME TO THE PROPERTY
    public static void setUpdatedUserName(String new_name){
        for (PropertyData propertyData : property) {
            if (propertyData.bookedMemberUserID==userid) {
                propertyData.bookedMember = new_name;
            }
            if (propertyData.usId ==userid && propertyData.relationBetw_OwnerAndUser.equals("Self")) {
                propertyData.ownerName = new_name;
            }
        }
    }
    public static void updateProperty(String ch, int userid){
        boolean updateStatus=false;
        for(int i=0;i<property.size();i++){
            if(getThisProperty(i).usId == userid){
                if(getThisProperty(i).bungId.equals(ch)){
                    bunglaw.updateBunglaw(i,property);
                    updateStatus=true;
                }
                else if(getThisProperty(i).cottId.equals(ch)){
                    cottage.updateCottage(i,property);
                    updateStatus=true;
                }
                else if(getThisProperty(i).ordId.equals(ch)){
                    ordinaryHouse.updateOrdHouse(i,property);
                    updateStatus=true;
                }
                else if(getThisProperty(i).pgId.equals(ch)){
                    pg.updatePG(i,property);
                    updateStatus=true;
                }
                else if(getThisProperty(i).agriId.equals(ch)){
                    agriculturalLand.updateAgriLand(i,property);
                    updateStatus=true;
                }
                else if(getThisProperty(i).commId.equals(ch)){
                    commercialLand.updateCommercialLand(i,property);
                    updateStatus=true;
                }
            }
        }
        if(!updateStatus){
            System.out.println("Can't update...");
        }
        else{
            System.out.println("Updated Successfully...");
        }
    }

    //DELETE
    public static void deleteMyProperty(String ch,int userid) {
        for(int i=0;i<property.size();i++){
            if(getThisProperty(i).usId ==userid && UtilClass.checkThisPropertyType(i,ch)){
                property.remove(i);
                System.out.println("Deleted Successfully...");
                return;
            }
        }
        System.out.println("Can't delete...");
    }

    //FILTER PROPERTY
    public static void filter(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("""
                        Enter the choice to filter

                        1.BUNGLAW\s
                        2.COTTAGE\s
                        3.ORDINARY HOUSE\s
                        4.PG\s
                        5.BOOKED HOUSES\s
                        6.AVAILABLE HOUSES\s
                        7.1BHK HOUSES\s
                        8.2BHK HOUSES\s
                        9.3BHK HOUSES\s
                        10.ABOVE 3BHK HOUSES\s
                        11.NO FILTER/BACK""");
                choice = HandleException.correctInput();
                UtilClass.filterHouse(choice);
            }
            case 2 -> {
                System.out.println("""
                        Enter the choice to filter

                        1.AGRICULTURAL LAND\s
                        2.COMMERCIAL LAND\s
                        3.BOOKED LANDS\s
                        4.AVAILABLE LANDS\s
                        5.NO FILTER/BACK""");
                choice = HandleException.correctInput();
                UtilClass.filterLand(choice);
            }
            default -> System.out.println("Invalid choice");
        }
    }

    //SEARCH PROPERTY
    public static void searchProperty(String str) {
        System.out.println("---------------------------------------");
        int search_count=0;
        for(int i=0;i<property.size();i++){
            if(UtilClass.CheckForSearchEngine(i,str.toLowerCase())){
                print(i);
                search_count++;
            }
        }
        if(search_count==0){
            System.out.println("No Results Found...");
        }
        System.out.println("---------------------------------------");
        System.out.println("\nSearched results ("+search_count+')');
    }

    //DELETE BLOCKED USER'S PROPERTY
    public void deleteTrashProperty(int userid){
        for(int i=0;i<property.size();i++) {
            if(Objects.equals(getThisProperty(i).usId, userid)) {
                property.remove(i);
                i--;
            }
        }

    }

    //VIEW MY PROPERTIES
    public static void viewProperty(int userid) {
        boolean stat=false;
        System.out.println("------------------------------------------");
        System.out.println("|             My Properties              |");
        System.out.println("------------------------------------------");
        for (int i = 0; i < property.size(); i++) {
            if (getThisProperty(i).usId == userid) {
                print(i);
                if (!getThisProperty(i).bookedMember.equals("") && getThisProperty(i).bookStatus) {
                    System.out.println("Booked member: " + getThisProperty(i).bookedMember);
                    stat=true;
                }
                System.out.println("------------------------------------------");
            }
        }
        if(stat){
            System.out.println("Not Available...");
            System.out.println("------------------------------------------");
        }
    }
    //VIEW ALL PROPERTIES
    public static void viewProperty() {
        System.out.println("------------------------------------------");
        System.out.println("|            Properties: ("+property.size()+')'+"             |");
        System.out.println("------------------------------------------");
        if(property.size()!=0) {
            for (int i = 0; i < property.size(); i++) {
                print(i);
                System.out.println("Status: " + ((getThisProperty(i).bookStatus) ? "Booked" : "Available"));
                System.out.println("------------------------------------------");
            }
        }
        else{
            System.out.println("Not Available...");
            System.out.println("------------------------------------------");
        }

    }
    //COMMON
    public static void printProperty(int i){
        System.out.println("Owner name: " + getThisProperty(i).ownerName);
        if(userid!=0){
            System.out.println("Owner Phone number: " + getThisProperty(i).ownerPhno);
        }
        System.out.println("Nearby areas: " + getThisProperty(i).nearbyAreas
                + "\nPrice: " + getThisProperty(i).budget
                + "\nDescription: " + getThisProperty(i).description);
    }

    public static void print(int i){
        if (!getThisProperty(i).bungId.equals("")) {
            bunglaw.printBung(i,property);
        }
        else if (!getThisProperty(i).cottId.equals("")) {
            cottage.printCottage(i,property);
        }
        else if (!getThisProperty(i).pgId.equals("")) {
            pg.printPG(i,property);
        }
        else if (!getThisProperty(i).ordId.equals("")) {
            ordinaryHouse.printOrdinaryHouse(i,property);
        }
        else if(!getThisProperty(i).commId.equals("")){
            commercialLand.printCommercialLand(i,property);
        }
        else if(!getThisProperty(i).agriId.equals("")){
            agriculturalLand.printAgri(i,property);
        }
    }

    //BOOK PROPERTY
    public static String bookMyProperty(String ch, int userid, String s) {
        for (int i=0;i<property.size();i++) {
            if (getThisProperty(i).usId != userid && UtilClass.checkThisPropertyType(i,ch) &&
                    !getThisProperty(i).bookStatus) {
                getThisProperty(i).bookStatus = true;
                getThisProperty(i).bookedMember = s;
                getThisProperty(i).bookedMemberUserID=userid;
                return "Booked Successfully...";
            }
        }
        return "Can't book...";
    }
    //CANCEL BOOK
    public static String cancelBooking(String ch, int userid){
        for (int i=0;i<property.size();i++) {
            if (getThisProperty(i).usId != userid && UtilClass.checkThisPropertyType(i,ch) &&
                    getThisProperty(i).bookStatus) {
                getThisProperty(i).bookStatus =false;
                getThisProperty(i).bookedMemberUserID=0;
                getThisProperty(i).bookedMember="";
                return "Booking cancelled...";
            }
        }
        return "Can't cancel book...";
    }

    //VIEW BOOKED PROPERTIES
    public static void viewmyBookedProperties(int userid) {
        boolean isbooked=false;
        System.out.println("------------------------------------------");
        for(int i=0;i<property.size();i++){
            if(getThisProperty(i).bookedMemberUserID==userid){
                print(i);
                isbooked=true;
                System.out.println("------------------------------------------");
            }
        }
        if(!isbooked) {
            System.out.println("No Booked Details Available");
            System.out.println("------------------------------------------");
        }
    }

    //ADD TO WISHLIST
    public static void addMyWishList(String id,int userid) {
        boolean wishListStatus=false;
        for (int i = 0; i < property.size(); i++) {
            if (UtilClass.compare(id,i) && !UtilClass.checkAlreadyAddedWishList(id,userid)){
                wishList.add(new WishList(id,userid));
                System.out.println("Added to wishList...");
                wishListStatus=true;
            }
        }
        if(!wishListStatus) System.out.println("Wrong ID");
    }
    //REMOVE FROM WISHLIST
    public static void removeMyWishList(String id,int userid) {
        boolean removeStatus=false;
        for (int i = 0; i < wishList.size(); i++) {
            if (wishList.get(i).userId ==userid && wishList.get(i).propId.equals(id)) {
                wishList.remove(i);
                removeStatus=true;
            }
        }
        if(removeStatus){
            System.out.println("Removed from WishList...");
        }
        else{
            System.out.println("Can't remove.. Enter correct ID...");
        }
    }
    //VIEW MY WISHLIST
    public static void viewWishList(int usid) {
        boolean status=false;
        System.out.println("---------------MY WISHLIST---------------");
        for (WishList list : wishList) {
            if (!list.propId.equals("") && list.userId == usid) {
                for (int j = 0; j < property.size(); j++) {
                    if (UtilClass.compare(list.propId, j)) {
                        System.out.println("----------------------------------------");
                        print(j);
                        status = true;
                        System.out.println("----------------------------------------");
                    }
                }
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("----------------------------------------");
        }
    }
}