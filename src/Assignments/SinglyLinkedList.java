package Assignments;

import prelims.ListOverflowException;
import prelims.MyList;
import prelims.Node;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements MyList<T> {
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
    public void insert(T data) throws ListOverflowException { //inserts lexicographically
            Node<T> newNode = new Node<>(data);
            Node<T> currNode = head;
            Node<T> prevNode = null;
            if(currNode == null){
                head = new Node<T>(data);
            }

            while(currNode != null && currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0){
                prevNode = currNode;
                currNode = currNode.getLink();
                System.out.println();
                System.out.println(prevNode.getInfo());
//                System.out.println(currNode.getInfo());
            }



















//            else if(currNode.getLink() == null && currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0){
//                System.out.println("newNode: "+ newNode.getInfo());
//                System.out.println("currNode: "+ currNode.getInfo());
//                currNode.setLink(newNode);
////                while(currNode.getLink() != null && currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0){
////                    prevNode = currNode;
////                    currNode = currNode.getLink();
////                    System.out.println(prevNode.getInfo());
////                    System.out.println(currNode.getInfo());
////                }
////                currNode.setLink(new Node<T>(data));
//            } else if (currNode.getLink() != null && currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0) {
//
//            }
    }

    /**
     * if (currNode.getInfo().toString().compareTo(newNode.getInfo().toString()) > 0) {//if data is will be at the front
     *                     newNode.setLink(currNode);
     *                     head = newNode;
     *                 }else if(currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0){
     *                     try{
     *                         while(currNode.getInfo().toString().compareToIgnoreCase(newNode.getInfo().toString()) < 0){
     *
     *                             prevNode = currNode;
     *                             currNode = currNode.getLink();
     *                         }
     *                         newNode.setLink(currNode);
     *                         prevNode.setLink(newNode);
     *                     }catch (NullPointerException e){
     *                         System.out.println("Error: "+ e);
     *                     }
     *                 }else{ */

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
}
