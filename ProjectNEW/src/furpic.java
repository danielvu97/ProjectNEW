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

public class furpic extends FurniturePresenter{
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
	static Saver saver;
	Scanner read;
	boolean loadflag = true;

		 
	
	public static void main(String[] args) {
		furpic P = new furpic();
		tables1 = new Coordinates();
		saver = new Saver();
		save = new String[10];
		
		saveC = new Rectangle[10];
		
		P.showImage("ROOM_CREATED.png");
		P.setVisible(true);
		P.pack();
	}  
	
	

	@Override
	public void Button1Pressed() {
		JLabel furniture = new JLabel(new ImageIcon("TABLE.png"));
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
				System.out.println(furniture.getName());
				

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		i = Integer.parseInt(index1);
		save[i] = "TABLE";
		System.out.println(i);
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
					
					tables1.deleteCoordinate(furniture.getName());
					Panel1.remove(furniture);
					//i = Integer.parseInt(index1);
					//i--;
					//index1 = String.valueOf(i);
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
	public void Button2Pressed() {
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
		System.out.println(i);
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
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
				flag = tables1.compareCoordinates(test,furniture.getName());
				if(flag == true) {
					furniture.setLocation(200,100);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button4Pressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button5Pressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button6Pressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button7Pressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Button8Pressed() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("resource")
	@Override
	public void ButtonSave() throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter outputWriter = null;
		saveC = tables1.coordinateValues();
		
		outputWriter = new BufferedWriter(new FileWriter("Room_Saved.txt"));
	    System.out.print(i);
	    for (int x = 0; x <i; x++) {
	    	if(saveC[x] != null) {
	        outputWriter.write(save[x]);
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].width));
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].height));
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].x));
	        outputWriter.newLine();
	        outputWriter.write(Integer.toString(saveC[x].y));
	        outputWriter.newLine();
	        
	    	}
	      }
	    
	    outputWriter.flush();
	    outputWriter.close();
	}

	@Override
	public void ButtonDelete() {
		// TODO Auto-generated method stub
			deleteflag = true;
			
			
	}

	@Override
	public void ButtonLoad() throws IOException {
		// TODO Auto-generated method stub
		if(loadflag == true) {
		saveC = tables1.coordinateValues();
		File text = new File("Room_Saved.txt"); 
		read =  new Scanner(text);
		while(read.hasNextLine()) {
		str = read.nextLine();
		JLabel furniture = new JLabel(new ImageIcon( str + ".png"));
		furniture.setName(index1);
		
		Panel1.add(furniture);
		Panel1.add(Center);
		
		int width1 = Integer.parseInt(read.nextLine());
		int height1 = Integer.parseInt(read.nextLine());
		
		int x_save = Integer.parseInt(read.nextLine());
		int y_save = Integer.parseInt(read.nextLine());
		validate();
		
		furniture.setBounds(x_save, y_save,width1,height1); 
		repaint();
		
		test = furniture.getBounds();
		tables1.Coordinating(test, furniture.getName());
		
		i = Integer.parseInt(index1);
		i++;
		index1 = String.valueOf(i);
		furniture.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				x = e.getXOnScreen();
				y = e.getYOnScreen();
				x_cursor = x-200;
				y_cursor = y-70;
				furniture.setLocation(x_cursor, y_cursor);	
				test = furniture.getBounds();
				tables1.Coordinating(test, furniture.getName());
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
					//i = Integer.parseInt(index1);
					//i--;
					//index1 = String.valueOf(i);
					repaint();
					deleteflag = false;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					flag = tables1.compareCoordinates(test,furniture.getName());
					for(int i = 0; i < saveC.length;i++) {
						System.out.println(saveC[i]);
					}
					
					if(flag == true) {
						furniture.setLocation(200,100);
						
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
		loadflag = false;
		
	}
		
	}

