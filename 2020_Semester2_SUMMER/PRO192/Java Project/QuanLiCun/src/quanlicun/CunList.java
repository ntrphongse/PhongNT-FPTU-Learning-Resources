/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlicun;

import DAO.FileDAO;
import DTO.Cun;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class CunList {
    ArrayList<Cun> list;
    static final String FileName = "dscun.csv";
    
    public CunList()
    {
        list = FileDAO.loadCuns(FileName);
    }
    
    public void addCun(Cun x)
    {
        list.add(x);
        FileDAO.writeCuns(list, FileName);
    }
    
    public int findCun(String id)
    {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    
    public void removeCun(String id)
    {
        int pos = findCun(id);
        if (pos != -1)
        {
            list.remove(pos);
            FileDAO.writeCuns(list, FileName);
        }
    }
    
}
