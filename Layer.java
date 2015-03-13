public class Layer {

	// For front and back layer
	public Corner cubie1Corner; public Edge cubie2Edge; public Corner cubie3Corner;
	public Edge cubie4Edge; public Center cubie5Center; public Edge cubie6Edge;
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

	public Layer(Corner cubie1Corner, Edge cubie2Edge, Corner cubie3Corner, Edge cubie4Edge, Center cubie5Center, Edge cubie6Edge, Corner cubie7Corner, Edge cubie8Edge, Corner cubie9Corner) {
		this.cubie1Corner = cubie1Corner;
		this.cubie2Edge = cubie2Edge;
		this.cubie3Corner = cubie3Corner;
		this.cubie4Edge = cubie4Edge;
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
	public Cubie getCubie(int i){
		// Wants cubie 5 for middle layer
		if(isMiddleLayer() && i == 5){
			return null;
		
		}else if(isMiddleLayer() && i != 5){

			switch(i){
				case 1: return cubie1Edge; 
				case 2: return cubie2Center;
				case 3: return cubie3Edge;
				case 4: return cubie4Center;
				case 6: return cubie6Edge;
				case 7: return cubie7Center;
				case 8: return cubie8Edge;
				case 9:	return cubie9Center;
			}
		} else if(!isMiddleLayer()){
			switch(i){
				case 1: return cubie1Corner;
				case 2: return cubie2Edge;
				case 3: return cubie3Corner;
				case 4:	return cubie4Edge;
				case 5:	return cubie5Center;
				case 6: return cubie6Edge;
				case 7:	return cubie7Corner;
				case 8: return cubie8Edge;
				case 9: return cubie9Corner;
			} 
		} 
		return null;
	}


}