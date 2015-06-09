package genetics.algorithm;

import edu.uci.ics.jung.graph.Graph;
import graph.MGraph;
import graph.Node;
import graph.Way;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    /**
     * Musisz sobie Maja to połączyć z GUI, zrobić maina u siebie z tego co wiem, ale nie orientuję się jak to działa. 
     * Komentarze na dole są do twojej informacji, skasuj je jak zrobisz żeby było estetycznie :)
     * @param args
     * @throws IOException 
     */
    
    public static void main(String args[]) throws IOException {
        MGraph mgraph = new MGraph(14, "pelny"); // tworzę obiekt MGraph i ustawiam mu parametry : ilość wierzchołków i typ pełny/niepełny
        Algorithm algorithm = new Algorithm(100, 40, (float) 0.7); // obiekt typu algorytm, podaję mu: 
        //rozmiar populacji, ilość iteracji po skończeniu których algorytm ma przestać się wykonywać, prawdopodobieństwo mutacji. Zrzutowane na float bo Asia robiła na doubleach a ja floatach.
        LinkedList<Node> result = algorithm.findCycle(mgraph.getGraph()); // linked lista result- do niej pakujemy najelpszy cykl jaki znalazł algorytm.
        printPath(mgraph.getGraph(), result); // wypisuje scieżkę.
    }

    public static void printPath(Graph g, LinkedList<Node> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i).getIdNode() + "-!");
            System.out.print(((Way) g.findEdge(path.get(i), path.get(i + 1))).getWeight() + "!-");

        }
    }
}
