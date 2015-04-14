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
	int[] algo1_moves;
	int[] algo2_moves;

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

		compare(algo1_moves, algo2_moves);
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
		if(numAlgo ==1){
			algo1_moves = moves;
		} else {
			algo2_moves = moves;
		}
		printResult(numAlgo, moves, time);
		
		try{
			File movesPerOpFile = new File("algo" + numAlgo + "_movesPerOp.txt");
			PrintWriter moves_per_op_pw = new PrintWriter(movesPerOpFile);
			if(numAlgo == 1){
					for(int i = 0; i< ((Lbl)algo).moves_per_operation.size();i++){
						moves_per_op_pw.println("step " + (i+1) + " " + ((Lbl)algo).moves_per_operation.get(i));	
					}
					
			}
			moves_per_op_pw.close();

		}catch(Exception e){
			e.printStackTrace();
		}


	}

	private void printResult(int numAlgo, int[] moves, double[] time) {
		DecimalFormat numberFormat = new DecimalFormat("0.00000");
		try{

			File resultFile = new File("algo"+numAlgo+"_results.txt");
			File timesFile = new File("algo"+numAlgo+"_times_ms.txt");
			File movesFile = new File("algo"+numAlgo+"_moves.txt");
			
			File countOfEachOperationFile = new File("algo"+numAlgo+"_countOfEachOperation.txt");
			PrintWriter result_pw = new PrintWriter(resultFile);
			PrintWriter times_pw = new PrintWriter(timesFile);
			PrintWriter moves_pw = new PrintWriter(movesFile);
			
			PrintWriter opCount_pw = new PrintWriter(countOfEachOperationFile);
			result_pw.println("----------------------");
			int moves_avg = 0;
			double time_avg = 0; 
			for (int i = 0; i < ALGO_RUNS; i++) {
				// result print
				result_pw.println(time[i] + " ms");	// ms
				result_pw.println(moves[i] + " moves");

				// times print
				times_pw.println(time[i]);

				// moves print
				moves_pw.println(moves[i]);

				// append avg
				moves_avg += moves[i];
				time_avg += time[i];
			}
			result_pw.println("--------------");
			result_pw.println("average moves " + moves_avg/moves.length);
			result_pw.println("average time " + numberFormat.format(time_avg/moves.length) + " ms");
			for(Entry<String, Double> entry : num_moves_op.entrySet()){
				// result print
				result_pw.println(entry.getKey() + "	" + entry.getValue()/ALGO_RUNS);

				//operations print
				opCount_pw.println(entry.getKey() + "	" + entry.getValue()/ALGO_RUNS);
			}
			
			result_pw.close();
			times_pw.close();
			moves_pw.close();
			opCount_pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void compare(int[] a1, int[] a2){
		int countA1Wins = 0;
		int countA2Wins = 0;
		int equals = 0;
		for(int i = 0; i < ALGO_RUNS; i++){
			if(a1[i] < a2[i]) {
				countA1Wins++;
			} 
			else if(a1[i] == a2[i]){
				equals++;
			} else {
				countA2Wins++;
			}
		}
		System.out.println("A1 wins: " + countA1Wins + " A2 wins: "+ countA2Wins + " equals:" + equals);
	}


	public static void main(String [] args) {
		Main main = new Main();
	}

}