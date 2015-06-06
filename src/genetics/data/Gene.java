package genetics.data;

public class Gene {
    
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
