package prelims;

public class DLNode<T> {
    private DLNode<T> prevNode;
    private DLNode<T> nextNode;
    private T info;
    public DLNode(){
        this.prevNode = null;
        this.nextNode = null;
    }
    public DLNode(T data){
        this.prevNode = null;
        this.nextNode = null;
        this.info = data;
    }
    public DLNode(T info, DLNode<T> nextNode){
        this.prevNode = null;
        this.nextNode = nextNode;
        this.info = info;
    }
    public DLNode(T info, DLNode<T> nextNode,DLNode<T> prevNode){
        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.info = info;
    }
    public DLNode<T> getPrevNode(){
        return this.prevNode;
    }
    public void setPrevNode(DLNode<T> prevNode){
        this.prevNode = prevNode;
    }
    public DLNode<T> getNextNode(){
        return this.nextNode;
    }
    public void setNextNode(DLNode<T> nextNode){
        this.nextNode = nextNode;
    }

}
