/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    public static HashMap<String, ArrayList<String>> loadGoods(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        HashMap<String, ArrayList<String>> list = null;
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            list = new HashMap<>();
            while (bf.ready())
            {
                String s = bf.readLine();
                String[] arr = s.split("@");
                if (arr.length == 2)
                {
                    String key = arr[0];
                    String values = arr[1];
                    ArrayList<String> vGoods = new ArrayList<>();
                    String[] vArr = values.split(", ");
                    for (String value : vArr) {
                        vGoods.add(value);
                    }
                    list.put(key, vGoods);
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
