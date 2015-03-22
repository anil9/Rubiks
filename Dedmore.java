public class Dedmore implements Algorithm{

	Cube cube;
	Side top;
	Side bot;
	Side front;
	Side left;
	Side right;
	Side back;

	public Dedmore(){}

	public void runAlg(Cube cube){
		this.cube = cube;
		top = cube.top;
		bot = cube.bot;
		front = cube.front;
		left = cube.left;
		right = cube.right;
		back = cube.back;

		cube.scramble(100000);	// just scrambling for time test.

	}


}