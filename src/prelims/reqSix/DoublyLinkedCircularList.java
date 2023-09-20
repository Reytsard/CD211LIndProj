package prelims.reqSix;

import prelims.DLNode;
import prelims.ListOverflowException;
import prelims.MyList;

import java.util.NoSuchElementException;

public class DoublyLinkedCircularList<T> implements MyList<T> {
    private DLNode<T> head = null;
    private DLNode<T> tail = null;

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

    @Override
    public void insert(T data) throws ListOverflowException {

    }

    public void addToTail(T data) {
        DLNode<T> newNode = new DLNode<>(data);
        if (head == null) {
            head = newNode;
            head.setNextNode(head);
            head.setPrevNode(head);
            tail = head; // Initialize tail if it's the first node
        } else {
            DLNode<T> prevNode = tail;
            prevNode.setNextNode(newNode);
            newNode.setPrevNode(prevNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            tail = newNode; // Update tail to the new node
        }
    }

    public void addToHead(T data) {
        DLNode<T> newNode = new DLNode<>(data);
        if (head == null) {
            head = newNode;
            head.setNextNode(head);
            head.setPrevNode(head);
            tail = head; // Initialize tail if it's the first node
        } else {
            DLNode<T> prevNode = tail;
            prevNode.setNextNode(newNode);
            newNode.setPrevNode(prevNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            head = newNode; // Update head to the new node
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

                if (currNode == tail) {
                    tail = prevNode; // Update tail if deleting the tail DLNode
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
    public DLNode<T> getHead() {
        return head;
    }

    public void setHead(DLNode<T> head) {
        this.head = head;
    }

    public DLNode<T> getTail() {
        return tail;
    }

    public void setTail(DLNode<T> tail) {
        this.tail = tail;
    }
    public void insert(T data, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > getSize()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        DLNode<T> newNode = new DLNode<>(data);

        if (head == null) {
            // If the list is empty, insert as the only node
            head = newNode;
            head.setNextNode(head);
            head.setPrevNode(head);
            tail = head; // Initialize tail if it's the first node
        } else if (position == 0) {
            // Insert at the head
            DLNode<T> prevNode = tail;
            prevNode.setNextNode(newNode);
            newNode.setPrevNode(prevNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            head = newNode; // Update head to the new node
        } else if (position == getSize()) {
            // Insert at the tail
            DLNode<T> prevNode = tail;
            prevNode.setNextNode(newNode);
            newNode.setPrevNode(prevNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            tail = newNode; // Update tail to the new node
        } else {
            // Insert at a specific position
            DLNode<T> currNode = head;
            int count = 0;
            while (count < position - 1) {
                currNode = currNode.getNextNode();
                count++;
            }
            DLNode<T> nextNode = currNode.getNextNode();
            currNode.setNextNode(newNode);
            newNode.setPrevNode(currNode);
            newNode.setNextNode(nextNode);
            nextNode.setPrevNode(newNode);
        }
    }
    public TodoItem getFirstByPriority(int priority) {
        if (head == null) {
            return null; // List is empty
        }

        DLNode<T> currNode = head;
        do {
            TodoItem todoItem = (TodoItem) currNode.getInfo();
            if (todoItem.getPriority() == priority) {
                return todoItem;
            }
            currNode = currNode.getNextNode();
        } while (currNode != head);

        return null; // Priority not found in the list
    }

    public void rotateToNext(int priority) {
        if (head == null) {
            return; // List is empty
        }

        DLNode<T> currNode = head;
        do {
            TodoItem todoItem = (TodoItem) currNode.getInfo();
            if (todoItem.getPriority() == priority) {
                DLNode<T> nextNode = currNode.getNextNode();
                if (nextNode != head) {
                    head = nextNode;
                }
                return; // Rotation completed
            }
            currNode = currNode.getNextNode();
        } while (currNode != head);
    }

    public boolean deleteByDescription(String description) {
        if (head == null) {
            return false; // List is empty, nothing to delete
        }

        DLNode<T> currNode = head;
        do {
            TodoItem todoItem = (TodoItem) currNode.getInfo();
            if (todoItem.getDescription().equals(description)) {
                DLNode<T> prevNode = currNode.getPrevNode();
                DLNode<T> nextNode = currNode.getNextNode();
                prevNode.setNextNode(nextNode);
                nextNode.setPrevNode(prevNode);

                if (currNode == head) {
                    head = nextNode; // Update head if deleting the head Node
                }

                return true; // Deletion completed
            }
            currNode = currNode.getNextNode();
        } while (currNode != head);

        return false; // Description not found in the list
    }

}
