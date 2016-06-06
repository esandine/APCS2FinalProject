public class BlockDriver{
    public static void main(String[] args){
	ReadLines r = new ReadLines("alphabet.jpeg");
	//r.setDef();
		r.divideLines();
	
		System.out.println(r.returnText());
    }
}
