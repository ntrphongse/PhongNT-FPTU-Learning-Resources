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
public class IndexDomain<E> {
    RealDomain<E> realDomain;
    private int n;  // index: 0.. (n-1)
    int curIndex = -1;
    public IndexDomain (RealDomain realDomain) {
        this.realDomain = realDomain;
        n = realDomain.size();
    }
    
    // Getting an index in this domain
    public int nextIndex() {
        if (this == null)
            throw new RuntimeException("Domain is null!");
        return ++curIndex;
    }
    
    public boolean hasNext() {
        return curIndex + 1 < n;
    }
    
    public void reset() {
        curIndex = -1;
    }
    
    public E getRealValue(int i) {
        if (curIndex == -1)
            return null;
        return this.realDomain.get(i);
    }

    public RealDomain<E> getRealDomain() {
        return realDomain;
    }

    public void setRealDomain(RealDomain<E> realDomain) {
        this.realDomain = realDomain;
    }
    
    
}
