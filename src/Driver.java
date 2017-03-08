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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	// number of gen, population size, mutation rate, number of variables in function, need new population, old population, individual that is best, average fitness, bestfitenss
	public static final int MAX_GENERATION = 100;
	public static final int POPULATION_SIZE = 200;
	public static final int MUTATION_RATE = 15;
	
	private static ArrayList<Individual> newPopulation;
	private static ArrayList<Individual> oldPopulation;
	private static ArrayList<Integer> fitness;
	private static Individual fittest = new Individual();
	private int averageFit; //Don't use
	private int bestFit; //Don't use
	private static int generation = 0;
	private static int variables;
	private static int[][] coefficients;


	public int getVariables()
	{
		return variables - 1;
	}

	//Finds the fittest individual from the current population and return best individual 
	private static Individual findFittest(double fit) 
	{
//		System.out.println("This is the fit score: " + fit);
		Individual fittestIndividual = new Individual();
		for(Individual i : oldPopulation)
		{
//			System.out.println(i.getFitness()); 
			if(i.getFitness() > fit)
			{
//				System.out.println("Replacement Fit Score: " + i.getFitness());
				fit= i.getFitness();
				fittest = i;
			}
		}
		return fittestIndividual;
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
	
	//Sets the fitness based on the average of evaluation and population
	public static void calculateFitness(double average)
	{
		// find the average of the eval then divide eval by average to create reproductionChance
		// this info is used to calculate fitness
		for(Individual i : oldPopulation)
		{
			i.setFitness( (double) i.getEvaluation() / average); //Sets the fitness based on the evaluation divided by the average (total population evaluation divided by pop size)
		}
	}
	
	//Creates an ArrayList and stores individuals based on their reproduction rates
	public static ArrayList<Individual> selection()
	{
		Random random = new Random();
		ArrayList<Individual> selectionList = new ArrayList<Individual>();
		ArrayList<Individual> selectedTwo = new ArrayList<Individual>();
		for(Individual individual : oldPopulation)
		{
			BigDecimal temp = new BigDecimal(individual.getFitness()); //BigDecimal in order to move the decimal over
			temp = temp.movePointRight(2);
			int repoChance = temp.intValue(); //returns int value of the BigDecimal number
			for (int i = 0; i <= repoChance; i++)
			{
				selectionList.add(individual); //Adds the individual into new arraylist for their fitness score 
			}
		}
		
		int select1 = random.nextInt(selectionList.size()); //Randomly selects 2 individuals 
		int select2 = random.nextInt(selectionList.size());
		
		selectedTwo.add(selectionList.get(select1));
		selectedTwo.add(selectionList.get(select2));

		return selectedTwo;
	}
	
	//Crosses over two selected Individuals 
	public static ArrayList<Individual> crossover(ArrayList<Individual> selectedTwo)
	{
		Individual individual1 = selectedTwo.get(0);
		Individual individual2 = selectedTwo.get(1);
		Individual newIndividual1 = new Individual();
		Individual newIndividual2 = new Individual();
		ArrayList<Individual> newIndividuals = new ArrayList<Individual>();
		Random random = new Random();
		int start = random.nextInt(((variables - 1) * 8) - 5); //Randomly selects a start to start in the middle of binary string

		for(int i = 0; i < ((variables - 1) * 8); i++)
		{
			
			if (i == start)
			{
				for(Integer s : individual1.getCrossOverBinary(start)) //Does 4 bytes at a time
				{
					newIndividual2.addBinary(i); //Switches binary strings
				}
				
				for(Integer s : individual2.getCrossOverBinary(start))
				{
					newIndividual1.addBinary(i);
				}
			}
			else if (i != start)
			{
				newIndividual1.addBinary(individual1.getSingleBinary(i)); //Adds the rest of the binary string to the new individual
				newIndividual2.addBinary(individual2.getSingleBinary(i));
			}
		}
		
		newIndividuals.add(newIndividual1);
		newIndividuals.add(newIndividual2);
		
		return newIndividuals;
	}
	
	//Mutates the population 
	public static void mutate()
	{
		Random random = new Random();
		
		for(Individual i : newPopulation)
		{
			int mutation = random.nextInt(MUTATION_RATE); //Selects a mutation rate 
			if (mutation == MUTATION_RATE)
			{
				int spot = random.nextInt(variables * 8); //Randomly selects a spot within the binary string
				i.mutateSpot(spot); //Mutates the random spot 
			}
		}
	}
	
	//Main method 
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
			fittest.setFitness(0.0);
			Population population = new Population(POPULATION_SIZE, true);
//			population.printPopulation();
			oldPopulation = population.getPopulation();
			
			Equation equation = new Equation();
			
			while(generation <= MAX_GENERATION)
			{				
				System.out.println("The current generation is: " + generation); 
				for (Individual i : oldPopulation)
				{
					i.setEvaluation(equation.solveFunction(coefficients, i)); 
				}
				calculateFitness(population.averagePopulation());
				
				findFittest(fittest.getFitness());
				System.out.print("Fittest: ");
				fittest.printIndividual();
				
//				System.out.println("Fittest Evaluation: " + fittest.getEvaluation());
				
				newPopulation = new ArrayList<Individual>();
				while (newPopulation.size() <= oldPopulation.size() - 2) //Keeps the population at the population size, instead of increasing 
				{
					ArrayList<Individual> crossed = crossover(selection());
					for(Individual i : crossed)
					{
						newPopulation.add(i); 
					}
				}
				mutate();
				comparePopulation();
			
				//Pointer error?
				oldPopulation = newPopulation;
				
				generation ++;
			}
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
	
	public static void comparePopulation()
	{
		int count = 0;
		for(int i = 0; i < oldPopulation.size(); i++)
		{
			if(oldPopulation.get(i) == newPopulation.get(i))
			{
				count++;
			}
			else
			{
				
			}
		}
		System.out.println("Count: " + count);
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
