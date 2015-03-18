

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

	private Side front;
	private Side top;
	private Side bot;
	private Side left;
	private Side right;
	private Side back;

	public Cube() {
		// 8 corners, 12(?) edges, 6 centers
		//initCubies();
		createFinishedCube();
		//printWholeCube();
		
		Fi();
		System.out.println(top);
		Fi();
		System.out.println(top);
		Fi();
		System.out.println(top);
		Fi();
		System.out.println(top);

		printWholeCube();
	}

	private void printWholeCube(){
		System.out.println("This is the whole cube:");
		System.out.println("Front:");
		System.out.println(front);
		System.out.println("Top:");
		System.out.println(top);
		System.out.println("Bot:");
		System.out.println(bot);
		System.out.println("Left:");
		System.out.println(left);
		System.out.println("Right:");
		System.out.println(right);
		System.out.println("Back:");
		System.out.println(back);
		System.out.println("End of whole cube.");
	}
	/*
	private void initCubies(){

		Center center = new Center("white");
		Edge edge = new Edge("white", "red");
		Corner corner = new Corner("white", "red", "blue");
		Layer layer = new Layer(null, null, null, null, null, null, null, null, null);

	}
	*/

	// implementerad som: Vit är top. Röd är Front. Gul bot.
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


		/*
		 * Sides are initiated.
		*/

		// getcolor -1 is a center position. Doesn't matter which int as param.
		// red
		front = new Side(new String[]{layer1.getCubie(7).getColor(2), layer1.getCubie(8).getColor(1), layer1.getCubie(9).getColor(2),
						middle.getCubie(1).getColor(1), middle.getCubie(2).getColor(-1), middle.getCubie(3).getColor(0),
						layer3.getCubie(1).getColor(2), layer3.getCubie(2).getColor(1), layer3.getCubie(3).getColor(2)});

		// white
		top = new Side(new String[]{layer1.getCubie(1).getColor(1), layer1.getCubie(2).getColor(0), layer1.getCubie(3).getColor(0),
						layer1.getCubie(4).getColor(1), layer1.getCubie(5).getColor(-1), layer1.getCubie(6).getColor(0),
						layer1.getCubie(7).getColor(1), layer1.getCubie(8).getColor(0), layer1.getCubie(9).getColor(0)});
		// yellow
		bot = new Side(new String[]{layer3.getCubie(1).getColor(1), layer3.getCubie(2).getColor(0), layer3.getCubie(3).getColor(0),
						layer3.getCubie(4).getColor(1), layer3.getCubie(5).getColor(-1), layer3.getCubie(6).getColor(0),
						layer3.getCubie(7).getColor(1), layer3.getCubie(8).getColor(0), layer3.getCubie(9).getColor(0)});

		// orange
		
		back = new Side(new String[]{layer3.getCubie(7).getColor(2), layer3.getCubie(8).getColor(1), layer3.getCubie(9).getColor(2),
						middle.getCubie(7).getColor(0), middle.getCubie(6).getColor(-1), middle.getCubie(5).getColor(1),
						layer1.getCubie(1).getColor(2), layer1.getCubie(2).getColor(1), layer1.getCubie(3).getColor(2)});
		// blue
		right = new Side(new String[]{layer1.getCubie(9).getColor(1), layer1.getCubie(6).getColor(1), layer1.getCubie(3).getColor(1),
						middle.getCubie(3).getColor(1), middle.getCubie(4).getColor(-1), middle.getCubie(5).getColor(0),
						layer3.getCubie(3).getColor(1), layer3.getCubie(6).getColor(1), layer3.getCubie(9).getColor(1)});
		// green
		left = new Side(new String[]{layer1.getCubie(1).getColor(0), layer1.getCubie(4).getColor(0), layer1.getCubie(7).getColor(0),
						middle.getCubie(7).getColor(1), middle.getCubie(8).getColor(-1), middle.getCubie(1).getColor(0),
						layer3.getCubie(1).getColor(0), layer3.getCubie(4).getColor(0), layer3.getCubie(7).getColor(0)});

	}

	//Operations on the cube
	 
	// Twisting front face 90 degrees clockwise
	public void F(){
		Side tempTop = new Side(top);
		Side tempFront = new Side(front);
		top.c7 = left.c9;
		top.c8 = left.c6;
		top.c9 = left.c3; 

		left.c3 = bot.c1;
		left.c6 = bot.c2;
		left.c9 = bot.c3; 

		bot.c1 = right.c7;
		bot.c2 = right.c4;
		bot.c3 = right.c1; 

		right.c1 = tempTop.c7;
		right.c4 = tempTop.c8;
		right.c7 = tempTop.c9; 

		front.c1 = tempFront.c7;
		front.c2 = tempFront.c4;
		front.c3 = tempFront.c1;
		front.c4 = tempFront.c8;
		front.c6 = tempFront.c2;
		front.c7 = tempFront.c9;
		front.c8 = tempFront.c6; 
		front.c9 = tempFront.c3; 

	}
	// Twisting front face 90 degrees anti-clockwise
	public void Fi(){
		Side tempTop = new Side(top);
		Side tempFront = new Side(front);
		top.c7 = right.c1;
		top.c8 = right.c4;
		top.c9 = right.c7; 

		right.c1 = bot.c3;
		right.c4 = bot.c2;
		right.c7 = bot.c1; 

		bot.c1 = left.c3;
		bot.c2 = left.c6;
		bot.c3 = left.c9; 

		left.c3 = tempTop.c9;
		left.c6 = tempTop.c8;
		left.c9 = tempTop.c7; 

		front.c1 = tempFront.c3;
		front.c2 = tempFront.c6;
		front.c3 = tempFront.c9;
		front.c4 = tempFront.c2;
		front.c6 = tempFront.c8;
		front.c7 = tempFront.c1;
		front.c8 = tempFront.c4; 
		front.c9 = tempFront.c7; 
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
		/*
		Layer tempLayer = new Layer(layer1.getCubie(7), layer1.getCubie(4), layer1.getCubie(1),
		 layer1.getCubie(8), layer1.getCubie(5), layer1.getCubie(2),
		  layer1.getCubie(9), layer1.getCubie(6), layer1.getCubie(3));
		layer1 = tempLayer;

		// wierd hårdkodning tillsvidare.
		layer1.getCubie(7).showingColor(layer1.getCubie(7).getShowingColor()-1);
		layer1.getCubie(8).showingColor(1);
		layer1.getCubie(9).showingColor(1);

		*/

		Side temp = new Side(front);
		Side temp_top = new Side(top);
		front.c1 = right.c1;
		front.c2 = right.c2;
		front.c3 = right.c3;

		right.c1 = back.c9;
		right.c2 = back.c8;
		right.c3 = back.c7;

		back.c9 = left.c1;
		back.c8 = left.c2;
		back.c7 = left.c3;

		left.c1 = temp.c1;
		left.c2 = temp.c2;
		left.c3 = temp.c3;

		top.c1 = temp_top.c7;
		top.c2 = temp_top.c4;
		top.c3 = temp_top.c1;
		top.c4 = temp_top.c8;
		top.c6 = temp_top.c2;
		top.c7 = temp_top.c9;
		top.c8 = temp_top.c6; 
		top.c9 = temp_top.c3; 




	}
	// Twisting upper face 90 degrees anti-clockwise
	public void Ui(){

		Side temp = new Side(front);
		Side temp_top = new Side(top);
		front.c1 = left.c1;
		front.c2 = left.c2;
		front.c3 = left.c3;

		left.c1 = back.c9;
		left.c2 = back.c8;
		left.c3 = back.c7;

		back.c9 = right.c1;
		back.c8 = right.c2;
		back.c7 = right.c3;

		right.c1 = temp.c1;
		right.c2 = temp.c2;
		right.c3 = temp.c3;

		top.c1 = temp_top.c3;
		top.c2 = temp_top.c6;
		top.c3 = temp_top.c9;
		top.c4 = temp_top.c2;
		top.c6 = temp_top.c8;
		top.c7 = temp_top.c1;
		top.c8 = temp_top.c4; 
		top.c9 = temp_top.c7; 

	}
	// Twisting bottom face 90 degrees clockwise
	public void D(){

	}
	// Twisting bottom face 90 degrees anti-clockwise
	public void Di(){

	}

	public String showFront(){

		/*
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
		*/
		return front.toString();


	}

	


	public static void main(String [] args) {
		Cube cube = new Cube();

	}



}

