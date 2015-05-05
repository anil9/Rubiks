import java.util.HashMap;
import java.util.ArrayList;

public class Lbl implements Algorithm{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();
	private final int MAX_ROTATIONS_IN_LAP = 3;
	private HashMap<String, Boolean> rotated = new HashMap<String, Boolean>();
	HashMap<Integer, Integer> moves_per_operation = new HashMap<Integer, Integer>();

	
	public Lbl(){

	}

	public void runAlg(Cube cube){
		int i = 0; 
		int recent_count = 0; 
		int count_to_add = 0;
			cube = findYellowCenter(cube);
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+cube.move_counter);
			}else{
				moves_per_operation.put(i, cube.move_counter);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			cube = whiteCross(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			cube = whiteCorners(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			cube = secondLayer(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			cube = yellowCross(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			cube = yellowEdges(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;
			if(cube.solved()){
				return;
			}
			//cube.printWholeCube();
			cube = orientLastLayer(cube);
			count_to_add = cube.move_counter - recent_count;
			if(moves_per_operation.containsKey(i)){
				moves_per_operation.put(i, moves_per_operation.get(i)+count_to_add);
			}else{
				moves_per_operation.put(i, count_to_add);
			}
			recent_count = cube.move_counter;
			i++;

	}

	/*
	*	Step 1
	* 
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
					cube.Ei();
					cube.Di();
				}
					
					cube.F();
					cube.F();
					rotated.put(cube.getSide(1).c5, true);
					cube.rightToFront();
				
			}

		}

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

			}else if(cube.getSide(5).c4.equals("white")){
				cube.Fi();

			}else if(cube.getSide(3).c2.equals("white")){
				cube.F();
				cube.F();

			}else if(cube.getSide(3).c8.equals("white")){
				cube.D();
				cube.D();
				cube.F();
				cube.F();

			}else if(cube.getSide(3).c4.equals("white")){
				cube.D();
				cube.F();
				cube.F();

			}else if(cube.getSide(3).c6.equals("white")){
				cube.Di();
				cube.F();
				cube.F();

			}else if(cube.getSide(6).c4.equals("white")){
				cube.E();
				cube.F();

			}else if(cube.getSide(6).c6.equals("white")){
				cube.Ei();
				cube.Fi();

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


			if(cube.getSide(1).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c4.equals(cube.getSide(5).c5)){
				cube.rightToFront();
				//System.out.println("redan klar");
				continue;
			}

			if(edgeInMiddleLayer(cube)){
				//System.out.println("middle");
			 cube = getMiddleLayerEdge(cube);
			}

			// the edge is in the top layer
			for(int j=0;j<4;j++){
				if(cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)){
				//	System.out.println("prepp för första");
					break;
				}
				if(cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)){
				//	System.out.println("prepp för andra");
					break;
				}
				cube.U();
			}
			if(cube.getSide(2).c8.equals(cube.getSide(5).c5) && cube.getSide(1).c2.equals(cube.getSide(1).c5)){
				//System.out.println("första");

				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();
			}else if(cube.getSide(2).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c2.equals(cube.getSide(5).c5)){
				//System.out.println("andra");

				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();
				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
			}

			if(!(cube.getSide(1).c6.equals(cube.getSide(1).c5) && cube.getSide(5).c4.equals(cube.getSide(5).c5))){
				System.out.println("break");
				break;
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
				//System.out.println("första get");
				cube.U();
				cube.R();
				cube.U();
				cube.Ri();
				cube.Ui();
				cube.Fi();
				cube.Ui();
				cube.F();

				//return cube; 
			}
			if((cube.getSide(5).c6.equals(cube.getSide(5).c5) && cube.getSide(6).c6.equals(cube.getSide(1).c5))||(cube.getSide(5).c6.equals(cube.getSide(1).c5) && cube.getSide(6).c6.equals(cube.getSide(5).c5))){
				//System.out.println("andra get");
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

				//return cube; 
			}
			if((cube.getSide(4).c4.equals(cube.getSide(5).c5) && cube.getSide(6).c4.equals(cube.getSide(1).c5))||(cube.getSide(4).c4.equals(cube.getSide(1).c5) && cube.getSide(6).c4.equals(cube.getSide(5).c5))){
				//System.out.println("tredje get");
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

				//return cube; 
			}

			if((cube.getSide(4).c6.equals(cube.getSide(5).c5) && cube.getSide(1).c4.equals(cube.getSide(1).c5))||(cube.getSide(4).c6.equals(cube.getSide(1).c5) && cube.getSide(1).c4.equals(cube.getSide(5).c5))){
				//System.out.println("fjärde get");
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

				//return cube; 
			}
			return cube;
	}

	/*
	*	Step 4
	*/
	private Cube yellowCross(Cube cube){
	

		if(cube.getSide(2).c2.equals("yellow") && cube.getSide(2).c4.equals("yellow") && cube.getSide(2).c6.equals("yellow") && cube.getSide(2).c8.equals("yellow")){
			return cube;
		}
		// Wrong L
		if(cube.getSide(2).c2.equals("yellow") && cube.getSide(2).c6.equals("yellow")){
			cube.leftToFront();

			cube.F();
			cube.U();
			cube.R();
			cube.Ui();
			cube.Ri();
			cube.Fi();


			return cube;
		}
		if(cube.getSide(2).c8.equals("yellow") && cube.getSide(2).c6.equals("yellow")){
			cube.leftToFront();
			cube.leftToFront();

			cube.F();
			cube.U();
			cube.R();
			cube.Ui();
			cube.Ri();
			cube.Fi();


			return cube;
		}
		if(cube.getSide(2).c8.equals("yellow") && cube.getSide(2).c4.equals("yellow")){
			cube.rightToFront();
			cube.F();
			cube.U();
			cube.R();
			cube.Ui();
			cube.Ri();
			cube.Fi();


			return cube;
		}
		if(cube.getSide(2).c2.equals("yellow") && cube.getSide(2).c4.equals("yellow")){
			
			cube.F();
			cube.U();
			cube.R();
			cube.Ui();
			cube.Ri();
			cube.Fi();


			return cube;
		}

		if(cube.getSide(2).c6.equals("yellow") && cube.getSide(2).c4.equals("yellow")){
			cube.F();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();


			return cube;
		}	
		if(cube.getSide(2).c2.equals("yellow") && cube.getSide(2).c8.equals("yellow")){	
			cube.rightToFront();
			
			cube.F();
			cube.R();
			cube.U();
			cube.Ri();
			cube.Ui();
			cube.Fi();

			return cube;

		}			


			cube.F();
			cube.U();
			cube.R();
			cube.Ui();
			cube.Ri();
			cube.Fi();

		return	yellowCross(cube);

		
		
	}

	/*
	*	Step 5
	*/
	private Cube yellowEdges(Cube cube){
			
		cube = twoCornersCorrect(cube);
		cube = noCornersCorrect(cube);

		for(int i = 0; i<4; i++){

			if(cube.getSide(2).c7.equals("yellow") && cube.getSide(6).c7.equals("yellow") && cube.getSide(5).c3.equals("yellow") && cube.getSide(1).c3.equals("yellow")){
				//System.out.println("case 1 choice one");
				cube.R();
				cube.U();
				cube.Ri();
				cube.U();
				cube.R();
				cube.U();
				cube.U();
				cube.Ri();

				return cube;
			}
			if(cube.getSide(2).c9.equals("yellow") && cube.getSide(6).c9.equals("yellow") && cube.getSide(4).c1.equals("yellow") && cube.getSide(1).c1.equals("yellow")){
				//System.out.println("case 1 choice two");
				cube.Li();
				cube.Ui();
				cube.L();
				cube.Ui();
				cube.Li();
				cube.U();
				cube.U();
				cube.L();

				return cube;
			}
			cube.rightToFront();

		}

		return cube;
	}

	private Cube twoCornersCorrect(Cube cube){
		if(caseTwo(cube)){
			//System.out.println("two corners");
			for(int i = 0; i<4; i++){
				if(cube.getSide(1).c1.equals("yellow")){
					cube.R();
					cube.U();
					cube.Ri();
					cube.U();
					cube.R();
					cube.U();
					cube.U();
					cube.Ri();

					return cube;
				}
				cube.rightToFront();
			}
		}
		return cube;
		
	}

	private boolean caseTwo(Cube cube){
		if(cube.getSide(2).c1.equals("yellow") && cube.getSide(2).c3.equals("yellow")){
			return true;
		}
		if(cube.getSide(2).c1.equals("yellow") && cube.getSide(2).c7.equals("yellow")){
			return true;	
		}
		if(cube.getSide(2).c1.equals("yellow") && cube.getSide(2).c9.equals("yellow")){
			return true;
		}
		if(cube.getSide(2).c3.equals("yellow") && cube.getSide(2).c7.equals("yellow")){
			return true;
		}
		if(cube.getSide(2).c3.equals("yellow") && cube.getSide(2).c9.equals("yellow")){
			return true;
		}
		if(cube.getSide(2).c7.equals("yellow") && cube.getSide(2).c9.equals("yellow")){
			return true;
		}
		return false; 
	} 

	private Cube noCornersCorrect(Cube cube){
		if(!(cube.getSide(2).c1.equals("yellow")||cube.getSide(2).c3.equals("yellow")||cube.getSide(2).c7.equals("yellow")||cube.getSide(2).c9.equals("yellow"))){
			//System.out.println("no corners");
			for(int i= 0;i<4;i++){
				if(cube.getSide(4).c3.equals("yellow")){
					cube.R();
					cube.U();
					cube.Ri();
					cube.U();
					cube.R();
					cube.U();
					cube.U();
					cube.Ri();

					return cube;
				}
				cube.rightToFront();
			}
		}
		return cube;
	
	}

	/*
	*	Step 6
	*/
	private Cube orientLastLayer(Cube cube){
		int i = 0;
		while(!cornersCorrect(cube)){

			if(cube.getSide(1).c3.equals(cube.getSide(6).c5) && cube.getSide(5).c1.equals(cube.getSide(5).c3)){
				cube.leftToFront();
				cube.R();
				cube.Bi();
				cube.R();
				cube.F();
				cube.F();
				cube.Ri();
				cube.B();
				cube.R();
				cube.F();
				cube.F();
				cube.R();
				cube.R();
				cube.U();
				cube.rightToFront();
			}

			if(cube.getSide(1).c1.equals(cube.getSide(5).c5) || cube.getSide(1).c1.equals(cube.getSide(6).c5)){
				if(cube.getSide(4).c3.equals(cube.getSide(5).c5) || cube.getSide(4).c3.equals(cube.getSide(6).c5)){
					cube.rightToFront();
					cube.R();
					cube.Bi();
					cube.R();
					cube.F();
					cube.F();
					cube.Ri();
					cube.B();
					cube.R();
					cube.F();
					cube.F();
					cube.R();
					cube.R();
					cube.U();
					cube.leftToFront();
				}
			}

			if((!cube.getSide(4).c1.equals(cube.getSide(4).c5) && !cube.getSide(5).c3.equals(cube.getSide(5).c5))){
				//System.out.println("orient corners");
				cube.R();
				cube.Bi();
				cube.R();
				cube.F();
				cube.F();
				cube.Ri();
				cube.B();
				cube.R();
				cube.F();
				cube.F();
				cube.R();
				cube.R();
				cube.U();

			}

			cube.rightToFront();
			i++;
			
		}

		//System.out.println(i);

		while(!cubeDone(cube)){
				if(!cube.getSide(1).c2.equals(cube.getSide(1).c5) && !cube.getSide(5).c2.equals(cube.getSide(5).c5) && !cube.getSide(6).c8.equals(cube.getSide(6).c5)){
					cube.rightToFront();
				}
				else if(!cube.getSide(1).c2.equals(cube.getSide(1).c5) && !cube.getSide(4).c2.equals(cube.getSide(4).c5) && !cube.getSide(6).c8.equals(cube.getSide(6).c5)){
					cube.leftToFront();
				}
				else if(!cube.getSide(4).c2.equals(cube.getSide(4).c5) && !cube.getSide(5).c2.equals(cube.getSide(5).c5) && !cube.getSide(6).c8.equals(cube.getSide(6).c5)){
					cube.rightToFront();
					cube.rightToFront();
				}

				if(cube.getSide(1).c2.equals(cube.getSide(4).c5) && cube.getSide(4).c2.equals(cube.getSide(5).c5) && cube.getSide(5).c2.equals(cube.getSide(1).c5)){
					//System.out.println("orient edges clockwise");
					cube.F();
					cube.F();
					cube.U();
					cube.Ri();
					cube.L();
					cube.F();
					cube.F();
					cube.R();
					cube.Li();
					cube.U();
					cube.F();
					cube.F();
					//break;
				}
				else if(cube.getSide(1).c2.equals(cube.getSide(5).c5) && cube.getSide(5).c2.equals(cube.getSide(4).c5) && cube.getSide(4).c2.equals(cube.getSide(1).c5)){
					//System.out.println("orient edges anti-clockwise");
					cube.F();
					cube.F();
					cube.Ui();
					cube.Ri();
					cube.L();
					cube.F();
					cube.F();
					cube.R();
					cube.Li();
					cube.Ui();
					cube.F();
					cube.F();
					//break;
				}
				else{ // all corners wrong
				//System.out.println("random test");
					cube.F();
					cube.F();
					cube.U();
					cube.Ri();
					cube.L();
					cube.F();
					cube.F();
					cube.R();
					cube.Li();
					cube.U();
					cube.F();
					cube.F();
				}
			cube.rightToFront();

		}

		return cube;
	}

	private boolean cornersCorrect(Cube cube){
		if(cube.getSide(1).c1.equals(cube.getSide(1).c5)&&cube.getSide(1).c3.equals(cube.getSide(1).c5)){
			if(cube.getSide(5).c1.equals(cube.getSide(5).c5)&&cube.getSide(5).c3.equals(cube.getSide(5).c5)){
				if(cube.getSide(6).c7.equals(cube.getSide(6).c5)&&cube.getSide(6).c9.equals(cube.getSide(6).c5)){
					if(cube.getSide(4).c1.equals(cube.getSide(4).c5)&&cube.getSide(4).c3.equals(cube.getSide(4).c5)){
						return true;
					}
				}
			}		
		}
		return false;
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

	private boolean cubeDone(Cube cube){
		int count = 0;
		for(int i = 1;i<7;i++){
			if(cube.getSide(i).c1.equals(cube.getSide(i).c5)){
				if(cube.getSide(i).c2.equals(cube.getSide(i).c5)){
					if(cube.getSide(i).c3.equals(cube.getSide(i).c5)){
						if(cube.getSide(i).c4.equals(cube.getSide(i).c5)){
							if(cube.getSide(i).c6.equals(cube.getSide(i).c5)){
								if(cube.getSide(i).c7.equals(cube.getSide(i).c5)){
									if(cube.getSide(i).c8.equals(cube.getSide(i).c5)){
										if(cube.getSide(i).c9.equals(cube.getSide(i).c5)){

											count++;
										}
									}
								}	
							}
						}
					}
				}		
			}
		}
		if(count==6){
			//System.out.println("klar");
			return true;
		}else{return false;}
	}

	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}