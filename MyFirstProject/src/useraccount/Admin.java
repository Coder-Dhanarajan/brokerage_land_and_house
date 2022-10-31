package useraccount;

import java.util.Scanner;

public class Admin{
    static Scanner sc=new Scanner(System.in);
    static void access(UserOperations user){
        System.out.println("Enter username:");
        String admin_name= sc.nextLine();
        System.out.println("Enter password:");
        String admin_passwd=sc.nextLine();
        if(admin_name.equals("admin") && admin_passwd.equals("admin123")){
            System.out.println("Hi Admin...!!!");
            user.allProfile();
        }
        else{
            System.out.println("Invalid Login...");
        }

    }
}