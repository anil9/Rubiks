import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.io.*;

public class Main {
	public static final int ALGO_RUNS = 10000;	// increase this to a good value
	public static final int CUBE_SCRAMBLE = 50;
	Cube cube;
	Cube solvedCube;
	Dedmore dedmore;
	Lbl lbl;
	ArrayList<Cube> cubes_to_solve = new ArrayList<Cube>();
	HashMap<String, Double> num_moves_op = new HashMap<String, Double>();
	int numAlgo = 0;

	public Main() {
		
		createCubes();

		lbl = new Lbl();
		System.out.println("LBL:");	
		numAlgo++;
		measure(lbl);		
		System.out.println("\ndedmore:");
		num_moves_op = new HashMap<String, Double>();
		dedmore = new Dedmore();
		numAlgo++;
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
		double[] time = new double[ALGO_RUNS];
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
			
			time[i] = stopTime;
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
		// write times to file in some nice format.
		printResult(numAlgo, moves, time);
		



	}

	private void printResult(int numAlgo, int[] moves, double[] time) {
		DecimalFormat numberFormat = new DecimalFormat("0.00000");
		try{

			File resultfile = new File("resultsAlgo"+numAlgo+".txt");
			PrintWriter pw = new PrintWriter(resultfile);
			pw.println("----------------------");
			int moves_avg = 0;
			double time_avg = 0; 
			for (int i = 0; i < ALGO_RUNS; i++) {
				pw.println(time[i] + " ms");	// ms
				pw.println(moves[i] + " moves");
				moves_avg += moves[i];
				time_avg += time[i];
			}
			pw.println("--------------");
			pw.println("average moves " + moves_avg/moves.length);
			pw.println("average time " + numberFormat.format(time_avg/moves.length) + " ms");
			for(Entry<String, Double> entry : num_moves_op.entrySet()){
				pw.println(entry.getKey() + "	" + entry.getValue()/ALGO_RUNS);
			}
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void main(String [] args) {
		Main main = new Main();
	}

}