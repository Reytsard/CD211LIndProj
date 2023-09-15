package GmailClone;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean using = true;
        boolean isLoggedIn = false;
        int optionSelected;
        do {
            if(isLoggedIn){
//                showMenu();
            }else{
                System.out.println("================================");
                System.out.println("Select from the options");
                System.out.println("1.Login\n2.Create New Account\n3.Exit");
                System.out.print("Option Selected: ");
                optionSelected = input.nextInt();
                switch (optionSelected){
                    case 1:
//                        showLogInForm();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("get rekt");
                }

            }
        }while(using);
//        do{
//            System.out.println("================================");
//            System.out.println("Welcome to data Structures Gmail!");
//            System.out.println("Select an Option:");
//            System.out.println("1.Create an Email\n2.View Inbox\n3.View Drafts");
//        }while(isLoggedIn);
    }
}
