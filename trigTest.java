public class trigTest{
    public static void main(String[]args){
	Polar p1 = new Polar(3.0,3.0);
	p1.rotate(Math.PI);
	System.out.println(""+p1.getXcor()+","+p1.getYcor());
    }
}