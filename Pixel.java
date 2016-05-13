import java.awt.Color;
public class Pixel{
    //Instance Variables
    private Color color;
    private int xcor;
    private int ycor;
    //Constructors
    public Pixel(int RGB,int x,int y){
	color = new Color(RGB);
	xcor = x;
	ycor = y;
    }
    //Mutators
    public void setColor(Color c){
	color = c;
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