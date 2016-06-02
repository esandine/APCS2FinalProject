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
	for(int c = 0; c < booleanArray.length; c++){
	    int cE = readLine(c);
	    boolean[][] arr = removeSymbol(c, cE);
	    symbols.add(new ReadImage(arr));
	    c = cE;
	}
    }
    public boolean[][] removeSymbol(int cS, int cE){
	int height = booleanArray.length;
	int width = cE - cS + 1;
	boolean[][] sym = new boolean[height][width];
	for(int r = 0; r < sym.length; r++){
	    for(int c = 0; c < sym[0].length; c++){
		sym[r][c] = booleanArray[r][c + cS]
	    }
	}
	return sym;
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
    public void setDef(){
	booleanArray = new boolean[50][50];
	for(int c = 0; c < 50; c++){
	    for(int r = 0; r < 50; r++){
		if(c % 10 == 0){
		    booleanArray[r][c] = false;
		}
		else{
		    booleanArray[r][c] = true;
		}
	    }
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
