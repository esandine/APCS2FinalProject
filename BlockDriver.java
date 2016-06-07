public class BlockDriver{
    public static void main(String[] args){
	ReadLines r = new ReadLines(args[0]);
	//r.setDef();
	r.divideLines();
	r.writeHTML();
    }
}
