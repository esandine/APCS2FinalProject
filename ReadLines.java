public class ReadLines{
    private ArrayList<BlockReader> lines;
    private booleanArray img;

    public ReadLines(String image){
	img = Read.loadBoolean(image);
	img.trim();
	lines = new ArrayList<BlockReader>();
    }
    //splits big block of text into mulptiple lines to be read by BlockReader class
    public void divideLines(){

    }
    //finds end row of one section of the block given the row it starts at
    public int findBottomRow(int rS){
	boolean triggered = true;
	boolean first = false;
	int rE = img.getRows();
	int r = rS;
	while(triggered && r < rE){
	    if(first){
		triggered = false;
	    }
	    for(int c = 0; c < img.getCols(); c++){
		if(img.getValue(r,c)){
		    triggered = true;
		    if(!first){
			first = true;
		    }
		}
	    }
	    r++;
	}
	return r;
    }
    
}
