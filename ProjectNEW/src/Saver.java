import java.awt.Rectangle;

public class Saver extends furpic {
	Rectangle [] saver;
	int j = 0;
	
	public Saver(){
		saver = new Rectangle[100];
	
}

public void Savefurniture( Rectangle[] A ) {
	for(int i = 0; i < A.length; i++) {
		if(A[i] != null) {
			saver[j] = A[i];
			j++;
		}
	}
	

}
}
