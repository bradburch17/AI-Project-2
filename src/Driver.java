/**
 * Driver class for Project 2 in CSC330 Artificial Intelligence at DePauw University. 
 * Contains code to read in file for generic algorithm 
 * 
 * Created 2-24-2017
 * @author Brad Burch and Katherine Martin  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Driver {
	// number of gen, population size, mutation rate, number of variables in function, need new population, old population, individual that is best, average fitness, bestfitenss
	public static final int MAX_GENERATION = 100;
	public static final int POPULATION_SIZE = 200;
	public static final int MUTATION_RATE = 10;
	
	private static ArrayList<Individual> newPopulation;
	private static ArrayList<Individual> oldPopulation;
	private static ArrayList<Integer> fitness;
	private static Individual fittest;
	private int averageFit;
	private int bestFit;
	private static int generation = 0;
	private static int variables;
	private static int[][] coefficients;

	public static void main(String[] args)
	{
		String fileName = new String();
		Scanner reader = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		System.out.println("This program is used to solve a mathematical equation with a generic algorithm.");

		System.out.print("Please enter a file you would like to solve: ");
		fileName = reader.nextLine();
		
		try
		{
			File file = new File (fileName);
			Scanner scanner = new Scanner(file);

			variables = scanner.nextInt() + 1;
			System.out.println("variables: " + (variables - 1));
			while (scanner.hasNext())
			{
				numbers.add(scanner.nextInt());
			}
			
			scanner.close();

			
			generateGrid(numbers);
			printGrid();

			
			while(generation <= MAX_GENERATION)
			{
				
				// evaluate each binary from population
				// add evaluation to each individual in population
				// find the average of the eval then divide eval by average to create reproductionChance
				// this info is used to calculate fitness
				// set the fitness
				//print fittest of the generation's eval
				// select the individuals to reproduce and create new generation
				// end with mutation
				//create new population
				// generation++
				
				System.out.println("The current generation is: " + generation);
//				for(Individual i : oldPopulation)
//				{
//					i.setFitness(calculateFitness(i));
//					
//				}
//				
//				fittest = findFittest(oldPopulation);
//				newPopulation = new ArrayList<Individual>(generateNewPopulation(oldPopulation));
//				mutatePopulation(newPopulation);
				generation ++;
				
			}
			// set generation to 0 
			// loop through generations to print generation, calc fitness, best individual, fill population, mutate population
			// increase generation size
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open the file " + fileName + ".");
		}
		catch(IOException e)
		{
			System.out.println("Could not read from " + fileName + ".");
		}
	}

	//Finds the fittest individual from the current population and return best individual 
	private static Individual findFittest(ArrayList<Individual> currentPopulation) 
	{
		int fit = 0;
		Individual currentIndividual = new Individual();
		for(Individual i : currentPopulation)
		{
			if(i.getFitness() > fit)
			{
				fit= i.getFitness();
				currentIndividual = i;
			}
		}
		return currentIndividual;
	}

	//Generates a new population 
	private static ArrayList<Individual> generateNewPopulation(ArrayList<Individual> oldPopulation)
	{
		ArrayList<Individual> newPopulation = new ArrayList<Individual>();
		
		// Look at fitness divide by average 
		// That number is percentage chance of being picked
		//
		return newPopulation;
		
	}
	
	//Calculates the fitness according to SOME ALGORITHM*******CHANGE
	private static int calculateFitness(Individual individual) 
	{
		// TODO Auto-generated method stub
		return 1;
		
	}
	
	//Generates the grid used for the algorithm 
	private static int[][] generateGrid(ArrayList<Integer> numbers)
	{		
		coefficients = new int[variables][variables];
		for(int i = 0; i < variables; i++)
		{
			for(int j = 0; j < variables; j++)
			{
				coefficients[i][j] = numbers.get(0);
				numbers.remove(0);
			}
		}
		
		return coefficients;
	}
	
	//Prints the grid 
	private static void printGrid()
	{
		for(int i = 0; i < variables; i++)
		{
			for(int j = 0; j < variables; j++)
			{
				System.out.print(coefficients[i][j] + " ");
			}
			System.out.println();
		}
	}
}
