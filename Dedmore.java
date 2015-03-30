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
		topCorners();
		topEdges();
		middleLayer();
		//cube.printWholeCube();
		lastCorners();
		lastEdges();




	}


	private void lastEdges() {
		while (true) {
			// find the cubie edge that's in place and put it in front:
			if (front.c2.equals(front.c5) || top.c8.equals(front.c5)) {
				// it's in place.
				break;
			} else if (right.c2.equals(right.c5) || top.c6.equals(right.c5)) {
				cube.rightToFront();
				break;
			} else if (left.c2.equals(left.c5) || top.c4.equals(left.c5)) {
				cube.leftToFront();
				break;
			} else if (back.c8.equals(back.c5) || top.c2.equals(back.c5)) {
				cube.rightToFront();
				cube.rightToFront();
				break;
			} else {
				algo5_2();
			}
		}
		// we now have front edge in place.
		while (!lastEdgesCorrect()) {
			algo5_1();
		}
		if (front.c2.equals(front.c5) && right.c2.equals(right.c5) && left.c2.equals(left.c5) && back.c8.equals(back.c5)) {
			// finished!!
			return;
		}
		if (front.c2.equals(top.c5) && right.c2.equals(top.c5) && left.c2.equals(top.c5) && back.c8.equals(top.c5)) {
			// double H pattern
			algoH();
			cube.rightToFront();
			algoH();
			return;
		}
		while (!right.c2.equals(top.c5)) {
			cube.rightToFront();
		}
		if (left.c2.equals(top.c5)) {
			// H pattern
			algoH();
			return;
		}
		if (front.c2.equals(top.c5)) {
			// fish pattern
			algoFish();
			return;
		}
		cube.rightToFront();
		if(front.c2.equals(top.c5) && right.c2.equals(top.c5)){
			// fish pattern
			algoFish();
			return;
		}
	}

	private void lastCorners() {
		// first two corners correct at front
		while (true) {
			if (front.c1.equals(front.c5) || left.c3.equals(front.c5) || top.c7.equals(front.c5)) {
				String desiredColor = front.c5;
				if (front.c3.equals(desiredColor) || top.c9.equals(desiredColor) || right.c1.equals(desiredColor)) {
					// is correctly positioned?
					if (front.c3.equals(right.c5) || top.c9.equals(right.c5) || right.c1.equals(right.c5)) {
						// no need to switch.
						break;
					} else {
						// need to switch
						algo4_1();
						break;
					}

				} else if (top.c3.equals(front.c5) || right.c3.equals(front.c5) || back.c9.equals(front.c5)) {
					//diagonal
					algo4_2();
					continue;	// need to make sure that they are correctly placed.
				} else {
					// not switch position and not diagonal. Try another.
					cube.U();
				}

			} else {
				cube.U();
			}
		}
		// the other two corners.
		cube.rightToFront();
		cube.rightToFront();
		if (front.c1.equals(right.c5) || left.c3.equals(right.c5) || top.c7.equals(right.c5)) {
			// need to switch
			algo4_1();
		}
		// so now we have 4 corners correctly positioned.
		// now we need to show the correct color
		while (!lastCornersCorrect()) {
			// several different patterns following.

			if (front.c1.equals(top.c5)) {
				if (front.c3.equals(top.c5)) {
					if (top.c1.equals(top.c5) && top.c3.equals(top.c5)) {
						algo4_3();
						continue;
					}
				} else if (right.c1.equals(top.c5) && right.c3.equals(top.c5)) {
					algo4_3();
					continue;
				} else if (top.c9.equals(top.c5)) {
					algo4_3();
					continue;
				}
			} if (front.c3.equals(top.c5)) {
				if (top.c7.equals(top.c5)) {
					if (top.c1.equals(top.c5)) {
						algo4_3();
						continue;
					} else if (top.c3.equals(top.c5)) {
						algo4_3();
						continue;
					}
				}
			}
			if (right.c3.equals(top.c5)) {
				if (right.c1.equals(top.c5)) {
					algo4_3();
					continue;
				} else if (top.c9.equals(top.c5)) {
					algo4_3();
					continue;
				}
			}
			// got no match
			cube.rightToFront();

		}



	}

	private void middleLayer() {
		// begin by turning the cube upside-down.
		cube.botToFront();
		cube.botToFront();
		for (int i = 0; i < 4; i++) {

			if (edgeInMiddleLayer()) {
				getMiddleLayerEdge();
			}

			for (int j = 0; j < 4; j++) {
				if (cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)) {
					break;
				}
				if (cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)) {
					break;
				}
				cube.U();
			}
			if (cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)) {
				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();
			} else if (cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)) {
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();
				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
			}

			cube.rightToFront();
		}
		while (!front.c5.equals(front.c8)) {
			cube.E();
		}
	}

	private boolean edgeInMiddleLayer() {
		if (cube.getSide(1).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c8.equals(cube.getSide(1).c5)) {
			if (cube.getSide(1).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c8.equals(cube.getSide(5).c5)) {
				return false;
			}
		}
		if (cube.getSide(5).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c6.equals(cube.getSide(1).c5)) {
			if (cube.getSide(5).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c6.equals(cube.getSide(5).c5)) {
				return false;
			}
		}
		if (cube.getSide(6).c8.equals(cube.getSide(1).c5) || cube.getSide(2).c2.equals(cube.getSide(1).c5)) {
			if (cube.getSide(6).c8.equals(cube.getSide(5).c5) || cube.getSide(2).c2.equals(cube.getSide(5).c5)) {
				return false;
			}
		}
		if (cube.getSide(4).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c4.equals(cube.getSide(1).c5)) {
			if (cube.getSide(4).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c4.equals(cube.getSide(5).c5)) {
				return false;
			}
		}

		return true;
	}

	private void getMiddleLayerEdge() {
		// edges is in correct spot but wrong colorpos.
		if ((cube.getSide(1).c6.equals(cube.getSide(5).c5) && cube.getSide(5).c4.equals(cube.getSide(1).c5)) || (cube.getSide(1).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c4.equals(cube.getSide(5).c5))) {
			cube.U();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();
			cube.Ui();
			cube.F();
			return;
		}
		if ((cube.getSide(5).c6.equals(cube.getSide(5).c5) && cube.getSide(6).c6.equals(cube.getSide(1).c5)) || (cube.getSide(5).c6.equals(cube.getSide(1).c5) && cube.getSide(6).c6.equals(cube.getSide(5).c5))) {
			cube.rightToFront();

			cube.U();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();
			cube.Ui();
			cube.F();

			cube.leftToFront();
			return;
		}
		if ((cube.getSide(4).c4.equals(cube.getSide(5).c5) && cube.getSide(6).c4.equals(cube.getSide(1).c5)) || (cube.getSide(4).c4.equals(cube.getSide(1).c5) && cube.getSide(6).c4.equals(cube.getSide(5).c5))) {
			cube.rightToFront();
			cube.rightToFront();

			cube.U();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();
			cube.Ui();
			cube.F();

			cube.leftToFront();
			cube.leftToFront();

			return;
		}

		if ((cube.getSide(4).c6.equals(cube.getSide(5).c5) && cube.getSide(1).c4.equals(cube.getSide(1).c5)) || (cube.getSide(4).c6.equals(cube.getSide(1).c5) && cube.getSide(1).c4.equals(cube.getSide(5).c5))) {
			cube.leftToFront();

			cube.U();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();
			cube.Ui();
			cube.F();

			cube.rightToFront();

			return;
		}
		return;
	}

	// only allowed to spin 2nd and 3rd layer when searching for cubie
	private void topEdges() {
		while (!topEdgesDone()) {
			cube.rightToFront();
			//System.out.println("outer loop");
			int i = 0;

			while (true) {
				if (i == 3) {
					// tested moving layer 2 and 3 enough times. Try another side.
					i = 0;
					break;
				}
				if (top.c8.equals(cube.BLUE) && front.c2.equals(front.c1)) {
					// this side is done
					break;
				}

				// is front.c8 the correct edge piece?
				if ((front.c8.equals(front.c1) || front.c8.equals(top.c7)) && (bot.c2.equals(front.c1) || bot.c2.equals(top.c7))) {
					if (front.c8.equals(top.c7)) {
						algo2_1();
					} else if (front.c8.equals(front.c1)) {
						algo2_2();
					}
					break;
				}
				// is front.c6 the correct edge piece?
				if ((front.c6.equals(front.c1) || front.c6.equals(top.c7)) && (right.c4.equals(front.c1) || right.c4.equals(top.c7))) {
					if (front.c6.equals(front.c1)) {
						algo2_3();
					} else if (front.c6.equals(top.c7)) {
						algo2_4();
					}
					break;
				}
				// is front.c2 the correct edge piece?
				if (front.c2.equals(top.c7) && top.c8.equals(front.c1)) {
					algo2_5();
					break;
				}
				// the edge is wrongly placed.
				if (front.c2.equals(top.c7) || top.c8.equals(top.c7)) {
					cube.M();
					cube.Di();
					cube.Mi();
				}
				// search for the correct edge piece.
				cube.Ei();
				cube.Di();
				i++;

			}

		}





	}

	private boolean topEdgesDone() {
		if (front.c2.equals(front.c1) && right.c2.equals(right.c1) && left.c2.equals(left.c1) && back.c8.equals(back.c7)) {
			if (top.c2.equals(cube.BLUE) && top.c4.equals(cube.BLUE) && top.c6.equals(cube.BLUE) && top.c8.equals(cube.BLUE)) {
				return true;
			}
		}
		return false;
	}


	// place the correct corners and color on top
	private void topCorners() {
		putFirstCornerCubieToFront_topRightPosition();
		int iterations = 0;
		int primeCubiePosition = 9;
		while (!topCornersDone()) {
			cube.rightToFront();
			if (primeCubiePosition == 3) {
				primeCubiePosition = 9;
			} else if (primeCubiePosition == 9) {
				primeCubiePosition = 7;
			} else if (primeCubiePosition == 7) {
				primeCubiePosition = 1;
			} else if (primeCubiePosition == 1) {
				primeCubiePosition = 3;
			}

			if (thisCornerCorrectlyPlaced(primeCubiePosition)) {
				continue;
			}


			// find the correct cubie:

			// check top layer
			if (front.c3.equals(cube.BLUE) || right.c1.equals(cube.BLUE) || top.c9.equals(cube.BLUE)) {
				if (topCorrectComparedToPrime(primeCubiePosition)) {
					// the cubie is the correct corner piece

					if (front.c3.equals(cube.BLUE)) {
						algo1_4();
						continue;
					} else if (right.c1.equals(cube.BLUE)) {
						algo1_5();
						continue;
					} else if (top.c9.equals(cube.BLUE)) {
						//continue;
					}
				}
			}

			// use D() to check bot layer
			boolean executedAlgo = false;
			for (int i = 0; i < 3; i++) {

				// the cubie has blue in it.
				if (right.c7.equals(cube.BLUE) || front.c9.equals(cube.BLUE) || bot.c3.equals(cube.BLUE)) {
					// the cubie is the correct corner piece
					if (botCorrectComparedToPrime(primeCubiePosition)) {
						if (right.c7.equals(cube.BLUE)) {
							algo1_1();
							executedAlgo = true;
							break;
						} else if (front.c9.equals(cube.BLUE)) {
							algo1_2();
							executedAlgo = true;
							break;
						} else if (bot.c3.equals(cube.BLUE)) {
							algo1_3();
							executedAlgo = true;
							break;
						}
					}
				}
				cube.D();
			}
			if (!executedAlgo) {
				cube.Ri();
				cube.Di();
				cube.R();
			}
			//  desired cubie is trapped in the middle layer, simply skip
			// to another corner and once you solve it the target cubie
			// will have been forced back into the top or bottom row.

			// next
			iterations++;

		}

	}





	private boolean topCornersDone() {
		//cube.printWholeCube();
		if (top.c1.equals(cube.BLUE) && top.c3.equals(cube.BLUE) && top.c7.equals(cube.BLUE) && top.c9.equals(cube.BLUE)) {

			if (back.c7.equals(back.c9) && left.c1.equals(left.c3) && right.c1.equals(right.c3) && front.c1.equals(front.c3)) {
				return true;
			}



		}
		return false;
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
	// Algorithms for step 2.

	private void algo2_1() {
		cube.Di();
		cube.M();
		cube.D();
		cube.Mi();
	}

	private void algo2_2() {
		cube.M();
		cube.Di();
		cube.Di();
		cube.Mi();
	}

	private void algo2_3() {
		cube.E();
		cube.F();
		cube.Ei();
		cube.Fi();
	}

	private void algo2_4() {
		cube.E();
		cube.Fi();
		cube.Ei();
		cube.Ei();
		cube.F();
	}

	private void algo2_5() {
		cube.M();
		cube.Di();
		cube.Di();
		cube.Mi();
		cube.Di();
		cube.M();
		cube.D();
		cube.Mi();
	}

	// algorithms for step 4
	private void algo4_1() {
		cube.Li();
		cube.Ui();
		cube.L();
		cube.F();
		cube.U();
		cube.Fi();
		cube.Li();
		cube.U();
		cube.L();
		cube.U();
		cube.U();
	}

	private void algo4_2() {
		cube.U();
		cube.Li();
		cube.Ui();
		cube.L();
		cube.F();
		cube.U();
		cube.Fi();
		cube.Li();
		cube.U();
		cube.L();
		cube.U();
	}

	private void algo4_3() {
		cube.Li();
		cube.Ui();
		cube.L();
		cube.Ui();
		cube.Li();
		cube.Ui();
		cube.Ui();
		cube.L();
		cube.Ui();
		cube.Ui();
	}

	// algorithms for step 5

	private void algo5_1() {
		cube.Mi();
		cube.Ui();
		cube.M();
		cube.Ui();
		cube.Ui();
		cube.Mi();
		cube.Ui();
		cube.M();
	}

	private void algoFish() {
		cube.Fi();
		cube.Li();
		cube.Ri();
		cube.Ei();
		cube.Ri();
		cube.Ri();
		cube.Ei();
		cube.Ei();
		cube.Ri();
		cube.Ui();
		cube.Ui();
		cube.R();
		cube.E();
		cube.E();
		cube.Ri();
		cube.Ri();
		cube.E();
		cube.R();
		cube.Ui();
		cube.Ui();
		cube.L();
		cube.F();
	}

	private void algoH() {
		cube.Ri();
		cube.Ei();
		cube.Ri();
		cube.Ri();
		cube.Ei();
		cube.Ei();
		cube.Ri();
		cube.Ui();
		cube.Ui();
		cube.R();
		cube.E();
		cube.E();
		cube.Ri();
		cube.Ri();
		cube.E();
		cube.R();
		cube.Ui();
		cube.Ui();
	}

	private void algo5_2() {
		cube.F();
		cube.F();
		cube.U();
		cube.L();
		cube.Ri();
		cube.F();
		cube.F();
		cube.Li();
		cube.R();
		cube.U();
		cube.F();
		cube.F();
	}

	private boolean lastEdgesCorrect() {
		if (front.c2.equals(front.c5) || top.c8.equals(front.c5)) {
			// it's in place.
			if (right.c2.equals(right.c5) || top.c6.equals(right.c5)) {

				if (left.c2.equals(left.c5) || top.c4.equals(left.c5)) {

					if (back.c8.equals(back.c5) || top.c2.equals(back.c5)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean lastCornersCorrect() {
		if (top.c1.equals(top.c5) && top.c3.equals(top.c5) && top.c7.equals(top.c5) && top.c9.equals(top.c5)) {
			if (left.c1.equals(left.c5) && left.c3.equals(left.c5) && right.c1.equals(right.c5) && right.c3.equals(right.c5)) {
				return true;
			}
		}
		return false;
	}

	private boolean thisCornerCorrectlyPlaced(int primeCubiePosition) {
		if (primeCubiePosition == 9) {
			// find prime
			// is prime corner
			return true;

		} else if (primeCubiePosition == 7) {
			// check if c7 is prime corner
			// c7 is prime corner.
			if (front.c3.equals(front.c1) && right.c1.equals(oppositeColor.get(left.c3))) {
				// this corner is done.
				return true;
			}
		} else if (primeCubiePosition == 1) {
			// check if c1 is prime corner
			// c1 is prime corner

			if (front.c3.equals(oppositeColor.get(back.c7)) && right.c1.equals(oppositeColor.get(left.c1))) {
				// this corner is done.
				return true;
			}

		} else if (primeCubiePosition == 3) {

			if (front.c3.equals(oppositeColor.get(back.c9)) && right.c1.equals(right.c3)) {
				// this corner is done
				return true;
			}
		}
		return false;
	}

	private boolean topCorrectComparedToPrime(int primeCubiePosition) {
		if (primeCubiePosition == 7) {
			if (front.c3.equals(front.c1) || right.c1.equals(front.c1) || top.c9.equals(front.c1)) {
				if (front.c3.equals(oppositeColor.get((left.c3))) || right.c1.equals(oppositeColor.get((left.c3))) || top.c9.equals(oppositeColor.get((left.c3)))) {
					if (front.c3.equals(top.c7) || right.c1.equals(top.c7) || top.c9.equals(top.c7)) {
						return true;
					}
				}
			}

		} else if (primeCubiePosition == 1) {

			if (front.c3.equals(oppositeColor.get((back.c7))) || right.c1.equals(oppositeColor.get((back.c7))) || top.c9.equals(oppositeColor.get((back.c7)))) {
				if (front.c3.equals((oppositeColor.get((left.c1)))) || right.c1.equals(oppositeColor.get((left.c1))) || top.c9.equals(oppositeColor.get((left.c1)))) {
					if (front.c3.equals(top.c1) || right.c1.equals(top.c1) || top.c9.equals(top.c1)) {
						return true;
					}
				}
			}

		} else if (primeCubiePosition == 3) {

			if (front.c3.equals(right.c3) || right.c1.equals(right.c3) || top.c9.equals(right.c3)) {
				if (front.c3.equals(oppositeColor.get((back.c9))) || right.c1.equals(oppositeColor.get((back.c9))) || top.c9.equals(oppositeColor.get((back.c9)))) {
					if (front.c3.equals(top.c3) || right.c1.equals(top.c3) || top.c9.equals(top.c3)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean botCorrectComparedToPrime(int primeCubiePosition) {
		if (primeCubiePosition == 7) {
			if (front.c9.equals(front.c1) || right.c7.equals(front.c1) || bot.c3.equals(front.c1)) {
				if (front.c9.equals(oppositeColor.get((left.c3))) || right.c7.equals(oppositeColor.get((left.c3))) || bot.c3.equals(oppositeColor.get((left.c3)))) {
					if (front.c9.equals(top.c7) || right.c7.equals(top.c7) || bot.c3.equals(top.c7)) {
						return true;
					}
				}
			}

		} else if (primeCubiePosition == 1) {

			if (front.c9.equals(oppositeColor.get((back.c7))) || right.c7.equals(oppositeColor.get((back.c7))) || bot.c3.equals(oppositeColor.get((back.c7)))) {
				if (front.c9.equals(oppositeColor.get((left.c1))) || right.c7.equals(oppositeColor.get((left.c1))) || bot.c3.equals(oppositeColor.get((left.c1)))) {
					if (front.c9.equals(top.c1) || right.c7.equals(top.c1) || bot.c3.equals(top.c1)) {
						return true;
					}
				}
			}

		} else if (primeCubiePosition == 3) {

			if (front.c9.equals(right.c3) || right.c7.equals(right.c3) || bot.c3.equals(right.c3)) {
				if (front.c9.equals(oppositeColor.get((back.c9))) || right.c7.equals(oppositeColor.get((back.c9))) || bot.c3.equals(oppositeColor.get((back.c9)))) {
					if (front.c9.equals(top.c3) || right.c7.equals(top.c3) || bot.c3.equals(top.c3)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}