package prelims;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    public void displayInfos(){
        Node<T> currNode = head;
        while(currNode.getLink() != null){
            System.out.println(currNode.getInfo());
            currNode = currNode.getLink();
        }
        System.out.println(currNode.getInfo());
    }
    public void deleteNode(T data){
        Node<T> currNode = head;
        Node<T> prevNode = null;
        if(currNode.getInfo() == data){//if data is in the first node
            head = currNode.getLink();
        }else{
            //using while loop to get the previous data and the next node
            while(currNode.getInfo() != data){
                prevNode = currNode;
                currNode = currNode.getLink();
            }
            if(currNode.getInfo() == data && currNode.getLink() != null){
                prevNode.setLink(currNode.getLink()); //if data is at the middle
            }else if(currNode.getInfo() == data && currNode.getLink() == null){
                prevNode.setLink(null); // if data is at the last node
            }else{

            }
        }
    }


































    @Override
    public int getSize() {
        Node<T> currNode = head;
        int count = 0;
        while(currNode.getLink() != null){
            count++;
            currNode = currNode.getLink();
        }
        return count;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        if(head == null){
            head = new Node<T>(data);
        }else{
            Node<T> currNode = head;
            while(currNode.getLink() != null){
                currNode = currNode.getLink();
            }
            currNode.setLink(new Node<T>(data));
        }
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        Node<T> currNode = head;
        while(currNode.getInfo() != data){
            currNode = currNode.getLink();
        }
        return currNode.getInfo();
    }

    @Override
    public boolean delete(T data) {
        //retirm true if item has been deleted else false
        //use class method to
        if(search(data) == -1){
            return false;
        }
        deleteNode(data);
        //change or clear pointer here
        return true;
    }

    @Override
    public int search(T data) {
        int count = 1;
        Node<T> currNode = head;
        while(currNode.getInfo() != data){
            currNode = currNode.getLink();
            count++;
        }

        if(currNode.getLink() == null && currNode.getInfo() != data){
            return -1;
        }
        return count;
    }

















//    private T data = null;
//    private MySinglyLinkedList<T> next = null;
//
//    public MySinglyLinkedList() {
//    }
//    public MySinglyLinkedList(T data){
//        this.data = data;
//    }
//    public MySinglyLinkedList(T data, MySinglyLinkedList<T> next){
//        this.data = data;
//        this.next = next;
//    }
//    public T getData(){
//        return data;
//    }
//    public void setData(T data){
//        this.data = data;
//    }
//    public MySinglyLinkedList<T> getNext(){
//        return next;
//    }
//    public void setNext(MySinglyLinkedList<T> next){
//        this.next = next;
//    }
//    public void insertFromHead(MySinglyLinkedList<T> newHead){
//        count++;
//    }
//    public void insertFromTail(MySinglyLinkedList<T> newTail){
//        count++;
//    }
//    public void insertInMiddle(MySinglyLinkedList<T> item,int index){
//        if(index == 0){
//            this.insertFromHead(item);
//        }else{
//            int count = 1;
//            MySinglyLinkedList<T> node = this;
//            MySinglyLinkedList<T> nextNode = this.getNext();
//            while(count <= index) {
//                if(count == index){
//                    node.setNext(item);
//                    item.setNext(nextNode);
//                }else{
//                    node = nextNode;
//                    nextNode = nextNode.getNext();
//                }
//                count++;
//            }
//        }
//    }
//
//    /**
//     * implementation of the MyList interface
//     */
//    @Override
//    public int getSize() {
//        return count;
//    }
//
//    @Override
//    public void insert(T data) throws ListOverflowException {
//    }
//    public void insert(MySinglyLinkedList<T> data) throws ListOverflowException {
//        this.insertFromTail(data);
//    }
//
//    @Override
//    public T getElement(T data) throws NoSuchElementException {
//        return null;
//    }
//
//    @Override
//    public boolean delete(T data) {
//        return false;
//    }
//
//    @Override
//    public int search(T data) {
//        return 0;
//    }
}
