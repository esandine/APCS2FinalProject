public class tester{
    public static void main(String[] args){
	if(args.length > 0){
	    booleanCharacters chars = new booleanCharacters(args[0]);
	    ReadImage img = new ReadImage("testimage.png");
	    img.setBlackAndWhite();
	    img.scaleImage();
	    booleanArray comp = new booleanArray(img.toBoolean());
	    System.out.println(chars.compareTo(comp, 70));
	}
    }
}
