import javax.swing.JComponent;

public abstract class FurniturePresenter extends Layout  {
	private wallpaper pic;
	
	public FurniturePresenter(){
		super();
	}
	
	public void showImage(String filename) {
		pic.Picture(filename);
		repaint();
	}
	
	
	public JComponent createFurnitureComponent() {
		pic = new wallpaper();
		return pic;
	}



}
