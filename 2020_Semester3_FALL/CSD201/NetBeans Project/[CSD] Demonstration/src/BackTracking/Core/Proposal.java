/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking.Core;

import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Proposal extends ArrayList<Integer> implements Comparable<Proposal>{
    double totalCost;

    @Override
    public int compareTo(Proposal o) {
        return totalCost < o.totalCost ? -1 :
               totalCost > o.totalCost ? 1 : 0;
    }
    
    // Get set of Real objects assigned to variables (Real Proposal)
    public ArrayList getRealObjects(VarSet varSet) {
        ArrayList realProposal = new ArrayList();
        for (int i = 0; i < varSet.size(); i++) {
            Variable v = varSet.get(i);
            int realIndex = this.get(i); // in Real Domain
            IndexDomain indexDomain = v.getIndexDomain();
            realProposal.add(indexDomain.getRealValue(realIndex));
        }
        return realProposal;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    
}
