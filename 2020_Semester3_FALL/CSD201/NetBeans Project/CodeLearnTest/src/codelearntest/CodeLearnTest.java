/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelearntest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CodeLearnTest {
    /**
     * @param args the command line arguments
     */
    static boolean checkTriangle(int[] A, int[] B, int[] C) {
        int c = A[0], d = A[1], e=B[0], f=B[1], g=C[0], h= C[1];
        if (c == e) {
            if (d == f)
                return false;
            else {
                if (g == c) 
                    return false;
                return true;
            }
        } else {
            double a = (d-f)/(c-e);
            double b = (d-a*c);
            if (h == (a*g+b))
                return false;
            return true;
        }
            
    }
    
    static boolean checkDif(int[] A, int[] B) {
        if (A[0]*B[0] < 0 && A[1]*B[1] < 0)
            return true;
        return false;
    }
    static int checkQuarter(int[] point) {
        if (point.length != 2)
            return -1;
        if (point[0] >= 0)
            if (point[1] >= 0)
                return 1;
            else
                return 4;
        else
            if (point[1] >= 0)
                return 2;
            else
                return 3;
    }
    
    static int[] cross(int[] A, int[] B, int[] C) {
        
    }
    static int[] cross(int[][] points) {
        int a[];
        if (points.length != 3)
            return new int[0];
        if (!checkTriangle(points[0], points[1], points[2]))
            return new int[0];
        int A[] = points[0], B[] = points[1], C[] = points[2];
        if (A[0] == 0) {
            int qB = checkQuarter(B), qC = checkQuarter(C);
            if (A[1] == 0) {
                if (qB == qC) {
                    a = new int[1];
                    a[0] = qB;
                }
                else {
                    if (!checkDif(B, C)) {
                        a = new int[2];
                        a[0] = qB;
                        a[1] = qC;
                    }
                    else {
                        if (qB == 2) { // qC == 4
                            if (Math.abs(qB) > Math.abs(qC)) {
                                a = new int[3];
                                a[0] = qB;
                                a[1] = qC;
                                a[2] = 3;
                            } else {
                                a = new int[3];
                                a[0] = qB;
                                a[1] = qC;
                                a[2] = 1;
                            }
                        } else if (qC == 2) { // qB == 4
                            if (Math.abs(qC) > Math.abs(qB)) {
                                a = new int[3];
                                a[0] = qB;
                                a[1] = qC;
                                a[2] = 3;
                            } else {
                                a = new int[3];
                                a[0] = qB;
                                a[1] = qC;
                                a[2] = 1;
                            }
                        }
                    }
                        
                }
            }
            if (A[1] > 0) {
                
            } else {
                
            }
        }
        return a;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] a = {{4,5},{4,4},{4,3}};
        
        System.out.println(checkTriangle(a[0], a[1], a[2]));
    }
    
}
