/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicineManager;

import DAO.FileDAO;
import DTO.Medicine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class MedicineManager {
    HashMap<String, ArrayList<Medicine>> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    
    public MedicineManager()
    {
        list = new HashMap<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadMedicine(inFile);
    }
    
    public void printDiseaseName(Medicine m)
    {
        Set<String> sKey = list.keySet();
        String write = "";
        for (String key : sKey) {
            ArrayList<Medicine> arrValues = list.get(key);
            for (Medicine Value : arrValues) {
                if (Value.getName().equals(m.getName()))
                {
                    write += key + ", ";
                    break;
                }
            }
        }
        if (!write.isEmpty())
            write = write.substring(0, write.length() - 2);
        else
            write = "Error! Can't find such a Medicine!";
        FileDAO.writeData(write, outFile1);
    }
    
    public void printMedicine(String diseaseName)
    {
        ArrayList<Medicine> arrValues = list.get(diseaseName);
        String write = "";
        if (arrValues == null)
            write = "Can't find the Disease Name!";
        else
        {
            for (Medicine Value : arrValues)
                write += Value.getName() + ", ";
            if (!write.isEmpty())
                write = write.substring(0, write.length() - 2);
            else
                write = "Can't find the Disease Name!";
        }
        FileDAO.writeData(write, outFile2);
    }
}
