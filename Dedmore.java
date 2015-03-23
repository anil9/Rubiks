import java.util.HashMap;

public class Dedmore implements Algorithm {

	Cube cube;
	Side top;
	Side bot;
	Side front;
	Side left;
	Side right;
	Side back;
	String primeCornerColor1;
	String primeCornerColor2;

	HashMap<String, String> oppositeColor = new HashMap();

	public Dedmore() {
		oppositeColor.put("red", "orange");
		oppositeColor.put("orange", "red");
		oppositeColor.put("green", "blue");
		oppositeColor.put("blue", "green");
		oppositeColor.put("yellow", "white");
		oppositeColor.put("white", "yellow");

	}


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
		cube.rightToFront();		// corner cubie is now the in the top left of the front
		int iterations = 0;

		while (!topCornersDone()) {

			if (top.c9.equals(cube.BLUE) && front.c3.equals(front.c1)) {
				// this corner is done.
				cube.rightToFront();
				continue;
			}

			// find the correct cubie:

			// check top layer
			if (front.c3.equals(cube.BLUE) || right.c1.equals(cube.BLUE) || top.c9.equals(cube.BLUE)) {
				// the cubie is the correct corner piece
				if (top.c7.equals(cube.BLUE)) {
					if (front.c3.equals(front.c1) || right.c1.equals(front.c1) || top.c9.equals(front.c1)) {
						if (front.c3.equals(cube.BLUE)) {
							algo1_4();
							cube.rightToFront();
							continue;
						} else if (right.c1.equals(cube.BLUE)) {
							algo1_5();
							cube.rightToFront();
							continue;
						} else if (top.c9.equals(cube.BLUE)) {
							cube.rightToFront();
							continue;
						}

					}
				} 
				// hela if-satsen är tillagd random.
				//http://www.helm.lu/cube/solutions/rubikscube/top/toplayer.html
				else if (top.c1.equals(cube.BLUE)) {
					if ((back.c7.equals(primeCornerColor1) && left.c1.equals(primeCornerColor2)) || (back.c7.equals(primeCornerColor2) && left.c1.equals(primeCornerColor1))) {
						String color = oppositeColor.get(back.c7);
						System.out.println("in the color if-statement");
						if (front.c3.equals(color) || right.c1.equals(color) || top.c9.equals(color)) {
							if (front.c3.equals(cube.BLUE)) {
								algo1_4();
								cube.rightToFront();
								continue;
							} else if (right.c1.equals(cube.BLUE)) {
								algo1_5();
								cube.rightToFront();
								continue;
							} else if (top.c9.equals(cube.BLUE)) {
								cube.rightToFront();
								continue;
							}

						}


					}
				}

			}

			// use D() to check bot layer

			for (int i = 0; i < 4; i++) {

				// the cubie has blue in it.
				if (right.c7.equals(cube.BLUE) || front.c9.equals(cube.BLUE) || bot.c3.equals(cube.BLUE)) {
					// the cubie is the correct corner piece
					if (right.c7.equals(front.c1) || front.c9.equals(front.c1) || bot.c3.equals(front.c1)) {
						if (right.c7.equals(cube.BLUE)) {
							algo1_1();
							break;
						} else if (front.c9.equals(cube.BLUE)) {
							algo1_2();
							break;
						} else if (bot.c3.equals(cube.BLUE)) {
							algo1_3();
							break;
						}
					}
				}
				cube.D();
			}
			//  desired cubie is trapped in the middle layer, simply skip
			// to another corner and once you solve it the target cubie
			// will have been forced back into the top or bottom row.

			// next
			cube.rightToFront();
			iterations++;

			if (iterations > 100 && iterations < 110) {
				cube.printWholeCube();
			}


		}

	}





	private boolean topCornersDone() {
		//cube.printWholeCube();
		return top.c1.equals(cube.BLUE) && top.c3.equals(cube.BLUE) && top.c7.equals(cube.BLUE) && top.c9.equals(cube.BLUE);
	}



// pick the blue-red-white corner cubie and turn it so that it is the upper-right-hand corner cubie on the front of your cube.
	private void putFirstCornerCubieToFront_topRightPosition() {

		int i = 0;
		while (i < 3) {
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
			primeCornerColor1 = front.c3;
			primeCornerColor2 = right.c1;
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
// Algorithms for step 1.

	private void algo1_1() {
		cube.Ri();
		cube.Di();
		cube.R();
	}

	private void algo1_2() {
		cube.Di();
		cube.Ri();
		cube.D();
		cube.R();
	}

	private void algo1_3() {
		cube.Ri();
		cube.D();
		cube.R();
		cube.D();
		cube.D();
		cube.Ri();
		cube.Di();
		cube.R();
	}

	private void algo1_4() {
		cube.F();
		cube.D();
		cube.Fi();
		cube.D();
		cube.D();
		cube.Ri();
		cube.D();
		cube.R();
	}

	private void algo1_5() {
		cube.Ri();
		cube.Di();
		cube.R();
		cube.D();
		cube.Ri();
		cube.Di();
		cube.R();
	}


}