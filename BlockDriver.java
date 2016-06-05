public class BlockDriver{
    public static void main(String[] args){
	BlockReader r = new BlockReader("text2.jpeg");
	//r.setDef();
		r.removeSymbols();
	
		System.out.println(r.stringImg());
    }
}
