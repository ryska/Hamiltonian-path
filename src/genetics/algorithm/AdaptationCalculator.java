package genetics.algorithm;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import genetics.data.Chromosome;
import graph.Way;
import java.util.ArrayList;

/**
 * Ocena przystosowania osobników
 * @author Adrianna
 */
public class AdaptationCalculator {
    UndirectedSparseGraph graph;
    ArrayList<Way> ways;
    public Way way;
    
   
    
    public AdaptationCalculator(UndirectedSparseGraph g){
        
        
    }
    /**
     * Oblicza przystosowanie osobnika w przedziale od 0 do 1.
     *  suma wszystkich krawędzi grafu 
     *  dodaję sumę odległości między wierzchołkami w grafie 
     * @param chromosome
     * @return 
     */
    public double addLength(Way w){
        double sum = 0;
        double length = w.getLength();
               
        
        return sum;      
    }
        

    public void calculate(Chromosome chromosome){
        chromosome.setAdaptation(1); // jak to zaimplementować?
        
    }
}
