package graph;

import java.io.Serializable;

public class Node implements Serializable {
       private int idNode;

    Node() {this.idNode = 0; }
    Node(int idNode){this.idNode = idNode;}
    public int getIdNode() {return this.idNode;}
    public void setIdNode(int idNode) {this.idNode = idNode;}
    
}
