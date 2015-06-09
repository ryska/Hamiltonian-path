package genetics.algorithm;

import genetics.data.Chromosome;
import genetics.data.Gene;
import genetics.data.Population;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Mutator {

    /**
     * Mutuje osobniki z podanej populacji z uwzględnieniem prawdopodobieństwa
     * mutacji.
     *
     * @param population Populacja do mutowania.
     * @return Populacja po mutowaniu.
     */
    protected double prob;
    
    /**
     * Konstruktor klasy.
     * @param mutationProb Parametr okreslający prawdopodobieńtwo mutacji osobnika.  
     */

    public Mutator(double mutationProb) {
        prob = mutationProb;
    }

    public Random random = new Random();
    
    /**
     * Funkcja odpowiedzialna za mutowanie osobników. 
     * @param population Populacja, której osobniki mutujemy.
     * @return Listę population ze zmutowanymi osobnikami.
     */

    public Population mutate(Population population) {
        List chromosomes = population.getChromosomes();
        int popSize = population.getChromosomes().size();

        /**
         * iteruję przez populacje i mutuję każdy chromosom z zadanym prawdopodopodobieństwem.
         */
        Iterator<Chromosome> itr = chromosomes.iterator();
        while (itr.hasNext()) {
            if (random.nextDouble() < prob) { 
                Chromosome ch = itr.next();
                int chromSize = ch.getGenes().size(); // ilosc genow w chromosomie
                int random1 = random.nextInt(chromSize - 1); //losuje geny do zmutowania   
                int random2 = random.nextInt(chromSize - 1);
                Gene tmp = ch.getGene(random1); // zamieniam miejscami
                ch.insertGene(random1, ch.getGene(random2));
                ch.insertGene(random2, tmp);
            }
        }
        
        return population;
    }
}
