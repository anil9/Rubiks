public class Edge {
	private String[] colors = new String[2];

	public Edge(String color1, String color2){
		colors[0] = color1;
		colors[1] = color2;

	}

	public String[] getColors(){
		return colors;
	}


}