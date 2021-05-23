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
import simpleGraphs.DJ_SP_Result;
import simpleGraphs.DJ_Shortest_Processor;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class MyDirectedWeightedGraph1 extends AbstractGraph{
    String filename;
    
    public MyDirectedWeightedGraph1 (String filename) {
        super(DIRECTED_WEIGHTED);
        this.filename = filename;
    }
    
    @Override
    public boolean loadGraph() {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("The file " + filename + " doesn't exist!");
            System.exit(0);
        }
        StringTokenizer stk1, stk2;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            line = bf.readLine();  // Read vertices
            stk1 = new StringTokenizer(line, " ");
            while (stk1.hasMoreElements()) {
                String vKey = stk1.nextToken();
                this.addVertex(vKey);
            }
            
            // Add adjacents
            while ((line = bf.readLine()) != null && line.length() > 0) {
                stk1 = new StringTokenizer(line, " ");
                String srcKey = stk1.nextToken();
                while (stk1.hasMoreElements()) {
                    String part = stk1.nextToken();
                    stk2 = new StringTokenizer(part, "(), ");
                    String destKey = stk2.nextToken();
                    double weight = Double.parseDouble(stk2.nextToken());
                    this.addAdj(srcKey, destKey, weight);
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
        String filename = "Dijskstra_demo.txt";
        MyDirectedWeightedGraph1 g = new MyDirectedWeightedGraph1(filename);
        g.loadGraph();
        System.out.println("Graph properties: ");
        System.out.println(g);
        
        DJ_Shortest_Processor processor = new DJ_Shortest_Processor(g);
        System.out.println("Shortest paths, Dijskstra algorithm: ");
        DJ_SP_Result result = processor.createDJShortestResult("d");
        if (result == null)
            System.out.println("FAIL!");
        else
            System.out.println(result);
    }
}
