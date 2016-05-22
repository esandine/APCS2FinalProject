import java.io.File;

public class booleanCharacters{
    private ReadImage[] chars;
    private String[] charStrings;
    private booleanArray[] booleanArrs;
    private String directory;
    private int index = 0;
    public booleanCharacters(String dir){
	File in = new File(dir);
	String[] charImages = in.list();
	chars = new ReadImage[charImages.length];
	charStrings = new String[charImages.length];
	booleanArrs = new booleanArray[chars.length];
	for(int i = 0; i < chars.length; i++){
	    chars[i] = new ReadImage(dir + charImages[i]);
	}
	System.out.println("changing to booleans");
	for(int i = 0; i < chars.length; i++){
	    booleanArrs[i] = new booleanArray(chars[i].toBoolean());
	}
	System.out.println("making string values for images");
	for(int i = 0; i < charImages.length; i++){
	    charStrings[i] = charImages[i].substring(0, charImages[i].length() - 4);
	    System.out.println(charStrings[i]);
	    System.out.println(charImages[i]);
	}
    }
    public boolean compareTo(booleanArray other, double percent){
	for(int i = 0; i < booleanArrs.length; i++){
	    if(booleanArrs[i].compareTo(other, percent)){
		index = i;
		System.out.println(index);
		return true;
	     
	    }
	}
	return false;
    }

    //returns the name of 
    public String toString(booleanArray other, double percent){
	if(compareTo(other, percent)){
	    return charStrings[index];
	}
	return "no matches found";
    }
}
