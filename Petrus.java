import java.util.HashMap;

public class Petrus{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();

	public Petrus(Cube cube){
		runAlg(cube);

	}

	private void runAlg(Cube cube){


	}

	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}