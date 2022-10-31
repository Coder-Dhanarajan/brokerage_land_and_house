package useraccount;
import java.util.Scanner;
import java.util.regex.Pattern;
public class UserValidation{
    static String emailRegex = "^(.+)@(.+)$";
    static String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
    static String mobilenumRegex = "\\d{10}";
    static Pattern patternEmail = Pattern.compile(emailRegex);
    static Pattern patternPassword = Pattern.compile(passwordRegex);
    static  Pattern patternMobilenum =Pattern.compile(mobilenumRegex);
    static Scanner sc=new Scanner(System.in);
    static boolean usernameValidate(String name){
        if(name.length()>20){
            System.out.println("Enter the username within 20 characters");
            return false;
        }
        else if(name.equals("")){
            System.out.println("Username required...");
            return false;
        }
        return true;
    }
    static boolean emailValidate(String email){
        if(email.equals("")){
            System.out.println("Email required...");
            return false;
        }
        else if(!(patternEmail.matcher(email).matches())){
            System.out.println("Invalid email");
            return false;
        }
        return true;
    }
    static boolean passwordValidate(String password){
        if(password.equals("")){
            System.out.println("Password required...");
            return false;
        }
        else if(!(patternPassword.matcher(password).matches())){
            System.out.println("Invalid password");
            return false;
        }
        return true;
    }
    public static String propertyTextValidate(){
        String text=sc.nextLine();
        if(text.equals("")){
            System.out.println("* Required field...");
            return propertyTextValidate();
        }
        return text;
    }
    public static String propertyPhnoValidate(){
        String phno=sc.nextLine();
        if (phno.equals("")) {
            System.out.println("Phone number required...");
            return propertyPhnoValidate();
        } else if (phno.length() != 10) {
            System.out.println("Phone number length should be in 10...");
            return propertyPhnoValidate();
        } else if (!patternMobilenum.matcher(phno).matches()) {
            System.out.println("Invalid phone number...");
            return propertyPhnoValidate();
        }
        return phno;
    }

}