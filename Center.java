public class Center implements Cubie{

	private String color;

	public Center(String color){
		this.color = color;
	}

	public void showingColor(int i){
		//do nothing
	}

	public int getShowingColor(){
		return 0;
	}

	public String getColor(int i){
		return color;
	}
	public String toString(){
		return getColor(-1);
	}


}