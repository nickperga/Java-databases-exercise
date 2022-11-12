public class Node {
    protected String data;
    protected Node next = null;
    protected Node prev = null;

    Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    
}
