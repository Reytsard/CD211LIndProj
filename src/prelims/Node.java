package prelims;

public class Node<T>{
    private T info;
    private Node<T> link;
    public Node(){
        info = null;
        link = null;
    }
    public Node(T datum){
        info = datum;
    }
    public Node(T datum, Node<T> link){
        info = datum;
        this.link = link;
    }
    public T getInfo(){
        return info;
    }
    public void setInfo(T info){
        this.info = info;
    }
    public Node<T> getLink(){
        return link;
    }
    public void setLink(Node<T> nextNode){
        link = nextNode;
    }
    public String toString(){
        return ""+info;
    }
}
