package prelims;

import java.util.Scanner;

public class requirementOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyFixedSizeArrayList<String> personalData = new MyFixedSizeArrayList<>();
        int answer;
        boolean using = true;

        System.out.println("=============================================================");
        System.out.println("Welcome to the Fixed Array Program");
        System.out.println();
        System.out.println("Let's us create a User");
        System.out.print("Input name:");
        personalData.setName(input.nextLine());
        System.out.print("Input age:");
        personalData.setAge(input.nextLine());
        System.out.print("input Model Number:");
        personalData.setModelNumber(input.nextLine());
        System.out.print("input Color:");
        personalData.setColor(input.nextLine());
        System.out.print("input status:");
        personalData.setStatus(input.nextLine());

        do{
            System.out.println("===================================");
            System.out.println("Select from the options");
            System.out.println();
            System.out.println("1.View Profile\n2.Edit Profile\n3.Exit\n");
            System.out.print("Selected Option: ");
            answer = input.nextInt();

            switch (answer){
                case 1:
                    personalData.displayInfo();
                    break;
                case 2:
                    personalData.displayInfo();
                    System.out.println("What do you want to change");
                    System.out.println("1. Name\n2. Age\n3. Model Number\n4. Color\n5. Status");
                    switch (input.nextInt()){
                        case 1:
                            System.out.print("Input new Name:");
                            personalData.setName(input.next());
                            System.out.println("New Name is "+ personalData.getName());
                            break;
                        case 2:
                            System.out.print("Input new age:");
                            personalData.setAge(input.next());
                            System.out.println("New Age is "+ personalData.getName());
                            break;
                        case 3:
                            System.out.print("Input new Model Number:");
                            personalData.setModelNumber(input.next());
                            System.out.println("New Model Number is "+ personalData.getModelNumber());
                            break;
                        case 4:
                            System.out.print("Input new Color");
                            personalData.setColor(input.next());
                            System.out.println("New color is "+ personalData.getColor());
                            break;
                        case 5:
                            System.out.print("Input new Status");
                            personalData.setStatus(input.next());
                            System.out.println("New status is "+ personalData.getStatus());
                            break;
                        default:
                            System.out.println("Select from 1-5 only. Returning to Menu");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the program.");
                    using = false;
                    break;
            }
        }while(using);
    }
}