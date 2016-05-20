import java.io.File;

public class Characters{
    private ReadImage[] characters;
    private String directory;
    public Characters(String dir){
	this(dir, "results/");
    }
    public Characters(String dir, String outputDir){
	File d = new File(dir);
	String[] charImages = d.list();
	characters = new ReadImage[charImages.length];
	for(int i = 0; i < characters.length; i++){
	    characters[i] = new ReadImage(dir + charImages[i]);
	}	
	File r = new File(outputDir);
	directory = outputDir;
    }
    public void recolorDir(){
	for(int i = 0; i < characters.length; i++){
	    String outputFile = directory + "/char" + i + ".png";
	    recolorImg(characters[i], outputFile);
	}
    }
    public void recolorImg(ReadImage image, String outputFile){
	image.setBlackAndWhite();
	image.outPut(outputFile);
    }
}
