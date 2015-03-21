import java.util.HashMap;

public class Petrus{

	private HashMap<Integer, Double> times = new HashMap<Integer, Double>();
	private HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();

	public Petrus(){

	}

	public void runAlg(Cube cube){
		cube.scramble(1000);
		cube.printWholeCube();
		buildTwoBlock(cube);

	}

	/*
	*	Step 1
	*/
	private Cube buildTwoBlock(Cube cube){
		/*String[] cornerColours = findStartCorner(cube);
		System.out.println(cornerColours[0] + " " + cornerColours[1] + " " + cornerColours[2]);
		*/return cube;
	}

	private Int[] findStartCorner(Cube cube){
		/*
			Tanke: kommer behöva att en sida vet vilken sida den är, samt dett grannsidor.
			Här behöver jag en funktion som givet cubienummer och sida får fram vilken den närliggande sidan är. 
			Om cubie-edge och cubie-corner (bredvid varandra) på samma sida har samma färg så måste jag kunna kolla att färgen är samma på andra sidan av cubien. 

		*/	

		for(int i = 1; i<=6;i++){
			Side side = cube.getSide(i);
			if(side.c1.equals(side.c2)||side.c1.equals(side.c4)){
				int[] ret = new int[2];
				// side,cubie pair
				ret[0] = i;
				ret[1] = 1;
				return ret;
			}
		}
		/*String[] ret = new String[3];
		ret[0] = colour1;
		ret[1] = colour2;
		ret[2] = colour3;
		*/return ret;

	}


	private void setTime(int i, Double time){
		times.put(i, time);
	}

	private void setMoves(int i, int num_moves){
		moves.put(i, num_moves);
	}

}