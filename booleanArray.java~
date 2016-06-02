import java.util.Hashtable;
import java.io.File;
public class booleanArray{
    private boolean[][]data;
    private Hashtable<booleanArray,String> characters;
    public booleanArray(boolean[][]data){
	setData(data);
    }
    public booleanArray(){
	data=new boolean[1618][1000];
	characters = new Hashtable<booleanArray,String>();
	for(int i = 0; i<1618000;i++){
	    data[i/1000][i%1000]=false;
	}
	trim();
    }
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
    public void setData(boolean[][]data){
	this.data=data;
	characters = new Hashtable<booleanArray,String>();
    }
    public void loadCharacters(){
	File in = new File("characters/");
	String[] fonts = in.list();
	for(int i = 0; i < fonts.length; i++){
	    loadDirectory("characters/"+fonts[i]+"/");
	}
    }
    public void loadDirectory(String dir){
	booleanCharacters b = new booleanCharacters(dir);
	Hashtable<booleanArray,String> h = b.toHashtable(dir.substring(11));
	for(booleanArray a : h.keySet()){
	    characters.put(a,h.get(a));
	}
    }
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
    //Scales rows
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

    //Scales cols
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
    public void scale(int r, int c){
	scaleRows(r);
	scaleCols(c);
    }
    //Rotates the boolean Array
    public void rotate(double rad){
	double centerX = data.length/2.0;
	double centerY = data[0].length/2.0;
	Polar p = new Polar(centerX,centerY);
	p.rotate(rad);
	boolean[][]newData = new boolean[2*p.getRadiusInt()][2*p.getRadiusInt()];
	double newCenterX = p.getRadiusInt()-.5;
	double newCenterY = p.getRadiusInt()-.5;

	System.out.println(centerX);
	System.out.println(centerY);
	System.out.println(newCenterX);
	System.out.println(newCenterY);
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
	trim();
    }
    //Makes two boolean arrays the same size
    public void scaleToFit(booleanArray other){
	int rows = Math.min(other.getRows(),getRows());
	int cols = Math.min(other.getCols(),getCols());
	scale(rows,cols);
	other.scale(rows,cols);
    }
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
    public int getFirstBoolean(boolean Start,boolean row){
        int start;
	if(Start){
	    start = 0;
	}else{
	    start=data.length-1;
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
		for(int i = data.length-1; i>0; i--){
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
