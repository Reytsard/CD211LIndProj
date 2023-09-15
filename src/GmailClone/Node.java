package GmailClone;

public class Node<T> {
    private T info;
    private Node<T> link;
    Node(){
        this.info = null;
        this.link = null;
    }
    Node(T info){
        this.info = info;
        this.link = null;
    }
    Node(T info, Node<T> link){
        this.info = info;
        this.link = link;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getLink() {
        return link;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

}
