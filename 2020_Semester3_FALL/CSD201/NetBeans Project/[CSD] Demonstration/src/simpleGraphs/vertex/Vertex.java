/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs.vertex;

import simpleGraphs.com.OrderedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Vertex implements Comparable<Vertex>{
    public String key = "", name = ""; // For identifying a vertex
    public int num = 0; // Order in a traversal
    public double pathLen = 0.0; // Shortest path
    public Vertex predecessor = null; // Shortest path
    public OrderedList adjList;
    
    public Vertex(String key) {
        this.key = key;
        adjList = new OrderedList();
    }
    
    public Vertex(String key, String name) {
        this.key = key;
        this.name = name;
        adjList = new OrderedList();
    }
    
    @Override
    public int compareTo(Vertex o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "(" + key + "," + name + ", adjs: " + adjList + ")";
    }

    public OrderedList getAdjList() {
        return adjList;
    }

    
}
