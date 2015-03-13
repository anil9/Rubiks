public class Layer {

	// For front and back layer
	public Corner cubie1Corner; public Edge cubie2Edge; public Corner cubie3Corner;
	public Edge cubie4Corner; public Center cubie5Center; public Edge cubie6Edge;
	public Corner cubie7Corner; public Edge cubie8Edge; public Corner cubie9Corner;

	// For middle layer
	public Edge cubie1Edge;
	public Center cubie2Center;
	public Edge cubie3Edge;
	public Center cubie4Center;
	//public Edge cubie6Edge;
	public Center cubie7Center;
	//public Edge cubis8Edge;
	public Center cubie9Center; 

	/*
		structure is:

		1 2 3
		4 5 6
		7 8 9
	*/

	public Layer(Corner cubie1Corner, Edge cubie2Edge, Corner cubie3Corner, Edge cubie4Corner, Center cubie5Center, Edge cubie6Edge, Corner cubie7Corner, Edge cubie8Edge, Corner cubie9Corner) {
		this.cubie1Corner = cubie1Corner;
		this.cubie2Edge = cubie2Edge;
		this.cubie3Corner = cubie3Corner;
		this.cubie4Corner = cubie4Corner;
		this.cubie5Center = cubie5Center;
		this.cubie6Edge = cubie6Edge;
		this.cubie7Corner = cubie7Corner;
		this.cubie8Edge = cubie8Edge;
		this.cubie9Corner = cubie9Corner;

	}

	/*
		Structure is:

		1 2 3
		4   6
		7 8 9
		
	*/
	public Layer(Edge cubie1Edge, Center cubie2Center, Edge cubie3Edge, Center cubie4Center, Edge cubie6Edge, Center cubie7Center, Edge cubie8Edge, Center cubie9Center ){

		this.cubie1Edge = cubie1Edge;
		this.cubie2Center = cubie2Center;
		this.cubie3Edge = cubie3Edge;
		this.cubie4Center = cubie4Center;
		this.cubie6Edge = cubie6Edge;
		this.cubie7Center = cubie7Center;
		this.cubie8Edge = cubie8Edge;
		this.cubie9Center = cubie9Center;


	}

	public boolean isMiddleLayer(){
		return cubie5Center == null;
	}

	// return interface cubie
	public void getCubie(int i){
		// Wants cubie 5 for middle layer
		if(isMiddleLayer() && i == 5){
			return;
		
		}else if(isMiddleLayer() && i != 5){

			switch(i){
				case 1: 
				case 2:
				case 3:
				case 4:
				case 6:
				case 7:
				case 8:
				case 9:
			}
		} else if(!isMiddleLayer()){
			switch(i){
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8: 
				case 9:
			} 
		}
	}


}