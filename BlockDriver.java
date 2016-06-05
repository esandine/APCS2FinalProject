public class BlockDriver{
    public static void main(String[] args){
	ReadLines r = new ReadLines("text4.jpeg");
	//r.setDef();
		r.divideLines();
	
		System.out.println(r.returnText());
    }
}
