import java.util.Hashtable;
public class tester{
    public static void main(String[] args){
	if(args.length > 0){
	    booleanCharacters chars = new booleanCharacters(args[0]);
	    /*ReadImage img = new ReadImage("A.png");
	    img.setBlackAndWhite();
	    img.scaleImage();
	    booleanArray comp = new booleanArray(img.toBoolean());
	    */
	    Hashtable<booleanArray,String> hash = chars.toHashtable();
	    //System.out.println(chars.toString(comp, 10));
	}
    }
}
