public class Corner implements Cubie{


private String[] colors;
private int showingColor = 0; 

public Corner(String color1, String color2, String color3, int showingColor){
	colors = new String[3];
	colors[0] = color1;
	colors[1] = color2;
	colors[2] = color3; 
	this.showingColor = showingColor;
}

public void showingColor(int i){
		showingColor = i;
	}

	public int getShowingColor(){
		return showingColor;
	}

public String[] getColors(){
	return colors;
}

public String getColor(int i){
	return colors[i];
}

public String toString(){
	return getColor(showingColor);
}

}


