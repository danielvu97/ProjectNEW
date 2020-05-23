
public class Coordinates extends furpic {
	
	int [] x1= new int[10];
	int[] y1; 
	int i;
	
	
	public Coordinates() {
		y1 = new int[10];
		i = 0;
	}
	
	public void Coordinating(String Name ,int x, int y ) {
		i = Integer.parseInt(Name);
		this.x1[i] = x;
		this.y1[i] = y;
		
	}
	
	public boolean compareCoordinates(int x2, int y2, int height , int width) {
		int half_height = y2- (height/2);
		int half_height2 = y2 + (height/2);
		int half_width = x2 - (width/2);
		int half_width2 = x2 + (width/2);
		System.out.println(x2 + " " + y2);
		System.out.println( half_height + " " + half_height2 );
		System.out.println( half_width + " " + half_width2 );

		
		for(int j = 0; j < 10; j++) {
			
			if( half_height < y1[j] && half_height2 > y1[j] && half_width < x1[j] && half_width2 >x1[j]) {
				System.out.println("hej1");
				return true;	
			}
		}
		return false;

		
	}
	
	
	
	
	
	public void iterate() {
		for(int i = 0; i < 10; i++) {
			if(x1[i] != 0) {
			System.out.println(i + "	" + x1[i] + "	" + y1[i]);
			
			}
		}
	}

	
	
	
	
	
	
}
