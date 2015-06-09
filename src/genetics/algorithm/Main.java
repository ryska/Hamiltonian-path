package genetics.algorithm;

import edu.uci.ics.jung.graph.Graph;
import graph.MGraph;
import graph.Node;
import graph.Way;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

//    public static void main(String[] args) throws IOException {
//        System.out.println("Wpisz liczbe wierzcholkow: ");
//        Scanner input = new Scanner(System.in);
//        int countNode = input.nextInt();
//        System.out.println("Wybrales " + countNode + " wierzcholkow. Brawo!");
//
//        System.out.println("Jaki graf (pelny/niepelny) ?");
//        Scanner input1 = new Scanner(System.in);
//        String type = input1.nextLine();
//        System.out.println("Wybrales graf " + type);
//
//        MGraph mgraph = new MGraph(countNode, type);
//    }
    public static void main(String args[]) throws IOException {
        MGraph mgraph = new MGraph(14, "pelny");
        Algorithm algorithm = new Algorithm(100, 40, (float) 0.7);
        LinkedList<Node> result = algorithm.findCycle(mgraph.getGraph());
        printPath(mgraph.getGraph(), result);
    }

    public static void printPath(Graph g, LinkedList<Node> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i).getIdNode() + "-!");
            System.out.print(((Way) g.findEdge(path.get(i), path.get(i + 1))).getWeight() + "!-");

        }
    }
}
