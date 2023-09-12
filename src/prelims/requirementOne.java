package prelims;

import java.util.Scanner;

public class requirementOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyFixedSizeArrayList<String> personalData = new MyFixedSizeArrayList<>();
        System.out.print("Input name:");
        personalData.setName(input.nextLine());
        System.out.print("Input age:");
        personalData.setAge(input.nextLine());
        System.out.print("input Model Number");
        personalData.setModelNumber(input.nextLine());
        System.out.print("input Color:");
        personalData.setColor(input.nextLine());
        System.out.print("input status:");
        personalData.setStatus(input.nextLine());
        personalData.populateArray(
                personalData.getName(),
                personalData.getAge() ,
                personalData.getModelNumber(),
                personalData.getColor(),
                personalData.getStatus());
        System.out.println("type what to delete");
        personalData.displayInfo();
        personalData.delete(input.nextLine());
        personalData.displayInfo();
        try {
            personalData.insert("hello world!");
        } catch (ListOverflowException e) {
            System.out.println("error: " + e);
        }
//        personalData.getElement();
//        personalData.insert();
    }
}
