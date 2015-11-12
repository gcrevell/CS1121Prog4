import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class Program4 {
	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		if (args.length < 1) {
			System.out.println("Too few arguemnts. Exiting...");
			System.exit(-1);
		}
		
		FileReader in = null;
		
		try {
			in = new FileReader(new File(args[0]));
		} catch (FileNotFoundException e) {
			System.out.println("That file cannot be found. Exinting...");
			e.printStackTrace();
			System.exit(-2);
		}
		
		int size = Integer.parseInt((char)(readChar(in)) + "" + (char)(readChar(in)));
		Queue<Character> q = new Queue<Character>(size);
		int c = 0;
		
		while ((c = readChar(in)) != -1) {
			q.enqueue((char) c);
			
			if (q.isFull()) {
				while (!q.isEmpty()) {
					System.out.print(q.dequeue());
				}
				System.out.println();
			}
		}
		
		while (!q.isEmpty()) {
			System.out.print(q.dequeue());
		}
	}
	
	private static int readChar(FileReader in) {
		try {
			return in.read();
		} catch (IOException e) {
			System.out.println("Problem reading in the next character.");
			e.printStackTrace();
			System.exit(-3);
		}
		return -1;
	}
}