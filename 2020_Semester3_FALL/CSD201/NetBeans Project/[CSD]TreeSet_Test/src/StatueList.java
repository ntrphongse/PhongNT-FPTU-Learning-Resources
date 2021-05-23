
import java.util.Iterator;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StatueList extends TreeSet<Statue>{

    public StatueList() {
        super();
    }
    
    public Statue search(String ID) {
        Statue s = this.ceiling(new Statue(ID));
        if (s!= null && s.ID.equals(ID))
            return s;
        return null;
    }
    
    public boolean remove(String ID) {
        Statue s = search(ID);
        if (s != null)
            return this.remove(s);
        else
            return false;
    }
    
    public boolean update(Statue oldStatue, String newAuthor, double newHeight, double newWeight) {
        if (oldStatue == null)
            return false;
        else if (search(oldStatue.ID) == null)
            return false;
        else {
            oldStatue.setAuthor(newAuthor);
            oldStatue.setHeight(newHeight);
            oldStatue.setWeight(newWeight);
            return true;
        }
    }
    
    public void displayAll() {
        Iterator<Statue> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            Statue s = it.next();
            System.out.println("[" + ++i + "] " + s);
        }
    }
}
