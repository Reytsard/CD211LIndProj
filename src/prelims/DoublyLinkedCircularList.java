package prelims;

import java.util.NoSuchElementException;

public class DoublyLinkedCircularList<T> implements MyList<T> {
    private DLNode<T> head = null;

    public void displayInfos() {
        if (head == null) {
            return;
        }

        DLNode<T> currNode = head;
        do {
            System.out.println(currNode.getInfo());
            currNode = currNode.getNextNode();
        } while (currNode != head);
    }

    public int getSize() {
        int count = 0;
        if (head == null) {
            return 0;
        } else {
            count++;
            DLNode<T> currNode = head.getNextNode();
            while (currNode != head) {
                count++;
                currNode = currNode.getNextNode();
            }
            return count;
        }
    }

    public void insert(T data) {
        DLNode<T> newNode = new DLNode<>(data);
        if (head == null) {
            head = newNode;
            head.setNextNode(head);
            head.setPrevNode(head);
        } else {
            DLNode<T> prevNode = head.getPrevNode();
            prevNode.setNextNode(newNode);
            newNode.setPrevNode(prevNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
        }
    }

    public T getElement(T data) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        DLNode<T> currNode = head;
        do {
            if (currNode.getInfo().equals(data)) {
                return currNode.getInfo();
            }
            currNode = currNode.getNextNode();
        } while (currNode != head);

        throw new NoSuchElementException("Element not found in the list");
    }

    public boolean delete(T data) {
        if (head == null) {
            return false; // List is empty, nothing to delete
        }

        DLNode<T> currNode = head;
        do {
            if (currNode.getInfo().equals(data)) {
                DLNode<T> prevNode = currNode.getPrevNode();
                DLNode<T> nextNode = currNode.getNextNode();
                prevNode.setNextNode(nextNode);
                nextNode.setPrevNode(prevNode);

                if (currNode == head) {
                    head = nextNode; // Update head if deleting the head DLNode
                }

                return true;
            }
            currNode = currNode.getNextNode();
        } while (currNode != head);

        return false; // Element not found in the list
    }

    public int search(T data) {
        if (head == null) {
            return -1;
        }

        DLNode<T> currNode = head;
        int count = 0;
        do {
            if (currNode.getInfo().equals(data)) {
                return count;
            }
            currNode = currNode.getNextNode();
            count++;
        } while (currNode != head);

        return -1; // Element not found in the list
    }
}