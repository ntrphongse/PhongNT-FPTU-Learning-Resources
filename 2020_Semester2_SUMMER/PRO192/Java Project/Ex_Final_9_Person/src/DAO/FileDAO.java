/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PersonName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    public static ArrayList<PersonName> loadPerson(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        ArrayList<PersonName> list = new ArrayList<>();
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            while (bf.ready())
            {
                String s = bf.readLine();
                String[] arr = s.split("\t");
                if (arr.length == 3)
                    list.add(new PersonName(arr[0], arr[1], Integer.parseInt(arr[2])));
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
    
    public static boolean writeData(String data, String FileName)
    {
        PrintWriter w = null;
        boolean result = false;
        try {
            w = new PrintWriter(FileName);
            w.write(data);
            w.flush();
            result = true;
        } 
        catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        finally
        {
            try {
                if (w != null)
                    w.close();
            } 
            catch (Exception e) {
                result = false;
                e.printStackTrace();
            }
        }
        return result;
    }
}
