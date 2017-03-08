/**
 * Individual class contains the individual information that will be stored in Population 
 * Individual contains a fitness score and an ArrayList of initially randomly generated
 * binary digits that are converted into decimal.
 * 
 * @author Brad Burch & Katherine Martin 
 * Created 2-24-2017
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	private ArrayList<Integer> binary = new ArrayList<Integer>();
	private double fitness;
	private double reproductionChance;
	private int evaluation;
	
	public Individual(){ }
	
	public double getFitness() 
	{
		return fitness;
	}

	public void setFitness(double fitness) 
	{
		this.fitness = fitness;
	}
	
	public int getEvaluation() 
	{
		return evaluation;
	}

	public void setEvaluation(int evaluation) 
	{
		this.evaluation = evaluation;
	}
	
	public double getReproductionChance() {
		return reproductionChance;
	}

	public void setReproductionChance(double reproductionChance) {
		this.reproductionChance = reproductionChance;
	}
	
	//Adds an integer to the binary string
	public void addBinary(int i)
	{
		binary.add(i);
	}
	
	//Returns the number at a certain location in the binary string
	public int getSingleBinary(int i)
	{
		return binary.get(i);
	}
	
	//Creates an individual based on the number of variables and then adds a random number between 0 and 1
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
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
            binary.add(r.nextInt(2));
        }
        
        return binary;
    }
	
	public ArrayList<Integer> getVariables() 
	{
		return binary;
	}
	
	//Returns the decimal value of an individual
	public int getIndividualDecimal()
	{
		Driver driver = new Driver();
		int total = 0; //The individual's added decimal values
		for(int i = 0; i < driver.getVariables(); i++)
		{
			//String for each x value of each individual 
			String s = Integer.toString(binary.get(i)) + 
					   Integer.toString(binary.get(i + 1)) + 
					   Integer.toString(binary.get(i + 2)) + 
					   Integer.toString(binary.get(i + 3)) +
					   Integer.toString(binary.get(i + 4)) + 
					   Integer.toString(binary.get(i + 5)) +
					   Integer.toString(binary.get(i + 6)) + 
					   Integer.toString(binary.get(i + 7));
			
			//Converts the binary string to a decimal number
			int d = Integer.parseInt(s, 2);
			total += d;
		}
		
		return total;
	}
	
	//Returns the binary string of an individual given a starting point
	public String getBinary(int x)
	{
		String s = new String();
		for (int i = 0; i < binary.size(); i++)
		{
			if (i == x)
			{
				s = Integer.toString(binary.get(i)) + 
					Integer.toString(binary.get(i + 1)) + 
					Integer.toString(binary.get(i + 2)) + 
					Integer.toString(binary.get(i + 3)) +
					Integer.toString(binary.get(i + 4)) + 
					Integer.toString(binary.get(i + 5)) +
					Integer.toString(binary.get(i + 6)) + 
					Integer.toString(binary.get(i + 7));
				break;
			}
		}
		
		return s;
	}
	
	//Used for cross-over and returns an ArrayList<Integer> of 4 bytes that will be crossed over to a new individual 
	public ArrayList<Integer> getCrossOverBinary(int x)
	{
		ArrayList<Integer> returned = new ArrayList<Integer>();
		for (int i = 0; i < binary.size(); i++)
		{
			if (i == x)
			{
				returned.add(binary.get(i));
				returned.add(binary.get(i + 1));
				returned.add(binary.get(i + 2));
				returned.add(binary.get(i + 3));
				break;
			}
		}

		return returned;
	}
	
	//Mutates one spot in the Individual binary string based on a random that is being passed in
	public void mutateSpot(int spot)
	{
		for(int i = 0; i < binary.size(); i++)
		{
			if (i == spot)
			{
				if (binary.get(spot) == 0)
				{
					binary.add(spot, 1);
				}
				else if (binary.get(spot) == 1)
				{
					binary.add(spot, 0);
				}
			}
		}
	}

	//Prints an individual
	public void printIndividual()
	{
		for(int i = 0; i < binary.size(); i++)
		{
			System.out.print(binary.get(i));
		}
		System.out.println();
	}
}
