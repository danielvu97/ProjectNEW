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
	String index1 = "0";
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
		JLabel table = new JLabel(new ImageIcon("TABLE.png"));
		table.setName(index1);
		keypad.add(table);
		
		table.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(table);
				Panel1.add(table);
				Panel1.add(Center);
				x_cursor = x-205;
				y_cursor = y-70;
				
				table.setLocation(x_cursor, y_cursor);
				tables1.Coordinating(table.getName(),x_cursor,y_cursor);
				System.out.println(table.getWidth());
				System.out.println(table.getHeight());
				tables1.iterate();
				
			//	System.out.println(table.getName());
				

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
		
		
		table.addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub
				System.out.println("hej");
				flag = tables1.compareCoordinates(x_cursor,y_cursor,table.getHeight(),table.getWidth());
				if(flag == true) {
					table.setLocation(200,100);
					repaint();
					
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
		JLabel chair = new JLabel(new ImageIcon("CHAIR.png"));
		keypad.add(chair);
		chair.setName(index1);
		chair.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(chair);
				Panel1.add(chair);
				Panel1.add(Center);
				chair.setLocation(x-200, y-50);
				tables1.Coordinating(chair.getName(),x,y);
				tables1.iterate();
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

}
