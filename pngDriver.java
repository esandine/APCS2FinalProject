public class pngDriver{
    public static void main(String[]args){
	booleanArray b1 = Read.loadBoolean("t.png");
	b1.loadCharacters();
	b1.printChars();
    }
}