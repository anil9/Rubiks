
import java.util.Arrays;
import java.util.Random;


public class Cube {
	public final String WHITE = "white";
	public final String RED = "red";
	public final String YELLOW = "yellow";
	public final String ORANGE = "orange";
	public final String BLUE = "blue";
	public final String GREEN = "green";

	public Side front;
	public Side top;
	public Side bot;
	public Side left;
	public Side right;
	public Side back;

	public Cube() {
		fillSides();
		//System.out.println(front);
//		System.out.println("Hel");
		//printWholeCube();

	}

	public void printWholeCube() {
		System.out.println("This is the whole cube:");
		System.out.println("======================");
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
		System.out.println("======================");
		System.out.println("End of whole cube.");
	}


	/*
	 * Assign colors to every position on every side.
	*/
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

	public Side getSide(int side){
		switch(side){
			case 1:
			return front;
			case 2:
			return top;
			case 3:
			return bot;
			case 4:
			return left;
			case 5: 
			return right;
			case 6:
			return back;
			default:
			return null;
		}

	}

	/*
	 * Scramble the cube by executing @param operations number of operations on the cube.
	 * @param operations The number of operations used to scramble the cube.
	*/
	public void scramble(int operations) {
		int numberOfOperations = 20;
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
			case 12:
				M();
				break;
			case 13:
				Mi();
				break;
			case 14:
				E();
				break;
			case 15:
				Ei();
				break;
			case 16:
				rightToFront();
				break;
			case 17:
				leftToFront();
				break;
			case 18:
				topToFront();
				break;
			case 19:
				botToFront();
				break;
			default:
				System.err.println("Error in scramble. Wierd operation number:" + op);
				break;


			}
		}
	}

	//Operations on the cube

	public void topToFront(){

		/*
		Ri_NoCount();
		M_NoCount();
		L_NoCount();
		*/

		Ri();
		M();
		L();
	}

	public void botToFront(){
		/*
		R_NoCount();
		Mi_NoCount();
		Li_NoCount();
		*/
		R();
		Mi();
		Li();
	}

	public void rightToFront(){
		/*
		U_NoCount();
		Ei_NoCount();
		Di_NoCount();
		*/
		U();
		Ei();
		Di();
	}

	public void leftToFront(){
		/*
		Ui_NoCount();
		E_NoCount();
		D_NoCount();
		*/
		Ui();
		E();
		D();
	}

	// rotate the middle layer between left and right, in the direction of a regular L
	public void M(){
		Side tempTop = new Side(top);
		top.c2 = back.c2;
		top.c5 = back.c5;
		top.c8 = back.c8;

		back.c2 = bot.c2;
		back.c5 = bot.c5;
		back.c8 = bot.c8;

		bot.c2 = front.c2;
		bot.c5 = front.c5;
		bot.c8 = front.c8;

		front.c2 = tempTop.c2;
		front.c5 = tempTop.c5;
		front.c8 = tempTop.c8;

	}
	// rotate the middle layer between left and right, in the direction of a regular Li
	public void Mi(){
		Side tempTop = new Side(top);
		top.c2 = front.c2;
		top.c5 = front.c5;
		top.c8 = front.c8;

		front.c2 = bot.c2;
		front.c5 = bot.c5;
		front.c8 = bot.c8;

		bot.c2 = back.c2;
		bot.c5 = back.c5;
		bot.c8 = back.c8;

		back.c2 = tempTop.c2;
		back.c5 = tempTop.c5;
		back.c8 = tempTop.c8;
	}

	// rotate the middle layer between up and down, in the direction of a regular D
	public void E(){
		Side tempFront = new Side(front);
		front.c4 = left.c4;
		front.c5 = left.c5;
		front.c6 = left.c6;

		left.c4 = back.c6;
		left.c5 = back.c5;
		left.c6 = back.c4;

		back.c4 = right.c6;
		back.c5 = right.c5;
		back.c6 = right.c4;

		right.c4 = tempFront.c4;
		right.c5 = tempFront.c5;
		right.c6 = tempFront.c6;
	}
	// rotate the middle layer between up and down, in the direction of a regular Di
	public void Ei(){
		Side tempFront = new Side(front);
		front.c4 = right.c4;
		front.c5 = right.c5;
		front.c6 = right.c6;

		right.c4 = back.c6;
		right.c5 = back.c5;
		right.c6 = back.c4;

		back.c4 = left.c6;
		back.c5 = left.c5;
		back.c6 = left.c4;		

		left.c4 = tempFront.c4;
		left.c5 = tempFront.c5;
		left.c6 = tempFront.c6;
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
		right.c9 = bot.c7;

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
		back.c8 = tempBack.c4;
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

	/*
		Operations which aren't counted follows.
	*/

	private void M_NoCount(){

		Side tempTop = new Side(top);
		top.c2 = back.c2;
		top.c5 = back.c5;
		top.c8 = back.c8;

		back.c2 = bot.c2;
		back.c5 = bot.c5;
		back.c8 = bot.c8;

		bot.c2 = front.c2;
		bot.c5 = front.c5;
		bot.c8 = front.c8;

		front.c2 = tempTop.c2;
		front.c5 = tempTop.c5;
		front.c8 = tempTop.c8;

	}
	private void Mi_NoCount(){

		Side tempTop = new Side(top);
		top.c2 = front.c2;
		top.c5 = front.c5;
		top.c8 = front.c8;

		front.c2 = bot.c2;
		front.c5 = bot.c5;
		front.c8 = bot.c8;

		bot.c2 = back.c2;
		bot.c5 = back.c5;
		bot.c8 = back.c8;

		back.c2 = tempTop.c2;
		back.c5 = tempTop.c5;
		back.c8 = tempTop.c8;
	}
	private void E_NoCount(){

		Side tempFront = new Side(front);
		front.c4 = left.c4;
		front.c5 = left.c5;
		front.c6 = left.c6;

		left.c4 = back.c4;
		left.c5 = back.c5;
		left.c6 = back.c6;

		back.c4 = right.c4;
		back.c5 = right.c5;
		back.c6 = right.c6;

		right.c4 = tempFront.c4;
		right.c5 = tempFront.c5;
		right.c6 = tempFront.c6;
	}
	private void Ei_NoCount(){
		Side tempFront = new Side(front);
		front.c4 = right.c4;
		front.c5 = right.c5;
		front.c6 = right.c6;

		right.c4 = back.c4;
		right.c5 = back.c5;
		right.c6 = back.c6;

		back.c4 = left.c4;
		back.c5 = left.c5;
		back.c6 = left.c6;		

		left.c4 = tempFront.c4;
		left.c5 = tempFront.c5;
		left.c6 = tempFront.c6;

	}

	private void L_NoCount(){
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
	private void Li_NoCount(){

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
	private void R_NoCount(){

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
	private void Ri_NoCount(){
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
	private void U_NoCount(){
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
	private void Ui_NoCount(){
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
	private void D_NoCount(){

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
	private void Di_NoCount(){

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


	/*public static void main(String [] args) {
		Cube cube = new Cube();

	}
	*/
}

