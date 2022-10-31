package useraccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleException{
    public static int correctInput(){
        Scanner sc=new Scanner(System.in);
        int input;
        try {
            input = sc.nextInt();
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Enter the Integer type input...");
        }
        return correctInput();
    }
}