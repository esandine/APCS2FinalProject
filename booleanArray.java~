public class booleanArray{
    private boolean[][]data;
    public booleanArray(boolean[][]data){
	setData(data);
    }
    public booleanArray(){
	data=new boolean[1618][1000];
	for(int i = 0; i<1618000;i++){
	    data[i/1000][i%1000]=false;
	}
    }
    public boolean getValue(int r, int c){
	return data[r][c];
    }
    public boolean[][] getData(){
	return data;
    }
    public void setData(boolean[][]data){
	if(!((data.length==1618)&&(data[0].length==1000))){
	    throw new IllegalArgumentException();
	}
	this.data=data;
    }
    public boolean compareTo(booleanArray other, double percent){
	double failuresLeft = percent * 16180;
	for(int r = 0;r < data.length;r++){
	    for(int c = 0; c < data[0].length;c++){
		if(getValue(r,c)!=other.getValue(r,c)){
		    failuresLeft--;
		}
	    }
	}
	return failuresLeft>=0;
    }
    public double percentError(booleanArray other){
	double max = 100;
	double min = 0;
	while(max-min>.000001){
            if(compareTo(other, (max+min)/2)){
		max=(max+min)/2;
            }
            else{
		min=(max+min)/2;
            }
        }
	return (max+min)/2;
    }
}
