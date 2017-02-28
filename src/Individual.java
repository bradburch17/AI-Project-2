import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	public static int[][] coefficient;
	
	private String binaryString;
	private int numVariables;
	private ArrayList<Integer> variables;

	public Individual(int number)
	{
		
	}
	
	public Individual(String binaryString, int[][] coefficient, ArrayList<Integer> variables){
		this.binaryString = binaryString;
		this.coefficient = coefficient;
		this.variables = variables;
	}
	
	public Individual(){
		
	}
	
	public int evaluate( int[][] file, String binaryString){
		int solution = 0;
		// takes the file and forms the algorithm; uses WXYZ from binary string in order to solve this algorithm
		return solution;
	}
	
	
	public String getBinaryString() {
		return binaryString;
	}
	
	public void setBinaryString(String binaryString) {
		this.binaryString = binaryString;

	}
	
	public void calculateIndividual() {
        for (int i = 0; i < binaryStringSize(); i++) {
            int random = ThreadLocalRandom.current().nextInt(0,1);
            variables.set(i, random);
        }
    }
	
	public void printIndividual(){
		System.out.println(binaryString);
	}
	
	public int binaryStringSize(){
		return binaryString.length();
	}
	
	public int[][] getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(int[][] coefficient) {
		this.coefficient = coefficient;
	}
	
	public ArrayList<Integer> getVariables() {
		return variables;
	}
	
	public void setVariables(ArrayList<Integer> variables) {
		// This get set to x1, x2, x3 --> calculated from coefficent
	}
	
	public int[] calculateDecmial(String currentBinaryString){
		// looks at parts of the binaryString and adds WXYZ values in decimal to an list in order to use them in evaluate
		int decimal = Integer.parseInt(currentBinaryString, 2);
		return ;
	}

}
