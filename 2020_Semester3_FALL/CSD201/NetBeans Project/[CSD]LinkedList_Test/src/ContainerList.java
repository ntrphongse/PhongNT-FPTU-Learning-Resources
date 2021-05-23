
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ContainerList extends LinkedList<Container>{
    public LinkedList<Container> getContainerList() {
        return this;
    }
     
    public boolean addContainer(Container x) {
        try {
            this.add(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void listAll() {
        try {
            if (this.isEmpty())
                throw new Exception("The list is empty! Please try to add some Container to operate...");
            Iterator<Container> container = iterator();
            while (container.hasNext())
                System.out.println(container.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int listRange(double minVol, double maxVol) throws Exception {
        int iCount = 0;
        if (this.isEmpty())
            throw new Exception("The list is empty! Please try to add some Container to operate...");
        Iterator<Container> container = iterator();
        while (container.hasNext()) {
            Container c = container.next();
            if (Validation.checkNumber(c.getVolume(), minVol, maxVol)) {
                System.out.println(c);
                iCount++;
            }
        }
        return iCount;
    }
    
    public Container searchContainer(String id) throws Exception {
        if (this.isEmpty())
            throw new Exception("The list is empty! Please try to add some Container to operate...");
        Iterator<Container> container = iterator();
        while (container.hasNext()) {
            Container c = container.next();
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
    
    public boolean removeContainer(String id) throws Exception {
        if (this.isEmpty())
            throw new Exception("The list is empty! Please try to add some Container to operate...");
        Container c = searchContainer(id);
        if (c == null)
            throw new Exception("No such a Container to remove!");
        this.remove(c);
        return true;
    }
}
