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
	private int numVariables;
	private ArrayList<Integer> binary = new ArrayList<Integer>();
	private double fitness;
	private double reproductionChance;
	private int evaluation;
	
	public Individual(){ }

	public Individual(int number){ }
	
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
	
	public void addBinary(int i)
	{
		binary.add(i);
	}
	
	public int getSingleBinary(int i)
	{
		return binary.get(i);
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
					   Integer.toString(binary.get(i + 3)) +
					   Integer.toString(binary.get(i + 4)) + 
					   Integer.toString(binary.get(i + 5)) +
					   Integer.toString(binary.get(i + 6)) + 
					   Integer.toString(binary.get(i + 7));
			
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

	public void printIndividual()
	{
		for(int i = 0; i < binary.size(); i++)
		{
			System.out.print(binary.get(i));
		}
		System.out.println();
	}
}
