package graph;

public class Way {
    private int idWay;
    private double length;

    Way(){idWay = 0; length = 0;}
    Way(int id, double len){idWay = id; length = len; }
    public int getIdWay() {return idWay;}
    public double getLength() {return length;}
    public void setIdWay(int id) {idWay = id;}
    public void setLength(double dlug) {length = dlug;}
}
