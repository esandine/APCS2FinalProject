import java.io.File;
public class Read{
    private static boolean debug = false;
    //A class of static methods

    //Uses the other constructors to create a booleanArray from a given file
    public static booleanArray loadBoolean(String image){
	double t1 = System.currentTimeMillis();
	ReadImage input = new ReadImage(image);
	double t2 = System.currentTimeMillis();
	double t3 = System.currentTimeMillis();
	//debug("ReadImage time: "+(t2-t1)/1000);
	//debug("Scale Image time: "+(t3-t2)/1000);
	return new booleanArray(input.toBoolean());
    }

    //Rescales an image file to the golden ratio
    public static void rescale(String image){
	ReadImage input = new ReadImage(image);
	input.scaleImage();
	input.outPut(image);
    }

    //Rescales an entire directory
    public static void rescaleDir(String dir){
        File in = new File(dir);
        String[] charImages = in.list();
	for(int i = 0;i<charImages.length;i++){
	    System.out.println(charImages[i]);
	    rescale(dir+charImages[i]);
	}
    }

    //Trims an image file
    public static void trim(String image){
	ReadImage img = new ReadImage(image);
	booleanArray b1 = new booleanArray(img.toBoolean());
	b1.trim();
	img.toImage(b1.getData());
	img.outPut(image);
    }

    //Trims the whitespace out of an entire directory
    public static void trimDir(String dir){
        File in = new File(dir);
        String[] charImages = in.list();
	for(int i = 0;i<charImages.length;i++){
	    System.out.println(charImages[i]);
	    trim(dir+charImages[i]);
	}
    }

    //Compares two images given the image names and the percent error needed
    public static boolean compare(String image1, String image2, double percentError){
	booleanArray a1 = loadBoolean(image1);
	booleanArray a2 = loadBoolean(image2);
	return a1.compareTo(a2,percentError);
    }

    //Gives the percent error between two images
    public static double percentError(String image1,String image2){
	booleanArray a1 = loadBoolean(image1);
	booleanArray a2 = loadBoolean(image2);
	return a1.percentError(a2);
    }

    //Used for debuging 
    public static void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }
}






