public class Main {
	public static final int ALGO_RUNS = 1000;	// increase this to a good value
	public static final int CUBE_SCRAMBLE = 1000;
	Cube cube;
	Dedmore dedmore;
	//Lbl lbl;


	public Main() {
		cube = new Cube();
		//lbl = new Lbl();

		//lbl.runAlg(cube);

		//measure(fridrich);
		//measure(petrus);
		dedmore = new Dedmore();
		measure(dedmore);
	}



	private void measure(Algorithm algo) {
		double[] result = new double[ALGO_RUNS];

		for (int i = 0; i < ALGO_RUNS; i++) {
			cube.scramble(CUBE_SCRAMBLE);
			long startTime = System.nanoTime();

			algo.runAlg(cube);
			double stopTime = (System.nanoTime() - startTime)/(double)1000000;	// ms
			
			result[i] = stopTime;
			//System.out.println("done");
			//cube.printWholeCube();		// remove later
		}
		// write results to file in some nice format.
		printResult(result);



	}

	private void printResult(double[] results) {
		for (int i = 0; i < ALGO_RUNS; i++) {
			System.out.println(results[i] + " ms");
		}
	}





	public static void main(String [] args) {
		Main main = new Main();
	}

}