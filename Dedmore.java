public class Dedmore implements Algorithm {

	Cube cube;
	Side top;
	Side bot;
	Side front;
	Side left;
	Side right;
	Side back;

	public Dedmore() {}


	public void runAlg(Cube cube) {
		this.cube = cube;
		top = cube.top;
		bot = cube.bot;
		front = cube.front;
		left = cube.left;
		right = cube.right;
		back = cube.back;
		setColorToTop(cube.BLUE);
		step1();


	}

	// place the top row corner
	private void step1() {
		putFirstCornerCubieToFront_topRightPosition();

	}

	// pick the blue-red-white corner cubie and turn it so that it is the upper-right-hand corner cubie on the front of your cube.
	private void putFirstCornerCubieToFront_topRightPosition() {

		int i = 0;
		while (i<3) {
			// first check if a top corner cubie is correctly positioned already
			if (top.c1.equals(cube.BLUE)) {
				cubieToFront_topRightPosition(1);
				return;
			}
			if (top.c3.equals(cube.BLUE)) {
				cubieToFront_topRightPosition(3);
				return;
			}
			if (top.c7.equals(cube.BLUE)) {
				cubieToFront_topRightPosition(7);
				return;
			}
			if (top.c9.equals(cube.BLUE)) {
				cubieToFront_topRightPosition(9);
				return;
			}

			// cubie correctly positioned, but top color is wrong:
			// top 1
			if (left.c1.equals(cube.BLUE)) {
				cube.Bi();
				cubieToFront_topRightPosition(3);

				return;
			} else if (back.c7.equals(cube.BLUE)) {
				cube.L();
				cubieToFront_topRightPosition(7);
				return;
			}

			// top 3
			if (right.c3.equals(cube.BLUE)) {
				cube.B();
				cubieToFront_topRightPosition(1);
				return;

			} else if (back.c9.equals(cube.BLUE)) {
				cube.Ri();
				cubieToFront_topRightPosition(9);
				// correct positioned.
				return;
			}
			// top 7
			if (left.c3.equals(cube.BLUE)) {
				cube.F();
				cubieToFront_topRightPosition(9);
				// correct positioned
				return;
			} else if (front.c1.equals(cube.BLUE)) {
				cube.Li();
				cubieToFront_topRightPosition(1);
				return;
			}
			// top 9
			if (right.c1.equals(cube.BLUE)) {
				cube.Fi();
				cubieToFront_topRightPosition(7);
				return;

			} else if (front.c3.equals(cube.BLUE)) {
				cube.R();
				cubieToFront_topRightPosition(3);
				return;
			}
			// operations and try again.
			cube.R();
			cube.Li();
			i++;
		}
		/*
		// check front 7 & 9
		if(front.c7.equals(cube.BLUE)){
			cube.Li();
			cubieToFront_topRightPosition(7);
		} else if(front.c9.equals(cube.BLUE)){
			cube.R();
			cubieToFront_topRightPosition(9);
		}
		*/



		System.out.println("Couldn't solve the issue");

	}

	private void cubieToFront_topRightPosition(int topPosition) {
		switch (topPosition) {
		case 1:
			cube.leftToFront();
			cube.leftToFront();
			break;
		case 3:
			cube.rightToFront();
			break;
		case 7:
			cube.leftToFront();
		case 9:
			break;
		}
		//System.out.println("Did something " + topPosition);
	}

	// finds the blue center piece and rotates the cube so that that blue center piece gets on top side.
	private void setColorToTop(String color) {
		if (top.c5.equals(color)) {
			// this is what we're looking for. Return.
			return;
		} else if (front.c5.equals(color)) {
			cube.botToFront();
			return;
		} else if (bot.c5.equals(color)) {
			cube.botToFront();
			cube.botToFront();
		} else if (back.c5.equals(color)) {
			cube.topToFront();
		} else if (left.c5.equals(color)) {
			cube.leftToFront();
			cube.botToFront();
		} else if (right.c5.equals(color)) {
			cube.rightToFront();
			cube.botToFront();
		}


	}


}