/**
 * Individual class contains the individual information that will be stored in Population 
 * Individual contains a fitness score and an ArrayList of initially randomly generated
 * binary digits that are converted into decimal.
 * 
 * @author Brad Burch & Katherine Martin 
 * Created 2-24-2017
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	private int numVariables;
	private ArrayList<Integer> binary = new ArrayList<Integer>();
	private int fitness;
	private double reproductionChance;
	private int evaluation;
	
	public Individual(){ }

	public Individual(int number){ }
	
	public int getFitness() 
	{
		return fitness;
	}

	public void setFitness(int fitness) 
	{
		this.fitness = fitness;
	}
	
	public int evaluate(int[][] file, String binaryString)
	{
		int solution = 0;
		// takes the file and forms the algorithm; uses WXYZ from binary string in order to solve this algorithm
		return solution;
	}
	
	public ArrayList<Integer> createIndividual() 
	{
		Driver driver = new Driver();
		Random r = new Random();
        for (int i = 0; i < driver.getVariables(); i++) 
        {
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
        }
        convertBinarytoDecimal();
        return binary;
    }
	
	public ArrayList<Integer> getVariables() 
	{
		return binary;
	}
	
	public void setVariables(ArrayList<Integer> variables) 
	{
		// This get set to x1, x2, x3 --> calculated from coefficient
		
	}
	
	//Converts the x values of each individual to a decimal number
	public void convertBinarytoDecimal()
	{
		// looks at parts of the binaryString and adds WXYZ values in decimal to an list in order to use them in evaluate
		ArrayList<Integer> thenewone = new ArrayList<Integer>();
		Driver driver = new Driver();
		int total = 0; //The individual's added decimal values
		for(int i = 0; i < driver.getVariables(); i++)
		{
			//String for each x value of each individual 
			String s = Integer.toString(binary.get(i)) + 
					   Integer.toString(binary.get(i + 1)) + 
					   Integer.toString(binary.get(i + 2)) + 
					   Integer.toString(binary.get(i + 3));
			
			//Converts the binary string to a decimal number
			int d = Integer.parseInt(s, 2);
			total += d;
		}

	}
	
	public int getIndividualDecimal()
	{
		ArrayList<Integer> thenewone = new ArrayList<Integer>();
		Driver driver = new Driver();
		int total = 0; //The individual's added decimal values
		for(int i = 0; i < driver.getVariables(); i++)
		{
			//String for each x value of each individual 
			String s = Integer.toString(binary.get(i)) + 
					   Integer.toString(binary.get(i + 1)) + 
					   Integer.toString(binary.get(i + 2)) + 
					   Integer.toString(binary.get(i + 3));
			
			//Converts the binary string to a decimal number
			int d = Integer.parseInt(s, 2);
			total += d;
		}
		return total;
	}

	public void printIndividual()
	{
		for(int i = 0; i < binary.size(); i++)
		{
			System.out.print(binary.get(i));
		}
		System.out.println();
	}
}
