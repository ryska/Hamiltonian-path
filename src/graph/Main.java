import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.algorithms.layout.*;
import org.apache.commons.collections15.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Wpisz liczbę wierzchołków: ");
        Scanner input = new Scanner(System.in);
        int countNode = input.nextInt();
        System.out.println("Wybrałeś " + countNode + " wierzchołków. Brawo!");

        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i=1; i<countNode+1; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        System.out.println("Jaki graf (pełny/niepełny) ?");
        Scanner input1 = new Scanner(System.in);
        String type = input1.nextLine();
        System.out.println("Wybrałeś graf "+type);



        if (type.equals("niepełny")) {
           GraphIncomplete incomplete = new GraphIncomplete();
           incomplete.generateIncomplete(countNode, nodes);
        }

        else if (type.equals("pełny")){

           GraphComplete complete = new GraphComplete();
            complete.generateComplete(countNode, nodes);
        }

        else System.out.println("Błąd w wybieraniu grafu! \n YOU ARE THE LOSER!!!");


        //System.out.println("Podaj nazwę pliku do zapisu grafu: ");
        //Scanner input2 = new Scanner(System.in);
        //String plik = input2.nextLine();
        //ObjectOutputStream wy = new ObjectOutputStream((new FileOutputStream("C://java_workspace//"+plik)));
        //wy.writeObject();
    }
}