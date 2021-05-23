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
public class ItemConsultant {
    double budget;
    VarSet varSet;
    ItemSolutionEvaluator evaluator;

    public ItemConsultant(double budget, VarSet varSet) {
        this.budget = budget;
        this.varSet = varSet;
        evaluator = new ItemSolutionEvaluator();
    }
    
    class ItemSolutionEvaluator implements Evaluator {
        private double computeCost(Proposal p) {
            double totalCost = 0;
            ArrayList list = p.getRealObjects(varSet);
            for (Object object : list) {
                totalCost += ((Item)object).getPrice();
            }
            p.setTotalCost(totalCost);
            return totalCost;
        }

        @Override
        public boolean isSatisfied(Proposal p) {
            return computeCost(p) <= budget;
        }
    }
    
    public void print(Proposal pro) {
        ArrayList list = pro.getRealObjects(varSet);
        System.out.println("A solution: ");
        for (Object object : list) {
            System.out.print((Item)object);
        }
        System.out.println("Cost: " + (int)pro.getTotalCost());
    }
    
    public static void main(String[] args) {
        
        RealDomain<Item> tvDom = new RealDomain<>();
        tvDom.add(new Item("TV01", "Sony 42", 4800000));
        tvDom.add(new Item("TV02", "LG 42", 3800000));
        tvDom.add(new Item("TV03", "Samsung 48", 7500000));
        tvDom.add(new Item("TV04", "Sony 55", 14800000));
        tvDom.add(new Item("TV05", "LG 65", 16800000));
        tvDom.add(new Item("TV06", "Samsung 55", 11200000));
        
        RealDomain<Item> rfDom = new RealDomain<>();
        rfDom.add(new Item("RF01", "National 420", 11800000));
        rfDom.add(new Item("RF02", "General 380", 10800000));
        rfDom.add(new Item("RF03", "Panasonic 180", 3500000));
        rfDom.add(new Item("RF04", "Hitachi 380", 9800000));
        rfDom.add(new Item("RF05", "Beko 250", 6700000));
        
        VarSet varSet = new VarSet();
        IndexDomain D = new IndexDomain(tvDom);
        varSet.add(new Variable(D));
        D = new IndexDomain(tvDom);
        varSet.add(new Variable(D));
        D = new IndexDomain(tvDom);
        varSet.add(new Variable(D));
        D = new IndexDomain(rfDom);
        varSet.add(new Variable(D));
        D = new IndexDomain(rfDom);
        varSet.add(new Variable(D));
        
        double budget = 40000000;
        ItemConsultant problem = new ItemConsultant(budget, varSet);
        Evaluator evaluator = problem.evaluator;
        
        BacktrackSolver solver = new BacktrackSolver(varSet, evaluator);
        ArrayList<Proposal> solutions;
        solutions = solver.getAllSolution();
        
        int n = solutions.size();
        if (n > 0) {
            System.out.println(n + " solutions were detected for the budget of " + (int)budget + ": ");
            System.out.println("Proposals: ");
            for (int i = 0; i < n; i++) {
                problem.print(solutions.get(i));
                
            }
        }
        else
            System.out.println("No solutions can be detected!");
    }
    
}
