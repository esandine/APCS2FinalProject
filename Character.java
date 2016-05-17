public class Character{
    private ReadImage character;
    public Character(String img){
	character = new ReadImage(img);
	character.setBlackAndWhite();
    }
    public recolorImg(String newImage){
	character.outPut(newImage);
    }
}
