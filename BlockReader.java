import java.util.*;

public class BlockReader{
    private ArrayList<booleanArray> symbols;
    //private ReadImage image;
    private booleanArray img;
    // private boolean[][] ori;
    
    public BlockReader(String image){
	//image = new ReadImage(img);
	//image.scaleImage();
	//int[] dims = image.dims();
	//System.out.println(dims[0] + " " + dims[1]);
	img = Read.loadBoolean(image);
	img.trim();
	//ori = booleanImage.getData();
	symbols = new ArrayList<booleanArray>();
	
    }
    public void removeSymbols(){
	System.out.println(img.getCols());
	for(int c = 0; c < img.getCols(); c++){
	    int cE = readLine(c);
	    System.out.println(c + " " + cE);
	    
	    if(cE < img.getCols()){
		boolean[][] arr = removeSymbol(c, cE);
		//print(arr);
		
		booleanArray curr = new booleanArray(arr);
		symbols.add(curr);
	    }
	    c = cE;
	}
    }
    public void print(boolean[][] arr){
	for(int r = 0; r < arr.length; r++){
	    for(int c = 0; c < arr[0].length; c++){
		System.out.print(arr[r][c] + " ");
	    }

	    System.out.println("");
	}
    }
    /*public void makeImages(){
	for(int i = 0; i < symbols.size(); i++){
	    String s = "sym" + i + ".png";
	    symbols.get(i).outPut(s);
	}
	}*/
    public String stringImg(){
	String text = "";
	System.out.println(symbols.size());
	for(int i = 0; i < symbols.size(); i++){
	    symbols.get(i).trim();
	    symbols.get(i).loadCharacters();
	    text+= symbols.get(i).closestMatch();
	}
	return text;
    }
    public boolean[][] removeSymbol(int cS, int cE){
	int height = img.getRows();
	int width = cE - cS + 1;
	boolean[][] sym = new boolean[height][width];
	for(int r = 0; r < sym.length; r++){
	    for(int c = 0; c < sym[0].length; c++){
		sym[r][c] = img.getValue(r,c + cS);
	    }
	}
	return sym;
    }
    public int readLine(int cS){
	boolean first = false;
	boolean triggered = false;
	int c = cS;
	int cE = cS;
	int C = img.getCols();
	while(c  < C){
	    for(int r = 0; r < img.getRows(); r++){
		if(img.getValue(r,c)){
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
	    if(c == C){
		cE = c - 1;
	    }


	}
	return cE;
    }
    /*public void setDef(){
	ori = new boolean[30][30];
	for(int c = 0; c < 30; c++){
	    for(int r = 0; r < 30; r++){
		if(c % 10 == 0 || (c%5==0 && r!=0)){
		    ori[r][c] = false;
		}
		else{
		    ori[r][c] = true;
		}
	    }
	}
	}*/
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
    /* public String toString(){
	return booleanImage.toString();
	}*/
}
