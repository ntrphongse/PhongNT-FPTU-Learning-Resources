/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking.BK_Uses;

import BackTracking.Core.BacktrackSolver;
import BackTracking.Core.DefaultEvaluator;
import BackTracking.Core.IndexDomain;
import BackTracking.Core.Proposal;
import BackTracking.Core.RealDomain;
import BackTracking.Core.VarSet;
import BackTracking.Core.Variable;
import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class BitStrGenerator {
    public static void main(String[] args) {
        int numOfVars = 4;
        System.out.println("BIT STRINGS GENERATOR");
        int i;
        
        RealDomain booleanSet = new RealDomain();
        booleanSet.add(0);
        booleanSet.add(1);
        VarSet varSet = new VarSet();
        for (i = 0; i < numOfVars; i++) {
            IndexDomain D = new IndexDomain(booleanSet);
            varSet.add(new Variable(D));
        }
        
        DefaultEvaluator evaluator = new DefaultEvaluator();
        
        BacktrackSolver solver = new BacktrackSolver(varSet, evaluator);
        ArrayList<Proposal> solutions;
        
        System.out.println("Get ONE solution: ");
        Proposal sol = solver.getOneSolution();
        
        if (sol != null)
            System.out.println("A solution: " + sol + "\n");
        else
            System.out.println("No solution!\n");
        
        solutions = solver.getAllSolution();
        int n = solutions.size();
        
        if (n > 0) {
            System.out.println(n + " solutions were detected: ");
            for (i = 0; i < n; i++) {
                System.out.println("A solution: " + solutions.get(i));
            }
        }
        else
            System.out.println("No solution can be detected!");
    }
}
