import java.awt.Color;
public class Pixel{
    //Instance Variables
    private Color color;
    private int xcor;
    private int ycor;
    //Constructors
    public Pixel(Color c,int x, int y){
	color = c;
	xcor = x;
	ycor = y;
	setOpaque();
    }
    public Pixel(int RGB,int x,int y){
	this(new Color(RGB),x,y);
	setOpaque();
    }
    //Mutators
    public void setColor(int rgb){
	color = new Color(rgb);
    }
    public void setOpaque(){
	color = new Color(color.getRGB());
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
    public int getXcor(){
	return xcor;
    }
    public int getYcor(){
	return ycor;
    }
    //Sets the color ot black if it is black or white if it is any color that is not black
    public void toBlackandWhite(){
	if((color.getRed()<30)&&(color.getGreen()<30)&&(color.getBlue()<30)){
	    setColor(Color.black);
	}else{
	    setColor(Color.white);
	}
    }
}
