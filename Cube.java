

public class Cube {

	public Cube() {
		// 8 corners, 12(?) edges, 6 centers
		initCubies();


	}

	private void initCubies(){

		Center center = new Center("white");
		Edge edge = new Edge("white", "red");
		Corner corner = new Corner("white", "red", "blue");

	}


	// implement operations on the cube


	public static void main(String [] args) {
		Cube cube = new Cube();

	}



}

