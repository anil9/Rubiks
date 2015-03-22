

public class Fridrich implements Algorithm {
	Cube cube;
	Side top;
	Side bot;
	Side front;
	Side left;
	Side right;
	Side back;

	public Fridrich() {

	}

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

	/*
		The goal here is to achieve a cross of one chosen color,
		 say white, so that the white center-piece is aligned with 
		 its 4 white edge-pieces.

		 For it to be a completed step, the second color of the white
		  edge-pieces must also align with it’s center-piece counterpart.
	
	*/
	private void cross(){
		// always build the white cross. (Time consuming to always choose this undependent of the cube)

		if(cube.top.c5 != Cube.WHITE){
			System.err.println("Error: Slice operations have been executed (not white in center-piece on top)");
		}

		// find white edge-piece:

		// check top first
		if(top.c2 == Cube.WHITE){
			
		}

	}







}