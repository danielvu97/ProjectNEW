import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class wallpaper extends JPanel {

	private BufferedImage image ;
	public void Picture(String filename) {

		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		Image temp = image.getScaledInstance(903, 500, BufferedImage.SCALE_SMOOTH);
		image = new BufferedImage(903, 500, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
