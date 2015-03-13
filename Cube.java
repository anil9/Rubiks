

public class Cube {
	private final String WHITE = "white";
	private final String RED = "red";
	private final String YELLOW = "yellow";
	private final String ORANGE = "orange";
	private final String BLUE = "blue";
	private final String GREEN = "green";

	private Layer layer1;
	private Layer middle;
	private Layer layer3;

	public Cube() {
		// 8 corners, 12(?) edges, 6 centers
		//initCubies();
		createFinishedCube();
		System.out.println(showFace());
		U();
		System.out.println(showFace());
		/*
		U();
		System.out.println(showFace());
		*/
	}
	/*
	private void initCubies(){

		Center center = new Center("white");
		Edge edge = new Edge("white", "red");
		Corner corner = new Corner("white", "red", "blue");
		Layer layer = new Layer(null, null, null, null, null, null, null, null, null);

	}
	*/

	// implementerad som: Vit är top. Röd är face. Gul bot.
	// Ordningen för färgernas positioner är: vänstraste -> höger -> upp/ned
	// för layer1 räknas cubies (i vit face-vy) från top-left.
	// för layer3 räknas cubies (i gul face-vy) från top-left. 

	private void createFinishedCube(){

		layer1 = new Layer(new Corner(GREEN, WHITE, ORANGE, 0), new Edge(WHITE, ORANGE, 0), new Corner(WHITE, BLUE, ORANGE, 0),
		 new Edge(GREEN, WHITE, 0), new Center(WHITE), new Edge(WHITE, BLUE, 0),
		 new Corner(GREEN, WHITE, RED, 2), new Edge(WHITE, RED, 1), new Corner(WHITE, BLUE, RED, 2));

		middle = new Layer(new Edge(GREEN, RED, 1), new Center(RED), new Edge(RED, BLUE, 0),
			new Center(BLUE), new Edge(BLUE, ORANGE, 0), new Center(ORANGE), new Edge(ORANGE, GREEN, 0), new Center(GREEN));

		layer3 = new Layer(new Corner(GREEN, YELLOW, RED, 2), new Edge(YELLOW, RED, 1), new Corner(YELLOW, BLUE, RED, 2),
			new Edge(GREEN, YELLOW, 0), new Center(YELLOW), new Edge(YELLOW, BLUE, 0),
			new Corner(GREEN, YELLOW, ORANGE, 0), new Edge(YELLOW, ORANGE, 0), new Corner(YELLOW, BLUE, ORANGE, 0));



	}

	//Operations on the cube
	 
	// Twisting front face 90 degrees clockwise
	public void F(){

	}
	// Twisting front face 90 degrees anti-clockwise
	public void Fi(){

	}
	// Twisting Back face 90 degrees clockwise
	public void B(){

	}
	// Twisting back face 90 degrees anti-clockwise
	public void Bi(){

	}
	// Twisting right face 90 degrees clockwise
	public void R(){

	}
	// Twisting right face 90 degrees anti-clockwise
	public void Ri(){

	}
	// Twisting left face 90 degrees clockwise
	public void L(){

	}
	// Twisting left face 90 degrees anti-clockwise
	public void Li(){

	}
	// Twisting upper face 90 degrees clockwise
	public void U(){

		Layer tempLayer = new Layer(layer1.getCubie(7), layer1.getCubie(4), layer1.getCubie(1),
		 layer1.getCubie(8), layer1.getCubie(5), layer1.getCubie(2),
		  layer1.getCubie(9), layer1.getCubie(6), layer1.getCubie(3));
		layer1 = tempLayer;

		// wierd hårdkodning tillsvidare.
		layer1.getCubie(7).showingColor(layer1.getCubie(7).getShowingColor()-1);
		layer1.getCubie(8).showingColor(1);
		layer1.getCubie(9).showingColor(1);




	}
	// Twisting upper face 90 degrees anti-clockwise
	public void Ui(){

	}
	// Twisting bottom face 90 degrees clockwise
	public void D(){

	}
	// Twisting bottom face 90 degrees anti-clockwise
	public void Di(){

	}

	public String showFace(){

		String face = "";

		face += layer1.getCubie(7).toString() + " ";
		face += layer1.getCubie(8).toString() + " ";
		face += layer1.getCubie(9).toString() + "\n";
		face += middle.getCubie(1).toString() + " ";
		face += middle.getCubie(2).toString() + " ";
		face += middle.getCubie(3).toString() + "\n";
		face += layer3.getCubie(1).toString() + " ";
		face += layer3.getCubie(2).toString() + " ";
		face += layer3.getCubie(3).toString();

		return face;


	}

	


	public static void main(String [] args) {
		Cube cube = new Cube();

	}



}

