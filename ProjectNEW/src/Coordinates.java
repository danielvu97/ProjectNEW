import java.awt.Rectangle;
import java.awt.geom.Area;

public class Coordinates extends furpic {
	
	Rectangle [] save = new Rectangle[10];
	Rectangle [] obstacle = new Rectangle[12];
	
	public Coordinates() {
		i = 0;
		for(int l = 0; l<12; l++) {
			obstacle[l] = new Rectangle();
		}
		
		obstacle[0].setBounds(293, 0, 5, 495); //left House wall
		obstacle[1].setBounds(293, 0, 500, 5); //Upper House wall
		obstacle[2].setBounds(785, 0, 5, 495); //Right House wall
		obstacle[3].setBounds(293, 494, 500, 5); //Bottom House wall
		obstacle[4].setBounds(489, 0, 9, 495); //middle House wall
		obstacle[5].setBounds(293, 76, 18, 104); //window1
		obstacle[6].setBounds(670, 0, 109, 13); //window 2
		obstacle[7].setBounds(588, 297, 5, 203 ); //bathroom left
		obstacle[8].setBounds(588, 297, 200, 8 ); //bathroom right
		obstacle[9].setBounds(442, 246, 50, 45); //Bottom House wall
		obstacle[10].setBounds(539, 356, 50, 45); //Bottom House wall
		obstacle[11].setBounds(515, 444, 50, 45); //Bottom House wall
	}
	
	public void Coordinating(Rectangle A, String Name) {
		i = Integer.parseInt(Name);
		save[i] = A;
		
	}
	
	
	public boolean compareCoordinates(Rectangle B, String Namn) {
		i = Integer.parseInt(Namn);
		
		for(int k=0; k<obstacle.length; k++) {
		if(obstacle[k].intersects(B) && obstacle[k] != null) {
			return true;
		}
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
