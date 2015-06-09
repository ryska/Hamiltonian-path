package genetics.algorithm;

import edu.uci.ics.jung.graph.Graph;
import genetics.data.Chromosome;
import genetics.data.Gene;
import graph.Node;
import java.util.LinkedList;

/**
 * Klasa odpowiedzialna za generowanie Node'ów z Chromosomów.
 * @author Adrianna
 */

public class NodeGenerator {
    
    /**
     * Funkcja generująca obiekty Node z obiektów Chromosom.
     * @param graph Wygenerowany graf, na którego elementach działamy.
     * @param chromosome Chromosom, z którego tworzymy Node.
     * @return Lista Node'ów.
     */
    
    public LinkedList<Node> generate(Graph graph, Chromosome chromosome){
      LinkedList<Node> nodeList = new LinkedList<>();
      LinkedList<Gene> genes = chromosome.getGenes();
      
      for(Gene gene : genes){
          for(Object node: graph.getVertices()){
              if(((Node)node).getIdNode() == gene.getId()){
                  nodeList.add((Node)node);
              }
          }
      }        
        return nodeList; 
    }
    
}
