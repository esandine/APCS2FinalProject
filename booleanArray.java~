import java.util.Hashtable;
import java.io.File;
//booleanArray is essentially a super 2D array of booleans. It is used for all comparisons within the program
public class booleanArray{
    //Instance Variables
    private boolean[][]data;//The boolean array
    private Hashtable<booleanArray,String> characters;//The other characters to compare to

    //Constructors

    //Standard Constructor
    public booleanArray(boolean[][]data){
	setData(data);
    }

    //Default constructor
    public booleanArray(){
	data=new boolean[1618][1000];
	characters = new Hashtable<booleanArray,String>();
	for(int i = 0; i<1618000;i++){
	    data[i/1000][i%1000]=false;
	}
	trim();
    }

    public void setValue(int r, int c, boolean val){
	data[r][c] = val;
    }


    //Accessors

    public boolean getValue(int r, int c){
	return data[r][c];
    }
    public int getRows(){
	return data.length;
    }
    public int getCols(){
	return data[0].length;
    }
    public boolean[][] getData(){
	return data;
    }
    //Mutators
    public void setData(boolean[][]data){
	this.data=data;
	characters = new Hashtable<booleanArray,String>();
    }

    //It loads the hashtable by reading all the directories in the characters directory
    public void loadCharacters(){
	File in = new File("characters/");
	String[] fonts = in.list();
	for(int i = 0; i < fonts.length; i++){
	    loadDirectory("characters/"+fonts[i]+"/");
	}
    }
    //Fills the hashtable with all the images within the directory as keys and all the names of the files as the values
    public void loadDirectory(String dir){
	booleanCharacters b = new booleanCharacters(dir);
	Hashtable<booleanArray,String> h = b.toHashtable(dir.substring(11));
	for(booleanArray a : h.keySet()){
	    characters.put(a,h.get(a));
	}
    }

    //Compares to see if it and another booleanArray are within a certain percentage not used
    public boolean compareTo(booleanArray other, double percent){
	double failuresLeft = percent * 161.8;
	for(int r = 0;r < data.length;r++){
	    for(int c = 0; c < data[0].length;c++){
		if(getValue(r,c)!=other.getValue(r,c)){
		    failuresLeft--;
		}
	    }
	}
	return failuresLeft>=0;
    }

    //The main comparison function, it finds the percent error between another booleanArray and itself
    public double percentError(booleanArray other){
	scaleToFit(other);
	double retValue = 0;
	for(int r = 0;r < data.length;r++){
	    for(int c = 0; c < data[0].length;c++){
		if(getValue(r,c)!=other.getValue(r,c)){
		    retValue++;
		}
	    }
	}
	return 100*retValue/(getRows()*getCols());
    }

    //Scales rows to a specific horizonatal value
    public boolean scaleRows(int newH){
	boolean[][]newData = new boolean[newH][data[0].length];
	double scaleFactor = (newH+0.0)/data.length;
	for(int r = 0;r<newData.length;r++){
	    for(int c = 0; c<newData[0].length; c++){
		newData[r][c]=data[(int)(r/scaleFactor)][c];
	    }
	}
	data=newData;
	return true;
    }

    //Scales cols to a specific vertical value
    public boolean scaleCols(int newH){
	boolean[][]newData = new boolean[data.length][newH];
	double scaleFactor = (newH+0.0)/data[0].length;
	for(int r = 0;r<newData.length;r++){
	    for(int c = 0; c<newData[0].length; c++){
		newData[r][c]=data[r][(int)(c/scaleFactor)];
	    }
	}
	data=newData;
	return true;
    }

    //Scales rows and columns
    public void scale(int r, int c){
	scaleRows(r);
	scaleCols(c);
    }

    //Rotates the boolean Array by converting the coordinates to polars, rotating and converting back to xy coordinates. Then it trims the sides to shrink the image
    public void rotate(double rad){
	double centerX = data.length/2.0;
	double centerY = data[0].length/2.0;
	Polar p = new Polar(centerX,centerY);
	p.rotate(rad);
	//Makes sure the new array is big enough
	boolean[][]newData = new boolean[2*p.getRadiusInt()][2*p.getRadiusInt()];
	double newCenterX = p.getRadiusInt()-.5;
	double newCenterY = p.getRadiusInt()-.5;
	//Rotates all coordinates
	for(int r = 0; r< data.length; r++){
	    for(int c = 0; c< data[0].length; c++){
		if(data[r][c]){
		    p=new Polar(r-centerX,c-centerY);
		    p.rotate(rad);
		    int newR = (int)(newCenterX+p.getXcor());
		    if(newR>=newData.length){
			newR=newData.length-1;
		    }
		    int newC = (int)(newCenterY+p.getYcor());
		    if(newC>=newData[0].length){
			newC=newData[0].length-1;
		    }
		    newData[newR][newC] = data[r][c];
		    if((newR<data.length-1)&&(newC<data.length-1)){
			newData[newR+1][newC+1] = data[r][c];
		    }
		    if(newR<data.length-1){
			newData[newR+1][newC]=data[r][c];
		    }
		    if(newC<data.length-1){
			newData[newR][newC+1]=data[r][c];
		    }
		}
	    }
	}
	data=newData;
	//Gets rid of the whitespace
	trim();
    }

    //Makes two boolean arrays the same size for comparison
    public void scaleToFit(booleanArray other){
	int rows = Math.min(other.getRows(),getRows());
	int cols = Math.min(other.getCols(),getCols());
	scale(rows,cols);
	other.scale(rows,cols);
    }

    //Goes through the hashtable and find the booleanArray with the closest match and returns the key
    public String closestMatch(){
	double max = 100;
	String retStr = "";
	for(booleanArray other : characters.keySet()){
	    double error = percentError(other);
	    if(error<max){
		max = error;
		retStr = characters.get(other);
	    }
	}
	return retStr;
    }

    //Prints all the characters, used for testing purposes
    public void printChars(){
	for(booleanArray b : characters.keySet()){
	    System.out.println(characters.get(b));
	    System.out.println(b);
	}
    }

    //Makes the image readable in X as true and _ as false
    public String toString(){
	String retStr = "";
	for(int r = 0; r<data.length; r++){
	    for(int c = 0; c<data[0].length;c++){
		if(data[r][c]){
		    retStr+="X";
		}else{
		    retStr+="_";
		}
		retStr+=" ";
	    }
	    retStr+="\n";
	}
	return retStr;
    }

    //Finds the first boolean either starting from the start or end, and using either columns or rows
    public int getFirstBoolean(boolean Start,boolean row){
        int start;
	if((!Start)&&row){
	    start = data.length-1;
	}else if(!Start){
	    start=data[0].length-1;
	}else{
	    start=0;
	}
	boolean notOver = true;
	while(notOver){
	    if(Start&&row){
		for(int i = 0; i<data[start].length; i++){
		    if(data[start][i]==true){
			notOver = false;
		    }
		}
		if(notOver){
		    start++;
		}
	    }else if(Start){
		for(int i = 0; i<data.length; i++){
		    if(data[i][start]==true){
			notOver = false;
		    }
		}
		if(notOver){
		    start++;
		}
	    }else if(row){
		for(int i = 0; i<data[start].length; i++){
		    if(data[start][i]==true){
			notOver = false;
		    }
		}
		if(notOver){
		    start--;
		}
	    }else{
		for(int i = 0; i<data.length; i++){
		    if(data[i][start]==true){
			notOver = false;
		    }
		}
		if(notOver){
		    start--;
		}
	    }
	}
	return start;
    }

    //Makes a new booleanArray by eliminating the whitespace using the prior function
    public void trim(){
	int startRow = getFirstBoolean(true,true);
	int endRow = getFirstBoolean(false,true);
	int startCol = getFirstBoolean(true,false);
	int endCol = getFirstBoolean(false,false);
	boolean[][] newData = new boolean[endRow-startRow+1][endCol-startCol+1];
	for(int i = 0; i<newData.length; i++){
	    for(int ii = 0; ii<newData[i].length; ii++){
		newData[i][ii]=data[i+startRow][ii+startCol];
	    }
	}
	data = newData;

    }

    //To get the angle to rotate by, it assumes most capital letters are majority verticle lines
    public double getRotAngle(){
	double size = 0;
	double total = 0;
	for(int r = 1; r < data.length-1; r++){
	    for(int c = 1; c < data[0].length-1; c++){
		if(data[r+1][c]){
		    size++;
		}
		if(data[r][c+1]){
		    total+=Math.PI/2;
		    size++;
		}
		if(data[r+1][c+1]){
		    total+=Math.PI/4;
		    size++;
		}
		if(data[r-1][c+1]){
		    total-=Math.PI/4;
		    size++;
		}
		if(data[r][c-1]){
		    total-=Math.PI/2;
		    size++;
		}
	    }
	}
	return total/size;
    }

    //Main for testing purposes
    public static void main(String[]args){
	boolean[][]data={{true,false,true},{false,true,false},{true,false,true}};
	boolean[][]data2={{true,true},{false,false}};
	booleanArray b2 = new booleanArray(data2);
	b2.scaleRows(9);
	b2.scaleCols(9);
	System.out.println(b2);
	b2.rotate(Math.PI*3/4);
	//System.out.println(b2);
	//b2.rotate(Math.PI/2);
	System.out.println(b2);
    }
}
