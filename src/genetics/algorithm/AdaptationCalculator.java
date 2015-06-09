package genetics.algorithm;

import edu.uci.ics.jung.graph.Graph;
import genetics.data.Chromosome;
import graph.Node;
import graph.Way;
import java.util.LinkedList;

/**
 * Ocena przystosowania osobników
 *
 * @author Adrianna
 */
public class AdaptationCalculator {

    Graph graph;
    float sum = 0;
    NodeGenerator ng = new NodeGenerator();

    public AdaptationCalculator(Graph g) {
        graph = g;
        float weight;
        for (Object edge : g.getEdges()) {
//            System.out.println(((Way) edge).getWeight());
            if (((Way) edge).getWeight() == null) {
                ((Way) edge).setWeight("0");
            }
            sum += Float.parseFloat(((Way) edge).getWeight());   // suma wag sciezek calego grafu
            
        }
    }

    /**
     * Oblicza przystosowanie osobnika w przedziale od 0 do 1. suma wszystkich
     * krawędzi grafu dodaję sumę odległości między wierzchołkami w grafie
     *
     * @param chromosome
     * @return
     */
    public void calculate(Chromosome chromosome) {
        //chromosome.setAdaptation(1); // jak to zaimplementować?
        //suma wag sciezek wygenerowanego cyklu
        LinkedList<Node> nodes = ng.generate(graph, chromosome);
        int nodesSize = nodes.size();
        float weight = 0;
        Way way;
        for (int i = 0; i < nodesSize - 1; i++) {
            way = (Way) graph.findEdge(nodes.get(i), nodes.get(i + 1));
            weight += Float.parseFloat(way.getWeight());
        }

        float adaptation = 1 - (weight / sum);
        chromosome.setAdaptation(adaptation);
    }
}
