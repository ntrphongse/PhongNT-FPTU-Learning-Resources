/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Medicine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Hp
 */
public class FileDAO {
    
    public static HashMap<String, ArrayList<Medicine>> loadMedicine(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        HashMap<String, ArrayList<Medicine>> list = new HashMap<>();
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            while (bf.ready())
            {
                String s = bf.readLine();
                
                String[] arr = s.split("@");
                if (arr.length == 2)
                {
                    String key = arr[0];
                    String value = arr[1];
                    String[] arrValue = value.split(", ");
                    ArrayList<Medicine> values = new ArrayList<>();
                    for (String string1 : arrValue)
                        values.add(new Medicine(string1));
                    list.put(key, values);
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
                
            } 
            catch (Exception e) {
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
