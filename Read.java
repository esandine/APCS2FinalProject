public class Read{
    private static boolean debug = false;
    //A class of static methods
    public static booleanArray loadBoolean(String image,boolean scale){
	double t1 = System.currentTimeMillis();
	ReadImage input = new ReadImage(image);
	double t2 = System.currentTimeMillis();
	if(scale){
	    input.scaleImage();
	}
	double t3 = System.currentTimeMillis();
	debug("ReadImage time: "+(t2-t1)/1000);
	debug("Scale Image time: "+(t3-t2)/1000);
	return new booleanArray(input.toBoolean());
    }
    public static void rescale(String image){
	ReadImage input = new ReadImage(image);
	input.scaleImage();
	input.outPut(image);
    }
    //Compares two images given the image names and the percent error needed
    public static boolean compare(String image1, String image2, double percentError){
	booleanArray a1 = loadBoolean(image1,true);
	booleanArray a2 = loadBoolean(image2,true);
	return a1.compareTo(a2,percentError);
    }
    public static double percentError(String image1,String image2){
	booleanArray a1 = loadBoolean(image1,true);
	booleanArray a2 = loadBoolean(image2,true);
	return a1.percentError(a2);
    }
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}