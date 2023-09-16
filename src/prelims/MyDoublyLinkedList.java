package prelims;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> implements MyList<T> {
    private DLNode<T> head;
    private DLNode<T> tail;
    public MyDoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public MyDoublyLinkedList(DLNode<T> head){
        this.head = head;
        this.tail = head;
    }
    public MyDoublyLinkedList(DLNode<T> head, DLNode<T> tail){
        this.head = head;
        this.tail = tail;
    }

    public void displayList(){
        DLNode<T> node = head;
        if(head == null){
            System.out.println("List empty");
        }else{
            /** this will loop through and print the node's info */
            while(node.getNextNode() != null){
                System.out.println(node.getInfo());
                node = node.getNextNode();
            }
            System.out.println(node.getInfo()); //will print na last node
        }
    }

    @Override
    public int getSize() {
        DLNode<T> currNode = head;
        int count = 0;
        while(currNode.getNextNode() != null){
            count++;
            currNode = currNode.getNextNode();
        }
        return count;
    }

    @Override
    public void insert(T data) {
        DLNode<T> newNode = new DLNode<>(data);
        DLNode<T> currNode = tail;

        if(tail != null){
            currNode.setNextNode(newNode);
            newNode.setPrevNode(currNode);
            tail = newNode;
        }else if(head == null){
            this.head = newNode;
            this.tail = head;
        }
        // to be continued
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        DLNode<T> currNode = head;
        while(currNode.getInfo() != data){
            currNode = currNode.getNextNode();
        }
        return currNode.getInfo();
    }

    @Override
    public boolean delete(T data) {
        if(search(data) == -1){
            return false;
        }
        deleteNode(data);
        return true;
    }
    private void deleteNode(T data){
        DLNode<T> currNode = head;
        DLNode<T> prevNode = null;
        if(currNode.getInfo() == data){//if data is in the first node
            head = currNode.getNextNode();
        }else{
            //using while loop to get the previous data and the next node
            while(currNode.getInfo() != data){
                prevNode = currNode;
                currNode = currNode.getNextNode();
            }
            if(currNode.getInfo() == data && currNode.getNextNode() != null){
                prevNode.setNextNode(currNode.getNextNode()); //if data is at the middle
            }else if(currNode.getInfo() == data && currNode.getNextNode() == null){
                prevNode.setNextNode(null); // if data is at the last node
            }
        }
    }

    @Override
    public int search(T data) {
        int count = 1;
        DLNode<T> currNode = head;
        while(currNode.getInfo() != data){
            currNode = currNode.getNextNode();
            count++;
        }

        if(currNode.getNextNode() == null && currNode.getInfo() != data){
            return -1;
        }
        return count;
    }
}
