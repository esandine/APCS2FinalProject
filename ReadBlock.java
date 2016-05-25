public class ReadBlock{
    private ArrayList<booleanArray> symbols;
    private ReadImage image;
    private booleanArray booleanImage;
    
    public ReadBlock(String img){
	image = new ReadImage(img);
	booleanImage = new booleanArray(image.toBoolean());
	symbols = new ArrayList<booleanArray>();
    }
    public boolean[][] removeSymbol(int rS, int rE, int cS, int cE){
	boolean[][] sym = new boolean[rE - rS + 1][cE - cS + 1];
	boolean[][] oriImg = booleanImage.getData();
	for(int r = 0; r < sym.length; r++){
	    for(int c = 0; c < sym[0].length; c++){
		sym[r][c] = oriImg[r + rS][c + cS];
	    }
	}
	return sym;
    }
}
