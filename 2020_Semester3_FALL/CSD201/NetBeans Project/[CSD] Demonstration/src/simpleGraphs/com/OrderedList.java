/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs.com;

import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderedList<T> extends ArrayList<Comparable> {
    public T search (T x) { // Binary Search
        if (this.isEmpty())
            return null;
        int first = 0, last = this.size() - 1, mid, d;
        while (first <= last) {
            mid = (first + last) / 2;
            Comparable result = this.get(mid);
            d = ((Comparable)x).compareTo(result);
            if (d == 0)
                return (T)result;
            else if (d < 0)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return null;
    }
    
    public void addItem(Comparable x) {
        if (this.isEmpty())
            this.add(x);
        else { // Determine the right position for x
            int i, n = this.size();
            for (i = n - 1; i >= 0; i--) {
                Comparable t = (Comparable)this.get(i);
                if (t.compareTo(x) <= 0)
                    break;
            }
            this.add(i + 1, x);
            
        }
    }
}
