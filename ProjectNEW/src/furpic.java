import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class furpic extends FurniturePresenter{
	String[] furnitureLoad = new String[30];

	//Necessary global variables
	boolean flag = false;
	int x = 0;
	int y = 0;
	int i = 0;
	int x_cursor = 0;
	int y_cursor = 0;
	Rectangle test;
	static Rectangle [] saveC;
	String index1 = "0";
	boolean deleteflag;
	public static Coordinates tables1;
	static String [] save;
	String str;
	Scanner read;
	static ShoppingList list;
	boolean loadflag = true;
	static JLabel [] tabletext = new JLabel[8];
	int o = 0;
	
	public static void main(String[] args) {
		furpic P = new furpic(); //initialise the program
		tables1 = new Coordinates(); //initialise the obstacles
		save = new String[30]; 
		list = new ShoppingList(); //initialise the shoppinglist and adds the furnitures
		list.add("TABLE");
		list.add("CHAIR");
		list.add("COUCH");
		list.add("TV");
		list.add("WARDROBE");
		list.add("BED");
		list.add("STOVE");
		list.add("TOILET");
		saveC = new Rectangle[30];
		
		for(int i = 0; i <8 ; i++) {
			tabletext[i] = new JLabel();
		}
		
		P.showImage("ROOM_CREATED.png"); //initialise the wallpaper
		P.setVisible(true);
		P.pack();
	}  
	
	/**
	 * @param When button1 aka. TABLE is pressed
	 * @precondition int i < 0 && Panel1 != null;
	 * @postcondition int i > 0;
	 */
	
	//Method for when button 1 is pressed
	@Override
	public void Button1Pressed() {
		assert i < 0 : " checks if it is not below 0";
		assert Panel1 != null:"Checks if there is a room";
		assert list != null: "add furniture to count in ShoppingList";
		list.check("TABLE"); //Increase the counter for table in shoppinglist
		tabletext[0].setText("TABLE x" + list.display("TABLE")); //Changes what will be written in the shoppinglist
		shoppinglist.add(tabletext[0]);	//Updates the framework for shoppinglist
		JLabel furniture = new JLabel(new ImageIcon("TABLE.png")); //Creates a JLabel of table
		furniture.setName(index1); //Gives the furniture a number as its name.
		keypad.add(furniture);
		
		//adds a MouseMotionListener
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) { //Enable us to move the grabbed furniture
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture); //Removes the furniture from keypad so it doesn't reset when another furniture spawns
				
				Panel1.add(furniture); //Adds the furniture to Panel1 instead.
				Panel1.add(Center); //Adds panel1 to center
				x_cursor = x-157; //centers the furniture around the mouse
				y_cursor = y-30;
				System.out.println("Reference " + index1); //prints out the name of the furniture
				
				furniture.setLocation(x_cursor, y_cursor); //updates locations so the furniture follows the mouse
				test = furniture.getBounds(); //get funiture bounds
				tables1.Coordinating(test,furniture.getName()); //save the furniture position in its corresponding position as the name.
				

				repaint(); //repaints the moving furniture so it visually possible to see how it follows the mouse.
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate(); //Part of repainting the furniture.
		i = Integer.parseInt(index1); //Converts furniture name to i
		
		assert i >= 0  : "Error"; //assertion
		
		save[i] = "TABLE"; //Saves a table to the saving arraylist which will be used for creating the textfile to save furnitures.
		i++; //increases the number of i
		index1 = String.valueOf(i); //gives the new string number/name the index of i
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) { //Deletes the furniture if mouse is pressed.
				// TODO Auto-generated method stub
				
				if(deleteflag == true) { //if delete flag is activated.
					list.delete("TABLE"); //Removes counter for table on the list by 1
					tabletext[0].setText("TABLE x" + list.display("TABLE")); //Updates the text in shoppinglist
					shoppinglist.add(tabletext[0]); //Updates the shoppinglist framework
					tables1.deleteCoordinate(furniture.getName()); //Removes the cordinate for the furniture
					Panel1.remove(furniture); //Removes the furniture from the framework
					repaint(); //Changes so the user can see that it gets removed
					deleteflag = false; //resets the delete button
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) { //Checks if two furniture collides or intersects
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100); //moves the furniture to specific location if it collides.
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName()); //Updates the saving position list
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	/*-----------------------------------------------------------------------------------------
	 * 
	 * 
	 * 
	 * The same method from above is applied in all the other furniture buttons
	 * Please check Button1 to understand how Button2 -> Button8 works!
	 * 
	 * 
	 * 
	 * -----------------------------------------------------------------------------------------
	 */

	@Override
	public void Button2Pressed() {
		list.check("CHAIR");
		tabletext[1].setText("CHAIR x" + list.display("CHAIR"));
		shoppinglist.add(tabletext[1]);
		JLabel furniture = new JLabel(new ImageIcon("CHAIR.png"));
		keypad.add(furniture);
		furniture.setName(index1);
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();				 
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-200;
				y_cursor = y-70;
				furniture.setLocation(x_cursor, y_cursor);
				System.out.println("Reference " + index1);
				test = furniture.getBounds();
				tables1.Coordinating(test, furniture.getName());
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "CHAIR";
		i++;
		index1 = String.valueOf(i);
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(deleteflag == true) {
					list.delete("CHAIR");
					tabletext[1].setText("CHAIR x" + list.display("CHAIR"));
					shoppinglist.add(tabletext[1]);
					
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
				}
					repaint();
				// TODO Auto-generated method stub
				
			}
				catch(Exception error) {
					}
				}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button3Pressed() {
		list.check("COUCH");
		tabletext[2].setText("COUCH x" + list.display("COUCH"));
		shoppinglist.add(tabletext[2]);
		JLabel furniture = new JLabel(new ImageIcon("COUCH.png"));
		keypad.add(furniture);
		furniture.setName(index1);
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();				 
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-200;
				y_cursor = y-70;
				furniture.setLocation(x_cursor, y_cursor);
				System.out.println("Reference " + index1);
				test = furniture.getBounds();
				tables1.Coordinating(test, furniture.getName());
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "COUCH";
		i++;
		index1 = String.valueOf(i);
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(deleteflag == true) {
					list.delete("COUCH");
					tabletext[2].setText("COUCH x" + list.display("COUCH"));
					shoppinglist.add(tabletext[2]);
					
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
				}
					repaint();
				// TODO Auto-generated method stub
				
			}
				catch(Exception error) {
					}
				}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public void Button4Pressed() {
		// TODO Auto-generated method stub
		list.check("TV");
		tabletext[3].setText("TV x" + list.display("TV"));
		shoppinglist.add(tabletext[3]);
		JLabel furniture = new JLabel(new ImageIcon("TV.png"));
		furniture.setName(index1);
		keypad.add(furniture);
		
		
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-157;
				y_cursor = y-30;
				
				furniture.setLocation(x_cursor, y_cursor);
				test = furniture.getBounds();
				tables1.Coordinating(test,furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "TV";
		i++;
		index1 = String.valueOf(i);
		
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(deleteflag == true) {
					list.delete("TV");
					tabletext[0].setText("TV x" + list.display("TV"));
					shoppinglist.add(tabletext[3]);
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public void Button5Pressed() {
		// TODO Auto-generated method stub
		list.check("WARDROBE");
		tabletext[4].setText("WARDROBE x" + list.display("WARDROBE"));
		shoppinglist.add(tabletext[4]);
		JLabel furniture = new JLabel(new ImageIcon("WARDROBE.png"));
		furniture.setName(index1);
		keypad.add(furniture);
		
		
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-157;
				y_cursor = y-30;
				
				furniture.setLocation(x_cursor, y_cursor);
				test = furniture.getBounds();
				tables1.Coordinating(test,furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "WARDROBE";
		i++;
		index1 = String.valueOf(i);
		
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(deleteflag == true) {
					list.delete("WARDROBE");
					tabletext[4].setText("WARDROBE x" + list.display("WARDROBE"));
					shoppinglist.add(tabletext[4]);
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void Button6Pressed() {
		// TODO Auto-generated method stub
		list.check("BED");
		tabletext[5].setText("BED x" + list.display("BED"));
		shoppinglist.add(tabletext[5]);
		JLabel furniture = new JLabel(new ImageIcon("BED.png"));
		furniture.setName(index1);
		keypad.add(furniture);
		
		
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-157;
				y_cursor = y-30;
				
				furniture.setLocation(x_cursor, y_cursor);
				test = furniture.getBounds();
				tables1.Coordinating(test,furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "BED";
		i++;
		index1 = String.valueOf(i);
		
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(deleteflag == true) {
					list.delete("BED");
					tabletext[5].setText("BED x" + list.display("BED"));
					shoppinglist.add(tabletext[5]);
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}

	@Override
	public void Button7Pressed() {
		// TODO Auto-generated method stub
		list.check("STOVE");
		tabletext[6].setText("STOVE x" + list.display("STOVE"));
		shoppinglist.add(tabletext[6]);
		JLabel furniture = new JLabel(new ImageIcon("STOVE.png"));
		furniture.setName(index1);
		keypad.add(furniture);
		
		
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-157;
				y_cursor = y-30;
				
				furniture.setLocation(x_cursor, y_cursor);
				test = furniture.getBounds();
				tables1.Coordinating(test,furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "STOVE";
		i++;
		index1 = String.valueOf(i);
		
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(deleteflag == true) {
					list.delete("STOVE");
					tabletext[6].setText("STOVE x" + list.display("STOVE"));
					shoppinglist.add(tabletext[6]);
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void Button8Pressed() {
		// TODO Auto-generated method stub
		list.check("TOILET");
		tabletext[7].setText("TOILET x" + list.display("TOILET"));
		shoppinglist.add(tabletext[7]);
		JLabel furniture = new JLabel(new ImageIcon("TOILET.png"));
		furniture.setName(index1);
		keypad.add(furniture);
		
		
		furniture.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(furniture);
				Panel1.add(furniture);
				Panel1.add(Center);
				x_cursor = x-157;
				y_cursor = y-30;
				
				furniture.setLocation(x_cursor, y_cursor);
				test = furniture.getBounds();
				tables1.Coordinating(test,furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "TOILET";
		i++;
		index1 = String.valueOf(i);
		
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(deleteflag == true) {
					list.delete("TOILET");
					tabletext[7].setText("TOILET x" + list.display("TOILET"));
					shoppinglist.add(tabletext[7]);
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					repaint();
					deleteflag = false;
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
					test = furniture.getBounds();
					tables1.Coordinating(test,furniture.getName());
					
					repaint();
					
				}
				}
				catch(Exception error) {
					
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@SuppressWarnings("resource")
	@Override
	public void ButtonSave(String s) throws IOException { //Initialize save button
		// TODO Auto-generated method stub
		BufferedWriter outputWriter = null;
		saveC = tables1.coordinateValues(); //Reads all the saved coordinates
		
		outputWriter = new BufferedWriter(new FileWriter(s)); //Creates a textfile
	    for (int x = 0; x <i; x++) {
	    	if(saveC[x] != null) { //Goes through the coordinate/saving list
	        outputWriter.write(save[x]); //Saves the name of the furniture for example "TABLE"
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].width)); //Saves the width
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].height)); //Saves the height
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].x)); //Saves the X-cordination of its position
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].y)); //Saves the Y-cordination of its position
	        outputWriter.newLine();
	    	}
	      }
	    outputWriter.flush();
	    outputWriter.close();
	}

	@Override
	public void ButtonDelete() { //actives the delete flag when delete button is pressed.
		// TODO Auto-generated method stub
			deleteflag = true; //The user is only able to delete one furniture at a time.
			
			
	}

	@Override
	public void ButtonLoad(String s) throws IOException { //Initilialize LoadButton
		// TODO Auto-generated method stub
		if(loadflag == true) { //loadflag is true by default so this enables us to only load once!
		saveC = tables1.coordinateValues(); //gets all the coordinates
		File text = new File(s); 
		read =  new Scanner(text); 
		while(read.hasNextLine()) { //Goes through the saved textfile
		str = read.nextLine(); //Goes through line by line
		
		/*/
		 * Checks what's written on the textfile and creates the corresponding furniture
		 */

		if(str.equals("TABLE")) {
			list.check("TABLE");
			tabletext[0].setText("TABLE x" + list.display("TABLE"));
			shoppinglist.add(tabletext[0]);
		}
		
		if(str.equals("CHAIR")) {
			list.check("CHAIR");
			tabletext[1].setText("CHAIR x" + list.display("CHAIR"));
			shoppinglist.add(tabletext[1]);
		}
		if(str.equals("COUCH")) {
			list.check("COUCH");
			tabletext[2].setText("COUCH x" + list.display("COUCH"));
			shoppinglist.add(tabletext[2]);
		}
		if(str.equals("TV")) {
			list.check("TV");
			tabletext[3].setText("TV x" + list.display("TV"));
			shoppinglist.add(tabletext[3]);
		}
		if(str.equals("WARDROBE")) {
			list.check("WARDROBE");
			tabletext[4].setText("WARDROBE x" + list.display("WARDROBE"));
			shoppinglist.add(tabletext[4]);
		}
		if(str.equals("BED")) {
			list.check("BED");
			tabletext[5].setText("BED x" + list.display("BED"));
			shoppinglist.add(tabletext[5]);
		}
		if(str.equals("STOVE")) {
			list.check("STOVE");
			tabletext[6].setText("STOVE x" + list.display("STOVE"));
			shoppinglist.add(tabletext[6]);
		}
		if(str.equals("TOILET")) {
			list.check("TOILET");
			tabletext[7].setText("TOILET x" + list.display("TOILET"));
			shoppinglist.add(tabletext[7]);
		}
		
		JLabel furniture = new JLabel(new ImageIcon( str + ".png")); //Create the furniture
		furniture.setName(index1); //Gives it a string number name
		
		o = Integer.parseInt(furniture.getName());
		
		furnitureLoad[o] = str; //Saves what kind of furniture it is
		Panel1.add(furniture);
		Panel1.add(Center);
		
		int width1 = Integer.parseInt(read.nextLine()); //reads width from textfile
		int height1 = Integer.parseInt(read.nextLine()); //read height from textfile
		
		int x_save = Integer.parseInt(read.nextLine()); //read x position
		int y_save = Integer.parseInt(read.nextLine()); //read y position
		validate();
		
		furniture.setBounds(x_save, y_save,width1,height1);  //draws the loaded furniture in its saved position from textfile.
		repaint();
		
		test = furniture.getBounds(); 
		tables1.Coordinating(test, furniture.getName()); //save the furniture in saving coordinate list
		
		i = Integer.parseInt(index1);
		i++;
		index1 = String.valueOf(i);
		furniture.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) { //ability to move the loaded furniture.
				// TODO Auto-generated method stub
				x = e.getXOnScreen();
				y = e.getYOnScreen();
				x_cursor = x-200;
				y_cursor = y-70;
				furniture.setLocation(x_cursor, y_cursor);	//moves the furniture according to the mouse
				test = furniture.getBounds();
				tables1.Coordinating(test, furniture.getName()); //saves the coordinate 
				repaint();
			}
		});
		
		furniture.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(deleteflag == true) {
					
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					o = Integer.parseInt(furniture.getName());
					
					/*
					 * If a button loaded furniture gets deleted, the shoppinglist will get updated
					 */
					
					if(furnitureLoad[o].equals("TABLE")) {
					list.delete("TABLE"); //decrement one table from shoppinglist
					tabletext[0].setText("TABLE x" + list.display("TABLE")); //updates the text
					shoppinglist.add(tabletext[0]); //update the framework
					}
					
					/*
					 * Same comment is applied below if statements.
					 */
					
					if(furnitureLoad[o].equals("CHAIR")) {
					list.delete("CHAIR");
					tabletext[1].setText("CHAIR x" + list.display("CHAIR"));
					shoppinglist.add(tabletext[1]);
					}
					if(furnitureLoad[o].equals("COUCH")) {
					list.delete("COUCH");
					tabletext[2].setText("COUCH x" + list.display("COUCH"));
					shoppinglist.add(tabletext[2]);
					}
					if(furnitureLoad[o].equals("TV")) {
					list.delete("TV");
					tabletext[3].setText("TV x" + list.display("TV"));
					shoppinglist.add(tabletext[3]);
					}
					if(furnitureLoad[o].equals("WARDROBE")) {
					list.delete("WARDROBE");
					tabletext[4].setText("WARDROBE x" + list.display("WARDROBE"));
					shoppinglist.add(tabletext[4]);
					}
					if(furnitureLoad[o].equals("BED")) {
					list.delete("BED");
					tabletext[5].setText("BED x" + list.display("BED"));
					shoppinglist.add(tabletext[5]);
					}
					if(furnitureLoad[o].equals("STOVE")) {
					list.delete("STOVE");
					tabletext[6].setText("STOVE x" + list.display("STOVE"));
					shoppinglist.add(tabletext[6]);
					}
					if(furnitureLoad[o].equals("TOILET")) {
					list.delete("TOILET");
					tabletext[7].setText("TOILET x" + list.display("TOILET"));
					shoppinglist.add(tabletext[7]);
					}
					
					
					repaint();
					deleteflag = false; //The user is only able to delete one furniture at a time.
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					flag = tables1.compareCoordinates(test,furniture.getName()); //checks if two funritures intersects
					
					if(flag == true) {
						furniture.setLocation(200,100); //set this specific location if it does intersect.
						
						repaint();
						
					}
					}
					catch(Exception error) {
						
					}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		}
		

		

	}
		loadflag = false; //Only able to load once when the program is running.
		
	}
		
	}