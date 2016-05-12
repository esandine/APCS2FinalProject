import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class ReadImage{
    public static void ReadImage(String input){
	try{
	    BufferedImage i1 = ImageIO.read(new File(input));
	}catch(IOException e){
	    System.out.println("No file found");
	}
	//i1=ImageIO.read(new File(input));
    }
    public static void main(String[]args){
	if(args.length>0){
	    ReadImage(args[0]);
	}
    }
}
