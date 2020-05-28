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
	
	public void check(String name) {
		Node temp = head;
		while(temp != null) {
			if(name == temp.furniture) {
				temp.counter++;
		}
			temp = temp.next;
		}
	}
	
	public  int display(String name){
		Node temp = head;
		while (temp != null){
			if (temp.furniture == name) {
			return temp.counter;
			}
			temp = temp.next;
		}
		return 0;		
	}
	
	public void delete(String name) {
		Node temp = head;
		System.out.println("lol");
		while(temp != null) {
			if(name == temp.furniture) {
				temp.counter--;
		}
			temp = temp.next;
		}
	}
}
