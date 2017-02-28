import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	private String bit;
	private int[][] coefficient;
	private ArrayList<Integer> variables;

	
	public Individual(String bit, int[][] coefficient, ArrayList<Integer> variables){
		this.bit = bit;
		this.coefficient = coefficient;
		this.variables = variables;
	}
	
	public Individual(){
		
	}
	
	public void eval( int[][] file){
		
	}
	
	
	public String getBit() {
		return bit;
	}
	
	public void setBit(String bit) {
		this.bit = bit;

	}
	
	public void calculateIndividual() {
        for (int i = 0; i < bitSize(); i++) {
            int random = ThreadLocalRandom.current().nextInt(0,1);
            variables.set(i, random);
        }
    }
	
	public void printIndividual(){
		System.out.println(bit);
	}
	
	public int bitSize(){
		return bit.length();
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
	
	public int calculateDecmial(String currentBit){
		int decimal = Integer.parseInt(currentBit, 2);
		return decimal;
	}

}
