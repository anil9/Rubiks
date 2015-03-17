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
	public Edge cubie5Edge;
	public Center cubie6Center;
	public Edge cubie7Edge;
	//public Edge cubis8Edge;
	public Center cubie8Center;

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

	public Layer(Cubie cubie1Corner, Cubie cubie2Edge, Cubie cubie3Corner, Cubie cubie4Edge, Cubie cubie5Center, Cubie cubie6Edge, Cubie cubie7Corner, Cubie cubie8Edge, Cubie cubie9Corner) {
		this.cubie1Corner = (Corner)cubie1Corner;
		this.cubie2Edge = (Edge)cubie2Edge;
		this.cubie3Corner = (Corner)cubie3Corner;
		this.cubie4Edge = (Edge)cubie4Edge;
		this.cubie5Center = (Center)cubie5Center;
		this.cubie6Edge = (Edge)cubie6Edge;
		this.cubie7Corner = (Corner)cubie7Corner;
		this.cubie8Edge = (Edge)cubie8Edge;
		this.cubie9Corner = (Corner)cubie9Corner;

	}

	/*
		Structure is:

		1 2 3 -> 4 5 -> 6 7 -> 8 
		

	*/
	public Layer(Edge cubie1Edge, Center cubie2Center, Edge cubie3Edge, Center cubie4Center, Edge cubie5Edge, Center cubie6Center, Edge cubie7Edge, Center cubie8Center ) {

		this.cubie1Edge = cubie1Edge;
		this.cubie2Center = cubie2Center;
		this.cubie3Edge = cubie3Edge;
		this.cubie4Center = cubie4Center;
		this.cubie5Edge = cubie5Edge;
		this.cubie6Center = cubie6Center;
		this.cubie7Edge = cubie7Edge;
		this.cubie8Center = cubie8Center;


	}

	public boolean isMiddleLayer() {
		return cubie5Center == null;
	}

	// return interface cubie
	public Cubie getCubie(int i) {
		if (isMiddleLayer()) {

			switch (i) {
			case 1: return cubie1Edge;
			case 2: return cubie2Center;
			case 3: return cubie3Edge;
			case 4: return cubie4Center;
			case 5: return cubie5Edge;
			case 6: return cubie6Center;
			case 7: return cubie7Edge;
			case 8: return cubie8Center;
			case 9:	return null;
			}
		} else if (!isMiddleLayer()) {
			switch (i) {
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
	/*
		public void setCubie(int i, Cubie cubie){
			if(isMiddleLayer() && i == 5){
				return;
			}else if(isMiddleLayer() && i != 5){
				switch(i){
					case 1:
				}
			}
	*/
}



