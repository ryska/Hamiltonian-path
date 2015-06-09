package genetics.algorithm;

import genetics.data.Chromosome;
import genetics.data.Gene;
import genetics.data.Population;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * Klasa odpowiedzialna za krzyżowanie osobników w populacji.
 * @author Adrianna
 */
public class Crosser {
    
    /**
     * Krzyżuje osobniki z podanej populacji z uwzględnieniem wartości
     * przystosowania każdego osobnika
     * @param population krzyżowana populacja
     * @return populacja po krzyżowaniu
     */
    
    public LinkedList<Chromosome> cross(Chromosome ch1, Chromosome ch2){
        
        LinkedList<Gene> parent1 = ch1.getGenes();
        LinkedList<Gene> parent2 = ch2.getGenes();
        
        LinkedList<Gene> child1 = new LinkedList<>();
        LinkedList<Gene> child2 = new LinkedList<>();
        
        /**
         * robię dzieci : 
        **/
        child1.addAll(getFirstHalf(ch1));
        child1.addAll(getSecondHalf(ch2));
        
        child2.addAll(getFirstHalf(ch2));
        child2.addAll(getSecondHalf(ch1));
        
        Chromosome c1 = new Chromosome(child1);
        Chromosome c2 = new Chromosome(child2);
        LinkedList<Gene> g = c1.getGenes();
        TreeSet<Gene> set = new TreeSet<>(g);
        
        LinkedList<Chromosome> returnList = new LinkedList<>();
        if(g.size()==set.size()){
            returnList.add(c1);
            returnList.add(c2);
        } else {
            returnList.add(ch1);
            returnList.add(ch2);
        }

        return returnList;
    }
    
    /**
     * Funkcja pobierająca pierwszą połowę genów z chromosomu-rodzica.
     * @param parent Chromosom, z którego pobieramy pierwszą połowę genów, jeśli liczba jest nieparzysta to zaokrąglamy w górę.
     * @return Pierwsza połowa genów.
     */
    
    protected LinkedList<Gene> getFirstHalf(Chromosome parent){
        LinkedList<Gene> p = parent.getGenes();
        LinkedList<Gene> half = new LinkedList();
        int parentSize = parent.getGenes().size();
        int partitionSize = (int)Math.ceil(parentSize/2);
        
        Iterator<Gene> itr = p.iterator();
        int zp=0;
        while (itr.hasNext() && zp < partitionSize) { 
                half.add(itr.next());
                zp++;
        }
        return half;
    }
    
    /**
     * Funkcja pobierająca drugą połowę genów od chromosomu-rodzica.
     * @param parent Chromosom, z którego pobieramy drugą połowę genów, lub resztę jeśli ich liczba jest nieparzysta.
     * @return Druga połowa genów.
     */
    
    protected LinkedList<Gene> getSecondHalf(Chromosome parent){
        LinkedList<Gene> secHalf = new LinkedList(parent.getGenes());
        LinkedList<Gene> fstHalf = getFirstHalf(parent);
        secHalf.removeAll(fstHalf);
        return secHalf;
    }
}
