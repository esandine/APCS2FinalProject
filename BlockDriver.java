public class BlockDriver{
    public static void main(String[] args){
	ReadBlock r = new ReadBlock("ocr.png");
	r.removeSymbols();
	r.makeImages();
    }
}
