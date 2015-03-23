import java.util.HashMap;

public class Lbl{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();
	private final int MAX_ROTATIONS_IN_LAP = 3;

	public Lbl(){

	}

	public void runAlg(Cube cube){
		cube.scramble(1000);
		//cube.printWholeCube();
		cube = findWhiteCenter(cube);
		cube = whiteCross(cube);
		System.out.println("center" + cube.getSide(2).c5);
		System.out.println(cube.getSide(2).c2);
		System.out.println(cube.getSide(2).c4);
		System.out.println(cube.getSide(2).c6);
		System.out.println(cube.getSide(2).c8);

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
					cube = moveWhiteEdge(cube);
					cube.rightToFront();
					
					
				}
				
				//cube.printWholeCube();


			}

			//cube.printWholeCube();

			while(!crossDone(cube)){
				System.out.println("crossDone not");
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

		/*for(int i = 0;i<MAX_ROTATIONS_IN_LAP;i++){
				cube.printWholeCube();
				cube.U();
			
		}
		if(!cube.getSide(1).c2.equals(cube.getSide(1).c5) && !cube.getSide(4).c2.equals(cube.getSide(4).c5)){
			cube.F();
			cube.F();
			cube.D();
			cube.L();
			cube.L();
			cube.D();
			cube.F();
			cube.F();
			cube.D();
			cube.L();
			cube.L();
		} else if(!cube.getSide(1).c2.equals(cube.getSide(1).c5) && !cube.getSide(5).c2.equals(cube.getSide(5).c5)){
			cube.F();
			cube.F();
			cube.Di();
			cube.R();
			cube.R();
			cube.Di();
			cube.F();
			cube.F();
			cube.Di();
			cube.L();
			cube.L();
		} else if(!cube.getSide(4).c2.equals(cube.getSide(4).c5) && !cube.getSide(6).c2.equals(cube.getSide(6).c5)){
			cube.B();
			cube.B();
			cube.Di();
			cube.L();
			cube.L();
			cube.Di();
			cube.B();
			cube.B();
			cube.Di();
			cube.L();
			cube.L();
		}else if(!cube.getSide(5).c2.equals(cube.getSide(5).c5) && !cube.getSide(6).c2.equals(cube.getSide(6).c5)){
			cube.B();
			cube.B();
			cube.D();
			cube.R();
			cube.R();
			cube.D();
			cube.B();
			cube.B();
			cube.D();
			cube.R();
			cube.R();
		}*/

		return cube;
	}

	private Cube moveWhiteEdge(Cube cube){
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

			if(cube.getSide(1).c2.equals("white")){
				
				cube.F();
				cube.Ri();
				cube.Di();
				cube.R();
				cube.Fi();
				cube.Fi();
				
			}else if(cube.getSide(1).c8.equals("white")){
				
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
	/*
	*	Step 2
	*/
	private Cube whiteCorners(Cube cube){
		return cube;
	}

	/*
	*	Step 3
	*/
	private Cube secondLayer(Cube cube){
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
	
	private Cube findWhiteCenter(Cube cube){
		if(cube.getSide(1).c5.equals("white")){
			cube.botToFront();
			return cube;
		}else if(cube.getSide(2).c5.equals("white")){
			return cube;
		}else if(cube.getSide(3).c5.equals("white")){
			cube.botToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(4).c5.equals("white")){
			cube.leftToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(5).c5.equals("white")){
			cube.rightToFront();
			cube.botToFront();
			return cube;
		}else if(cube.getSide(6).c5.equals("white")){
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