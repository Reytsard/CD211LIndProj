package prelims.reqFive;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class requirementFive {
    private static int currentPriority = 1; // Current priority level for round-robin timer
    private static Timer timer = new Timer();
    public static void main(String[] args) {
        SinglyLinkedCircularList<TodoItem> todoList = new SinglyLinkedCircularList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Todo List Menu:");
            System.out.println("1. Add a todo item");
            System.out.println("2. Delete a todo item");
            System.out.println("3. Round-robin timer (highest to lowest priority)");
            System.out.println("4. Round-robin timer (lowest to highest priority)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a todo item: ");
                    String todoText = scanner.nextLine();
                    System.out.print("Enter priority (1 = highest, 5 = lowest): ");
                    int priority = scanner.nextInt();
                    TodoItem todoItem = new TodoItem(todoText, priority);
                    todoList.insert(todoItem);
                    System.out.println("Todo item added to the list.");
                    break;

                case 2:
                    System.out.print("Enter the todo item to delete: ");
                    String itemToDelete = scanner.nextLine();
                    boolean deleted = todoList.delete(itemToDelete);
                    if (deleted) {
                        System.out.println("Todo item deleted.");
                    } else {
                        System.out.println("No todo item with that description found.");
                    }
                    break;

                case 3:
                    System.out.println("Round-robin timer (highest to lowest priority):");
                    startRoundRobinTimer(todoList, true);
                    break;

                case 4:
                    System.out.println("Round-robin timer (lowest to highest priority):");
                    startRoundRobinTimer(todoList, false);
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void startRoundRobinTimer(SinglyLinkedCircularList<TodoItem> todoList, boolean highestToLowest) {
        currentPriority = highestToLowest ? 1 : 5; // Reset priority to 1 or 5
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                TodoItem todoItem = todoList.getFirstByPriority(currentPriority);
                if (todoItem != null) {
                    System.out.println("Priority " + currentPriority + ": " + todoItem.getDescription());
                    todoList.rotateToNext(currentPriority);
                    currentPriority = getNextPriority(currentPriority, highestToLowest);
                }
            }
        };

        // Schedule the timer to run every 3 seconds for a minute (20 iterations)
        timer.scheduleAtFixedRate(timerTask, 0, 3000);
        try {
            // Run the timer for 60 seconds (60,000 milliseconds)
            Thread.sleep(60000);
            // Cancel the timer after a minute
            timer.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getNextPriority(int currentPriority, boolean highestToLowest) {
        int numPriorities = 5;
        if (highestToLowest) {
            return currentPriority % numPriorities + 1;
        } else {
            return currentPriority > 1 ? currentPriority - 1 : numPriorities;
        }
    }

}
