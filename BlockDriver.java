public class BlockDriver{
    public static void main(String[] args){
	ReadLines r = new ReadLines("alpha2.gif");
	//r.setDef();
		r.divideLines();
	
		System.out.println(r.returnText());
    }
}
