import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class ReadImage{
    private BufferedImage image;
    private int[][] pixelRBGValues;
    /*private void loadRBGValues(){
	pixelRGBValues = new int[image
	for(int i = 
	}*/
    public ReadImage(String input){
	try{
	    image = ImageIO.read(new File(input));
	}catch(IOException e){
	    System.out.println("No file found");
	    image = null;
	}
	//i1=ImageIO.read(new File(input));
    }
    public static void main(String[]args){
	if(args.length>0){
	    ReadImage r1 = new ReadImage(args[0]);
	}
    }
}
