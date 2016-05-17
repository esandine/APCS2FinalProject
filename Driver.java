public class Driver{
    public static void main(String[]args){
	if(args.length>2){
	    System.out.println(Read.compare(args[0],args[1],Double.parseDouble(args[2])));
	}
    }
}