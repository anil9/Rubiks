public class Layer {

	public Corner cubie1Corner; public Edge cubie2Edge; public Corner cubie3Corner;
	public Edge cubie4Corner; public Center cubie5Center; public Edge cubie6Edge;
	public Corner cubie7Corner; public Edge cubie8Edge; public Corner cubie9Corner;

	public Edge cubie1Edge;
	public Edge cubie3Edge;
	public Edge cubie4Edge;
	public Edge cubie5Edge;
	public Edge cubie6Edge;
	public Edge cubie7Edge;


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
		4   5
		6 7 8
		
	*/
	public Layer(Edge cubie1Edge, Edge cubie2Edge, Edge cubie3Edge, Edge cubie4Edge, Edge cubie5Edge, Edge cubie6Edge, Edge cubie7Edge, Edge cubie8Edge ){

		this.cubie1Edge = cubie1Edge;
		this.cubie2Edge = cubie2Edge;
		this.cubie3Edge = cubie3Edge;
		this.cubie4Edge = cubie4Edge;
		this.cubie5Edge = cubie5Edge;
		this.cubie6Edge = cubie6Edge;
		this.cubie7Edge = cubie7Edge;
		this.cubie8Edge = cubie8Edge;


	}

	public boolean isMiddleLayer(){
		return cubie5Center == null;
	}




}