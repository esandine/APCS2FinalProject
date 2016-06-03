import java.util.*;

public class DemoDriver{
    public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);
	System.out.println("What image would you like to compare?");
	String inputFile = "";
	while(inputFile == ""){
	    try{
		inputFile = myScanner.next();
	    }catch(NullPointerException e){
		System.out.println("Choose another file");
		inputFile = "";
	    }
	}
	booleanArray myImage = Read.loadBoolean(inputFile);
	System.out.println("testing");
	System.out.println(myImage);
	myImage.loadCharacters();
	System.out.println("tsting2");
	System.out.println(myImage.closestMatch());
    }
}
