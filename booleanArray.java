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
	double newCenterX = p.getRadiusInt();
	double newCenterY = p.getRadiusInt();

	System.out.println(centerX);
	System.out.println(centerY);
	for(int r = 0; r< data.length; r++){
	    for(int c = 0; c< data[0].length; c++){
		p=new Polar(r-centerX,c-centerY);
		p.rotate(rad);
		int newR = (int) Math.round(newCenterX+p.getXcor());
		int newC = (int) Math.round(newCenterY+p.getYcor());
		newData[newR][newC] = data[r][c];
	    }
	}
	data=newData;
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
    public static void main(String[]args){
	boolean[][]data={{true,false,true},{false,true,false},{true,false,true}};
	boolean[][]data2={{true,true},{false,false}};
	booleanArray b2 = new booleanArray(data2);
	System.out.println(b2);
	b2.scaleRows(9);
	System.out.println(b2);
	b2.scaleCols(9);
	System.out.println(b2);
	b2.rotate(0);
	//System.out.println(b2);
	//b2.rotate(Math.PI/2);
	System.out.println(b2);
    }
}
