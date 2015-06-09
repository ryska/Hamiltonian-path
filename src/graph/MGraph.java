package graph;

import edu.uci.ics.jung.graph.Graph;

import java.util.ArrayList;

public class MGraph {
    private int countNode;
    private String typeGraph;
    public MGraph(int count, String type){chooseGraph(count,type); }

    public void setCountNode(int countNode) {this.countNode = countNode; }
    public int getCountNode() {return countNode;}
    public void setTypeGraph(String typeGraph) {this.typeGraph = typeGraph; }
    public String getTypeGraph() {return typeGraph; }
    private Graph<Node, Way> graph;
    public Graph<Node, Way> getGraph(){return graph;}

    public void chooseGraph(int countNode, String typeGraph){
        this.countNode = countNode;
        this.typeGraph = typeGraph;

        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i=1; i<this.countNode+1; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        if (this.typeGraph.equals("niepelny")) {
            GraphIncomplete incomplete = new GraphIncomplete();
            graph = incomplete.generateIncomplete(countNode, nodes);
        }
        else if (this.typeGraph.equals("pelny")) {
            GraphComplete complete = new GraphComplete();
            graph = complete.generateComplete(countNode, nodes);
        }
        else System.out.println("Blad w wybieraniu grafu.");


    }

}
