package genetics.algorithm;

import edu.uci.ics.jung.graph.Graph;
import genetics.data.Chromosome;
import genetics.data.Population;
import graph.MGraph;
import graph.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Klasa odpowiedzialna za znalezienie możliwie najlepszej ścieżki 
 * cyklu Hamilltona w grafie.
 * @author Adrianna
 */
//    
//    MGraph mgraph = new Mgraph(ileWierzcholkow, rodzajGrafu); 
//    Algorithm algorithm = new Algorithm(popsize, noit, muprob);
//    result = algorithm.findCycle(mgraph);



public class Algorithm {
    
    int popSize;
    int noIt;
    float mutProb;
    public Algorithm(int populationSize, int numOfIterations, float mutationProbability){
        popSize = populationSize;
        noIt = numOfIterations;
        mutProb = mutationProbability;
    }
    
    public LinkedList<Node> findCycle(Graph g){
        int generation=1;
        Population population = new PopulationGenerator().generate(g,popSize); // popSize od uzytkownika
        StopChecker stopChecker = new StopChecker(noIt); // number of Iterations od uzytkownika
        while (!(stopChecker.shouldStop(population))) {
            population = calculateAdaptation(g, population);
            population = crossPopulation(population);
            population = new Mutator(mutProb).mutate(population); // mutProb od uzytkownika ? 
            
            System.out.println(generation);
            generation++;
        }
        
        return new NodeGenerator().generate(g,stopChecker.getBest());
    }
    
    protected Population calculateAdaptation(Graph g, Population population){
        List<Chromosome> chromList = population.getChromosomes();
        AdaptationCalculator ac = new AdaptationCalculator(g);
        for(Chromosome ch : chromList){
            ac.calculate(ch);
        }
        
        return population;
    }
    
    protected Population crossPopulation(Population population) {
        Population newPopulation = new Population();
        List<Chromosome> chromosomes = population.getChromosomes();
        Random random = new Random();
        Crosser crosser = new Crosser();
        ArrayList<Chromosome> toCross = new ArrayList<>();
        

        for(Chromosome chrom: chromosomes){
            if(random.nextFloat() <= chrom.getAdaptation()){
                toCross.add(chrom);
            }else{
                newPopulation.addToPopulation(chrom);
            }
        }
        if(toCross.size()%2==1){
            toCross.remove(toCross.size()-1);
        }
        for(int i=0; i < toCross.size(); i+=2){
            newPopulation.getChromosomes().addAll(crosser.cross(toCross.get(i), toCross.get(i+1)));
        }
        
        return newPopulation;
    }

    
}
