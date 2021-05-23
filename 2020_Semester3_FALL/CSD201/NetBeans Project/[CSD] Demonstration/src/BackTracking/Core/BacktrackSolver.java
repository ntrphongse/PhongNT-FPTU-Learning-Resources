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
public class BacktrackSolver {
    VarSet varSet; // Set of Variables
    Evaluator evaluator;

    public BacktrackSolver(VarSet varSet, Evaluator evaluator) {
        this.varSet = varSet;
        this.evaluator = evaluator;
    }
    
    // Solve problem at the varIndex(th) variable
    private void getNSolution(int varIndex, int n, ArrayList<Proposal> solutions) {
        if (solutions.size() == n)
            return;
        Variable v = varSet.get(varIndex);
        IndexDomain D = v.getIndexDomain();
        D.reset();
        
        while (D.hasNext()) {
            v.setD_Index(D.nextIndex());
            if (varIndex == varSet.size() - 1) {
                Proposal prop = new Proposal();
                for (Variable var: varSet)
                    prop.add(var.getD_Index());
                if (solutions.size() < n) {
                    if (evaluator.isSatisfied(prop))
                        solutions.add(prop);
                }
                else
                    return;
            }
            else
                getNSolution(varIndex + 1, n, solutions);
        }
    }
    
    public ArrayList<Proposal> getNSolution(int n) {
        ArrayList<Proposal> solutions = new ArrayList<>();
        int varIndex = 0;
        getNSolution(varIndex, n, solutions);
        return solutions;
    }
    
    public Proposal getOneSolution() {
        ArrayList<Proposal> solutions;
        solutions = getNSolution(1);
        return solutions.get(0);
    }
    
    private void getAllSolution(int varIndex, ArrayList<Proposal> solutions) {
        Variable v = varSet.get(varIndex);
        IndexDomain D = v.getIndexDomain();
        D.reset();
        
        while (D.hasNext()) {
            v.setD_Index(D.nextIndex());
            if (varIndex == varSet.size() - 1) {
                Proposal prop = new Proposal();
                for (Variable var: varSet)
                    prop.add(var.getD_Index());
                if (evaluator.isSatisfied(prop))
                    solutions.add(prop);
            }
            else 
                getAllSolution(varIndex + 1, solutions);
        }
    }
    
    public ArrayList<Proposal> getAllSolution() {
        ArrayList<Proposal> solutions = new ArrayList<>();
        int varIndex = 0;
        getAllSolution(varIndex, solutions);
        return solutions;
    }
    
}
