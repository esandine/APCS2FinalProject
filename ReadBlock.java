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
    public int[] findDim(){
	int[] dim = new int[4];
	boolean[][] oriImg = booleanImage.getData();
	int r = 0;
	int c = 0;
	int rS = oriImg.length - 1;
	int rE = 0;
	int cS = oriImg[0].length - 1;
	int cE = 0;
	while(r < oriImg.length){
	    while(c < oriImg[0].length){
		if(oriImg[r][c]){
		    if(r < rS){
			rS = r;
		    }
		    if(r > rE){
			rE = r;
		    }
		    if(c < cS){
			cS = c;
		    }
		    if(c > cE){
			cE = c;
		    }
		}
		c++;
	    }
	    r++;
	}
	dim[0] = rS;
	dim[1] = rE;
	dim[2] = cS;
	dim[3] = cE;
    }
}
