import java.awt.Rectangle;
import java.awt.geom.Area;

public class Coordinates extends furpic{
	
	Rectangle [] save = new Rectangle[30]; //Creates an arraylist
	Rectangle [] obstacle = new Rectangle[12]; //creates an obstaclelist
	
	//Creates obstacles for the room. walls, windows and doors
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
	
	//Updates the position of the selected furniture
	public void Coordinating(Rectangle A, String Name) {
		i = Integer.parseInt(Name); //Takes input and convert it into a integer.
		save[i] = A; //saves the position of the furniture in the arraylist corresponding to its name.
		
	}
	
	//Checks if the selected furniture intersects with other furnitures. 
	public boolean compareCoordinates(Rectangle B, String Namn) {
		i = Integer.parseInt(Namn);
		
		//Checks if the furniture are intersecting with the house obstacles.
		for(int k=0; k<obstacle.length; k++) { //Goes through list
		if(obstacle[k].intersects(B) && obstacle[k] != null) { //Checks intersect
			return true; //true = the furnitures are intersecting
		}
		}
		
		//Checks if the furniture are intersecting with other placed furnitures.
		for(int j=0; j<save.length; j++) { //Goes through list
			if(i != j && save[j] != null) {
				if(save[j].intersects(B)) { //Checks intersect
				return true; //true = the furnitures are intersecting
				}
			}
		}
		return false; //false = the furnitures are not intersecting
	}
	
	
	//A method which removes the furniture and its position in the array.
	public void deleteCoordinate(String Name) {
		i = Integer.parseInt(Name);
		save[i] = null;
	}
	
	//A method which returns the saved array. Used for savebutton.
	public Rectangle [] coordinateValues() {
		return save;
		
	}
	
	
		
	}
