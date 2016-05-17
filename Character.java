public class Character{
    private boolean[][] character;
    public Character(String img){
	ReadImage i = new ReadImage(img);
	character = i.toBoolean();
    }
}
