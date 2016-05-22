import java.io.File;
import java.util.Hashtable;
public class booleanCharacters{
    private String[] charStrings;
    private booleanArray[] booleanArrs;
    private String directory;
    private int index = 0;
    public booleanCharacters(String dir){
	File in = new File(dir);
	String[] charImages = in.list();
	charStrings = new String[charImages.length];
	booleanArrs = new booleanArray[charStrings.length];
	for(int i = 0; i < booleanArrs.length; i++){
	    //System.out.println(dir+charImages[i]);
	    booleanArrs[i] = Read.loadBoolean(dir + charImages[i],false);
	}
	for(int i = 0; i < charImages.length; i++){
	    charStrings[i] = charImages[i].substring(0, charImages[i].length() - 4);	   
	}
    }
    public Hashtable<booleanArray,String> toHashtable(){
	Hashtable<booleanArray,String> retHashtable = new Hashtable<booleanArray,String>(booleanArrs.length);
	for(int i = 0;i<booleanArrs.length;i++){
	    retHashtable.put(booleanArrs[i],charStrings[i]);
	}
	return retHashtable;
    }
    public boolean compareTo(booleanArray other, double percent){
	for(int i = 0; i < booleanArrs.length; i++){
	    if(booleanArrs[i].compareTo(other, percent)){
		index = i;
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
