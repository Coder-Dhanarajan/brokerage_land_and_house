package useraccount;
import java.util.*;
import property.PropertyOptions;

public class UserOptions {

    static void userOptions(boolean status, UserOperations user1, PropertyOptions property1){
        while(status) {
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    | Please Enter your choice... |
                    | 1.PROFILE                   |
                    | 2.ADD PROPERTY              |
                    | 3.UPDATE PROPERTY           |
                    | 4.DELETE PROPERTY           |
                    | 5.VIEW MY PROPERTY          |
                    | 6.VIEW ALL PROPERTY         |
                    | 7.BOOKING                   |
                    | 8.WISHLIST                  |
                    | 9.FILTER AND VIEW           |
                    | 10.SEARCH                   |
                    | 11.LOGOUT                   |
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    """);
            int ch = HandleException.correctInput();
            switch (ch) {
                case 1 ->{
                    user1.read();
                    System.out.println("""
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            | Enter your choice...                       |
                            | 1.EDIT PROFILE                             |
                            | 2.DELETE ACCOUNT                           |
                            | Enter any integer to go BACK (except 1,2)  |
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            """);
                    int ch2=HandleException.correctInput();
                    switch(ch2){
                        case 1 -> user1.update();
                        case 2 -> {
                            user1.delete();
                            status=false;
                        }
                    }
                }
                case 2 -> property1.addProperty();
                case 3 -> {
                    System.out.println("Note:\nWhen you want to update the field, you can enter 'YES'. " +
                            "Else, enter anything.");
                    property1.updateProperty();
                }
                case 4 -> property1.deleteProperty();
                case 5 -> property1.viewMyProperty();
                case 6 -> property1.viewAllProperty();
                case 7 ->{
                    System.out.println("""
                            
                            Enter your choice...
                            1.BOOK PROPERTY
                            2.CANCEL BOOKING
                            3.VIEW BOOKED PROPERTIES
                            Enter any integer to go BACK (except 1,2,3)""");
                    int ch2=HandleException.correctInput();
                    switch(ch2){
                        case 1 -> property1.bookProperty();
                        case 2 -> property1.cancelBooking();
                        case 3 -> property1.viewBookedProperties();
                    }
                }
                case 8 -> {
                    System.out.println("""
                            
                            Enter your choice...
                            1.ADD TO WISHLIST
                            2.VIEW MY WISHLIST
                            3.REMOVE FROM WISHLIST
                            Enter any integer to go BACK (except 1,2,3)""");
                    int ch3=HandleException.correctInput();
                    switch(ch3){
                        case 1 -> property1.addToMyWishList();
                        case 2 -> property1.viewMyWishList();
                        case 3 -> property1.deleteFroMyWishList();
                    }
                }
                case 9 -> property1.filterAndView();
                case 10 -> property1.searchProperty();
                case 11 ->{
                    user1.logout();
                    status=false;
                }
                default -> System.out.println("Invalid option buddy!!!... :(");
            }
        }
    }
    public static void main(String[] args) {
        UserOperations user=new UserOperations();
        PropertyOptions property=new PropertyOptions();
        Scanner sc=new Scanner(System.in);

        DummyUsers.dummy(UserOperations.data,1000);
        boolean isActive=true;
        System.out.println("***********************************************************************" +
                "**********************************************************************************************");
        System.out.println("*                                                                  " +
                "       WELCOME TO NOBROKER!  " +
                "                                                                    *");
        System.out.println("***********************************************************************" +
                "**********************************************************************************************");
        while(isActive){
            System.out.println("""
                    
                    Hi Buddy... Welcome to NoBroker!!!\040
                    Please enter your choice to begin...
                    ~~~~~~~~~~~~~~~~~~~~~~
                    | 1.SIGN UP          |
                    | 2.LOGIN            |
                    | 3.VIEW PROPERTY    |
                    | 4.SEARCH PROPERTY  |
                    | 5.EXIT             |
                    | 6.ADMIN            |
                    ~~~~~~~~~~~~~~~~~~~~~~""");
            int choice=HandleException.correctInput();
            boolean status=true;
            switch(choice){
                case 1:
                    if(user.createAccount()) {
                        userOptions(status,user,property);
                    }
                    break;
                case 2:
                    if(user.login()) {
                        userOptions(status,user,property);
                    }
                    break;
                case 3:
                    property.viewAllProperty();
                    break;
                case 4:
                    property.searchProperty();
                    break;
                case 5:
                    System.out.println("Are you confirm to exit this app? If yes, Enter 'YES' to confirm, " +
                            "else enter anything\nWarning!!! The data will be erase when you exit...");
                    if(sc.nextLine().equals("YES")) {
                        System.out.println("Thank you!!! See you again :)");
                        isActive = false;
                    }
                    break;
                case 6:
                    Admin.access(user);
                    break;
                default:
                    System.out.println("Invalid option buddy!!!... :(");
            }
        }
    }
}