public class Characters{
    private Character[] characters;
    public Characters(String dir){
	File d = new File(dir);
	String[] charImages = d.list();
	characters = new Character[charImages.length];
	for(int i = 0; i < characters.length; i++){
	    characters[i] = new Character(charImages[i]);
	}	
    }
    public recolorDir(){
	for(int i = 0; i < characters.length; i++){
	    String outputFile = "char" + i;
	    characters[i].recolorImg(outputFile);
	}
    }
}