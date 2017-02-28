
public class Population {

	private Individual[] population;

	public Population(int size, boolean initialize){
		population = new Individual[size];
		if(initialize){
			for( int i = 0; i < size(); i++){
			Individual individual = new Individual();
			individual.calculateIndividual();
			addIndividual(i, individual);
			}
		}
	}
	// method to check if there is room in youngPopulation and adds to it using crossover
	private void addIndividual(int i, Individual individual) {
		population[i] = individual;
		
	}

	public Individual[] getPopulation() {
		return population;
	
	}

	public void setPopulation(Individual[] population) {
		this.population = population;
	}
	
	public Individual getIndividual(int i){
		return population[i];
	}
	
	
	public int size(){
		return population.length;
	}

	
}
