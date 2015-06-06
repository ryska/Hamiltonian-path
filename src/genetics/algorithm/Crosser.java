/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetics.algorithm;

import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import genetics.data.Chromosome;
import genetics.data.Gene;
import genetics.data.Population;
import java.util.LinkedList;

/**
 *
 * @author Adrianna
 */
public class Crosser {
    
    /**
     * Krzyżuje osobniki z podanej populacji z uwzględnieniem wartości
     * przystosowania każdego osobnika
     * @param population krzyżowana populacja
     * @return populacja po krzyżowaniu
     */
    public double crossProbability = 0.3; // ? 
    public Population cross(Chromosome ch1, Chromosome ch2){
        
        LinkedList<Vertex> parent1 = ch1.getGenes();
        LinkedList<Vertex> parent2 = ch2.getGenes();
        
        LinkedList<Vertex> child1 = new LinkedList<>(parent1);
        LinkedList<Vertex> child2 = new LinkedList<>(parent2);
        
        
        
        
        
        return population;
    }
    
    protected boolean isEven(LinkedList<Gene> genes){
        if((genes.size() % 2)==0){
            return true;
        }else {return false;}
    }
    
}
