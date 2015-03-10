public class Corner{

private String[] colors; 

public Corner(String front, String top, String side){
	colors = new String[3];
	colors[0] = front;
	colors[1] = top;
	colors[2] = side; 
}

public String[] getColors(){
	return colors;
}
/*
public static void main(String[] args){
	Corner c = new Corner("blue", "black", "green");
}
*/	
}

