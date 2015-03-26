import java.util.HashMap;

public class Lbl implements Algorithm{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();
	private final int MAX_ROTATIONS_IN_LAP = 3;
	private HashMap<String, Boolean> rotated = new HashMap<String, Boolean>();

	
	public Lbl(){

	}

	public void runAlg(Cube cube){
			cube.scramble(1000);;
			cube = findYellowCenter(cube);
			cube = whiteCross(cube);
			cube = secondLayer(cube);
			/*if(!stepOneDone(cube)){
				System.out.println("inte klar");
				break;

			}*/
			cube = whiteCorners(cube);
		
		
		cube.printWholeCube();

	}

	/*
	*	Step 1
	*/
	private Cube whiteCross(Cube cube){
		if(!crossDone(cube)){

			while(hasWhiteEdgeonVertical(cube)){
				for(int j= 0;j<=MAX_ROTATIONS_IN_LAP;j++){
					if(!hasWhiteEdgeonVertical(cube)){
						break;
					}
					cube = moveWhiteEdgeEasy(cube);
					cube = moveWhiteEdgeSpecial(cube);
					cube.rightToFront();
					
					
				}
			
			}

			while(!crossDone(cube)){
					while(cube.getSide(2).c8.equals("white")){
						//System.out.println("top is white");
						cube.U();
					}
					while(!cube.getSide(3).c2.equals("white")){
						//System.out.println("bot is not white");
						cube.D();
					}
					cube.F();
					cube.F();
				
			}
		}



		//Daisy method
		int count_back = 0;
		for(int i = 0; i<4;i++){
			while(!cube.getSide(2).c8.equals("white")){
				cube.U();
			}

			if(cube.getSide(1).c2.equals(cube.getSide(1).c5)){
				cube.F();
				cube.F();
				rotated.put(cube.getSide(1).c5, true);
				cube.rightToFront();
			}else{
				while(!cube.getSide(1).c2.equals(cube.getSide(1).c5)){
					//System.out.println("U");
					cube.Ei();
					cube.Di();
					//count_back++;
				}
					/*if(rotated.get(cube.getSide(1).c5)!= null && rotated.get(cube.getSide(1).c5)== true){
						System.out.println("redan roterad");
					}
					*/
					cube.F();
					cube.F();
					rotated.put(cube.getSide(1).c5, true);
					cube.rightToFront();
				
			}

		}

		//cube.printWholeCube();
		return cube;
	}
	private Cube moveWhiteEdgeEasy(Cube cube){
		int rotation;
			if(cube.getSide(2).c8.equals("white")){
					rotation = 0;
					while(cube.getSide(2).c8.equals("white") && rotation<= MAX_ROTATIONS_IN_LAP){
						cube.U();
						rotation++;
					}
					if(cube.getSide(2).c8.equals("white")){
						return cube;
					}
				
			}
			if(cube.getSide(4).c6.equals("white")){
				cube.F();
			//	System.out.println("left");
			}else if(cube.getSide(5).c4.equals("white")){
				cube.Fi();
			//	System.out.println("right");
			}else if(cube.getSide(3).c2.equals("white")){
				cube.F();
				cube.F();
			//	System.out.println("bot nära");
			}else if(cube.getSide(3).c8.equals("white")){
				cube.D();
				cube.D();
				cube.F();
				cube.F();
			//	System.out.println("bot bort");	
			}else if(cube.getSide(3).c4.equals("white")){
				cube.D();
				cube.F();
				cube.F();
			//	System.out.println("bot left");
			}else if(cube.getSide(3).c6.equals("white")){
				cube.Di();
				cube.F();
				cube.F();
			//	System.out.println("bot right");
			}else if(cube.getSide(6).c4.equals("white")){
				cube.E();
				cube.F();
			//	System.out.println("back left");
			}else if(cube.getSide(6).c6.equals("white")){
				cube.Ei();
				cube.Fi();
			//	System.out.println("back right");
			} else if(cube.getSide(1).c2.equals("white")){
				
				cube.F();
				cube.Ri();
				cube.Di();
				cube.R();
				cube.Fi();
				cube.Fi();

				
			}

		return cube;

	} 

	private Cube moveWhiteEdgeSpecial(Cube cube){
		int rotation;
			if(cube.getSide(2).c8.equals("white")){
					rotation = 0;
					while(cube.getSide(2).c8.equals("white") && rotation<= MAX_ROTATIONS_IN_LAP){
						cube.U();
						rotation++;
					}
					if(cube.getSide(2).c8.equals("white")){
						return cube;
					}
				
			}
			if(cube.getSide(1).c8.equals("white")){
				
				cube.Fi();
				cube.Ri();
				cube.Di();
				cube.R();
				cube.Fi();
				cube.Fi();
			}else if(cube.getSide(1).c6.equals("white")){
				
				cube.Ri();
				cube.Di();
				cube.R();
				cube.Fi();
				cube.Fi();
			}else if(cube.getSide(1).c4.equals("white")){
				
				cube.L();
				cube.D();
				cube.Li();
				cube.Fi();
				cube.Fi();
			}

			return cube;
	}

	private boolean hasWhiteEdgeonVertical(Cube cube){
		for(int i = 0; i<=MAX_ROTATIONS_IN_LAP;i++){
			if(cube.getSide(1).c2.equals("white")||cube.getSide(1).c4.equals("white")||cube.getSide(1).c6.equals("white")||cube.getSide(1).c8.equals("white")){
				return true;
			}
			cube.rightToFront();
		}
		return false;
	}

	private boolean crossDone(Cube cube){
		if(cube.getSide(2).c2.equals("white") && cube.getSide(2).c4.equals("white") && cube.getSide(2).c6.equals("white") && cube.getSide(2).c8.equals("white")){
			return true;	
		}
		return false;
	}

	private boolean stepOneDone(Cube cube){
		if(cube.getSide(3).c2.equals("white") && cube.getSide(3).c4.equals("white") && cube.getSide(3).c6.equals("white") && cube.getSide(3).c8.equals("white")){
			return true;	
		}
		return false;
	}
	/*
	*	Step 2
	*/
	private Cube whiteCorners(Cube cube){
		for(int i = 0; i<4;i++){
				cube = findWhiteEdge(cube);
				if(!((cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5)))){
					cube = moveWhiteEdge(cube);
				}

				cube.rightToFront();
				//cube.printWholeCube();
		}
		return cube;
	}

	private Cube findWhiteEdge(Cube cube){
		if(hasWhiteEdgeFront(cube)){

			return cube;
		}
		// Right down front corner
		if(cube.getSide(1).c9.equals(cube.getSide(3).c5)||cube.getSide(3).c3.equals(cube.getSide(3).c5)||cube.getSide(5).c7.equals(cube.getSide(3).c5)){
			if(cube.getSide(1).c9.equals(cube.getSide(1).c5)||cube.getSide(3).c3.equals(cube.getSide(1).c5)||cube.getSide(5).c7.equals(cube.getSide(1).c5)){
				if(cube.getSide(1).c9.equals(cube.getSide(5).c5)||cube.getSide(3).c3.equals(cube.getSide(5).c5)||cube.getSide(5).c7.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.R();
						cube.U();
						cube.Ri();
						cube.Ui();
					}
					return cube;
				}
			}

			
		}
		// Left down front corner
		if(cube.getSide(1).c7.equals(cube.getSide(3).c5)||cube.getSide(3).c1.equals(cube.getSide(3).c5)||cube.getSide(4).c9.equals(cube.getSide(3).c5)){
			if(cube.getSide(1).c7.equals(cube.getSide(1).c5)||cube.getSide(3).c1.equals(cube.getSide(1).c5)||cube.getSide(4).c9.equals(cube.getSide(1).c5)){
				if(cube.getSide(1).c7.equals(cube.getSide(5).c5)||cube.getSide(3).c1.equals(cube.getSide(5).c5)||cube.getSide(4).c9.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.Li();
						cube.Ui();
						cube.L();
					}
					return cube;
				}
			}


		}
		// Left up front corner
		if(cube.getSide(4).c3.equals(cube.getSide(3).c5)||cube.getSide(2).c7.equals(cube.getSide(3).c5)||cube.getSide(1).c1.equals(cube.getSide(3).c5)){
			if(cube.getSide(4).c3.equals(cube.getSide(1).c5)||cube.getSide(2).c7.equals(cube.getSide(1).c5)||cube.getSide(1).c1.equals(cube.getSide(1).c5)){
				if(cube.getSide(4).c3.equals(cube.getSide(5).c5)||cube.getSide(2).c7.equals(cube.getSide(5).c5)||cube.getSide(1).c1.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.Ui();
					}
					return cube;
				}
			}


		}
		// Right up back corner
		if(cube.getSide(5).c3.equals(cube.getSide(3).c5)||cube.getSide(2).c3.equals(cube.getSide(3).c5)||cube.getSide(6).c9.equals(cube.getSide(3).c5)){
			if(cube.getSide(5).c3.equals(cube.getSide(1).c5)||cube.getSide(2).c3.equals(cube.getSide(1).c5)||cube.getSide(6).c9.equals(cube.getSide(1).c5)){
				if(cube.getSide(5).c3.equals(cube.getSide(5).c5)||cube.getSide(2).c3.equals(cube.getSide(5).c5)||cube.getSide(6).c9.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.U();
					}
					return cube;
				}
			}

			
		}
		// Left up back corner
		if(cube.getSide(4).c1.equals(cube.getSide(3).c5)||cube.getSide(2).c1.equals(cube.getSide(3).c5)||cube.getSide(6).c7.equals(cube.getSide(3).c5)){
			if(cube.getSide(4).c1.equals(cube.getSide(1).c5)||cube.getSide(2).c1.equals(cube.getSide(1).c5)||cube.getSide(6).c7.equals(cube.getSide(1).c5)){
				if(cube.getSide(4).c1.equals(cube.getSide(5).c5)||cube.getSide(2).c1.equals(cube.getSide(5).c5)||cube.getSide(6).c7.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.Ui();
						cube.Ui();
					}
					return cube;
				}
			}

		}
		//Right down back corner
		if(cube.getSide(5).c9.equals(cube.getSide(3).c5)||cube.getSide(3).c9.equals(cube.getSide(3).c5)||cube.getSide(6).c3.equals(cube.getSide(3).c5)){
			if(cube.getSide(5).c9.equals(cube.getSide(1).c5)||cube.getSide(3).c9.equals(cube.getSide(1).c5)||cube.getSide(6).c3.equals(cube.getSide(1).c5)){
				if(cube.getSide(5).c9.equals(cube.getSide(5).c5)||cube.getSide(3).c9.equals(cube.getSide(5).c5)||cube.getSide(6).c3.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.B();
						cube.U();
						cube.Bi();	
					}
					return cube;
				}
			}			
			
		}
		//Left down back corner
		if(cube.getSide(4).c7.equals(cube.getSide(1).c5)||cube.getSide(3).c7.equals(cube.getSide(1).c5)||cube.getSide(6).c1.equals(cube.getSide(1).c5)){
			if(cube.getSide(4).c7.equals(cube.getSide(3).c5)||cube.getSide(3).c7.equals(cube.getSide(3).c5)||cube.getSide(6).c1.equals(cube.getSide(3).c5)){
				if(cube.getSide(4).c7.equals(cube.getSide(5).c5)||cube.getSide(3).c7.equals(cube.getSide(5).c5)||cube.getSide(6).c1.equals(cube.getSide(5).c5)){
					if(!(cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
						cube.Bi();
						cube.Ui();
						cube.B();
						cube.Ui();
					}
					return cube;
				}
			}
				
			
		}
		System.out.println("Inget fall");
		return cube;
	}

	private boolean hasWhiteEdgeFront(Cube cube){
		if(cube.getSide(1).c3.equals(cube.getSide(3).c5)){
			if(cube.getSide(2).c9.equals(cube.getSide(1).c5) && cube.getSide(5).c1.equals(cube.getSide(5).c5)){
				return true;
			}
		} else if(cube.getSide(1).c3.equals(cube.getSide(1).c5)){
			if(cube.getSide(5).c1.equals(cube.getSide(3).c5) && cube.getSide(2).c9.equals(cube.getSide(5).c5)){
				return true;
			}
		} else if(cube.getSide(2).c9.equals(cube.getSide(3).c5)){
			if(cube.getSide(5).c1.equals(cube.getSide(1).c5) && cube.getSide(1).c3.equals(cube.getSide(5).c5)){
				return true;
			}
		} 
		return false;
	}

	private Cube moveWhiteEdge(Cube cube){
		
			
			if(cube.getSide(1).c3.equals(cube.getSide(3).c5)){
				if(cube.getSide(2).c9.equals(cube.getSide(1).c5)){
					if(cube.getSide(5).c1.equals(cube.getSide(5).c5)){
						if(!(cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
							cube.Fi();
							cube.Ui();
							cube.F();
						}
					}
				}
			}else if(cube.getSide(1).c3.equals(cube.getSide(1).c5)){
				if(cube.getSide(5).c1.equals(cube.getSide(3).c5)){
					if(cube.getSide(2).c9.equals(cube.getSide(5).c5)){
						if(!(cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
							cube.R();
							cube.U();
							cube.Ri();
						}
					}
				}
			}else if(cube.getSide(2).c9.equals(cube.getSide(3).c5)){
				if(cube.getSide(5).c1.equals(cube.getSide(1).c5)){
					if(cube.getSide(1).c3.equals(cube.getSide(5).c5)){
						if(!(cube.getSide(1).c9.equals(cube.getSide(1).c5)&&cube.getSide(3).c3.equals(cube.getSide(3).c5)&&cube.getSide(5).c7.equals(cube.getSide(5).c5))){
							cube.Fi();
							cube.U();
							cube.U();
							cube.F();
							cube.U();

							cube.Fi();
							cube.Ui();
							cube.F();
							
						}
					}
				}
			}
		
			
		return cube;
	}

	/*
	*	Step 3
	*/
	private Cube secondLayer(Cube cube){
		for(int i = 0; i<4;i++){

			if(edgeInMiddleLayer(cube)){
				System.out.println("middle");
			 cube = getMiddleLayerEdge(cube);
			}

			for(int j=0;j<4;j++){
				if(cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)){
					System.out.println("prepp för första");
					break;
				}
				if(cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)){
					System.out.println("prepp för andra");
					break;
				}
				cube.U();
			}
			if(cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)){
				System.out.println("första");

				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();
			}else if(cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)){
				System.out.println("andra");

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
		return cube;
	}

	private boolean edgeInMiddleLayer(Cube cube){
		if(cube.getSide(1).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c8.equals(cube.getSide(1).c5)){
			if(cube.getSide(1).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c8.equals(cube.getSide(5).c5)){
				return false;
			}		
		}
		if(cube.getSide(5).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c6.equals(cube.getSide(1).c5)){
			if(cube.getSide(5).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c6.equals(cube.getSide(5).c5)){
				return false;
			}		
		}
		if(cube.getSide(6).c8.equals(cube.getSide(1).c5) || cube.getSide(2).c2.equals(cube.getSide(1).c5)){
			if(cube.getSide(6).c8.equals(cube.getSide(5).c5) || cube.getSide(2).c2.equals(cube.getSide(5).c5)){
				return false;
			}		
		}
		if(cube.getSide(4).c2.equals(cube.getSide(1).c5) || cube.getSide(2).c4.equals(cube.getSide(1).c5)){
			if(cube.getSide(4).c2.equals(cube.getSide(5).c5) || cube.getSide(2).c4.equals(cube.getSide(5).c5)){
				return false;
			}		
		}

		return true;
	}

	private Cube getMiddleLayerEdge(Cube cube){
		// edges is in correct spot but wrong colorpos. 
			if((cube.getSide(1).c6.equals(cube.getSide(5).c5) && cube.getSide(5).c4.equals(cube.getSide(1).c5))||(cube.getSide(1).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c4.equals(cube.getSide(5).c5))){
				System.out.println("första");
				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();

				return cube; 
			}
			if((cube.getSide(5).c6.equals(cube.getSide(5).c5) && cube.getSide(6).c6.equals(cube.getSide(1).c5))||(cube.getSide(5).c6.equals(cube.getSide(1).c5) && cube.getSide(6).c6.equals(cube.getSide(5).c5))){
				System.out.println("andra");
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

				return cube; 
			}
			if((cube.getSide(4).c4.equals(cube.getSide(5).c5) && cube.getSide(6).c4.equals(cube.getSide(1).c5))||(cube.getSide(4).c4.equals(cube.getSide(1).c5) && cube.getSide(6).c4.equals(cube.getSide(5).c5))){
				System.out.println("tredje");
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

				return cube; 
			}

			if((cube.getSide(4).c6.equals(cube.getSide(5).c5) && cube.getSide(1).c4.equals(cube.getSide(1).c5))||(cube.getSide(4).c6.equals(cube.getSide(1).c5) && cube.getSide(1).c4.equals(cube.getSide(5).c5))){
				System.out.println("fjärde");
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

				return cube; 
			}
			return cube;
	}

	/*
	*	Step 4
	*/
	private Cube yellowCross(Cube cube){
		return cube;
	}

	/*
	*	Step 5
	*/
	private Cube yellowEdges(Cube cube){
		return cube;
	}

	/*
	*	Step 6
	*/
	private Cube orientYellowCorners(Cube cube){
		return cube;
	}
	
	private Cube findYellowCenter(Cube cube){
		if(cube.getSide(1).c5.equals("yellow")){
			cube.botToFront();
			return cube;
		}else if(cube.getSide(2).c5.equals("yellow")){
			return cube;
		}else if(cube.getSide(3).c5.equals("yellow")){
			cube.botToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(4).c5.equals("yellow")){
			cube.leftToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(5).c5.equals("yellow")){
			cube.rightToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(6).c5.equals("yellow")){
			cube.topToFront();
			return cube;
		}
		return null;
	}

	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}