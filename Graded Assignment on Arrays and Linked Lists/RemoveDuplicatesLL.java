
import java.util.HashSet;

class Node {
	int val;
	Node next;
	
	public Node(int val) {
		this.val = val;
		this.next = null;
	}
}

class Linkedlist {
	Node head;
	
	public Linkedlist() {
		this.head = null;
	}
	
	public void add(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
		}
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	public void removeDuplicates() {
		if (head ==  null) {
			return;
		}
		HashSet<Integer> uniqueElements = new HashSet<>();
		Node temp = head;
		Node prev = null;
		
		while(temp != null) {
			if(uniqueElements.contains(temp.val)) {
				prev.next = temp.next;
			}
			else {
				uniqueElements.add(temp.val);
				prev = temp;
			}
			temp = temp.next;
		}
	}
	
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.val+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
}
public class RemoveDuplicatesLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist list = new Linkedlist();
		list.add(2);
		list.add(5);
		list.add(12);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(5);
		
		System.out.println("Input: ");
		list.display();
		
		list.removeDuplicates();
		
		System.out.println("Output: ");
		list.display();
	}

}
