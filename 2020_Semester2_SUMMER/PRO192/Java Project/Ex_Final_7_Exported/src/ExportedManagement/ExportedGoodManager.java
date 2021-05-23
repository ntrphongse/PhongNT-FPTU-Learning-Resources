/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportedManagement;

import DAO.FileDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ExportedGoodManager {
    HashMap<String, ArrayList<String>> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    
    public ExportedGoodManager()
    {
        list = new HashMap<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadGoods(inFile);
    }
    
    public void printCountries(String goodName)
    {
        String write = "";
        if (list.isEmpty())
            write = "Data is not loaded !";
        else
        {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                ArrayList<String> aGoods = list.get(key);
                if (aGoods.contains(goodName))
                    write += key + ", ";
            }
            if (!write.isEmpty())
                write = write.substring(0, write.length() - 2);
        }
        FileDAO.writeData(write, outFile1);
    }
    
    public void CountCountry(String goodName)
    {
        String write = "";
        int gCount = 0;
        if (list.isEmpty())
            write = "Data is not loaded !";
        else
        {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                ArrayList<String> aGoods = list.get(key);
                if (aGoods.contains(goodName))
                    gCount++;
            }
            write = "" + gCount;
        }
        FileDAO.writeData(write, outFile2);
    }
}
