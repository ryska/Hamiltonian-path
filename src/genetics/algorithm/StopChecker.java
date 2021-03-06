package genetics.algorithm;

import genetics.data.Chromosome;
import genetics.data.Population;

/**
 * Przyjmuje całą populację i sprawdza czy powinno się zakończyć działanie algorytmu.
 * @author Adrianna
 */
public class StopChecker {
    protected int checkedPopulations = 0;
    protected float bestChecked = -1;
    protected int stopAfter;
    Chromosome bestCheckedChromosome;
    
    /**
     * Konstruktor klasy.
     * @param noIterations Number of interations / liczba iteracji.
     */
    public StopChecker(int noIterations){
        stopAfter = noIterations;
    }
    
    /**
     * Sprawdza, czy warunek stopu jest spełniony (czy przez podaną ilość iteracji znaleziony został osobnik lepiej przystosowany).
     * @param population Najmłodsza populacja, którą sprawdzamy
     * @return true jeśli kończymy działanie algorytmu.
     */
    public boolean shouldStop(Population population){
        float chromosomeAdaptation;
        for( Chromosome chromosome : population.getChromosomes()){
            chromosomeAdaptation = chromosome.getAdaptation();
            if(chromosomeAdaptation> bestChecked){
                bestChecked = chromosomeAdaptation;
                bestCheckedChromosome = chromosome;
                checkedPopulations = 0;
            }
        }
        if(checkedPopulations >= stopAfter){
            return true;
        }
        checkedPopulations++;
            
        return false;
    }
    
    /**
     * Pobiera najlepiej przystosowany chromosom.
     * @return Najlepiej przystosowany chromosom lub null.
     */
    public Chromosome getBest(){
        return bestCheckedChromosome;
    }
    
}
