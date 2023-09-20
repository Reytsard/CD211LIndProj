package prelims;

import java.util.Scanner;

public class requirementThree {
    public static void main(String[] args) {
        MySinglyLinkedList<String> todoList = new MySinglyLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("Todo List Menu:");
            System.out.println("1. Add a todo item");
            System.out.println("2. Display all todo items");
            System.out.println("3. Delete a todo item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter a todo item: ");
                    String todoItem = scanner.nextLine();
                    todoList.insert(todoItem);
                    System.out.println("Todo item added to the list.");
                    break;

                case 2:
                    System.out.println("Todo items:");
                    todoList.displayInfos();
                    break;

                case 3:
                    System.out.print("Enter the todo item to delete: ");
                    String itemToDelete = scanner.nextLine();
                    boolean deleted = todoList.delete(itemToDelete);
                    if (deleted) {
                        System.out.println("Todo item deleted.");
                    } else {
                        System.out.println("Todo item not found.");
                    }
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
}
