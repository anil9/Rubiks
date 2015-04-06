import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;

public class Main {
	public static final int ALGO_RUNS = 2;	// increase this to a good value
	public static final int CUBE_SCRAMBLE = 10;
	Cube cube;
	Cube solvedCube;
	Dedmore dedmore;
	Lbl lbl;
	ArrayList<Cube> cubes_to_solve = new ArrayList<Cube>();
	HashMap<String, Double> num_moves_op = new HashMap<String, Double>();

	public Main() {
		
		createCubes();

		lbl = new Lbl();
		System.out.println("LBL:");	
		measure(lbl);		
		System.out.println("\ndedmore:");
		num_moves_op = new HashMap<String, Double>();
		dedmore = new Dedmore();
		measure(dedmore);
	}

	private void createCubes(){
		for(int i = 0; i<ALGO_RUNS;i++){
			cube = new Cube();
			cube.scramble(CUBE_SCRAMBLE);
			cube.move_counter = 0;
			cubes_to_solve.add(cube);
		}
	}


	private void measure(Algorithm algo) {
		double[] result = new double[ALGO_RUNS];
		int[] moves = new int[ALGO_RUNS];

		for (int i = 0; i < ALGO_RUNS; i++) {
			cube = new Cube(cubes_to_solve.get(i));
			cube.num_moves_per_op = new HashMap<String, Double>();
			long startTime = System.nanoTime();

			algo.runAlg(cube);
			double stopTime = (System.nanoTime() - startTime)/(double)1000000;	// ms
			if(!cube.solved()){
				cube.printWholeCube();
				System.exit(1);
			}
			
			result[i] = stopTime;
			moves[i] = cube.move_counter;
			for(Entry<String, Double> entry : cube.num_moves_per_op.entrySet()){
				if(!num_moves_op.containsKey(entry.getKey())){
					num_moves_op.put(entry.getKey(), entry.getValue());
				}else{
					double temp = num_moves_op.get(entry.getKey());
					num_moves_op.put(entry.getKey(), temp+entry.getValue());
				}
			}

			//System.out.println("done");
		}
		// write results to file in some nice format.
		printResult(moves, result);
		



	}

	private void printResult(int[] moves, double[] results) {
		int moves_avg = 0; 
		for (int i = 0; i < ALGO_RUNS; i++) {
			//System.out.println(results[i] + " ms");	// ms
			//System.out.println(moves[i] + " moves");
			moves_avg += moves[i];
		}
		System.out.println(moves_avg/moves.length);
		for(Entry<String, Double> entry : num_moves_op.entrySet()){
			System.out.println(entry.getKey() + "	" + entry.getValue()/ALGO_RUNS);
		}
	}


	public static void main(String [] args) {
		Main main = new Main();
	}

}