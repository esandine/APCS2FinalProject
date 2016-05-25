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
    public boolean[][] getData(){
	return data;
    }
    public void setData(boolean[][]data){
	//if(!((data.length==162)&&(data[0].length==100))){
	//    throw new IllegalArgumentException();
	//}
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
	double retValue = 0;
	for(int r = 0;r < data.length;r++){
	    for(int c = 0; c < data[0].length;c++){
		if(getValue(r,c)!=other.getValue(r,c)){
		    retValue++;
		}
	    }
	}
	return retValue/161.8;
    }
    //Scales up a boolean array horizontally
    public boolean scaleRowsUp(int newH){
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
		retStr+=data[r][c];
		retStr+=" ";
	    }
	    retStr+="\n";
	}
	return retStr;
    }
    public static void main(String[]args){
	boolean[][]data={{true,false,true},{false,true,false},{true,false,true}};
	booleanArray b2 = new booleanArray(data);
	System.out.println(b2);
	b2.scaleRowsUp(11);
	System.out.println(b2);
    }
}
