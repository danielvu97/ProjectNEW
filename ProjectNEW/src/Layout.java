import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Layout extends JFrame implements ActionListener {

	JComponent Center = createFurnitureComponent();
	JPanel Panel1 = new JPanel();
	JPanel keypad = new JPanel();
	JPanel savepad = new JPanel();
	JButton b1 = new JButton("Table");
	JButton b2 = new JButton("Chair");
	JButton b3 = new JButton("Sofa");
	JButton b4 = new JButton("TV");
	JButton b5 = new JButton("Wardrobe");
	JButton b6 = new JButton("Bed");
	JButton b7 = new JButton("Stove");
	JButton b8 = new JButton("Toilet");
	
	JButton save = new JButton("Save");
	JButton delete = new JButton("Delete");
	JButton load = new JButton("Load");
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			Button1Pressed();
		}
		if (e.getSource() == b2) {
			Button2Pressed();
		}
		if (e.getSource() == b3) {
			Button3Pressed();
		}
		if (e.getSource() == b4) {
			Button4Pressed();
		}
		if (e.getSource() == b5) {
			Button5Pressed();
		}
		if (e.getSource() == b6) {
			Button6Pressed();
		}
		if (e.getSource() == b7) {
			Button7Pressed();
		}
		if (e.getSource() == b8) {
			Button8Pressed();
		}
		if (e.getSource() == save) {
			try {
				ButtonSave();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == delete) {
			ButtonDelete();
		}
		if (e.getSource() == load) {
			try {
				ButtonLoad();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}


public Layout(){
	
	keypad.setLayout(new BoxLayout(keypad, BoxLayout.Y_AXIS));
	
	Dimension d = b5.getMaximumSize();
	b1.setMaximumSize(d);
	b2.setMaximumSize(d);
	b3.setMaximumSize(d);
	b4.setMaximumSize(d);
	b5.setMaximumSize(d);
	b6.setMaximumSize(d);
	b7.setMaximumSize(d);
	b8.setMaximumSize(d);
	
	
	keypad.add(b1);
	keypad.add(b2);
	keypad.add(b3);	
	keypad.add(b4);
	keypad.add(b5);
	keypad.add(b6);
	keypad.add(b7);
	keypad.add(b8);
	
	savepad.add(save);
	savepad.add(delete);
	savepad.add(load);
	
	Panel1.setLayout(new BorderLayout());
	Panel1.add(Center,BorderLayout.CENTER);
	
	setLayout(new BorderLayout());
	add(Panel1, BorderLayout.CENTER);
	add(keypad,BorderLayout.WEST);
	add(savepad,BorderLayout.SOUTH);
	
	keypad.setPreferredSize(new Dimension(150, 400));
	Panel1.setPreferredSize(new Dimension(903, 500));
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);
	b7.addActionListener(this);
	b8.addActionListener(this);
	save.addActionListener(this);
	delete.addActionListener(this);
	load.addActionListener(this);
	
}

public abstract void Button1Pressed();
public abstract void Button2Pressed();
public abstract void Button3Pressed();
public abstract void Button4Pressed();
public abstract void Button5Pressed();
public abstract void Button6Pressed();
public abstract void Button7Pressed();
public abstract void Button8Pressed();
public abstract void ButtonSave() throws IOException;
public abstract void ButtonDelete();
public abstract void ButtonLoad() throws IOException;

public abstract JComponent createFurnitureComponent();

}

