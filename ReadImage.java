import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.Graphics2D;
public class ReadImage{
    private BufferedImage image;
    private Pixel[][] pixelRGBValues;
    private int height;
    private int width;
    private Pixel bgC;
    private BufferedImage symbol;
    public static boolean debug = false;
    public ReadImage(boolean[][] data){
	height = data.length;
	width = data[0].length;
	image = new BufferedImage(width, height, 1);
	pixelRGBValues = new Pixel[height][width];
	for(int r = 0; r < height; r++){
	    for(int c = 0; c < width; c++){
		if(data[r][c]){
		    image.setRGB(c, height - r - 1, 0);
		}
		else{
		    image.setRGB(c, height - r - 1, 255);
		}
	    }
	}
    }
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

    //Scales image
    public void scaleImage(int h, int w){
	height = h;
	width = w;
	//Special thanks to stackoverflow for helping fix the issue with type casting
	//http://stackoverflow.com/questions/9417356/bufferedimage-resize
	//It makes an image which then copies to the BufferedImage
	Image scaled = image.getScaledInstance(w,h,Image.SCALE_SMOOTH);
	image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2d = image.createGraphics();//to rewrite the buffered image
	g2d.drawImage(scaled, 0, 0, null);
	g2d.dispose();//gets rid of it
	//End of help from stackoverflow

	loadRGBValues();
    }
    //Scales to golden ratio
    public void scaleImage(){
	scaleImage(162,100);
    }
    //finds the background color
    private void getBG(){
	int black = 0;
	int white = 0;
	bgC = new Pixel(0,0,0);
	for(int c = 0; c < width; c++){
	    if(isBlack(0, c) || isBlack(height - 1, c)){
		black++;
	    }
	    else{
		white++;
	    }
	}
	for(int r = 1; r < height - 1; r++){
	    if(isBlack(r, 0) || isBlack(r, width - 1)){
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
	if(pixelRGBValues[r][c].getColor().equals(Color.black)){
	    return true;
	}
	else{
	    return false;
	}
    }
    //remove symbols from picture
    private BufferedImage removeSymbol(){
	int startX = width - 1;
	int startY = height - 1;
	int endX = 0;
	int endY = 0;
	getBG();
	for(int r = 0; r < height; r++){
	    for(int c = 0; c < width; c++){
		if(!pixelRGBValues[r][c].getColor().equals(bgC.getColor())){
		    if(r < startY){
			startY = r;
		    }
		    if(r > endY){
			endY = r;
		    }
		    if(c < startX){
			startX = c;
		    }
		    if(c > endX){
			endX= c;
		    }
		}
	    }
	}
	int w = Math.abs(startX - endX) + 1;
	int h = Math.abs(startY - endY) + 1;
	System.out.println(height + "," + width + "," + h + "," + w);
	BufferedImage symbol = new BufferedImage(w, h, 1);
	for(int r = 0; r < h; r++){
	    for(int c = 0; c < w; c++){
		symbol.setRGB(c, h - r - 1, pixelRGBValues[r + startY][c + startX].getColor().getRGB());
	    }
	}
	//	System.out.println(symbol.getHeight() + "," + symbol.getWidth());
	return symbol;
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
    public boolean[][]toBoolean(){
	double t1 = System.currentTimeMillis();
	setBlackAndWhite();
	boolean[][]retArray=new boolean[pixelRGBValues.length][pixelRGBValues[0].length];
	for(int r = 0;r<retArray.length;r++){
	    for(int c = 0;c<retArray[0].length;c++){
		if(pixelRGBValues[r][c].getColor().equals(Color.black)){
		    retArray[r][c]=true;
		}else{
		    retArray[r][c]=false;
		}
		//System.out.println("1");
	    }
	}
	debug("toBoolean time: "+(System.currentTimeMillis()-t1)/1000);
	return retArray;
    }
    public void toBoolean(boolean[][] data){
	setBlackAndWhite();
	for(int r = 0; r < data.length; r++){
	    for(int c = 0; c < data[0].length; c++){
		if(pixelRGBValues[r][c].getColor().equals(Color.black)){
		    data[r][c] = true;
		}
		else{
		    data[r][c] = false;
		}
	    }
	}
    }
    public int[] dims(){
	int[] dim = new int[2];
	dim[0] = pixelRGBValues.length;
	dim[1] = pixelRGBValues[0].length;
	return dim;
    }
    public void outPut(String s){
	try{
	    ImageIO.write(image,"png",new File(s));
	}catch(IOException e){
	    System.out.println("Writing error");
	}
    }
    /*public void outputSymbol(String s){
	//	setRGBValues();
	try{
	    ImageIO.write(symbol,"png",new File(s));
	}catch(IOException e){
	    System.out.println("Writing error");
	}

	}*/
    //Creates a booleanArray class to be compared
    
    public static void main(String[]args){
	if(args.length>1){
	    ReadImage r1 = new ReadImage(args[0]);
	    r1.scaleImage();
	    r1.outPut(args[1]);
	}
	else if(args.length>0){
	    ReadImage r1 = new ReadImage(args[0]);
	    long time = System.currentTimeMillis();
	    r1.image=r1.removeSymbol();
	    for(int i = 0; i< 1000000;i++){
		r1.image.getScaledInstance(1618,1000,Image.SCALE_FAST);
	    }
	    System.out.println("Fast"+(System.currentTimeMillis()-time));
	}
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}

