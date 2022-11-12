import java.io.PrintStream;
import java.util.NoSuchElementException;

public interface StringStack {


	
	public boolean isEmpty();

	public void push(String item);
	
	public String pop() throws NoSuchElementException;

	public String peek() throws NoSuchElementException;

	public void printStack(PrintStream stream);

	public int size();

}
