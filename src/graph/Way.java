package graph;

import java.io.Serializable;

public class Way  implements Serializable{
    private int idWay;
    private String weightWay;

    Way(){this.idWay = 0;}
    Way(int idWay){this.idWay = idWay; }
    public int getIdWay() {return this.idWay;}
    public void setIdWay(int idWay) {this.idWay = idWay;}
    public String getWeight() {return this.weightWay;}
    public void setWeight(String weightWay) {this.weightWay = weightWay; }

}
