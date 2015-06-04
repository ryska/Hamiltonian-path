package genetics.algorithm;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import genetics.data.Chromosome;

/**
 * Ocena przystosowania osobników
 * @author Adrianna
 */
public class AdaptationCalculator {
    UndirectedSparseGraph graph;
    
    public AdaptationCalculator(UndirectedSparseGraph g){
        graph = g;
    }
    /**
     * Oblicza przystosowanie osobnika w przedziale od 0 do 1.
     * @param chromosome
     * @return 
     */
    public void calculate(Chromosome chromosome){
        chromosome.setAdaptation(1); // jak to zaimplementować?
        
    }
}
