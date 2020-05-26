import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Saver extends furpic {
	Rectangle [] saver;
	String [] label;
	int j = 0;
	
	public Saver(){
		saver = new Rectangle[100];
		label = new String[100] ;
	
}
	
	public void Savefurniture(String label, int i) {
		
		this.label[i] = label; 
		
	}
	
	

@SuppressWarnings("resource")
public void SavefurnitureCoordinates( Rectangle[] A )  throws IOException{
	for(int i = 0; i < A.length; i++) {
		if(A[i] != null) {
			saver[j] = A[i];
			j++;
		}
	}
	
	BufferedWriter outputWriter = null;
    outputWriter = new BufferedWriter(new FileWriter("Room_Saved"));
    for (int i = 1; i <= saver.length; i++) {
    	
      outputWriter.write(label[i]);
      

    }
    
    outputWriter.flush();
    outputWriter.close();
	

}
}
