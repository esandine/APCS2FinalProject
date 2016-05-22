import java.io.File;

public class Characters{
    private ReadImage[] characters;
    private String directory;
    private String[] imgNames;
    public Characters(String dir){
	this(dir, "results/");
    }
    public Characters(String dir, String outputDir){
	File d = new File(dir);
	String[] charImages = d.list();
	imgNames = new String[charImages.length];
	for(int i = 0; i < charImages.length; i++){
	    imgNames[i] = charImages[i];
	}
	characters = new ReadImage[charImages.length];
	for(int i = 0; i < characters.length; i++){
	    characters[i] = new ReadImage(dir + charImages[i]);
	}
	File r = new File(outputDir);
	directory = outputDir;
    }
    public void rescale(){
	System.out.println("scaling images");
	for(int i = 0; i < characters.length; i++){
	    characters[i].scaleImage();
	}
    }
    public void recolorDir(){
	System.out.println("recoloring images to output");
	for(int i = 0; i < characters.length; i++){
	    String outputFile = directory + "/" + imgNames[i];
	    recolorImg(characters[i], outputFile);
	}
    }
    public void recolorImg(ReadImage image, String outputFile){
	image.setBlackAndWhite();
	image.outPut(outputFile);
    }
    public static void main(String[] args){
	
	    Characters rescaling = new Characters("alphabet/", "rescaledAlpha/");
	     rescaling.rescale();
	    rescaling.recolorDir();
	    

    }
	
    
}
