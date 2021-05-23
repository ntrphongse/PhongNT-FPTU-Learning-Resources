/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking.BK_Uses;

import BackTracking.Core.BacktrackSolver;
import BackTracking.Core.Evaluator;
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
public class BuffaloProblem {
    int numOfBuffaloes = 0;
    int numOfWhisks = 0;
    BuffaloEval evaluator;

    public class BuffaloEval implements Evaluator{
        private int countGrass(Proposal p) {
            if (p.get(2)%2 == 1)
                return 0;
            return p.get(0)*1 + p.get(1)*2 + p.get(2)/2;
        }
        
        private int countBuffaloes(Proposal p) {
            return p.get(0) + p.get(1) + p.get(2);
        }
        @Override
        public boolean isSatisfied(Proposal p) {
            return countGrass(p) == numOfWhisks &&
                   countBuffaloes(p) == numOfBuffaloes;
        }
    }
    
    public BuffaloProblem(int numOfBuffaloes) {
        this.numOfBuffaloes = numOfBuffaloes;
        this.numOfWhisks = numOfBuffaloes;
        evaluator = new BuffaloEval();
    }
    
    public BuffaloProblem(int numOfBuffaloes, int numOfWhisks) {
        this.numOfBuffaloes = numOfBuffaloes;
        this.numOfWhisks = numOfWhisks;
        evaluator = new BuffaloEval();
    }
    
    public static void main(String[] args) {
        int numOfGrassPgk = 100;
        BuffaloProblem problem = new BuffaloProblem(numOfGrassPgk);
        int minVal = 0;
        int maxVal;
        
        RealDomain smallDomain = new RealDomain();
        int val;
        maxVal = numOfGrassPgk;
        if (maxVal > numOfGrassPgk)
            maxVal = numOfGrassPgk;
        for (val = minVal; val <= maxVal; val++)
            smallDomain.add(val);
        
        RealDomain bigDomain = new RealDomain();
        maxVal = numOfGrassPgk/2;
        if (maxVal > numOfGrassPgk)
            maxVal = numOfGrassPgk;
        for (val = minVal; val <= maxVal; val++)
            bigDomain.add(val);
        
        RealDomain oldDomain = new RealDomain();
        maxVal = numOfGrassPgk*2;
        if (maxVal > numOfGrassPgk)
            maxVal = numOfGrassPgk;
        for (val = minVal; val <= maxVal; val++)
            oldDomain.add(val);
        
        VarSet varSet = new VarSet();
        IndexDomain D = new IndexDomain(smallDomain);
        varSet.add(new Variable(D));
        D = new IndexDomain(bigDomain);
        varSet.add(new Variable(D));
        D = new IndexDomain(oldDomain);
        varSet.add(new Variable(D));
        
        Evaluator evaluator = problem.evaluator;
        
        BacktrackSolver solver = new BacktrackSolver(varSet, evaluator);
        ArrayList<Proposal> solutions;
        solutions = solver.getAllSolution();
        
        int n = solutions.size();
        if (solutions.size() > 0) {
            System.out.println(n + " solutions were detected: ");
            System.out.println("        [small, big, old buffaloes]");
            for (int i = 0; i < n; i++) {
                System.out.println("A solution: " + solutions.get(i));
                
            }
        }
        else
            System.out.println("No solution can be detected!");
    }
}
