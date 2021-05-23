/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Airport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    public static HashMap<String, Airport> loadAirport(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        HashMap<String, Airport> list = new HashMap<>();
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            while (bf.ready())
            {
                String s = bf.readLine();
                String[] arr = s.split(",");
                if (arr.length == 5)
                {
                    for (int i = 0; i <= 3; i++)
                        arr[i] = arr[i].substring(1, arr[i].length()-1);
                    String key = arr[3];
                    Airport nAirport = new Airport(arr[0], arr[1], arr[2], Long.parseLong(arr[4]));
                    list.put(key, nAirport);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (bf != null)
                    bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public static void writeData(String data, String FileName)
    {
        PrintWriter w = null;
        try {
            w = new PrintWriter(FileName);
            w.write(data);
            w.flush();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (w != null)
                    w.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
