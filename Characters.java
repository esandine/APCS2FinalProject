import java.io.File;

public class Characters{
    private ReadImage[] characters;
    public Characters(String dir){
	File d = new File(dir);
	String[] charImages = d.list();
	characters = new ReadImage[charImages.length];
	for(int i = 0; i < characters.length; i++){
	    System.out.println(charImages[i]);
	    characters[i] = new ReadImage(dir + charImages[i]);
	}	
	
    }
    public void recolorDir(){
	for(int i = 0; i < characters.length; i++){
	    String outputFile = "char" + i;
	    System.out.println(outputFile);
	    recolorImg(characters[i], outputFile);
	}
    }
    public void recolorImg(ReadImage image, String outputFile){
	image.setBlackAndWhite();
	image.outPut(outputFile);
    }
}
