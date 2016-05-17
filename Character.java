public class Character{
    private ReadImage character;
    public Character(String img){
	character = new ReadImage(img);
	character.setBlackAndWhite();
    }
    public void recolorImg(String newImage){
	character.outPut(newImage);
    }
}
