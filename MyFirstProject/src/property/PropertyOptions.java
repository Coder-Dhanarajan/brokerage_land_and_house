package property;
import java.util.Scanner;
import useraccount.HandleException;

public class PropertyOptions {

    public static int userid;
    public static String uname;
    Scanner sc=new Scanner(System.in);

    public void addProperty(){
        System.out.println("1.HOUSE 2.LAND\nEnter any integer to go BACK");
        int ch = HandleException.correctInput();
        switch (ch) {
            case 1 -> {
                System.out.println("Enter the choice 1.Bunglaw 2.Cottage 3.PG 4.Ordinary Houses" +
                        "\nEnter any integer to go BACK");
                int choice = HandleException.correctInput();
                switch (choice) {
                    case 1 -> PropertyOperations.add_bunglaw(userid);
                    case 2 -> PropertyOperations.add_cottage(userid);
                    case 3 -> PropertyOperations.add_pg(userid);
                    case 4 -> PropertyOperations.add_Ordinary(userid);
                    //default -> System.out.println("Invalid Option...");
                }
            }
            case 2 -> {
                System.out.println("Enter the choice 1.Commercial Land 2.Agricultural Land" +
                        "\nEnter any integer to go BACK");
                int choice = HandleException.correctInput();
                switch (choice) {
                    case 1 -> PropertyOperations.add_commercialLand(userid);
                    case 2 -> PropertyOperations.add_AgriLand(userid);
                }
            }
            //default -> System.out.println("Invalid Option");
        }

    }
    public void updateProperty() {
        System.out.println("Just enter your property ID... \nTo go back, just click ENTER key");
        String ch=sc.nextLine();
        if(!ch.equals(""))
        PropertyOperations.updateProperty(ch,userid);
    }
    public void deleteProperty(){
        System.out.println("Just enter your property ID... \nTo go back, just click ENTER key");
        String ch=sc.nextLine();
        if(!ch.equals("")) {
            System.out.println("Are you sure to delete this property? if yes, Enter 'Y' or 'y', else enter anything");
            String response=sc.nextLine();
            if (response.equals("Y") || response.equals("y")) {
                PropertyOperations.deleteMyProperty(ch, userid);
            }
        }
    }
    public void viewMyProperty() {
        PropertyOperations.viewProperty(userid);
        System.out.println("Press any key to continue...");
        sc.nextLine();

    }
    public void viewAllProperty() {
        PropertyOperations.viewProperty();
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }
    public void searchProperty() {
        while (true) {
            System.out.println("Search... \nTo go back, just click ENTER key");
            try {
                String str = sc.nextLine();
                if (!str.equals(""))
                    PropertyOperations.searchProperty(str);
                else break;
            } catch (NullPointerException e) {
                System.out.println("Something wrong... Try again!!!");
            }
        }
    }
    public void filterAndView(){
        while(true) {
            try {
                System.out.println("""
                        Enter the choice to filter              
                        1.HOUSE\s
                        2.LAND
                        3.BACK"""
                );
                int choice = HandleException.correctInput();
                if (choice == 3) break;
                PropertyOperations.filter(choice);
                System.out.println("Press any key to continue...");
                sc.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Something wrong... Try again...");
            }
        }
    }
    public void bookProperty() {
        System.out.println("Please enter the property ID... \nTo go back, just click ENTER key");
        String ch=sc.nextLine();
        if(!ch.equals(""))
        System.out.println(PropertyOperations.bookMyProperty(ch,userid, uname));
    }
    public void cancelBooking(){
        System.out.println("Please enter the property ID... \nTo go back, just click ENTER key");
        String ch=sc.nextLine();
        if(!ch.equals(""))
        System.out.println(PropertyOperations.cancelBooking(ch,userid));
    }
    public void viewBookedProperties() {
        PropertyOperations.viewmyBookedProperties(userid);
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }
    public void addToMyWishList() {
        System.out.println("Please Enter the property ID \nTo go back, just click ENTER key");
        String id=sc.nextLine();
        if(!id.equals(""))
        PropertyOperations.addMyWishList(id,userid);
    }
    public void viewMyWishList() {
        PropertyOperations.viewWishList(userid);
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }

    public void deleteFroMyWishList() {
        System.out.println("Please Enter the property ID \nTo go back, just click ENTER key");
        String id=sc.nextLine();
        if(!id.equals(""))
        PropertyOperations.removeMyWishList(id,userid);
    }
}