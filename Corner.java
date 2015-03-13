public class Corner {


private String[] colors; 

public Corner(String color1, String color2, String color3){
	colors = new String[3];
	colors[0] = color1;
	colors[1] = color2;
	colors[2] = color3; 
}

public String[] getColors(){
	return colors;
}

public String getColor(int i){
	return color[i];
}

}


