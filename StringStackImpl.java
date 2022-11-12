import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack{
    
    public Node head = null;
    int size;

    public boolean isEmpty(){
        return head == null;
    }

    public void push(String item){
        Node n = new Node(item);
        head = n;
        size++;
    }

    public String pop() throws NoSuchElementException{
        if (head == null){
            throw new NoSuchElementException();  
        }else{
            Node h1 = head;
            head = head.getPrev();
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

    public void printStack(PrintStream stream){
        while (head != null){
            stream.println(head);
            head = head.getPrev();
        }
    }

    public int size(){
        return size;
    }


}