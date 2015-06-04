package genetics.data;

import java.util.LinkedList;
import java.util.List;

public class Population {
    //list of characters(chromosomes) 
    protected List<Chromosome> population = new LinkedList<>();
    
    public void addToPopulation(Chromosome chromosome){
        population.add(chromosome);
    }
    
    public List<Chromosome> getChromosomes(){
        return population;
    }   
    public void setChromosomes(List newPopulation){
        population = newPopulation;
    }
    
}
