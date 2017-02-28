import java.util.ArrayList;

public class Fitness {
	private static ArrayList<Individual> population;

	public static void setBit(ArrayList<Individual> newIndividual) {
        population = newIndividual;
    }
	
	public int calculateFitness(Individual individual){
			// TO DO LATER
			for( Individual i : population){
				int decimal = i.calculateDecmial(individual.getBit());
			// Looks at population and grabs decimal values then compares
			}
		return null;
	}

}
