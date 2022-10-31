package useraccount;
import property.PropertyOperations;
import property.PropertyOptions;

import java.util.*;
public class UserOperations {
    Scanner sc=new Scanner(System.in);
    public static ArrayList<UserDataManager> data=new ArrayList<>();
    static int uid=1006;
    boolean isLoggedin =false;
    int myProfileIndex =0;
    String name,password,email;

    //CREATE
    boolean createAccount() {
        System.out.print("USERNAME: ");
        name = sc.nextLine();
        System.out.print("EMAIL: ");
        email = sc.nextLine();
        System.out.print("PASSWORD: ");
        password = sc.nextLine();
        return signUp(name,email,password);
    }
    boolean signUp(String name,String email,String password){
        if (UserValidation.usernameValidate(name) && UserValidation.emailValidate(email) && UserValidation.passwordValidate(password)) {
            for (UserDataManager datum : data) {
                if (datum.userName.equals(name) || datum.email.equals(email) || datum.password.equals(password)) {
                    System.out.println("Already exists...");
                    return false;
                }
            }
            data.add(new UserDataManager(name, email, password, ++uid));
            System.out.println("Signed up Successfully...");
            return checkLogin(name, password);
        }
        else{
            return false;
        }

    }


    //LOGIN
    boolean login(){
        System.out.print("USERNAME: ");
        name = sc.nextLine();
        System.out.print("PASSWORD: ");
        password = sc.nextLine();

        return checkLogin(name,password);
    }
    boolean checkLogin(String name,String password){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).userName.equals(name) && data.get(i).password.equals(password)) {
                myProfileIndex =i;
                PropertyOptions.uname =data.get(i).userName;
                PropertyOperations.name=data.get(i).userName;
                System.out.println("Logged in successfully... \nHi "+data.get(i).userName +'!');
                isLoggedin = true;
                PropertyOptions.userid =data.get(i).userId;
                return true;

            }
        }
        System.out.println("Invalid login...");
        return false;
    }


    //LOGOUT
    void logout(){
        if(isLoggedin) {
            isLoggedin = false;
            PropertyOptions.userid =0;
            System.out.println("Logged out successfully...");
        }
    }


    //VIEW ALL DETAILS (FOR ADMIN USE ONLY)
    public void allProfile(){
        System.out.println("-----------------------------------------");
        System.out.println("              USER DETAILS               ");
        System.out.println("-----------------------------------------");
        if(getUserDetails()==0){
            System.out.println("---No Details available---");
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println();
    }
    int getUserDetails(){
        for (UserDataManager datum : data) {
            System.out.println("USER ID: " + datum.userId + "\nUSERNAME: " + datum.userName + "\nEMAIL: " + datum.email);
            System.out.println();
        }
        return data.size();
    }


    //VIEW
    void read(){
        System.out.println("-----------------------------------------");
        System.out.println("              MY PROFILE:                ");
        System.out.println("-----------------------------------------");
        System.out.println("USER ID: " + getMyProfile(myProfileIndex).userId +
                "\nUSERNAME: " + getMyProfile(myProfileIndex).userName +
                "\nEMAIL: " + getMyProfile(myProfileIndex).email);
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println();
    }

    UserDataManager getMyProfile(int userIndex){
        return data.get(userIndex);
    }


    //UPDATE
    void update(){
                System.out.println("What you want to update? 1.USERNAME 2.EMAIL 3.PASSWORD");
                int op = HandleException.correctInput();
                if (op == 1) {
                    System.out.print("Rename username: ");
                    String updatedName=sc.nextLine();
                    if (UserValidation.usernameValidate(updatedName)) {
                        updateMyDetails(myProfileIndex).userName = updatedName;
                        PropertyOptions.uname =updatedName;
                        PropertyOperations.setUpdatedUserName(updatedName);
                        System.out.println("Updated Successfully...");
                    }
                } else if (op == 2) {
                    System.out.print("Rename email: ");
                    String updatedEmail=sc.nextLine();
                    if (UserValidation.emailValidate(updatedEmail)) {
                        updateMyDetails(myProfileIndex).email = updatedEmail;
                        System.out.println("Updated Successfully...");
                    }
                } else if (op == 3) {
                    System.out.print("Rename password: ");
                    String updatedPassword=sc.nextLine();
                    if (UserValidation.passwordValidate(updatedPassword)) {
                        updateMyDetails(myProfileIndex).password = updatedPassword;
                        System.out.println("Updated Successfully...");
                    }
                } else {
                    System.out.println("Not a correct option...");
                }
    }
    UserDataManager updateMyDetails(int userIndex){
        return data.get(userIndex);
    }


    //DELETE
    void delete(){
        PropertyOperations imp=new PropertyOperations();
        imp.deleteTrashProperty(data.get(myProfileIndex).userId);
        data.remove(myProfileIndex);
        isLoggedin =false;
        System.out.println("Deleted Successfully...");
    }
}