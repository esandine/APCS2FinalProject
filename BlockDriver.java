public class BlockDriver{
    public static void main(String[] args){
	BlockReader r = new BlockReader("testB.png");
	r.setDef();
	r.removeSymbols();
	r.makeImages();
		System.out.println(r);
    }
}
