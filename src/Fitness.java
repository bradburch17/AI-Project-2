/**
 * Fitness may or may not be used.
 * 
 * @author Brad Burch & Katherine Martin 
 * Created 2-24-2017
 */

import java.util.ArrayList;

public class Fitness {
	private static ArrayList<Individual> population;

	public static void setBit(ArrayList<Individual> newIndividual) {
        population = newIndividual;
    }
	
	public int calculateFitness(Individual individual){
			// TO DO LATER
			for( Individual i : population){
//				int decimal = i.calculateDecmial(individual.getBinaryString());
			// Looks at population and evaluation values and based on which is higher
			}
		return 1;
	}

}
