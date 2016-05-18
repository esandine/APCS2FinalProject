public class Read{
    //A class of static methods
    public static booleanArray loadBoolean(String image){
	ReadImage input = new ReadImage(image);
	input.scaleImage();
	return new booleanArray(input.toBoolean());
    }
    public static boolean compare(String image1, String image2, double percentError){
	booleanArray a1 = loadBoolean(image1);
	booleanArray a2 = loadBoolean(image2);
	return a1.compareTo(a2,percentError/100);
    }
}