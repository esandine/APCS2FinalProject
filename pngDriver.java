public class pngDriver{
    public static void main(String[]args){
	ReadImage r = new ReadImage("penguin.jpg");
	r.outPut("penguintry.jpg");
	r.getColors();
    }
}