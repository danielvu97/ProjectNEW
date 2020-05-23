
public class Coordinates extends furpic {
	
	int [] x1;
	int[] y1; 
	int i;
	
	
	public Coordinates() {
		x1 = new int[10];
		y1 = new int[10];
		i = 0;
	}
	
	public void Coordinating(String Name ,int x, int y ) {
		i = Integer.parseInt(Name);
		this.x1[i] = x;
		this.y1[i] = y;
		
	}
	
	/*public boolean compareCoordinates(int x1, int y1, int height , int width) {
		if() {
			
		}
		return false;
	}*/
	
	
	
	
	
	public void iterate() {
		for(int i = 0; i < 10; i++) {
			if(x1[i] != 0) {
			System.out.println(i + "	" + x1[i] + "	" + y1[i]);
			
			}
		}
	}

	
	
	
	
	
	
}
