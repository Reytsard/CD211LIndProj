package prelims;

import java.util.NoSuchElementException;

public class SinglyLinkedCircularList<T> implements MyList<T>{
    private Node<T> head = null;
    public void displayInfos(){
        Node<T> currNode = head;
        while(currNode.getLink() != head){
            System.out.println(currNode.getInfo());
            currNode = currNode.getLink();
        }
        System.out.println(currNode.getInfo());
    }
    public int getSize() {
        int count = 0;
        if(head == null){
            return 0;
        }else{
            count++;
            Node<T> currNode = head;
            while(currNode.getLink() != head){
                count++;
                currNode = currNode.getLink();
            }
            return count;
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            newNode.setLink(head);
        }else{
            Node<T> currNode = head;
            while(currNode.getLink() != head){
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

    public boolean delete(T data) {
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
        if(head == null){
            return -1;
        }else{
            while(currNode.getInfo() != data){
                count++;
                currNode = currNode.getLink();
            }
            return count;
        }
    }
}
