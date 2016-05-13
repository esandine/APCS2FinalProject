public class Pixel{
    //Instance Variables
    private Color color;
    private int xcor;
    private int ycor;
    //Constructors
    public Pixel(int RGB,int x,int y){
	color new Color(RGB);
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
}