/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphsDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import simpleGraphs.AbstractGraph;
import simpleGraphs.GraphTraverser;
import simpleGraphs.com.OrderedList;
import simpleGraphs.vertex.TraversedVertex;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class MyUnDirectedGraph1 extends AbstractGraph{
    String filename;

    public MyUnDirectedGraph1(String filename) {
        super(AbstractGraph.UNDIRECTED);
        this.filename = filename;
    }
    
    @Override
    public boolean loadGraph() {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("The file " + filename + " doesn't exist!");
            System.exit(0);
        }
        StringTokenizer stk;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            line = bf.readLine();  // Read vertices
            stk = new StringTokenizer(line, " ");
            while (stk.hasMoreElements()) {
                String vKey = stk.nextToken();
                this.addVertex(vKey);
            }
            
            // Add adjacents
            while ((line = bf.readLine()) != null && line.length() > 0) {
                stk = new StringTokenizer(line, " ");
                String srcKey = stk.nextToken();
                while (stk.hasMoreElements()) {
                    String destKey = stk.nextToken();
                    this.addAdj(srcKey, destKey);
                }
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return true;
    }
    
    public static void main(String[] args) {
        String filename = "unDirectedGraph1.txt";
        MyUnDirectedGraph1 g = new MyUnDirectedGraph1(filename);
        g.loadGraph();
        System.out.println("Graph properties: ");
        System.out.println(g);
        
        GraphTraverser processor = new GraphTraverser(g);
        System.out.println("Breadth-First traversal: ");
        OrderedList<TraversedVertex> vList = processor.breadthFirstTraversal();
        System.out.println(vList);
        System.out.println("Depth-First traversal: ");
        vList = processor.DepthFirstTraversal();
        System.out.println(vList);
    }
}
