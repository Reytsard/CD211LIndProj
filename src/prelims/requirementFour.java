package prelims;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class requirementFour { public static void main(String[] args) {
    MyDoublyLinkedList<String> familyTree = new MyDoublyLinkedList<>();
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    while (true) {
        System.out.println("Family Tree Menu:");
        System.out.println("1. Add a child");
        System.out.println("2. List family members from oldest to youngest");
        System.out.println("3. List family members from youngest to oldest");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter the child's name: ");
                String childName = scanner.nextLine();

                // Input and validate the birthday format
                Date birthday = null;
                while (birthday == null) {
                    try {
                        System.out.print("Enter the child's birthday (dd/mm/yyyy): ");
                        String birthdayStr = scanner.nextLine();
                        birthday = dateFormat.parse(birthdayStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/mm/yyyy.");
                    }
                }

                String formattedBirthday = dateFormat.format(birthday);
                String familyMemberInfo = childName + " (Birthday: " + formattedBirthday + ")";
                familyTree.insert(familyMemberInfo);
                System.out.println("Child added to the family tree.");
                break;

            case 2:
                System.out.println("Family members from oldest to youngest:");
                displayFamilyMembers(familyTree, true);
                break;

            case 3:
                System.out.println("Family members from youngest to oldest:");
                displayFamilyMembers(familyTree, false);
                break;

            case 4:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}

    private static void displayFamilyMembers(MyDoublyLinkedList<String> familyTree, boolean ascending) {
        if (ascending) {
            familyTree.displayList();
        } else {
            int size = familyTree.getSize();
            DLNode<String> currNode = familyTree.getTail();

            while (currNode != null) {
                System.out.println(currNode.getInfo());
                currNode = currNode.getPrevNode();
            }
        }
    }

}
