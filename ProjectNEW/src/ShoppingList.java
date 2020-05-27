public class ShoppingList {
	
	private class Node{
		String furniture;
		int counter = 0;
		Node next;	
	}
	
	Node head;
	
	ShoppingList(){
		this.head = null;
	};

	public void add(String name) {
			Node temp = new Node();
			
			temp.furniture = name;
			temp.next = head;
			head = temp;
			
	}
	
	public int check(String name) {
		Node temp = head;
		while(temp != null) {
			if(name == temp.furniture) {
				temp.counter++;
		}
			temp = temp.next;
		}
		return temp.counter;
	}
	
	public void display(){
		Node temp = head;
		while (temp != null){
			System.out.printf(temp.furniture + " "+ temp.counter);
			System.out.println();
			temp = temp.next;
		}		
	}
public static void main(String[]args) {
		
		ShoppingList list = new ShoppingList();
		
		list.add("Table");
		list.add("Chair");
		list.add("Couch");
		
		list.check("Table");
		list.check("Table");
		list.display();
}
}
