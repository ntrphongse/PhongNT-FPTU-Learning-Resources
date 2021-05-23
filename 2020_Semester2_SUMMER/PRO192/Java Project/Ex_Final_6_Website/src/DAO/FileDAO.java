/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Website;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    
    public static HashMap<String, Website> loadWebsite(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        HashMap<String, Website> list = new HashMap<>();
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            while (bf.ready())
            {
                String s = bf.readLine();
                String[] arr = s.split("@");
                if (arr.length == 4)
                {
                    String date = arr[0];
                    String domainName = arr[1];
                    String user = arr[2];
                    String pass = arr[3];
                    list.put(date, new Website(domainName, user, pass));
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
