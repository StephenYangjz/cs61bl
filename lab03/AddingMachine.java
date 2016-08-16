import java.util.*;

public class AddingMachine {
	int val;
	AddingMachine next;

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean justStarting = true;
		int total = 0;
		int subtotal = 0;
		int input;
		int last = 1;
		int MAXIMUM_NUMBER_OF_INPUTS = 100;
		AddingMachine head = new AddingMachine();
		AddingMachine point = head;
		while (true) {
			input = scanner.nextInt();
			if (input == 0) {
				if (last == 0) {
					System.out.println("total " + total);
					while(head.next!=null){
						System.out.println(head.val);
						head = head.next;
					}
					return;
				}
				System.out.println("subtotal " + subtotal);
				total += subtotal;
				subtotal = 0;
			}
			else{
				point.val = input;
				point.next = new AddingMachine();
				point = point.next;
			}
			subtotal += input;
			last = input;
		    // TODO Your code here
		}
	}

}
