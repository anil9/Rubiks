public class Edge implements Cubie{
	private String[] colors = new String[2];
	private int showingColor = 0;

	public Edge(String color1, String color2, int showingColor){
		colors[0] = color1;
		colors[1] = color2;
		this.showingColor = showingColor;

	}


	public int getShowingColor(){
		return showingColor;
	}
	
	public void showingColor(int i){
		showingColor = i;
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