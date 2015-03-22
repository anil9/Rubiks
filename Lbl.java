import java.util.HashMap;

public class Lbl{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();

	public Petrus(){

	}

	public void runAlg(Cube cube){
		cube.scramble(1000);
		cube.printWholeCube();
		buildTwoBlock(cube);

	}

	/*
	*	Step 1
	*/
	private Cube buildTwoBlock(Cube cube){
		int[] startcornerIndex = findStartCorner(cube);
		System.out.println(startcornerIndex[0] + " " + startcornerIndex[1]);
		return cube;
	}

	/*
	*	Searching for blue-yellow-orange corner and returning index for it. 
	*/
	private int[] findStartCorner(Cube cube){
		for(int i = 1; i<=6;i++){
			Side side = cube.getSide(i);
			for(int j = 1; j<=4;j++){	
				if(side.getC(j).equals("blue")||side.getC(j).equals("yellow")||side.getC(j).equals("orange")){
					int[] ret = new int[2];
					// side,cubie pair
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
		return null;

	}

	private int[] findEdge(Cube cube, String col1, String col2){
		
	}


	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}