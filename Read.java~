public class Read{
    //A class of static methods
    public static booleanArray loadBoolean(String image){
	ReadImage input = new ReadImage(image);
	input.scaleImage();
	return new booleanArray(input.toBoolean());
    }
    //Compares two images given the image names and the percent error needed
    public static boolean compare(String image1, String image2, double percentError){
	booleanArray a1 = loadBoolean(image1);
	booleanArray a2 = loadBoolean(image2);
	return a1.compareTo(a2,percentError/100);
    }
    public static double percentError(String image1,String image2){
	double max = 100;
	double min = 0;
	while(max-min>.000001){
	    if(compare(image1, image2, (max+min)/2)){
		max=(max+min)/2;
	    }
	    else{
		min=(max+min)/2;
	    }
	}
	return (max+min)/2;
    }
}