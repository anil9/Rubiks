

public class Cube {

	public Cube() {
		// 8 corners, 12(?) edges, 6 centers
		initCubies();


	}

	private void initCubies(){

		Center center = new Center("white");
		Edge edge = new Edge("white", "red");
		Corner corner = new Corner("white", "red", "blue");
		Layer layer = new Layer(null, null, null, null, null, null, null, null, null);

	}

	//Operations on the cube
	 
	// Twisting front face 90 degrees clockwise
	public void F(){

	}
	// Twisting front face 90 degrees anti-clockwise
	public void Fi(){

	}
	// Twisting Back face 90 degrees clockwise
	public void B(){

	}
	// Twisting back face 90 degrees anti-clockwise
	public void Bi(){

	}
	// Twisting right face 90 degrees clockwise
	public void R(){

	}
	// Twisting right face 90 degrees anti-clockwise
	public void Ri(){

	}
	// Twisting left face 90 degrees clockwise
	public void L(){

	}
	// Twisting left face 90 degrees anti-clockwise
	public void Li(){

	}
	// Twisting upper face 90 degrees clockwise
	public void U(){

	}
	// Twisting upper face 90 degrees anti-clockwise
	public void Ui(){

	}
	// Twisting bottom face 90 degrees clockwise
	public void D(){

	}
	// Twisting bottom face 90 degrees anti-clockwise
	public void Di(){

	}


	


	public static void main(String [] args) {
		Cube cube = new Cube();

	}



}

