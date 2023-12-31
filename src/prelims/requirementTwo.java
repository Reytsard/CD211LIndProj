package prelims;

import java.lang.reflect.Array;
import java.util.Scanner;

public class requirementTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isUsing = true;
        MyGrowingArrayList<String> growingArray = new MyGrowingArrayList<>();
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
                    growingArray.displayInfo();
                    break;
                case 2:
                    System.out.println("Input new To-do-List");
                    String newToDo = input.nextLine();
                    try {
                        growingArray.insert(newToDo+"");
                    } catch (ListOverflowException e) {
                        System.out.println("Error: "+ e.getMessage());
                    }
                    break;
                case 3:
                    growingArray.displayInfo();
                    System.out.println();
                    System.out.println("What do you want to remove? input whole sentence");
                    String toRemove = input.nextLine();
                    if(growingArray.search(toRemove) != -1){
                        growingArray.delete(toRemove);
                    }else{
                        System.out.println("Invalid Input! No identical todo found");
                    }
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
