package genetics.algorithm;

import genetics.data.Chromosome;
import genetics.data.Gene;
import genetics.data.Population;
import java.util.Random;

public class Mutator {

    /**
     * Mutuje osobniki z podanej populacji z uwzględnieniem prawdopodobieństwa 
     * mutacji.
     * @param population Populacja do mutowania.
     * @return Populacja po mutowaniu.
     */
    
    public Random random = new Random();
    
    public Population mutate(Population population){
        //List chromosomes = population.getChromosomes();
        // przeiterować przez populacje i zmutować każdy chromosom z zadanym prawdopod. Jako param w konstruktorze. jak mniejsza to mutuje. 
        int popSize = population.getChromosomes().size(); 
        
         //pobieram randomowy chromosom z populacji do zmutowania 
        int rand = random.nextInt(popSize);       
        Chromosome randomChromosome = population.getChromosomes().get(rand);
        
        int chromSize = randomChromosome.getGenes().size(); // liczba genow w chromosomie
       
        //losuje geny do zmutowania 
        int random1 = random.nextInt(chromSize-1);
        int random2 = random.nextInt(chromSize-1);

//        Gene mutateMe1 = (Gene)randomChromosome.getGenes().get(random1);
//        Gene mutateMe2 = (Gene)randomChromosome.getGenes().get(random2);
        
        
        //zamieniam
        Gene tmp = randomChromosome.getGene(random1);
        randomChromosome.insertGene(random1, randomChromosome.getGene(random2));
        randomChromosome.insertGene(random2, tmp);

        // ????
        return population;
    }
}
