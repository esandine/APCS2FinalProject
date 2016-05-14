import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
public class ReadImage{
    private BufferedImage image;
    private Pixel[][] pixelRGBValues;
    private int height;
    private int width;
    private ArrayList<int[][]> symbols;
    private Color bgC;
    //Converts the image to a 2D array of RGB values
    private void loadRGBValues(){
	pixelRGBValues = new Pixel[height][width];
	for(int r = 0; r < height; r++){ 
	    for(int c = 0; c < width; c++){
		pixelRGBValues[r][c] = new Pixel(image.getRGB(c, height - r - 1),r,c);
	    }
	}
    }
    //The reverse of loadRGBValues() primarily used for testing
    private void setRGBValues(){
	for(int r = 0; r < height; r++){ 
	    for(int c = 0; c < width; c++){
		image.setRGB(c, height - r -1, pixelRGBValues[r][c].getColor().getRGB());
	    }
	}
    }
    //finds the background color
    private void getBG(){
	int black = 0;
	int white = 0;
	for(int c = 0; c < width; c++){
	    if(isBlack(0, c) || isBlack(width - 1, c)){
		black++;
	    }
	    else{
		white++;
	    }
	}
	for(int r = 1; r < height - 1; r++){
	    if(isBlack(r, 0) || isBlack(r, height - 1)){
		black++;
	    }
	    else{
		white++;
	    }
	}
	if(black > white){
	    bgC.setColor(Color.black);
	}
	else{
	    bgC.setColor(Color.white);
	}
    }
    private boolean isBlack(int r, int c){
	if(pixelRGBValue[r][c].getColor().equals(color.Black)){
	    return true;
	}
	else{
	    return false;
	}
    }
    private void setBlack(){
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		pixelRGBValues[r][c].setColor(Color.black);
	    }
	}
    }
    public ReadImage(String input){
	try{
	    symbols = new ArrayList<int[][]>;
	    image = ImageIO.read(new File(input));
	    height = image.getHeight();
	    width = image.getWidth();
	    loadRGBValues();
	}catch(IOException e){
	    System.out.println("No file found");
	    image = null;
	}
	//i1=ImageIO.read(new File(input));
    }
    public String toString(){
	String ans = "";
	for(int r = 0; r < height; r++){
	    for(int c = 0; c < width; c++){
		ans += pixelRGBValues[r][c].getColor().getRGB() + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    public String getDimension(){
	return "h: " + height + ", w: " + width;
    }
    //Makes all the pixels either white or black
    public void setBlackAndWhite(){
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		pixelRGBValues[r][c].toBlackandWhite();
	    }
	}
    }
    
    public void outPut(String s){
	setRGBValues();
	try{
	    ImageIO.write(image,"gif",new File(s));
	}catch(IOException e){
	    System.out.println("Writing error");
	}
    }
    public static void main(String[]args){
	if(args.length>1){
	    ReadImage r1 = new ReadImage(args[0]);
	    r1.setBlackAndWhite();
	    r1.outPut(args[1]);
	}
	else if(args.length>0){
	    ReadImage r1 = new ReadImage(args[0]);
	    r1.setBlackAndWhite();
	    //r1.setBlack();
	    System.out.println(r1.getDimension());
	    System.out.println(r1);
	    r1.outPut("results.jpg");
	}
    }
}
