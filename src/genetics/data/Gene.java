package genetics.data;

public class Gene {
    
    // vertex constructor in its location
    public Gene(int ID){
        id = ID;
    } 
    
    // vertex id
    protected int id; 
    
    public String toString(){
        return "id:" + getId();
    }
    
    public int getId(){
        return id;
    }
}
