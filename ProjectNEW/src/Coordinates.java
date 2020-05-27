import java.awt.Rectangle;
import java.awt.geom.Area;

public class Coordinates extends furpic {
	
	Rectangle [] save = new Rectangle[10];
	//Rectangle [] walls = new Rectangle[10];
	Rectangle wall = new Rectangle(); 
	
	public Coordinates() {
		i = 0;
		wall.setBounds(404, 76, 15, 100);
	}
	
	public void Coordinating(Rectangle A, String Name) {
		i = Integer.parseInt(Name);
		save[i] = A;
		
	}
	
	
	public boolean compareCoordinates(Rectangle B, String Namn) {
		i = Integer.parseInt(Namn);
		
		if(wall.intersects(B)) {
			return true;
		}
		
		for(int j=0; j<10; j++) {
			if(i != j && save[j] != null) {
				if(save[j].intersects(B)) {
				return true;
				}
			}
		}
		return false;
	}
	
	
	
	public void deleteCoordinate(String Name) {
		i = Integer.parseInt(Name);
		save[i] = null;
	}
	
	public Rectangle [] coordinateValues() {
		return save;
		
	}
	
	
		
	}
