
import java.util.Arrays;
import java.util.Random;


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
		fillSides();
		//printWholeCube();
		//System.out.println(front);
		printWholeCube();
	}

	private void printWholeCube() {
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

	private void fillSides() {
		String[] red = new String[9];
		String[] white = new String[9];
		String[] yellow = new String[9];
		String[] green = new String[9];
		String[] blue = new String[9];
		String[] orange = new String[9];

		Arrays.fill(red, RED);
		Arrays.fill(white, WHITE);
		Arrays.fill(yellow, YELLOW);
		Arrays.fill(green, GREEN);
		Arrays.fill(blue, BLUE);
		Arrays.fill(orange, ORANGE);

		front = new Side(red);
		top = new Side(white);
		bot = new Side(yellow);
		left = new Side(green);
		right = new Side(blue);
		back = new Side(orange);
	}


	// This method is never used.
	private void createFinishedCube() {


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
		front = new Side(new String[] {layer1.getCubie(7).getColor(2), layer1.getCubie(8).getColor(1), layer1.getCubie(9).getColor(2),
		                               middle.getCubie(1).getColor(1), middle.getCubie(2).getColor(-1), middle.getCubie(3).getColor(0),
		                               layer3.getCubie(1).getColor(2), layer3.getCubie(2).getColor(1), layer3.getCubie(3).getColor(2)
		                              });

		// white
		top = new Side(new String[] {layer1.getCubie(1).getColor(1), layer1.getCubie(2).getColor(0), layer1.getCubie(3).getColor(0),
		                             layer1.getCubie(4).getColor(1), layer1.getCubie(5).getColor(-1), layer1.getCubie(6).getColor(0),
		                             layer1.getCubie(7).getColor(1), layer1.getCubie(8).getColor(0), layer1.getCubie(9).getColor(0)
		                            });
		// yellow
		bot = new Side(new String[] {layer3.getCubie(1).getColor(1), layer3.getCubie(2).getColor(0), layer3.getCubie(3).getColor(0),
		                             layer3.getCubie(4).getColor(1), layer3.getCubie(5).getColor(-1), layer3.getCubie(6).getColor(0),
		                             layer3.getCubie(7).getColor(1), layer3.getCubie(8).getColor(0), layer3.getCubie(9).getColor(0)
		                            });

		// orange

		back = new Side(new String[] {layer3.getCubie(7).getColor(2), layer3.getCubie(8).getColor(1), layer3.getCubie(9).getColor(2),
		                              middle.getCubie(7).getColor(0), middle.getCubie(6).getColor(-1), middle.getCubie(5).getColor(1),
		                              layer1.getCubie(1).getColor(2), layer1.getCubie(2).getColor(1), layer1.getCubie(3).getColor(2)
		                             });
		// blue
		right = new Side(new String[] {layer1.getCubie(9).getColor(1), layer1.getCubie(6).getColor(1), layer1.getCubie(3).getColor(1),
		                               middle.getCubie(3).getColor(1), middle.getCubie(4).getColor(-1), middle.getCubie(5).getColor(0),
		                               layer3.getCubie(3).getColor(1), layer3.getCubie(6).getColor(1), layer3.getCubie(9).getColor(1)
		                              });
		// green
		left = new Side(new String[] {layer1.getCubie(1).getColor(0), layer1.getCubie(4).getColor(0), layer1.getCubie(7).getColor(0),
		                              middle.getCubie(7).getColor(1), middle.getCubie(8).getColor(-1), middle.getCubie(1).getColor(0),
		                              layer3.getCubie(1).getColor(0), layer3.getCubie(4).getColor(0), layer3.getCubie(7).getColor(0)
		                             });

	}

	//Operations on the cube

	/*
	 * Scramble the cube by executing @param operations number of operations on the cube.
	 * @param operations The number of operations used to scramble the cube.
	*/

	public void scramble(int operations) {
		int numberOfOperations = 12;
		Random random = new Random();

		for (int i = 0; i < operations; i++) {
			int op = random.nextInt(numberOfOperations);		// generates 0 <= random int < numberOfOperations

			switch (op) {
			case 0:
				F();
				break;
			case 1:
				Fi();
				break;
			case 2:
				B();
				break;
			case 3:
				Bi();
				break;
			case 4:
				R();
				break;
			case 5:
				Ri();
				break;
			case 6:
				L();
				break;
			case 7:
				Li();
				break;
			case 8:
				U();
				break;
			case 9:
				Ui();
				break;
			case 10:
				D();
				break;
			case 11:
				Di();
				break;
			default:
				System.err.println("Error in scramble. Wierd operation number:" + op);
				break;


			}



		}

	}

	// Twisting front face 90 degrees clockwise
	public void F() {
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
	public void Fi() {
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
	public void B() {
		Side tempTop = new Side(top);
		Side tempBack = new Side(back);

		top.c1 = right.c3;
		top.c2 = right.c6;
		top.c3 = right.c9;

		right.c3 = bot.c9;
		right.c6 = bot.c8;
		right.c7 = bot.c7;

		bot.c9 = left.c7;
		bot.c8 = left.c4;
		bot.c7 = left.c1;

		left.c1 = tempTop.c3;
		left.c4 = tempTop.c2;
		left.c7 = tempTop.c1;

		back.c9 = tempBack.c3;
		back.c8 = tempBack.c6;
		back.c7 = tempBack.c9;
		back.c6 = tempBack.c2;
		back.c4 = tempBack.c8;
		back.c3 = tempBack.c1;
		back.c2 = tempBack.c4;
		back.c1 = tempBack.c7;

	}
	// Twisting back face 90 degrees anti-clockwise
	public void Bi() {
		Side tempTop = new Side(top);
		Side tempBack = new Side(back);

		top.c1 = left.c7;
		top.c2 = left.c4;
		top.c3 = left.c1;

		left.c7 = bot.c9;
		left.c4 = bot.c8;
		left.c1 = bot.c7;

		bot.c9 = right.c3;
		bot.c8 = right.c6;
		bot.c7 = right.c9;

		right.c3 = tempTop.c1;
		right.c6 = tempTop.c2;
		right.c9 = tempTop.c3;

		back.c9 = tempBack.c7;
		back.c8 = tempBack.c5;
		back.c7 = tempBack.c1;
		back.c6 = tempBack.c8;
		back.c4 = tempBack.c2;
		back.c3 = tempBack.c9;
		back.c2 = tempBack.c6;
		back.c1 = tempBack.c3;

	}
	// Twisting right face 90 degrees clockwise
	public void R() {
		Side tempTop = new Side(top);
		Side tempRight = new Side(right);

		top.c3 = front.c3;
		top.c6 = front.c6;
		top.c9 = front.c9;

		front.c3 = bot.c3;
		front.c6 = bot.c6;
		front.c9 = bot.c9;

		bot.c3 = back.c3;
		bot.c6 = back.c6;
		bot.c9 = back.c9;

		back.c3 = tempTop.c3;
		back.c6 = tempTop.c6;
		back.c9 = tempTop.c9;

		right.c1 = tempRight.c7;
		right.c2 = tempRight.c4;
		right.c3 = tempRight.c1;
		right.c4 = tempRight.c8;
		right.c6 = tempRight.c2;
		right.c7 = tempRight.c9;
		right.c8 = tempRight.c6;
		right.c9 = tempRight.c3;



	}
	// Twisting right face 90 degrees anti-clockwise
	public void Ri() {
		Side tempTop = new Side(top);
		Side tempRight = new Side(right);

		top.c3 = back.c3;
		top.c6 = back.c6;
		top.c9 = back.c9;

		back.c3 = bot.c3;
		back.c6 = bot.c6;
		back.c9 = bot.c9;

		bot.c3 = front.c3;
		bot.c6 = front.c6;
		bot.c9 = front.c9;

		front.c3 = tempTop.c3;
		front.c6 = tempTop.c6;
		front.c9 = tempTop.c9;

		right.c1 = tempRight.c3;
		right.c2 = tempRight.c6;
		right.c3 = tempRight.c9;
		right.c4 = tempRight.c2;
		right.c6 = tempRight.c8;
		right.c7 = tempRight.c1;
		right.c8 = tempRight.c4;
		right.c9 = tempRight.c7;

	}
	// Twisting left face 90 degrees clockwise
	public void L() {
		Side tempTop = new Side(top);
		Side tempLeft = new Side(left);

		top.c1 = back.c1;
		top.c4 = back.c4;
		top.c7 = back.c7;

		back.c1 = bot.c1;
		back.c4 = bot.c4;
		back.c7 = bot.c7;

		bot.c1 = front.c1;
		bot.c4 = front.c4;
		bot.c7 = front.c7;

		front.c1 = tempTop.c1;
		front.c4 = tempTop.c4;
		front.c7 = tempTop.c7;

		left.c1 = tempLeft.c7;
		left.c2 = tempLeft.c4;
		left.c3 = tempLeft.c1;
		left.c4 = tempLeft.c8;
		left.c6 = tempLeft.c2;
		left.c7 = tempLeft.c9;
		left.c8 = tempLeft.c6;
		left.c9 = tempLeft.c3;


	}
	// Twisting left face 90 degrees anti-clockwise
	public void Li() {

		Side tempTop = new Side(top);
		Side tempLeft = new Side(left);

		top.c1 = front.c1;
		top.c4 = front.c4;
		top.c7 = front.c7;

		front.c1 = bot.c1;
		front.c4 = bot.c4;
		front.c7 = bot.c7;

		bot.c1 = back.c1;
		bot.c4 = back.c4;
		bot.c7 = back.c7;

		back.c1 = tempTop.c1;
		back.c4 = tempTop.c4;
		back.c7 = tempTop.c7;

		left.c1 = tempLeft.c3;
		left.c2 = tempLeft.c6;
		left.c3 = tempLeft.c9;
		left.c4 = tempLeft.c2;
		left.c6 = tempLeft.c8;
		left.c7 = tempLeft.c1;
		left.c8 = tempLeft.c4;
		left.c9 = tempLeft.c7;


	}
	// Twisting upper face 90 degrees clockwise
	public void U() {

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
	public void Ui() {

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
	public void D() {
		Side tempFront = new Side(front);
		Side tempBot = new Side(bot);

		front.c7 = left.c7;
		front.c8 = left.c8;
		front.c9 = left.c9;

		left.c7 = back.c3;
		left.c8 = back.c2;
		left.c9 = back.c1;

		back.c1 = right.c9;
		back.c2 = right.c8;
		back.c3 = right.c7;

		right.c7 = tempFront.c7;
		right.c8 = tempFront.c8;
		right.c9 = tempFront.c9;

		bot.c1 = tempBot.c7;
		bot.c2 = tempBot.c4;
		bot.c3 = tempBot.c1;
		bot.c4 = tempBot.c8;
		bot.c6 = tempBot.c2;
		bot.c7 = tempBot.c9;
		bot.c8 = tempBot.c6;
		bot.c9 = tempBot.c3;

	}
	// Twisting bottom face 90 degrees anti-clockwise
	public void Di() {
		Side tempFront = new Side(front);
		Side tempBot = new Side(bot);

		front.c7 = right.c7;
		front.c8 = right.c8;
		front.c9 = right.c9;

		right.c7 = back.c3;
		right.c8 = back.c2;
		right.c9 = back.c1;

		back.c1 = left.c9;
		back.c2 = left.c8;
		back.c3 = left.c7;

		left.c7 = tempFront.c7;
		left.c8 = tempFront.c8;
		left.c9 = tempFront.c9;

		bot.c1 = tempBot.c3;
		bot.c2 = tempBot.c6;
		bot.c3 = tempBot.c9;
		bot.c4 = tempBot.c2;
		bot.c6 = tempBot.c8;
		bot.c7 = tempBot.c1;
		bot.c8 = tempBot.c4;
		bot.c9 = tempBot.c7;
	}

	public static void main(String [] args) {
		Cube cube = new Cube();

	}



}

