package graph;

import edu.uci.ics.jung.graph.Graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.*;
import java.io.*;

public class FileGraph implements Serializable {
    private Graph<Node, Way> graph;
    private String fileName;

    int i = 1;
    public FileGraph(Graph<Node,Way> graph) {
        this.graph = graph;
        fileName = "graph"+i+".ser";
        i++;
    }

    public void write() throws IOException {

        ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream("C://java_workspace//"+fileName));
        wy.writeObject(graph);
    }


    public Graph<Node, Way> read() throws IOException, ClassNotFoundException {

        ObjectInputStream we = new ObjectInputStream(new FileInputStream("C://java_workspace//"+fileName));
        Graph<Node,Way> g = (Graph<Node,Way>) we.readObject();
        return g;
    }
}




