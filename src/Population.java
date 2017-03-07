/**
 * Population class handles the population used for the genetic algorithm. 
 * It contains an ArrayList of individuals from the MAX_POPULATION variable in Driver
 * and manipulates the given population 
 * 
 * @author Brad Burch & Katherine Martin 
 * Created 2-24-2017
 */

import java.util.ArrayList;

public class Population {

	private ArrayList<Individual> population = new ArrayList<Individual>();

	public Population(int size)
	{
		for( int i = 0; i < size; i++)
		{
			Individual individual = new Individual();
			individual.createIndividual();
		}
	}
	
	public Population(int size, boolean firstTime)
	{
		if(firstTime)
		{
			for( int i = 0; i < size; i++)
			{
				Individual individual = new Individual();
				individual.createIndividual();
				population.add(individual);
			}
		}
	}
	
	// method to check if there is room in youngPopulation and adds to it using crossover - NOT USED
	private void addIndividual(int i, Individual individual) 
	{
		population.add(i, individual);
	}
	
	//Takes the current population and returns the average decimal to be used for fitness calculation 
	public double averagePopulation()
	{
		double average, total = 0;
		for(int i = 0; i < population.size(); i++)
		{
			total += population.get(i).getEvaluation(); //The evaluation seems to be increasing, although it should not be
		}
		
		System.out.println("Total: " + total); //Currently returning huge number
		average = total / population.size();
		
		return average;
	}
	
	public ArrayList<Individual> getPopulation()
	{
		return population;
	}
	
	//Prints all the individuals in the population
	public void printPopulation()
	{
		for(int i = 0; i < population.size(); i++)
		{
			population.get(i).printIndividual();
		}
	}
}
