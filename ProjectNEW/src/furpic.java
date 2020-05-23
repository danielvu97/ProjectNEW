import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class furpic extends FurniturePresenter{
	
	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		furpic P = new furpic();
		P.showImage("ROOM_CREATED.png");
		P.setVisible(true);
		P.pack();
	}

	@Override
	public void Button1Pressed() {
		JLabel table = new JLabel(new ImageIcon("TABLE.png"));
		keypad.add(table);
		table.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(table);
				Panel1.add(table);
				Panel1.add(Center);
				table.setLocation(x-200, y-50);
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		
	}

	@Override
	public void Button2Pressed() {
		JLabel chair = new JLabel(new ImageIcon("CHAIR.png"));
		keypad.add(chair);
		chair.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				 x = e.getXOnScreen();
				 y = e.getYOnScreen();
				keypad.remove(chair);
				Panel1.add(chair);
				Panel1.add(Center);
				chair.setLocation(x-200, y-50);
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		validate();
		
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
