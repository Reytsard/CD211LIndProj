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
    public void insert(T data) throws ListOverflowException {

    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean delete(T data) {
        return false;
    }

    @Override
    public int search(T data) {
        return 0;
    }
}
