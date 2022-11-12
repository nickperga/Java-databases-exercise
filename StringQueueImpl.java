import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl implements StringQueue{

    public Node head = null;
    public Node tail = null;

    int size;

    public boolean isEmpty(){
        return head == null;
    }

    public void put(String item){
        Node n = new Node(item);
        tail = n;
        if(head == null){
            head=n;
        }
        size++;
    }

    public String get() throws NoSuchElementException{
        if (head == null){
            throw new NoSuchElementException();  
        }else{
            Node h1 = head;
            head = head.getNext();
            size--;
            return h1.getData();
        }
    }

    public String peek() throws NoSuchElementException{
        if (head == null){
            throw new NoSuchElementException();  
        }else{
            return head.getData();
        }
    }
    
    public void printQueue(PrintStream stream){
        while (head != tail){
            stream.println(head);
            head = head.getNext();
        }
        stream.println(head);
    }
    
    public int size(){
        return size;
    }




}