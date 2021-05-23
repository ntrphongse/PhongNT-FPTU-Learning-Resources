/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */


public class MeasureTime {
    public static double duration(){
        double S=0.0;
        for (long i = 0; i < 1000000000; i++)
            S += 0.1;
        return S;
    }
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        double S = duration();
        long t2 = System.currentTimeMillis();
        System.out.println("Resultl: " + S);
        System.out.println("Duration of operation: " + (t2 - t1) + " milisecs");
    }
    
}
