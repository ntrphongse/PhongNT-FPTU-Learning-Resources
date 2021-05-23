/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import simpleGraphs.com.OrderedList;
import simpleGraphs.vertex.AdjInfo;
import simpleGraphs.vertex.TraversedVertex;
import simpleGraphs.vertex.Vertex;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class GraphTraverser {
    AbstractGraph graph;

    public GraphTraverser(AbstractGraph graph) {
        this.graph = graph;
    }
    
    public OrderedList<TraversedVertex> breadthFirstTraversal(){
        OrderedList<TraversedVertex> result = new OrderedList<>();
        graph.resetNum();
        Iterator<Comparable> vSet = graph.iterator();
        LinkedList<Vertex> queue = new LinkedList<>();
        
        int i = 1;
        Vertex v;
        while (vSet.hasNext()) {
            v = (Vertex)vSet.next();
            if (v.num == 0) {
                v.num = i++;
                result.add(new TraversedVertex(v, v.num));
                
                queue.add(v);
                while (!queue.isEmpty()) {
                    v = queue.removeFirst();
                    for (int pos = 0; pos < v.adjList.size(); pos++) {
                        Vertex adjV = ((AdjInfo)v.adjList.get(pos)).dest;
                        if (adjV.num == 0) {
                            adjV.num = i++;
                            result.add(new TraversedVertex(adjV, adjV.num));
                            queue.addLast(adjV);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    protected int DFS(Vertex u, int order, OrderedList<TraversedVertex> result) {
        u.num = order;
        result.add(new TraversedVertex(u, order));
        order++;
        OrderedList<AdjInfo> adjList = u.getAdjList();
        for (int pos = 0; pos < u.adjList.size(); pos++) {
            Vertex adjV = ((AdjInfo)adjList.get(pos)).dest;
            if (adjV.num == 0)
                order = DFS(adjV, order, result);
        }
        return order;
    }
    
    public OrderedList<TraversedVertex> DepthFirstTraversal(){
        graph.resetNum();
        OrderedList<TraversedVertex> result = new OrderedList<>();
        int order = 1;
        Iterator<Comparable> vSet = graph.iterator();
        while (vSet.hasNext()) {
            Vertex u = (Vertex)vSet.next();
            if (u.num == 0)
                order = DFS(u, order, result);
        }
        return result;
    }
}
