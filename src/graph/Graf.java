package graph;

import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.algorithms.layout.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Graf extends JFrame {
    public Graf(Graph<Node, Way> g) {
        super("Graf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VisualizationViewer<Node,Way> vv = new VisualizationViewer<Node, Way>(new FRLayout<Node, Way>(g));
        new Dimension(300,200);
        getContentPane().add(vv);
        pack();
        setSize(new Dimension(400,300));
        setVisible(true);
    }
    public static void main(String[] args) {
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
        String rodzaj = input1.nextLine();
        System.out.println("Wybrałeś graf "+rodzaj);

        if (rodzaj.equals("n")) {
            ArrayList<Way> ways = new ArrayList<Way>();
            Random random = new Random();
            int countWay;
            int n = (countNode * (countNode - 1)) / 2;
            //if (ways.size()>5) {
                countWay = (random.nextInt(n - countNode) + countNode);
            //} else countWay = (random.nextInt(n - (countNode-1))+countNode);

            //System.out.println("Liczba krawędzi: " + countWay);

            Random generator = new Random();
            for (int i = 1; i < countWay + 1; i++) { // indeksowanie id od 0 ale w konstruktorze domyślnym ustawione na 1 !
                double len = generator.nextDouble() * 100;
                Way way = new Way(i, len);
                ways.add(way);
            }
            /*System.out.println("Długości krawędzi: ");
            Iterator<Way> it = ways.iterator();
            while (it.hasNext()) {
                Way way = it.next();
                System.out.println("Id: " + way.getIdWay() + " dlugosc: " + way.getLength());
            }*/
            Graph<Node, Way> graf_niepelny = new UndirectedSparseGraph<Node, Way>();
            int w = 0;
            int v1;
            int v2;
            for (int i = 0; i < nodes.size(); i++) {
                Node n1 = nodes.get(i);
                graf_niepelny.addVertex(n1);
                Random rand = new Random();
                v1 = (rand.nextInt(nodes.size()));
                while (v1 == i) {
                    v1 = (rand.nextInt(nodes.size()));
                }
                Node n2 = nodes.get(v1);
                graf_niepelny.addVertex(n2);

                while (graf_niepelny.isNeighbor(n1,n2)){
                    v1 = (rand.nextInt(nodes.size()));
                    while (v1 == i) {
                        v1 = (rand.nextInt(nodes.size()));
                    }
                    n2 = nodes.get(v1);
                    graf_niepelny.addVertex(n2);
                }
                graf_niepelny.addEdge(ways.get(w), n1, n2);
                w++;
            }
            for (int i = 0; i<nodes.size(); i++) {
                Random rand = new Random();
                Node n1 = nodes.get(i);
                int suma = graf_niepelny.outDegree(n1);

                if ((suma)<2){
                    v1 = (rand.nextInt(nodes.size()));
                    while (v1 == i) {
                        v1 = (rand.nextInt(nodes.size()));
                    }
                    Node n2 = nodes.get(v1);
                    graf_niepelny.addVertex(n2);

                    while (graf_niepelny.isNeighbor(n1,n2)){
                        v1 = (rand.nextInt(nodes.size()));
                        while (v1 == i) {
                            v1 = (rand.nextInt(nodes.size()));
                        }
                        n2 = nodes.get(v1);
                        graf_niepelny.addVertex(n2);
                    }
                    graf_niepelny.addEdge(ways.get(w), n1, n2);
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
                    graf_niepelny.addVertex(n1);
                    Node n2 = nodes.get(v2);
                    graf_niepelny.addVertex(n2);

                    while (graf_niepelny.isNeighbor(n1,n2)){
                        v2 = (rand.nextInt(nodes.size()));
                        while (v1 == v2) {
                            v2 = (rand.nextInt(nodes.size()));
                        }
                        n2 = nodes.get(v2);
                        graf_niepelny.addVertex(n2);
                    }
                    graf_niepelny.addEdge(ways.get(a), n1, n2);
                }
            }
            new Graf(graf_niepelny);
            //System.out.println("Graf: "+graf_niepelny.toString());
        }

        else if (rodzaj.equals("p")){

            ArrayList<Way> ways = new ArrayList<Way>();

            int countWay = (countNode * (countNode - 1)) / 2;
            System.out.println("Liczba krawędzi: " + countWay);

            Random generator = new Random();
            for (int i = 1; i < countWay+1; i++) { // indeksowanie id od 0 ale w konstruktorze domyślnym ustawione na 1 !
                double len = generator.nextDouble() * 100;
                Way way = new Way(i, len);
                ways.add(way);
            }
            System.out.println("Dlugosci krawędzi: ");
            Iterator<Way> it = ways.iterator();
            while (it.hasNext()){
                Way way = it.next();
                System.out.println("Id: "+way.getIdWay()+" dlugosc: "+way.getLength());
            }
            Graph<Node,Way> graf_pelny = new UndirectedSparseGraph<Node, Way>();

            int h=0;
            for (int i=0; i<nodes.size()-1; i++) {
                Node n1 = nodes.get(i);
                graf_pelny.addVertex(n1);
                for (int j = i+1; j<nodes.size(); j++) {
                    Node n2 = nodes.get(j);
                    graf_pelny.addVertex(n2);

                    graf_pelny.addEdge(ways.get(h), n1, n2);
                    h++;
                }
            }
            new Graf(graf_pelny);
            //System.out.println("graf = "+graf_pelny.toString());
        }

        else System.out.println("Błąd w wybieraniu grafu! \n YOU ARE THE LOSER!!!");
    }
}