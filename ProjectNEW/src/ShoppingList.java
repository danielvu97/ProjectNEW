public class ShoppingList {
	
	//A LinkedList method which saves the furnitures in nodes
	
	//Creates the Node containing data.
	private class Node{
		String furniture;
		int counter = 0;
		Node next;	
	}
	
	//reference node
	Node head;
	
	ShoppingList(){
		this.head = null;
	};

	//A method which adds a Node to the list
	public void add(String name) {
			Node temp = new Node(); //creates a temporary node
			
			assert temp == null : "temp always empty in the beginning"; //assertion precondition
			
			temp.furniture = name; //Takes the input and saves it as data in the temporary node
			temp.next = head; //points toward the old head
			head = temp; //updates the lists so the temporary node becomes the new head.
			
			assert head != null : "After an addition to the node, head should never be null"; //assertion postcondition
			assert temp.next == null : "The next node always empty after execution";
			assert head.furniture == name : "head has the name";
			
	}
	
	//A method which increases the counter for each node. The counter is what is displayed on the framework.
	public void check(String name) { //Selects the furniture by receiving an input
		Node temp = head; //creates a temporary node
		int c = temp.counter;
		while(temp != null) { //Goes through the whole list
			if(name == temp.furniture) {
				temp.counter++; //if the furniture name is equal to the input, increase the counter for that furniture.
				assert temp.counter != c : "After finding the name increment the counter";
		}
			temp = temp.next; //checks the next node.

		}
		
	}
	
	//A Method which returns the counter of the called furniture
	public  int display(String name){
		Node temp = head;
		while (temp != null){ //Goes through the list
			if (temp.furniture == name) { //if input is equal the furniture name return counter.
			return temp.counter;
			}
			temp = temp.next; //checks the next node.
		}
		return 0;		//returns 0 if temp is null
	}
	
	//A Method which decreases the counter for the called node.
	public void delete(String name) { //Selects the furniture
		Node temp = head;
		int c = temp.counter;
		while(temp != null) { //Goes through the list
			if(name == temp.furniture) { //if input is equal furniture, decrease the counter
				temp.counter--;
				assert temp.counter != c : "After finding the node subtract 1 with the counter";
		}
			temp = temp.next; //checks the next node.
		}
	}
}
