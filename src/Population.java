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
	
	// method to check if there is room in youngPopulation and adds to it using crossover
	private void addIndividual(int i, Individual individual) 
	{
//		population[i] = individual;
		
	}
	
	public void printPopulation()
	{
		for(int i = 0; i < population.size(); i++)
		{
			population.get(i).printIndividual();
		}
	}
}
