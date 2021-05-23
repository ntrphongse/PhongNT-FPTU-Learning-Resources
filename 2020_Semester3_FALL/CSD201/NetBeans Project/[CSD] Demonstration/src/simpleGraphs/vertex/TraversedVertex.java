/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs.vertex;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TraversedVertex implements Comparable<TraversedVertex>{

    public Vertex v;
    public int num;

    public TraversedVertex(Vertex v, int num) {
        this.v = v;
        this.num = num;
    }
    
    @Override
    public int compareTo(TraversedVertex o) {
        return num < o.num ? -1 : num > o.num ? 1 : 0;
    }

    @Override
    public String toString() {
        return "(" + v.key + "," + v.num + ")";
    }
}
