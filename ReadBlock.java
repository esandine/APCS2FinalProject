public class ReadBlock{
    private ArrayList<booleanArray> symbols;
    private ReadImage image;
    private booleanArray booleanImage;
    
    
    public ReadBlock(String img){
	image = new ReadImage(img);
	booleanImage = new booleanArray(image.toBoolean());
	symbols = new ArrayList<booleanArray>();
    }
    public void removeSymbols(){
	int currentC = 0;
	boolean[][] oriImg = booleanImage.getData();
	for(int c = 0; r < oriImg[0]ngth; c++){
	    int[] dim = findDim(currentC);
	    for(int r = 0; c < oriImg.length;r++){
		symbols.add(new booleanArray(removeSymbol(dim[0], dim[1], dim[2], dim[3])));
	    }
	    c = dim[2];
	}
    }
    public boolean[][] removeSymbol(int rS, int rE, int cS, int cE){
	boolean[][] sym = new boolean[rE - rS + 1][cE - cS + 1];
	boolean[][] oriImg = booleanImage.getData();
	for(int r = 0; r < sym.length; r++){
	    for(int c = 0; c < sym[0].length; c++){
		sym[r][c] = oriImg[r + rS][c + cS];
		oriImg[r+rS][c+cS] = false;
	    }
	}
	return sym;
    }
    public int[] findDim(int cMin){
	int[] dim = new int[4];
	boolean[][] oriImg = booleanImage.getData();
	int r = 0;
	int c = cMin;
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
