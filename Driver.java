public class Driver{
    public static void main(String[] args){
	if(args.length > 0){
	    Characters c = new Characters(args[0]);
	    c.recolorDir();
	}
    }
}
