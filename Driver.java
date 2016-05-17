public class Driver{
    public static void main(String[]args){
	if(args.length>1){
	    booleanArray r1 = Read.loadBoolean(args[0]);
	    booleanArray r2 = Read.loadBoolean(args[1]);
	    System.out.println(r1.compareTo(r2,0));
	}
    }
}