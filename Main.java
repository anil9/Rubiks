public class Main {
	public static final int ALGO_RUNS = 100;	// increase this to a good value
	public static final int CUBE_SCRAMBLE = 1000;
	Cube cube;
	Cube solvedCube;
	Dedmore dedmore;
	Lbl lbl;


	public Main() {
		cube = new Cube();

		lbl = new Lbl();
		System.out.println("LBL:");		
		measure(lbl);

		System.out.println("\ndedmore:");
		dedmore = new Dedmore();
		//measure(dedmore);
	}



	private void measure(Algorithm algo) {
		double[] result = new double[ALGO_RUNS];

		for (int i = 0; i < ALGO_RUNS; i++) {
			cube.scramble(CUBE_SCRAMBLE);
			long startTime = System.nanoTime();

			algo.runAlg(cube);
			double stopTime = (System.nanoTime() - startTime)/(double)1000000;	// ms
			if(!cube.solved()){
				cube.printWholeCube();
				System.exit(1);
			}
			
			result[i] = stopTime;
			//System.out.println("done");0
		}
		// write results to file in some nice format.
		printResult(result);
		



	}

	private void printResult(double[] results) {
		for (int i = 0; i < ALGO_RUNS; i++) {
			System.out.println(results[i] + " ms");	// ms
		}
	}

	public static void main(String [] args) {
		Main main = new Main();
	}

}