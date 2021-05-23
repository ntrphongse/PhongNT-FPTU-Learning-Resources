/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cun;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class FileDAO {
    // Mở file dscun.csv
    // Trả về ArrayList<Cun> list
    
    public static ArrayList<Cun> loadCuns(String FileName)
    {
        FileReader f = null;
        BufferedReader bf = null;
        ArrayList<Cun> list = new ArrayList<>();
        try {
            f = new FileReader(FileName);
            bf = new BufferedReader(f);
            while (bf.ready())
            {
                String s = bf.readLine();
                String[] arr = s.split(",");
                if (arr.length == 4) // Sau khi cắt phải có 4 chuỗi con mới tạo cún
                {
                    double t1 = Double.parseDouble(arr[2]);
                    double t2 = Double.parseDouble(arr[3]);
                    Cun c = new Cun(arr[0], arr[1], t1, t2);
                    list.add(c);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
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
    
    // Ghi ArrayList<Cun> list vào file text
    public static void writeCuns(ArrayList<Cun> list, String FileName)
    {
        PrintWriter w = null;
        try {
            w = new PrintWriter(FileName);
            for (Cun cun : list) {
                w.println(cun); // Gọi hàm toString của lớp Cún và ghi chuỗi return vào buffer của w
                w.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (w != null)
                    w.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
