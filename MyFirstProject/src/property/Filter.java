package property;

import property.house.*;
import property.land.*;

import java.util.*;

class Filter {

    public static void filterBunglaw(ArrayList<PropertyData> property, Bunglaw bunglaw) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).bungId.equals("")) {
                bunglaw.printBung(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }

    }
    public static void filter1BHKHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                       OrdinaryHouse ordinaryHouse, PG pg){
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if (((!property.get(i).bungId.equals("") || !property.get(i).ordId.equals(""))
                    && (property.get(i).bedroomsCount.equals("Only 1")))
                    || ((!property.get(i).pgId.equals("")) && property.get(i).noOfBeds.equals("Only 1"))) {
                call(i, property, bunglaw,ordinaryHouse,pg);
                status=true;
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    public static void filter2BHKHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                       OrdinaryHouse ordinaryHouse,PG pg){
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(((!property.get(i).bungId.equals("") || !property.get(i).ordId.equals(""))
                    && (property.get(i).bedroomsCount.equals("2")))
                    || ((!property.get(i).pgId.equals("")) && property.get(i).noOfBeds.equals("2"))){
                call(i,property,bunglaw, ordinaryHouse,pg);
                status=true;
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }
    public static void filter3BHKHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                       OrdinaryHouse ordinaryHouse, PG pg){
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(((!property.get(i).bungId.equals("") || !property.get(i).ordId.equals(""))
                    && (property.get(i).bedroomsCount.equals("3")))
                    || ((!property.get(i).pgId.equals("")) && property.get(i).noOfBeds.equals("3"))){
                call(i,property,bunglaw,ordinaryHouse,pg);
                status=true;
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }
    public static void filterAbove3BHKHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                            OrdinaryHouse ordinaryHouse, PG pg){
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(((!property.get(i).bungId.equals("") || !property.get(i).ordId.equals(""))
                    && (property.get(i).bedroomsCount.equals("Above 3")))
                    || ((!property.get(i).pgId.equals("")) && property.get(i).noOfBeds.equals("Above 3"))){
                call(i,property,bunglaw,ordinaryHouse,pg);
                status=true;
            }
        }
        if(!status) {
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }
    private static void call(int i, ArrayList<PropertyData> property, Bunglaw bunglaw,
                             OrdinaryHouse ordinaryHouse, PG pg) {
        if(!property.get(i).bungId.equals("")) {
            bunglaw.printBung(i, property);
            System.out.println("---------------------------------------");
        }
        else if(!property.get(i).ordId.equals("")) {
            ordinaryHouse.printOrdinaryHouse(i, property);
            //status=true;
            System.out.println("---------------------------------------");
        }
        else if(!property.get(i).pgId.equals("")){
            pg.printPG(i, property);
            //status=true;
            System.out.println("---------------------------------------");
        }
    }
    public static void filterCottage(ArrayList<PropertyData> property, Cottage cottage) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).cottId.equals("")) {
                cottage.printCottage(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    public static void filterOrdinaryHouse(ArrayList<PropertyData> property, OrdinaryHouse ordinaryHouse) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).ordId.equals("")) {
                ordinaryHouse.printOrdinaryHouse(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    public static void filterPG(ArrayList<PropertyData> property, PG pg) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).pgId.equals("")) {
                pg.printPG(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    public static void filterHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                   OrdinaryHouse ordinaryHouse,PG pg,Cottage cottage) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            call(i,property,bunglaw, ordinaryHouse, pg);
            if(!property.get(i).cottId.equals("")){
                cottage.printCottage(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //AGRI
    public static void filterAgriculturalLand(ArrayList<PropertyData> property,
                                              AgriculturalLand agriculturalLand) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).agriId.equals("")) {
                agriculturalLand.printAgri(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    public static void filterCommercialLand(ArrayList<PropertyData> property, CommercialLand commercialLand) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).commId.equals("")) {
                commercialLand.printCommercialLand(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //LAND ONLY
    public static void filterLand(ArrayList<PropertyData> property, AgriculturalLand agriculturalLand,
                                  CommercialLand commercialLand) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).agriId.equals("")) {
                agriculturalLand.printAgri(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
            else if(!property.get(i).commId.equals("")) {
                commercialLand.printCommercialLand(i, property);
                status=true;
                System.out.println("---------------------------------------");
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //ONLY BOOKED LAND
    public static void filterOnlyBookedHouse(ArrayList<PropertyData> property, Bunglaw bunglaw,
                                             Cottage cottage, OrdinaryHouse ordinaryHouse, PG pg) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(property.get(i).bookStatus) {
                if (!property.get(i).bungId.equals("")) {
                    bunglaw.printBung(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).cottId.equals("")) {
                    cottage.printCottage(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).ordId.equals("")) {
                    ordinaryHouse.printOrdinaryHouse(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).pgId.equals("")) {
                    pg.printPG(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //ONLY AVAILABLE HOUSE
    public static void filterOnlyAvailableHouse(ArrayList<PropertyData> property, Bunglaw bunglaw, Cottage cottage, OrdinaryHouse ordinaryHouse, PG pg) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).bookStatus) {
                if (!property.get(i).bungId.equals("")) {
                    bunglaw.printBung(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).cottId.equals("")) {
                    cottage.printCottage(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).ordId.equals("")) {
                    ordinaryHouse.printOrdinaryHouse(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                } else if (!property.get(i).pgId.equals("")) {
                    pg.printPG(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //ONLY BOOKED LAND
    public static void filterOnlyBookedLand(ArrayList<PropertyData> property, AgriculturalLand agriculturalLand,
                                            CommercialLand commercialLand ) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(property.get(i).bookStatus) {
                if(!property.get(i).agriId.equals("")) {
                    agriculturalLand.printAgri(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
                else if(!property.get(i).commId.equals("")) {
                    commercialLand.printCommercialLand(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }

    //ONLY AVAILABLE LAND
    public static void filterOnlyAvailableLand(ArrayList<PropertyData> property, AgriculturalLand agriculturalLand,
                                               CommercialLand commercialLand) {
        boolean status=false;
        System.out.println("---------------------------------------");
        for(int i=0;i<property.size();i++){
            if(!property.get(i).bookStatus) {
                if(!property.get(i).agriId.equals("")) {
                    agriculturalLand.printAgri(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
                else if(!property.get(i).commId.equals("")) {
                    commercialLand.printCommercialLand(i, property);
                    status=true;
                    System.out.println("---------------------------------------");
                }
            }
        }
        if(!status){
            System.out.println("No Details Available");
            System.out.println("---------------------------------------");
        }
    }
}