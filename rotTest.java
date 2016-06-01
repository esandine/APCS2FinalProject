import java.util.*;
public class rotTest{
    public static void main(String[]args){
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
        myImage.loadCharacters();
	myImage.rotate(Math.PI/4);
	System.out.println(myImage.getRotAngle());
        System.out.println(myImage.closestMatch());
    }
}

