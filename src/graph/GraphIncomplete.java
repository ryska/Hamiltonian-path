package graph;

import edu.uci.ics.jung.algorithms.importance.AbstractRanker;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GraphIncomplete extends JFrame {

    GraphIncomplete(){};

    public GraphIncomplete(Graph<Node, Way> g) {
        super("GraphIncomplete");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VisualizationViewer<Node,Way> vv = new VisualizationViewer<Node, Way>(new FRLayout<Node, Way>(g));
        new Dimension(300,200);
        getContentPane().add(vv);
        pack();
        setSize(new Dimension(400,300));
        setVisible(true);
    }

    public Graph<Node, Way> generateIncomplete(int countNode, ArrayList<Node> nodes){

        ArrayList<Way> ways = new ArrayList<Way>();
        Random random = new Random();
        int countWay;
        int n = (countNode * (countNode - 1)) / 2;

        countWay = (random.nextInt(n - countNode) + countNode);

        for (int i = 1; i < countWay + 1; i++) { // indeksowanie id od 0 ale w konstruktorze domyślnym ustawione na 1 !
            Way way = new Way(i);
            ways.add(way);
        }

        Graph<Node, Way> graphIncomplete = new UndirectedSparseGraph<Node, Way>();
        int w = 0;
        int v1;
        int v2;
        for (int i = 0; i < nodes.size(); i++) {
            Node n1 = nodes.get(i);
            graphIncomplete.addVertex(n1);
            Random rand = new Random();
            v1 = (rand.nextInt(nodes.size()));
            while (v1 == i) {
                v1 = (rand.nextInt(nodes.size()));
            }
            Node n2 = nodes.get(v1);
            graphIncomplete.addVertex(n2);

            while (graphIncomplete.isNeighbor(n1,n2)){
                v1 = (rand.nextInt(nodes.size()));
                while (v1 == i) {
                    v1 = (rand.nextInt(nodes.size()));
                }
                n2 = nodes.get(v1);
                graphIncomplete.addVertex(n2);
            }
            graphIncomplete.addEdge(ways.get(w), n1, n2);
            w++;
        }
        for (int i = 0; i<nodes.size(); i++) {
            Random rand = new Random();
            Node n1 = nodes.get(i);
            int suma = graphIncomplete.outDegree(n1);

            if ((suma)<2){
                v1 = (rand.nextInt(nodes.size()));
                while (v1 == i) {
                    v1 = (rand.nextInt(nodes.size()));
                }
                Node n2 = nodes.get(v1);
                graphIncomplete.addVertex(n2);

                while (graphIncomplete.isNeighbor(n1,n2)){
                    v1 = (rand.nextInt(nodes.size()));
                    while (v1 == i) {
                        v1 = (rand.nextInt(nodes.size()));
                    }
                    n2 = nodes.get(v1);
                    graphIncomplete.addVertex(n2);
                }
                graphIncomplete.addEdge(ways.get(w), n1, n2);
                w++;
            }
        }
        if (w != ways.size()) {
            for (int a=w; a<ways.size(); a++) {
                Random rand = new Random();
                v1 = (rand.nextInt(nodes.size()));
                v2 = (rand.nextInt(nodes.size()));
                while (v1 == v2) {
                    v2 = (rand.nextInt(nodes.size()));
                }
                Node n1 = nodes.get(v1);
                graphIncomplete.addVertex(n1);
                Node n2 = nodes.get(v2);
                graphIncomplete.addVertex(n2);

                while (graphIncomplete.isNeighbor(n1,n2)){
                    v2 = (rand.nextInt(nodes.size()));
                    while (v1 == v2) {
                        v2 = (rand.nextInt(nodes.size()));
                    }
                    n2 = nodes.get(v2);
                    graphIncomplete.addVertex(n2);
                }
                graphIncomplete.addEdge(ways.get(a), n1, n2);
            }
        }
        new GraphIncomplete(graphIncomplete);

        return graphIncomplete;
    }
}
