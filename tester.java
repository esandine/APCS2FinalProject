import java.util.Hashtable;
public class tester{
    public static void main(String[] args){
	if(args.length > 0){
	    booleanArray b = Read.loadBoolean(args[0]);
	    b.loadDirectory("alphabet/");
	    System.out.println(b.closestMatch());
	}
    }
}
