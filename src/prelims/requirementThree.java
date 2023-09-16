package prelims;

import java.util.Scanner;

public class requirementThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MySinglyLinkedList<String> SLL = new MySinglyLinkedList<>();
        boolean isUsing = true;
        System.out.println("===========================================");
        System.out.println("Welcome to To-do-List Program");
        do {
            System.out.println();
            System.out.println("Select from the options");
            System.out.println();
            System.out.println("1. View To-do List");
            System.out.println("2. Add a To-do");
            System.out.println("3. Delete a To-do");
            System.out.println("4. Exit");
            System.out.print("Selected Option: ");
            int a =input.nextInt();
            input.nextLine();
            System.out.println();
            switch(a){
                case 1:
                    SLL.displayInfos();
                    break;
                case 2:
                    System.out.println("Input new To-do-List");
                    String newToDo = input.nextLine();
                        SLL.insert(newToDo+"");
                    break;
                case 3:
                    SLL.displayInfos();
                    System.out.println();
                    System.out.println("What do you want to remove? input whole to do");
                    String toRemove = input.nextLine();
                    SLL.delete(toRemove);
                    break;
                case 4:
                    System.out.println("Thank you for using the program");
                    isUsing = false;
                    break;
                default:
                    System.out.println("Invalid input! Select from 1-3 only");
            }
        }while(isUsing);
    }
}
