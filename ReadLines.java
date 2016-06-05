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
	return 1;
    }
    
}
