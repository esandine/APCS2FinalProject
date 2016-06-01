public class Character{
    private ReadImage character;
    private boolean[][] 
	public Character(String img){
	character = new ReadImage(img);
    }
    public void recolorImg(String newImage){
	character.getDimension();
	character.setBlackAndWhite();
	character.outPut(newImage);
    }
}