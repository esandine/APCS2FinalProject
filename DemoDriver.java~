import java.util.*;

public class DemoDriver{
    public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);
	System.out.println("Welcome to our Optical Character Reader (OCR)  created by team Sardine Kimbap.");
	System.out.println("To run the OCR download the image you wish to read into this directory.");
	System.out.println("Next enter the name of your image file below.");
	System.out.println("The results will be viewable in results.html");
	System.out.println("What image would you like to compare?");
	String inputFile = "";
	boolean next = true;
	while(inputFile.equals("")){
	    try{
		inputFile = myScanner.next();
		ReadLines reader = new ReadLines(inputFile);
		reader.divideLines();
		reader.writeHTML();
		System.out.println("Would you like another image read? y/n");
		String response = "";
		while(response.equals("")){
		    response = myScanner.next();
		    if(response.equals("y")){
			inputFile = "";
			System.out.println("Which image do you want to read next?");
		    }
		    else if(!response.equals("n")){
			System.out.println("Answer with y or n only");
			response = "";
		    }
		}
	    }catch(NullPointerException e){
		System.out.println("Choose another file");
		inputFile = "";
	    }
	}

    }
}


