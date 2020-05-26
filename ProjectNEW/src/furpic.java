import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
	String index1 = "0";
	boolean deleteflag;
	public static Coordinates tables1;
	
	
	
	public static void main(String[] args) {
		furpic P = new furpic();
		tables1 = new Coordinates();
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
		int i = Integer.parseInt(index1);
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

	@Override
	public void ButtonSave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ButtonDelete() {
		// TODO Auto-generated method stub
			deleteflag = true;
	}
		
		
	}

