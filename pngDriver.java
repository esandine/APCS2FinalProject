public class pngDriver{
    public static void main(String[]args){
	//ReadImage r = new ReadImage("penguin.jpg");
	//r.setBlackAndWhite();
	//r.outPut("penguintry.jpg");
	//r.getColors();
	System.out.println("Start read");
	booleanArray b1 = Read.loadBoolean("T.png");
	System.out.println("Finish read");
	System.out.println(b1);
    }
}