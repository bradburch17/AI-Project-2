import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	private String binaryString;
	private int numVariables;
	private ArrayList<Integer> binary = new ArrayList<Integer>();
	private int fitness;
	private double reproductionChance;
	private int evaluation;
	
	public Individual(){ }

	public Individual(int number)
	{
		
	}
	
	public Individual(String binaryString, int[][] coefficient, ArrayList<Integer> variables)
	{
		this.binaryString = binaryString;
		this.binary = variables;
	}
	
	public int evaluate(int[][] file, String binaryString)
	{
		int solution = 0;
		// takes the file and forms the algorithm; uses WXYZ from binary string in order to solve this algorithm
		return solution;
	}
	
	
	public String getBinaryString() 
	{
		return binaryString;
	}
	
	public void setBinaryString(String binaryString) 
	{
		this.binaryString = binaryString;

	}
	
	public ArrayList<Integer> createIndividual() 
	{
		Driver driver = new Driver();
        for (int i = 0; i < driver.getVariables(); i++) 
        {
        	//Creates a binary string. 
            int random1 = ThreadLocalRandom.current().nextInt(0,1);
            int random2 = ThreadLocalRandom.current().nextInt(0,1);
            int random3 = ThreadLocalRandom.current().nextInt(0,1);
            int random4 = ThreadLocalRandom.current().nextInt(0,1);

            binary.add(random1);
            binary.add(random2);
            binary.add(random3);
            binary.add(random4);
        }
        
        return binary;
    }
	
	public void printIndividual()
	{
		System.out.println(binaryString);
	}
	
	public int binaryStringSize()
	{
		return binaryString.length();
	}
	
	public ArrayList<Integer> getVariables() 
	{
		return binary;
	}
	
	public void setVariables(ArrayList<Integer> variables) 
	{
		// This get set to x1, x2, x3 --> calculated from coefficient
		
	}
	
	public int[] calculateDecmial(String currentBinaryString)
	{
		// looks at parts of the binaryString and adds WXYZ values in decimal to an list in order to use them in evaluate
		int[] array = new int[0]; //JUST TO GET RID OF ERRORS. DELETE. 
		int decimal = Integer.parseInt(currentBinaryString, 2);
		return array;
	}

	public int getFitness() 
	{
		return fitness;
	}

	public void setFitness(int fitness) 
	{
		this.fitness = fitness;
	}
}
