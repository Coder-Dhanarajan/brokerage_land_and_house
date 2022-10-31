package property;

import  java.util.ArrayList;

public class DummyProperty{
    //BUNGLAW
    static PropertyData call(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                    String s8, String s9, String s10, String s11, String s12, String s13, String s14,
                    String s15, String s16, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.houseAddress =s7;
        p.gardenSize =s8;
        p.bathroomType =s9;
        p.kitchensCount =s10;
        p.bedroomsCount =s11;
        p.bathroomsCount =s12;
        p.swimmingpoolCount =s13;
        p.noOfFloors =s14;
        p.acCount =s15;
        p.bungId =s16;
        p.usId =uid;
        return p;
    }

    //COTTAGE
    static PropertyData call(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                             String s8, String s9, String s10, String s11, String s12, String s13, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.houseAddress =s7;
        p.bathroomType =s8;
        p.isHall =s9;
        p.isKitchen =s10;
        p.isBathroom =s11;
        p.isBedroom =s12;
        p.cottId =s13;
        p.usId =uid;
        return p;
    }

    //PG
    static PropertyData call(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                             String s8, String s9, String s10, String s11, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.houseAddress =s7;
        p.bathroomType =s8;
        p.isAc =s9;
        p.noOfBeds =s10;
        p.pgId =s11;
        p.usId =uid;
        return p;
    }
    //ORDINARY
    static PropertyData callOrd(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                             String s8, String s9, String s10, String s11, String s12, String s13, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.houseAddress =s7;
        p.bathroomType =s8;
        p.kitchensCount =s9;
        p.bedroomsCount =s10;
        p.bathroomsCount =s11;
        p.acCount =s12;
        p.ordId =s13;
        p.usId =uid;
        return p;
    }
    //COMMERCIAL
    static PropertyData call(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                             String s8, String s9, String s10, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.landAddress =s7;
        p.landSize =s8;
        p.commercialType =s9;
        p.commId =s10;
        p.usId =uid;
        return p;
    }
    //AGRI
    static PropertyData call(String s1, String s2, String s3, String s4, String s5, String s6, String s7,
                             String s8, String s9, int uid){
        PropertyData p=new PropertyData();
        p.ownerName =s1;
        p.ownerPhno =s2;
        p.nearbyAreas =s3;
        p.relationBetw_OwnerAndUser =s4;
        p.budget=s5;
        p.description=s6;
        p.landAddress =s7;
        p.landSize =s8;
        p.agriId =s9;
        p.usId =uid;
        return p;
    }
    public static void addDummyProperty(ArrayList<PropertyData> property, int uid){
        if(uid==1001)
            property.add(call("Dharma", "9901223344", "Schools", "Uncle", "20000000",
                "Nice House", "1/200,North street, Palayampatti.", "200x300 feet",
                "Attached", "3", "3", "3", "2", "Above 3", "3",
                uid + "BH" + 2001,  uid));
        else if(uid==1002)
            property.add(call("Rajan", "9900112233", "Temple", "", "20000",
                "Clean area", "1/33,H.T. Nagar, Thirupur.", "Seperated", "Yes",
                "Yes", "Yes","Yes", uid + "CH" + 3001,  uid));
        else if(uid==1003)
            property.add(call("Shiva", "9155263844", "Grocery shops, Hospitals", "", "5000",
                "All facilities available", "Near Collectorate office, Tenkasi.", "Attached",
                "Yes", "2", uid + "PGH" + 4001,  uid));
        else if(uid==1004)
            property.add(callOrd("Kumar", "8022716651", "Hospitals, new bus stand", "Brother/Sister",
                "300000", "Nice House", "9/22, K.K. Salai, Madurai.", "Seperated",
                "2", "3", "2", "1", uid + "OH" + 5001,  uid));
        else if(uid==1005)
            property.add(call("Divya", "9811220055", "Schools", "", "500000",
                    "Clean area, Surrounding village", "1/250,West street, Singapuram.",
                    "20 acres","Hospitals", uid + "CL" + 6001,  uid));
        else if(uid==1006)
            property.add(call("Lakshmi", "9901223344", "Schools", "Mother/Father", "2000000",
                    "Nice House", "1/20,new 5th street, Palayamkottai.", "12 acres",
                    uid + "AL" + 7001,  uid));

    }
}