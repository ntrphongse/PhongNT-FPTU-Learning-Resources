/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs;

import java.util.Iterator;
import simpleGraphs.vertex.AdjInfo;
import simpleGraphs.vertex.Vertex;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DJ_Shortest_Processor extends GraphTraverser{
    public static final double INFINITY = Double.MAX_VALUE;
    
    public DJ_Shortest_Processor(AbstractGraph graph) {
        super(graph);
    }
    
    private void DJreset() {
        for (Comparable p : graph) {
            Vertex v = (Vertex)p;
            v.num = 0;
            v.pathLen = INFINITY;
            v.predecessor = null;
        }
    }
    
    private Vertex getMinLenVertex() {
        Vertex result = null;
        Iterator it = graph.iterator();
        while (it.hasNext()) {
            Vertex v = (Vertex)it.next();
            if (v.num == 0) {
                if (result == null)
                    result = v;
                else if (result.pathLen > v.pathLen)
                    result = v;
            }
        }
        return result;
    }
    
    private void DJ_Algorithm(Vertex startVertex) {
        DJreset();
        startVertex.pathLen = 0;
        Vertex curVertex = startVertex;
        Vertex predecessor;
        double curLen, newLen;
        while (curVertex != null) {
            curVertex.num = 1;
            predecessor = curVertex;
            curLen = curVertex.pathLen;
            
            Iterator adjs = curVertex.adjList.iterator();
            while (adjs.hasNext()) {
                AdjInfo adj = (AdjInfo)adjs.next();
                Vertex v = adj.dest;
                newLen = curLen + adj.weight;
                if (v.num == 0 && newLen < v.pathLen) {
                    v.pathLen = newLen;
                    v.predecessor = predecessor;
                }
            }
            curVertex = getMinLenVertex();
        }
    }
    
    public DJ_SP_Result createDJShortestResult(Vertex startV){
        DJ_Algorithm(startV);
        
        DJ_SP_Result result = new DJ_SP_Result(startV, graph);
        
        result.setupPath();
        return result;
    }
    
    public DJ_SP_Result createDJShortestResult(String starKey) {
        Vertex startV = graph.search(starKey);
        if (starKey == null)
            return null;
        return createDJShortestResult(startV);
    }
}
