package prelims.reqSix;

import prelims.ListOverflowException;
import prelims.reqSix.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class requirementSix {
    private static int currentPriority = 1; // Current priority level for round-robin timer
    private static Timer timer = new Timer();
    private static long itemDuration = 3000; // Default item duration (in milliseconds)
    private static long roundRobinDuration = 60000; // Default round-robin duration (in milliseconds)

    public static void main(String[] args) {
        DoublyLinkedCircularList<TodoItem> todoList = new DoublyLinkedCircularList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Todo List Menu:");
            System.out.println("1. Add a todo item");
            System.out.println("2. Delete a todo item");
            System.out.println("3. Round-robin timer (highest to lowest priority)");
            System.out.println("4. Round-robin timer (lowest to highest priority)");
            System.out.println("5. Set item duration");
            System.out.println("6. Set round-robin duration");
            System.out.println("7. Exit");
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
                    try {
                        todoList.insert(todoItem);
                    } catch (ListOverflowException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Todo item added to the list.");
                    break;

                case 2:
                    System.out.print("Enter the todo item description to delete: ");
                    String itemToDelete = scanner.nextLine();
                    boolean deleted = todoList.deleteByDescription(itemToDelete);
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
                    System.out.print("Enter item duration (in milliseconds): ");
                    itemDuration = scanner.nextLong();
                    System.out.println("Item duration set to " + itemDuration + " milliseconds.");
                    break;

                case 6:
                    System.out.print("Enter round-robin duration (in milliseconds): ");
                    roundRobinDuration = scanner.nextLong();
                    System.out.println("Round-robin duration set to " + roundRobinDuration + " milliseconds.");
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void startRoundRobinTimer(DoublyLinkedCircularList<TodoItem> todoList, boolean highestToLowest) {
        currentPriority = highestToLowest ? 1 : 5; // Reset priority to 1 or 5

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                TodoItem todoItem = todoList.getFirstByPriority(currentPriority);
                if (todoItem != null) {
                    System.out.println("Priority " + currentPriority + ": " + todoItem.getDescription());
                    currentPriority = getNextPriority(currentPriority, highestToLowest);
                }
            }
        };

        // Schedule the timer to run every itemDuration milliseconds
        long itemInterval = itemDuration;
        timer.scheduleAtFixedRate(timerTask, 0, itemInterval);

        try {
            // Run the timer for roundRobinDuration milliseconds
            Thread.sleep(roundRobinDuration);
            // Cancel the timer after roundRobinDuration
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
