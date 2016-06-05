public class pngDriver{
    public static void main(String[]args){
	booleanArray b = Read.loadBoolean(args[0]);
	b.scale(50,50);
	System.out.println(b);
    }
}