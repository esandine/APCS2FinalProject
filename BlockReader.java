import java.util.*;

public class BlockReader{
    private ArrayList<ReadImage> symbols;
    private ReadImage image;
    private booleanArray booleanImage;
    private boolean[][] booleanArray;
    
    public BlockReader(String img){
	image = new ReadImage(img);
	image.scaleImage();
	int[] dims = image.dims();
	System.out.println(dims[0] + " " + dims[1]);
	booleanArray = new boolean[dims[0]][dims[1]];
	image.toBoolean(booleanArray);
	symbols = new ArrayList<ReadImage>();
	
    }
    public void removeSymbols(){
	
    }
    
    public int readLine(int cS){
	boolean first = false;
	boolean triggered = false;
	int c = cS;
	int cE = 0;
	int C = booleanArray[0].length;
	while(c  < C){
	    for(int r = 0; r < booleanArray.length; r++){
		if(booleanArray[r][c]){
		    triggered = true;
		    first = true;
		}
	    }
	    if(first && !triggered){
		C = c;
		cE = c;
	    }
	    triggered = false;
	    c++;
	}
    }
    /*public int[] getEnds(int rS, int cS){
	int[] endpoint = new int[2];
	int rE = 0;
	int cE = 0;
	boolean first = false;
	boolean triggered = true;
	int R = booleanArray.length;
	int C = booleanArray[0].length;
	int r = 0;
	while(r < R){
	    int c = 0;
	    while(c < C){
		boolean continue = true;
		if(booleanArray[r][c]){
		    if(r > rE){
			rE = r;
		    }
		    if(c > cE){
			cE = c;
		    }
		}
		if(triggered && !booleanArray[r][c]){
		    
		}
		c++;
	    }
	    if(!triggered){
		C = 0;
		R = 0;
	    }
	    if(first){
		triggered = false;
	    }
	    r++;
	}
	return endpoint;
	}*/
    public String toString(){
	String s = "";
	for(int r = 0; r < booleanArray.length; r++){
	    for(int c = 0; c < booleanArray[0].length; c++){
		s += booleanArray[r][c] + " ";
	    }
	    s += "\n";
	}
	return s;
    }
}
