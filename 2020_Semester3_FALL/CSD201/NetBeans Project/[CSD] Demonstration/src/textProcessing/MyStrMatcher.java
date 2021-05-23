/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textProcessing;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class MyStrMatcher {
    // Bruth Force approach
    public static int indexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = 0; i < n-m+1; i++) {
            j = 0;
            while (j < m) {
                if (S.charAt(i+j) != pattern.charAt(j))
                    break;
                j++;
                if (j == m)
                    return i;
            }
        }
        return -1; // not found
    }
    
    public static int lastIndexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = n - m; i >= 0; i--) {
            j = 0;
            while (j < m) {
                if (S.charAt(i+j) != pattern.charAt(j))
                    break;
                j++;
                if (j == m)
                    return i;
            }
        }
        return -1; // not found
    }
    
    // Knuth-Morris-Pratt algorithm
    // Create Longest proper Prefix which is also Suffix
    public static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        fail[0] = 0; // First element having no previous element
        int j = 1; // position of the array fail will be assigned value
        int k = 0; // value will be assigned to elements in the array fail
        while (j < m) { // assign value to fail[1]... fail[m-1]
            if (pattern[j] == pattern[k]) { // 2 characters are the same
                fail[j] = k+1;
                k++;
            }
            else if (k > 0)
                k = fail[k-1]; // get back/backward previous value
            else
                fail[j] = 0; // No improvement, go to the first character
            j++; // next fail element
        }
        return fail;
    }
    
    public static int indexOf_KMP(char S[], char p[]) {
        int n = S.length;
        int m = p.length;
        int[] prefixes = computeFailKMP(p);
        int j = 0; // position into source string S
        int k = 0; // index into pattern p
        while (j < n) { // traverse S
            if (S[j] == p[k]) {
                if (k == m-1)
                    return j-m+1; // found
            }
            else // 2 characters are not equal
                if (k > 0)
                    k = prefixes[k-1]; // update position in p
            j++; // next character in S
            k++;
        }
        return -1; // not found
    }
    
    public static int indexOf_KMP(String S, String pattern) {
        return indexOf_KMP(S.toCharArray(), pattern.toCharArray());
    }
    
    public static void printArray(int a[]) {
        for (int x: a)
            System.out.print(x + ", ");
    }
    
    public static void main(String[] args) {
        String S1 = "Jack! go away, and you, please do not go away tonigh!";
        String p1 = "go";
        String p2 = "away";
        int pos1 = indexOf_BF(S1, p1);
        int pos2 = indexOf_BF(S1, p2);
        int pos3 = lastIndexOf_BF(S1, p2);
        System.out.println("S1 = " + S1);
        System.out.println("p1 = " + p1);
        System.out.println("Index of p1 in S1: " + pos1);
        System.out.println("p2 = " + p2);
        System.out.println("Index of p2 in S1: " + pos2);
        System.out.println("Last index of p2 in S1: " + pos3);
        
        // KMP
        String S2 = "bacbabababacaca";
        String pattern = "ababaca";
        int fail[] = computeFailKMP(pattern.toCharArray());
        System.out.println("S2: " + S2);
        System.out.println("Pattern: " + pattern);
        System.out.println("fail[]: " );
        printArray(fail);
        System.out.println("\nPattern at position in S2: " + indexOf_KMP(S2, pattern));
    }
}
