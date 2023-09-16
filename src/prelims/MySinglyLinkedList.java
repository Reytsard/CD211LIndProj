package prelims;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    private Node<T> head = null;

    public void displayInfos(){
        if(head == null){
            System.out.println("List Empty");
        }else{
            Node<T> currNode = head;
            int count = 1;
            while(currNode.getLink() != null){
                System.out.println(count + ". " + currNode.getInfo());
                currNode = currNode.getLink();
                count++;
            }
            System.out.println(count + ". " + currNode.getInfo());
        }

    }
    private void deleteNode(T data){
        Node<T> currNode = head;
        Node<T> prevNode = null;
        if(currNode.getInfo() == data){//if data is in the first node
            head = currNode.getLink();
        }else{
            //using while loop to get the previous data and the next node
            while(currNode != null && currNode.getInfo() != data){
                prevNode = currNode;
                currNode = currNode.getLink();
            }
            if(currNode != null && currNode.getInfo() == data && currNode.getLink() != null){
                prevNode.setLink(currNode.getLink()); //if data is at the middle
            }else if(currNode != null && currNode.getInfo() == data && currNode.getLink() == null){
                prevNode.setLink(null); // if data is at the last node
            }
        }
        //fix deletion of a node
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
    public void insert(T data) {
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
        if(search(data) == -1){
            return false;
        }
        deleteNode(data);
        return true;
    }

    @Override
    public int search(T data) {
        int count = 0;
        if(head == null){
            return -1;
        }else{
            Node<T> currNode = head;
            while(currNode != null && currNode.getInfo() != data){
                currNode = currNode.getLink();
                count++;
            }

            if(currNode != null && currNode.getLink() == null && currNode.getInfo() != data){
                return -1;
            }
        }

        return count;
    }

}
