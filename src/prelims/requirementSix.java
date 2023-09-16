package prelims;

import java.util.NoSuchElementException;

public class requirementSix {
    public static void main(String[] args) {
        DoublyLinkedCircularList<Integer> list = new DoublyLinkedCircularList<>();

        // Insert elements
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        // Display elements
        list.displayInfos(); // This should print 1, 2, 3, 4

        // Get element
        try {
            int element = list.getElement(3);
            System.out.println("Element 3 found: " + element); // This should print "Element 3 found: 3"
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }

        // Delete element
        boolean deleted = list.delete(2);
        if (deleted) {
            System.out.println("Element 2 deleted");
        } else {
            System.out.println("Element 2 not found");
        }

        // Display elements after deletion
        list.displayInfos(); // This should print 1, 3, 4

        // Search element
        int index = list.search(3);
        if (index != -1) {
            System.out.println("Element 3 found at index: " + index); // This should print "Element 3 found at index: 1"
        } else {
            System.out.println("Element 3 not found");
        }
    }
}
