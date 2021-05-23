/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirportManagementSystem;

import DAO.FileDAO;
import DTO.Airport;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class AirportManager {
    HashMap<String, Airport> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    
    public AirportManager()
    {
        list = new HashMap<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadAirport(inFile);
    }
    
    public void printCountries()
    {
        String write = "";
        if (list.isEmpty())
            write = "No data to write!";
        else
        {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                write += key + "-" + list.get(key).getName() + "\n";
            }
        }
        FileDAO.writeData(write, outFile1);
    }
    
    public void LargesAirport()
    {
        String write = "";
        if (list.isEmpty())
            write = "No data to write!";
        else
        {
            Set<String> sKey = list.keySet();
            long maxArea = 0;
            for (String key : sKey) {
                Airport gAirport = list.get(key);
                if (gAirport.getArea() > maxArea)
                {
                    maxArea = gAirport.getArea();
                    write = key + ", " + gAirport.getName();
                }
            }
        }
        FileDAO.writeData(write, outFile2);
    }
}
