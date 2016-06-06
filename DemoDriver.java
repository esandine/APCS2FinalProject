import java.util.*;

public class DemoDriver{
    public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);
	System.out.println("What image would you like to compare?");
	String inputFile = "";
	boolean next = true;
	while(inputFile.equals("")){
	    try{
		inputFile = myScanner.next();
		ReadLines reader = new ReadLines(inputFile);
		reader.divideLines();
		System.out.println(reader.returnText());
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


