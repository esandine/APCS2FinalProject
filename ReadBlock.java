import java.util.*;

public class ReadBlock{
    private ArrayList<ReadImage> symbols;
    private ReadImage image;
    private booleanArray booleanImage;
    
    
    public ReadBlock(String img){
	image = new ReadImage(img);
	image.scaleImage();
	booleanImage = new booleanArray(image.toBoolean());
	symbols = new ArrayList<ReadImage>();
    }
    public void removeSymbols(){
	boolean[][] oriImg = booleanImage.getData();
	for(int c = 0; c < oriImg[0].length; c++){
	    //System.out.println("1");
	    for(int r = 0; r < oriImg.length;r++){
		if(oriImg[r][c] = true){
		    int[] dim = findDim(c,r);
		    //System.out.println("" + dim[0] + " " + dim[1] + " " + dim[2] + " " + dim[3]);
		    boolean[][] arr = new boolean[
		    for(int i = 0; i < arr.length; i++){
			for(int x = 0; x < arr[0].length; x++){
			    System.out.print(arr[i][x] + " ");
			}
			System.out.println("");
		    }
		    //   System.out.println("3");
		    if(dim[1]-dim[0]+1 > 0 && dim[3]-dim[2]+1 > 0){
			System.out.println("4");
			ReadImage curr = new ReadImage(arr);
			symbols.add(curr);
			System.out.println("hi");
		    }
		    c = dim[3];
		}
	    }
	}
    }
    public void makeImages(){
	for(int i = 0; i < symbols.size(); i++){
	    
	    String s = "symbol" + i + ".png";
	    symbols.get(i).outPut(s);
	}
    }
    public boolean[][] removeSymbol(int rS, int rE, int cS, int cE){
	int height = rE-rS+1;
	int width = cE-cS+1;
	if(height < 0 || width < 0){
	    height = 0;
	    width = 0;
	}
      	boolean[][] sym = new boolean[height][width];
	boolean[][] oriImg = booleanImage.getData();
	for(int r = 0; r < sym.length; r++){
	    for(int c = 0; c < sym[0].length; c++){
		sym[r][c] = oriImg[r + rS][c + cS];
		oriImg[r+rS][c+cS] = false;
	    }
	}
	return sym;
    }
    public int[] findDim(int cMin, int rMin){
	int[] dim = new int[4];
	boolean[][] oriImg = booleanImage.getData();
	int c = cMin;
	int rS = rMin;
	int rE = 0;
	int cS = cMin;
	int cE = 0;
	boolean b = false;;
	while(c < oriImg[0].length && b){
	    b = false;
	    for(int r = 0; r < oriImg.length; r++){
		if(oriImg[r][c]){
		    b = true;
		    if(c > cE){
			cE = c;
		    }
		    if(r > rE){
			rE = r;
		    }
		}
	    }
	}
	dim[0] = rS;
	dim[1] = rE;
	dim[2] = cS;
	dim[3] = cE;
	return dim;
    }
    
}
