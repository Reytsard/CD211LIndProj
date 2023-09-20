package prelims.reqFive;

import prelims.Node;

import java.util.NoSuchElementException;

public class SinglyLinkedCircularList<T> {
    private Node<T> head = null;

    public void displayInfos() {
        Node<T> currNode = head;
        while (currNode.getLink() != head) {
            System.out.println(currNode.getInfo());
            currNode = currNode.getLink();
        }
        System.out.println(currNode.getInfo());
    }

    public int getSize() {
        int count = 0;
        if (head == null) {
            return 0;
        } else {
            count++;
            Node<T> currNode = head;
            while (currNode.getLink() != head) {
                count++;
                currNode = currNode.getLink();
            }
            return count;
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            newNode.setLink(head);
        } else {
            Node<T> currNode = head;
            while (currNode.getLink() != head) {
                currNode = currNode.getLink();
            }
            currNode.setLink(newNode);
            newNode.setLink(head);
        }
    }

    public T getElement(T data) throws NoSuchElementException {
        Node<T> currNode = head;

        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        do {
            if (currNode.getInfo().equals(data)) {
                return currNode.getInfo();
            }
            currNode = currNode.getLink();
        } while (currNode != head);

        throw new NoSuchElementException("Element not found in the list");
    }

    public boolean delete(String data) {
        if (head == null) {
            return false; // List is empty, nothing to delete
        }

        Node<T> currNode = head;
        Node<T> prevNode = null;
        boolean deleted = false;

        do {
            if (currNode.getInfo().equals(data)) {
                // Found the element to delete
                if (currNode == head) {
                    // If it's the head node, update head and link of the last node
                    Node<T> lastNode = head;
                    while (lastNode.getLink() != head) {
                        lastNode = lastNode.getLink();
                    }
                    if (lastNode == head) {
                        head = null; // List contains only one element, so remove it
                    } else {
                        head = head.getLink(); // Update the head to the next element
                        lastNode.setLink(head); // Update the last node's link
                    }
                } else {
                    // If it's not the head node, remove it by updating the previous node's link
                    prevNode.setLink(currNode.getLink());
                }
                deleted = true;
                break;
            }
            prevNode = currNode;
            currNode = currNode.getLink();
        } while (currNode != head);

        return deleted;
    }

    public int search(T data) {
        Node<T> currNode = head;
        int count = 0;
        if (head == null) {
            return -1;
        } else {
            while (!currNode.getInfo().equals(data)) {
                count++;
                currNode = currNode.getLink();
                if (currNode == head) {
                    return -1; // Element not found
                }
            }
            return count;
        }
    }

    public T getFirstByPriority(int priority) {
        Node<T> currNode = head;
        if (head == null) {
            return null; // List is empty
        } else {
            do {
                TodoItem item = (TodoItem) currNode.getInfo();
                if (item.getPriority() == priority) {
                    return currNode.getInfo();
                }
                currNode = currNode.getLink();
            } while (currNode != head);
            return null; // No item with the specified priority found
        }
    }

    public void rotateToNext(int priority) {
        Node<T> currNode = head;
        Node<T> prevNode = null;

        if (head == null) {
            return; // List is empty, nothing to rotate
        }

        do {
            TodoItem item = (TodoItem) currNode.getInfo();
            if (item.getPriority() == priority) {
                if (prevNode == null) {
                    // If it's the head node, update the head
                    head = head.getLink();
                } else {
                    // If it's not the head node, rotate by updating the previous node's link
                    prevNode.setLink(currNode.getLink());
                }
                // Move the current node to the end
                Node<T> lastNode = head;
                while (lastNode.getLink() != head) {
                    lastNode = lastNode.getLink();
                }
                lastNode.setLink(currNode);
                currNode.setLink(head);
                break;
            }
            prevNode = currNode;
            currNode = currNode.getLink();
        } while (currNode != head);
    }
}