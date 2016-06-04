import java.awt.Color;
import java.awt.Transparency;
import java.awt.image.*;
import java.awt.color.*;
public class Pixel{
    //Instance Variables
    private Color color;
    private int xcor;
    private int ycor;
    //Constructors

    //Standard constructor
    public Pixel(Color c,int x, int y){
	color = c;
	xcor = x;
	ycor = y;
	setOpaque();
    }

    //Makes a pixel from a pixel rgb value
    public Pixel(int RGB,int x,int y){
	this(new Color(0),x,y);
	setColor(convertPixel(RGB));
    }

    //convertPixel converts colors from the BufferedImage rgb values to Color rgb values
    public int convertPixel(int RGB){
	//ColorSpace space = new ICC_ColorSpace(ICC_Profile.getInstance(ColorSpace.CS_sRGB));
	//ColorModel c = new ComponentColorModel(space, false, false, Transparency.OPAQUE, DataBuffer.TYPE_INT);
	ColorModel c =  ColorModel.getRGBdefault();
	return c.getRGB(RGB);
    }

    //Mutators
    public void setColor(int rgb){
	setColor(new Color(rgb));
    }
    public void setColor(Color c){
	color = c;
    }

    //Used to reset alpha values, no longer used
    public void setOpaque(){
	if(color.getAlpha()<.5){
	    color = new Color(color.getRed(),color.getGreen(),color.getBlue());
	}else{
	    color = Color.white;
	}
    }

    public void setXcor(int x){
	xcor = x;
    }
    public void setYcor(int y){
	ycor = y;
    }
    //Accessors
    public Color getColor(){
	return color;
    }
    public String toString(){
	return "Red: "+color.getRed()+"Green: "+color.getGreen()+"Blue: "+color.getBlue();
    }

    public int getXcor(){
	return xcor;
    }
    public int getYcor(){
	return ycor;
    }
    //Sets the color to white or black depending on the RGB values
    public void toBlackandWhite(){
	if((color.getRed()<128)&&(color.getGreen()<128)&&(color.getBlue()<128)){
	    setColor(Color.black);
	}else{
	    setColor(Color.white);
	}
    }
}
