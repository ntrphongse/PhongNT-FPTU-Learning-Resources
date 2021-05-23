/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking.Core;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Variable {
    IndexDomain indexDomain; // index domain which this variable belongs to
    int d_Index = -1; // index in domain is assigned to this var.
    double cost = 0; // cost when this var. is assigned a value
    
    public Variable(IndexDomain indexDomain) {
        this.indexDomain = indexDomain;
    }
    
    public Variable(IndexDomain indexDomain, double cost) {
        this.indexDomain = indexDomain;
        this.cost = cost;
    }

    public IndexDomain getIndexDomain() {
        return indexDomain;
    }

    public void setIndexDomain(IndexDomain indexDomain) {
        this.indexDomain = indexDomain;
    }

    public int getD_Index() {
        return d_Index;
    }

    public void setD_Index(int d_Index) {
        this.d_Index = d_Index;
    }
    
    
}
