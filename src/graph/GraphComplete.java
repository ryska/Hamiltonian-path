import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GraphComplete extends JFrame {

    GraphComplete(){}

    public GraphComplete(Graph<Node, Way> g) {
        super("Graf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VisualizationViewer<Node,Way> vv = new VisualizationViewer<Node, Way>(new FRLayout<Node, Way>(g));
        new Dimension(300,200);
        getContentPane().add(vv);
        pack();
        setSize(new Dimension(400,300));
        setVisible(true);
    }

    public Graph<Node, Way> generateComplete(int countNode, ArrayList<Node> nodes){
        ArrayList<Way> ways = new ArrayList<Way>();

        int countWay = (countNode * (countNode - 1)) / 2;

        for (int i = 1; i < countWay+1; i++) { // indeksowanie id od 0 ale w konstruktorze domyślnym ustawione na 1 !
            Way way = new Way(i);
            ways.add(way);
        }

        Graph<Node,Way> graphComplete = new UndirectedSparseGraph<Node, Way>();

        int h=0;
        for (int i=0; i<nodes.size()-1; i++) {
            Node n1 = nodes.get(i);
            graphComplete.addVertex(n1);
            for (int j = i+1; j<nodes.size(); j++) {
                Node n2 = nodes.get(j);
                graphComplete.addVertex(n2);

                graphComplete.addEdge(ways.get(h), n1, n2);
                h++;
            }
        }
        new GraphComplete(graphComplete);

        return graphComplete;
    }
}
