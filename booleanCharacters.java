import java.io.File;

public class booleanCharacters{
    private ReadImage[] chars;
    private String[] charStrings;
    private booleanArray[] booleanArrs;
    private String directory;
    public booleanCharacters(String dir){
	File in = new File(dir);
	String[] charImages = in.list();
	chars = new ReadImage[charImages.length];
	charStrings = new String[charImages.length];
	booleanArrs = new booleanArray[chars.length];
	System.out.println("scaling images");
	for(int i = 0; i < chars.length; i++){
	    chars[i] = new ReadImage(dir + charImages[i]);
	    chars[i].scaleImage();
	}
	System.out.println("changing too booleans");
	for(int i = 0; i < chars.length; i++){
	    booleanArrs[i] = new booleanArray(chars[i].toBoolean());
	}
	System.out.println("making string values for images");
	for(int i = 0; i < charImages.length; i++){
	    charStrings[i] = charImages[i].substring(0, charImages[i].length() - 4);
	}
    }
    public boolean compareTo(booleanArray other, double percent){
	for(int i = 0; i < booleanArrs.length; i++){
	    if(booleanArrs[i].compareTo(other, percent)){
		return true;
	    }
	}
	return false;
    }
}
