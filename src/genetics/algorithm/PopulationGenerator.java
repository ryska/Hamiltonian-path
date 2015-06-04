package genetics.algorithm;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import genetics.data.Chromosome;
import genetics.data.Gene;
import genetics.data.Population;
import graph.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PopulationGenerator {

    /**
     * generates a population based on graph
     *
     * @param graph
     * @return populacja
     */
    public Population generate(UndirectedSparseGraph graph, int generationSize) {
        /**
         * Zbiór wszystkich wierzchołków
         */
        ArrayList vertices = (ArrayList) graph.getVertices();
        Population population = new Population();
        Chromosome chromosome;
        
        for (int i=0; i < generationSize; i++){
            population.addToPopulation(createChromosome(permute(vertices)));
        }
        
        return population;
    }

    
    /**
     * Zwraca pojedynczą permutację podanych wierzchołków
     * @param vertices Lista wierzchołków
     * @return Pojedyncza permutacja
     */
    protected LinkedList<Node> permute(ArrayList vertices) {
        LinkedList<Node> permutation = new LinkedList<>();
        int verticesSize = vertices.size();
        int randomIndex;
        Node randomElement;
        Random randomGenerator = new Random();
        
        while (permutation.size() < verticesSize) {            
            randomIndex = randomGenerator.nextInt(vertices.size());
            randomElement = (Node)vertices.toArray()[randomIndex];
            if (!permutation.contains(randomElement)){
                permutation.add(randomElement);
            }
        }
        return permutation;
    }
    
    /**
     * Tworzy pojedynczy chromosom.
     * @param permutation Lista wierzchołków.
     * @return Chromosom.
     */
    
    protected Chromosome createChromosome(LinkedList<Node> permutation){
        LinkedList<Gene> genes = new LinkedList<>();
        
        for (Node node : permutation){
            genes.add(new Gene(node.getIdNode()));
        }
        
        return new Chromosome(genes);
    }
    
}
