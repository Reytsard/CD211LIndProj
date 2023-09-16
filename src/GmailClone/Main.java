package GmailClone;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Users<SinglyLinkedList<String>> emailsAndPasswords = new Users<>();
    public static boolean isLoggedIn = false;


    public static void main(String[] args) {
        boolean using = true;
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
                        showLogInForm();
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Thank you for using the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("get rekt");
                }

            }
        }while(using);
    }

    public static void showLogInForm(){
        String userName;
        String password;
        System.out.println("============================");
        System.out.println("Login");
        System.out.print("Username: ");
        userName = input.next();
        System.out.println();
        System.out.print("Password: ");
        password = input.next();
        isLoggedIn = emailsAndPasswords.authenticateUserNameAndPassword(userName,password);
        //authenticateUserNameAndPassword(userName,password);
        /** remove after */
        System.out.println(userName);
        System.out.println(password);
    }
}
