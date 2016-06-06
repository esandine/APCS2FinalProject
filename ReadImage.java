import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.Graphics2D;
//This class is responsible for reading images and converting them to array of pixels
public class ReadImage{
    //Instance variables
    private BufferedImage image;//The image file that is read
    private Pixel[][] pixelRGBValues;//The array of pixels
    private int height;//The height of image
    private int width;//The width of image
    private Pixel bgC;//The background color (Currently not in use)
    private BufferedImage symbol;//For chopping files (Currently not in use)
    public static boolean debug = false;//For debugging

    //Constructors:

    //This creates an Image from an array of booleans, it is used for testing purposes
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

    //The main constructor, reads an iamge and fills the instance variables accordingly
    public ReadImage(String input){
	try{
	    image = ImageIO.read(new File(input));
	    height = image.getHeight();
	    width = image.getWidth();
	    //setImageType();
	    loadRGBValues();
	}catch(IOException e){
	    System.out.println("No file found");
	    image = null;
	}
	//i1=ImageIO.read(new File(input));
    }

    //Methods

    //setImageType rewrites the bufferedimage to make sure it is in the right color format
    private void setImageType(){
	try{
	    BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
	    newImage.setData(image.getData());
	    image=newImage;
	}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Please try a different file");
	}
    }

    //Converts the image to a 2D array of pixels
    private void loadRGBValues(){
	pixelRGBValues = new Pixel[height][width];
	for(int r = 0; r < height; r++){ 
	    for(int c = 0; c < width; c++){
		pixelRGBValues[r][c] = new Pixel(image.getRGB(c,r),r,c);
	    }
	}
    }

    //The reverse of loadRGBValues() primarily used for testing
    private void setRGBValues(){
	setImageType();
	for(int r = 0; r < height; r++){ 
	    for(int c = 0; c < width; c++){
		image.setRGB(c,r,pixelRGBValues[r][c].getColor().getRGB());
	    }
	}
    }

    //Prints out all the pixel values, used for testing
    public void checkRGB(){
	for(int r = 0; r < height; r++){
	    for(int c = 0;c < width; c++){
		System.out.println(image.getRGB(c,r));
	    }
	}
    }

    //Scales images. Used in resizing all the images in the font directories
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

    //Scales to golden ratio, currently not used anymore
    public void scaleImage(){
	scaleImage(162,100);
    }

    //MaxNode is used to find the two most common colors
    private class MaxNode{
	private int color;
	private int frequency;
	public MaxNode(int i){
	    this(i,0);
	}
	public MaxNode(int i, int f){
	    color = i;
	    frequency = f;
	}
	public void add(){
	    frequency++;
	}
	public int getColor(){
	    return color;
	}
	public int getFrequency(){
	    return frequency;
	}
	public String toString(){
	    return "Color: "+getColor()+" Frequency: "+getFrequency();
	}
    }

    //Finds the two most common colors in the image
    public int[] twoColors(){
	//Creates array of colors to check if color already exists
	ArrayList<Integer> colors = new ArrayList<Integer>();
	//Creates array of nodes to keep trakc of frequency of the colors
	ArrayList<MaxNode> nodes = new ArrayList<MaxNode>();
	for(int r = 0; r < pixelRGBValues.length; r++){
	    for(int c = 0; c < pixelRGBValues[0].length; c++){
		Integer co = pixelRGBValues[r][c].getColor().getRGB();
		if(colors.contains(co)){
		    //If the color is added you increase frequency by one
		    nodes.get(colors.indexOf(co)).add();
		}else{
		    //If not make a new node with the color
		    colors.add(co);
		    nodes.add(new MaxNode(co));
		}
	    }
	}
	int[] retValues = new int[2];
	if(nodes.size()==0){
	    //This means no colors which is suspicious
	    throw new IllegalArgumentException();
	}else if(nodes.size()==1){
	    //If image is one color return it twice
	    retValues[0]=nodes.get(0).getColor();
	    retValues[1]=nodes.get(0).getColor();
	}else{
	    //If not find the two nodes with biggest frequencies
	    MaxNode mostCommon;
	    MaxNode secondCommon;
	    if(nodes.get(0).getFrequency()>nodes.get(1).getFrequency()){
		mostCommon = nodes.get(0);
		secondCommon = nodes.get(1);
	    }else{
		mostCommon = nodes.get(1);
		secondCommon = nodes.get(0);
	    }
	    for(int i = 2; i<nodes.size(); i++){
		MaxNode n = nodes.get(i);
		if(n.getFrequency()>mostCommon.getFrequency()){
		    //If this is the biggest frequency
		    if(mostCommon.getFrequency()>secondCommon.getFrequency()){
			secondCommon = new MaxNode(mostCommon.getColor(),mostCommon.getFrequency());
			System.out.println("Triggered");
		    }
		    mostCommon = n;
		}else if(n.getFrequency()>secondCommon.getFrequency()){
		    //If second biggest frequency
		    secondCommon = n;
		}
	    }
	    retValues[0]=mostCommon.getColor();
	    retValues[1]=secondCommon.getColor();
	}
	return retValues;
    }
    //Sets image to all black, used for testing
    private boolean isBlack(int r, int c){
	if(pixelRGBValues[r][c].getColor().equals(Color.black)){
	    return true;
	}
	else{
	    return false;
	}
    }

    //Prints out all the colors of the pixels in pixelRGBValues
    public void getColors(){
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		System.out.println(pixelRGBValues[r][c].getColor());
	    }
	}
    }

    //Sets all the pixels to black, used for testing
    private void setBlack(){
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		pixelRGBValues[r][c].setColor(Color.black);
	    }
	}
    }

    //Used for debugging purposes
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

    //Returns the dimensions
    public String getDimension(){
	return "h: " + height + ", w: " + width;
    }

    //Makes all the pixels either white or black
    public void setBlackAndWhite(){
	//Gets the two most common colors
	int[] twoc= twoColors();
	//Splits the most common color into rgb components
	Color most = new Color(twoc[0]);
	float[] mostComponents = most.getRGBComponents(null);
	//Splits the second most common color into rgb componets
	Color second = new Color(twoc[1]);
	float[] secondComponents = second.getRGBComponents(null);

	//Variables for the current rgb values
	float[] currentComponents = new float[3];
	//Variables for the error between most and second most common colors
	float mostError;
	float secondError;
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		mostError = 0;
		secondError = 0;
		currentComponents = pixelRGBValues[r][c].getColor().getRGBComponents(null);
		for(int i = 0; i< 3; i++){
		    mostError+=Math.abs(Math.abs(mostComponents[i])-Math.abs(currentComponents[i]));
		    secondError+=Math.abs(Math.abs(secondComponents[i])-Math.abs(currentComponents[i]));
		}
		if(mostError>secondError){
		    pixelRGBValues[r][c].setColor(Color.black);
		}else{
		    pixelRGBValues[r][c].setColor(Color.white);
		}
	    }
	    //System.out.println("");
	}
    }

    //Function that converts the array of pixels into an array of booleans
    //True=black, False = anything else
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
	//debug("toBoolean time: "+(System.currentTimeMillis()-t1)/1000);
	return retArray;
    }

    //Converts the pixels to black and white, primarily used for testing/debugging
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

    //dims returns the dimensions of the array
    public int[] dims(){
	int[] dim = new int[2];
	dim[0] = pixelRGBValues.length;
	dim[1] = pixelRGBValues[0].length;
	return dim;
    }	

    //converts a 2d array of booleans to an image
    public void toImage(boolean[][]barry){
	pixelRGBValues = new Pixel[barry.length][barry[0].length];
	for(int i = 0; i<barry.length; i++){
	    for(int ii = 0; ii<barry[0].length; ii++){
		if(barry[i][ii]){
		    pixelRGBValues[i][ii] = new Pixel(Color.BLACK,i,ii);
		}else{
		    pixelRGBValues[i][ii] = new Pixel(Color.WHITE,i,ii);
		}
	    }
	}
	height = pixelRGBValues.length;
	width = pixelRGBValues[0].length;
	setRGBValues();
    }

    //Primarily used for testing and resizing fonts, it writes the image on a new file
    public void outPut(String s){
	setRGBValues();
	try{
	    ImageIO.write(image,"JPG",new File(s));
	}catch(IOException e){
	    System.out.println(e);
	}
    }
    //Used for debugging
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}

