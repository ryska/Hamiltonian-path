package genetics.data;

import java.util.LinkedList;


// pojedynczy osobnik
public class Chromosome {
    // list of all genes
    protected LinkedList genes;
    protected float adaptation = 0;
    protected Gene gene;
    
    public Chromosome(LinkedList geneList){
        genes = geneList;
    }
    public LinkedList getGenes(){
        return genes;
    }
    public void setGenes(LinkedList geneList){
        genes = geneList;
    }      
    public void insertGene(int whichOne, Gene gen){
        genes.set(whichOne, gen);      
    }
    public Gene getGene(int index){
        gene = (Gene)genes.get(index);
        return gene;
    }
    public float getAdaptation(){
        return adaptation;
    }   
    public void setAdaptation(float a){
        adaptation = a;
    }          
}
