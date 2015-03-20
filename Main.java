public class Main {
	public static final int ALGO_RUNS = 10;	// increase this to a good value
	public static final int CUBE_SCRAMBLE = 1000;
	Cube cube;
	Fridrich fridrich;
	Petrus petrus;


	public Main() {
		cube = new Cube();
		fridrich = new Fridrich();
		//petrus = new Petrus();

		measure(fridrich);
		//measure(petrus);
	}



	private void measure(Algorithm algo) {
		long[] result = new long[ALGO_RUNS];

		for (int i = 0; i < ALGO_RUNS; i++) {
			cube.scramble(CUBE_SCRAMBLE);
			long startTime = System.currentTimeMillis();

			algo.runAlg(cube);
			long stopTime = System.currentTimeMillis() - startTime;
			
			result[i] = stopTime;
		}
		// write results to file in some nice format.
		printResult(result);

	}

	private void printResult(long[] results) {
		for (int i = 0; i < ALGO_RUNS; i++) {
			System.out.println(results[i]);
		}
	}





	public static void main(String [] args) {
		Main main = new Main();
	}

}