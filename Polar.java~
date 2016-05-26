//For use in rotating coordinates
public class Polar{
    private double radius;
    private double angle;
    //Mutators
    public void setRadius(double r){
	radius = r;
    }
    public void setAngle(double a){
	angle = a;
    }
    public void rotate(double rad){
	setAngle(getAngle()+rad);
    }
    //Accessors
    public double getAngle(){
	return angle;
    }
    public double getRadius(){
	return radius;
    }
    public int getXcor(){
	return (int)(radius*Math.cos(angle));
    }
    public int getYcor(){
	return (int)(radius*Math.sin(angle));
    }
    //Constructors
    public Polar(int x, int y){
	if(x==0){
	    setRadius(y);
	    setAngle(Math.PI/2);
	}else{
	    setRadius(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)));
	    setAngle(Math.atan(y/x));
	}
    }
}