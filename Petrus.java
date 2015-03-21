import java.util.HashMap;

public class Petrus{

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
		String[] cornerColours = findStartCorner(cube);
		System.out.println(cornerColours[0] + " " + cornerColours[1] + " " + cornerColours[2]);
		return cube;
	}

	private String[] findStartCorner(Cube cube){
		String colour1 = cube.getSide(1).c1;
		String colour2 = cube.getSide(2).c7;
		String colour3 = cube.getSide(4).c3;
		String[] ret = new String[3];
		ret[0] = colour1;
		ret[1] = colour2;
		ret[2] = colour3;
		return ret;



	}
	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}