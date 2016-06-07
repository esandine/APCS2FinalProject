import java.util.*;
import java.io.*;
public class ReadLines{
    private ArrayList<String> lines;
    private booleanArray img;

    public ReadLines(String image){
	img = Read.loadBoolean(image);
	img.trim();
	img.correct();
	lines = new ArrayList<String>();
    }
    //splits big block of text into mulptiple lines to be read by BlockReader class
    public void divideLines(){
	for(int r = 0; r < img.getRows(); r++){
	    int rE = findBottomRow(r);
	    boolean[][] barry = removeLine(r, rE);
	    //booleanArray currLine = new booleanArray(barry);
	    //System.out.println(currLine);
	    
	    BlockReader Line = new BlockReader(barry);
	    //System.out.println(Line.stringImg());
	    Line.removeSymbols();
	    String currText = Line.stringImg();
	    lines.add(currText);
	    r = rE;
	}
    }
    //finds end row of one section of the block given the row it starts at
    public int findBottomRow(int rS){
	boolean triggered = true;
	boolean first = false;
	int rE = img.getRows();
	int r = rS;
	while(triggered && r < rE){
	    if(first){
		triggered = false;
	    }
	    for(int c = 0; c < img.getCols(); c++){
		if(img.getValue(r,c)){
		    triggered = true;
		    if(!first){
			first = true;
		    }
		}
	    }
	    r++;
	}
	return r - 1;
    }
    //return boolean[][] using dimension given
    public boolean[][] removeLine(int rS, int rE){
	int height = rE - rS + 1;
	//System.out.println(img.getRows());
	int width = img.getCols();
	//System.out.println(height + " " + width);
	boolean[][] arr = new boolean[height][width];
	for(int r = 0; r < height; r++){
	    for(int c = 0; c < width; c++){
	
		arr[r][c] = img.getValue(r + rS, c);
		//System.out.print(arr[r][c]);
	    }
	}
	return arr;
    }
    //returns image in text form
    public String returnText(){
	String txt = "";
	for(int i = 0; i < lines.size(); i++){
	    txt += lines.get(i) + "\n";
	}
	return txt;
    }
    public String toHTML(){
	String inPut= returnText();
	String retStr="<!DOCTYPE html><html><head><center>";
	for(int i = 0; i<inPut.length(); i++){
	    if(inPut.substring(i,i+1).equals("\n")){
		retStr+="<br>";
	    }else{
		retStr+=inPut.substring(i,i+1);
	    }
	}
	retStr+="</center></head></html>";
	return retStr;
    }
    public void writeHTML(){
	try{
	    File f = new File("results.html");
	    PrintWriter w = new PrintWriter(f);
	    System.out.println(toHTML());
	    w.write(toHTML());
	    w.close();
	}catch(IOException e){
	    System.out.println("Error writing to results.html. This is the html: ");
	    System.out.println(toHTML());
	    System.out.println("Plaintext:");
	    System.out.println(returnText());
	}
    }
}
