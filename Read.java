public class Read{
    //A class of static methods
    public static booleanArray loadBoolean(String image){
	ReadImage input = new ReadImage(image);
	input.scaleImage();
	return new booleanArray(input.toBoolean());
    }
}