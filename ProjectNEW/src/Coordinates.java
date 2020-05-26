import java.awt.Rectangle;
import java.awt.geom.Area;

public class Coordinates extends furpic {
	
	Rectangle [] save = new Rectangle[10];
	
	
	public Coordinates() {
		i = 0;
	}
	
	public void Coordinating(Rectangle A, String Name) {
		i = Integer.parseInt(Name);
		save[i] = A;
		
	}
	
	
	public boolean compareCoordinates(Rectangle B, String Namn) {
		i = Integer.parseInt(Namn);
		
		if(B.contains(398, 0, 75, 50)) {
			return true;
		}
		for(int j=0; j<10; j++) {
			if(i != j ) {
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
	
	
		
	}
