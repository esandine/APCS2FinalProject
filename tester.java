import java.util.Hashtable;
public class tester{
    public static void main(String[] args){
	if(args.length > 0){
	    double t1 = System.currentTimeMillis();
	    booleanArray b = Read.loadBoolean(args[0]);
	    double t2 = System.currentTimeMillis();
	    //b.loadDirectory("alphabet/");
	    double t3 = System.currentTimeMillis();
	    //System.out.println(b.closestMatch());
	    System.out.println("Reading one file: "+((t2-t1)/1000));
	    System.out.println("loading directory: "+((t3-t2)/1000));
	    System.out.println("Total: "+(System.currentTimeMillis()-t1)/1000);
	}
    }
}
