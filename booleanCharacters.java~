import java.io.File;
import java.util.Hashtable;
//Primarily used for creating the hashtable of booleans in the loadCharacters function of booealArray
public class booleanCharacters{
    //Instance Variables
    private String[] charStrings;
    private booleanArray[] booleanArrs;
    private String directory;
    private int index = 0;

    //Constructors

    //Loads a directory into the booleanCharacters
    public booleanCharacters(String dir){
	File in = new File(dir);
	String[] charImages = in.list();
	charStrings = new String[charImages.length];
	booleanArrs = new booleanArray[charStrings.length];
	for(int i = 0; i < booleanArrs.length; i++){
	    booleanArrs[i] = Read.loadBoolean(dir + charImages[i]);
	}
	for(int i = 0; i < charImages.length; i++){
	    charStrings[i] = charImages[i].substring(0, charImages[i].length() - 4);	   
	}
    }

    //Creates the hashTable using the data
    public Hashtable<booleanArray,String> toHashtable(String dir){
	Hashtable<booleanArray,String> retHashtable = new Hashtable<booleanArray,String>(booleanArrs.length);
	for(int i = 0;i<booleanArrs.length;i++){
	    retHashtable.put(booleanArrs[i],dir+charStrings[i]);
	}
	return retHashtable;
    }

    //Finds a match of a booleanArray in a directory
    public boolean compareTo(booleanArray other, double percent){
	for(int i = 0; i < booleanArrs.length; i++){
	    if(booleanArrs[i].compareTo(other, percent)){
		index = i;
		return true;
	     
	    }
	}
	return false;
    }

    //returns the name of the closest match in the directory
    public String toString(booleanArray other, double percent){
	if(compareTo(other, percent)){
	    return charStrings[index];
	}
	return "no matches found";
    }
}
