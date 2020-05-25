import java.awt.Rectangle;

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
		for(int j=0; j<10; j++) {
			if(i != j ) {
				if(save[j].intersects(B)) {
				return true;
				}
			}
		}
		return false;
	}
		
	
}
