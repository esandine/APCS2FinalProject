import java.util.*;

public class BlockReader{
    private ArrayList<booleanArray> symbols;
    //private ReadImage image;
    private booleanArray img;
    // private boolean[][] ori;

    //constructor for single line text
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
    //constructor to be used for multiline reading class
    public BlockReader(boolean[][] image){
	symbols = new ArrayList<booleanArray>();
	img = new booleanArray(image);
	img.trim();
    }
    //loops through one line of text, does not handle multiple lines. Makes each char found its own booleanArray in symbols ArrayList
    public void removeSymbols(){
	for(int c = 0; c < img.getCols(); c++){
	    int cE = readLine(c);

	    if(cE < img.getCols()){
		boolean[][] arr = removeSymbol(c, cE);
		//print(arr);
		
		booleanArray curr = new booleanArray(arr);
		symbols.add(curr);
	    }
	    c = cE;
	}
    }
    //used for debugging
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

    //Returns the string that is found in the image
    public String stringImg(){
	String text = "";

	for(int i = 0; i < symbols.size(); i++){
	    boolean space = symbols.get(i).trim();
	    symbols.get(i).loadCharacters();
	    if(space){
		text+= " " + symbols.get(i).closestMatch();
	    }
	    else{
		text+= symbols.get(i).closestMatch();
	    }
	}   
	return text;
    }
    //given the starting column and end column, makes an 2d array of booleans that will be used to instantiate each booleanArray in symbols
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
    //Used to find the end column of an image given its starting col, basically finding its width. Does not actually read the whole line, not best name
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
    //used for testing
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
}
