import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class ReadImage{
    private BufferedImage image;
    private int[][] pixelRGBValues;
    private int height;
    private int width;
    private void loadRGBValues(){
	pixelRGBValues = new int[height][width];
	for(int r = 0; r < height; r++){ 
	    for(int c = 0; c < width; c++){
		pixelRGBValues[r][c] = image.getRGB(c, height - r - 1);
	    }
	}
    }
    private void setBlack(){
	for(int r = 0; r < height; r++){
	    for(int c = 0; c<width; c++){
		pixelRGBValues[r][c] = 0;
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
		ans += pixelRGBValues[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    public String getDimension(){
	return "h: " + height + ", w: " + width;
    }
    public static void main(String[]args){
	if(args.length>0){
	    ReadImage r1 = new ReadImage(args[0]);
	    //r1.setBlack();
	    System.out.println(r1.getDimension());
	    System.out.println(r1);
	}
    }
}
