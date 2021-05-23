/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hp
 */
public class demoFileInOutStream {
    // Đọc file nhị phân bất kì và trả về dãy nhị phân đã đọc
    public static byte[] readFile(String FileName)
    {
        FileInputStream input = null;
        byte[] result = null;
        try {
            input = new FileInputStream(FileName);
            result = new byte[input.available()];
            input.read(result);
        } 
        catch (Exception e) {
            e.printStackTrace();
            // System.out.println("File loi!");
        }
        finally {
            try {
                if (input != null)
                    input.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    // Ghi mảng nhị phân vào file trong đĩa
    public static void writeFile(byte[] data, String FileName)
    {
        FileOutputStream g = null;
        try {
            g = new FileOutputStream(FileName);
            g.write(data);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (g != null)
                    g.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Ghi một số nguyên & một kí tự vào file nhị phân
    public static void writeData(int x, char c, String FileName)
    {
        FileOutputStream f = null;
        DataOutputStream df = null;
        try {
            f = new FileOutputStream(FileName);
            df = new DataOutputStream(f);
            df.writeInt(x);
            df.writeChar(c);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Đọc file nhị phân và ép kiểu về integer, char
    public static void readData(String FileName)
    {
        FileInputStream f = null;
        DataInputStream df = null;
        try {
            f = new FileInputStream(FileName);
            df = new DataInputStream(f);
            int kq1 = df.readInt();
            char kq2 = df.readChar();
            System.out.println(kq1 + ", " + kq2);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Ghi một OBJECT vào file nhị phân
    public static void writeObj(Dog d, String FileName)
    {
        FileOutputStream f = null;
        ObjectOutputStream df = null;
        try {
            f = new FileOutputStream(FileName);
            df = new ObjectOutputStream(f);
            df.writeObject(d);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void readObj(String FileName)
    {
        FileInputStream f = null;
        ObjectInputStream df = null;
        try {
            f = new FileInputStream(FileName);
            df = new ObjectInputStream(f);
            Dog kq = (Dog) df.readObject();
            System.out.println(kq);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Ghi một OBJECT vào file nhị phân
    public static void writeObj(ArrayList<Dog> list, String FileName)
    {
        FileOutputStream f = null;
        ObjectOutputStream df = null;
        try {
            f = new FileOutputStream(FileName);
            df = new ObjectOutputStream(f);
            df.writeObject(list);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static ArrayList<Dog> readObj2(String FileName)
    {
        FileInputStream f = null;
        ObjectInputStream df = null;
        ArrayList<Dog> kq = null;
        try {
            f = new FileInputStream(FileName);
            df = new ObjectInputStream(f);
            kq = (ArrayList<Dog>) df.readObject();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (f != null)
                    f.close();
                if (df != null)
                    df.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    
    // Lấy TÊN FILE, ĐƯỜNG DẪN THƯ MỤC, NGÀY TẠO...
    // ==> Properties
    public static void getProperties(String Name)
    {
        File f = null;
        try {
            f = new File(Name);
            if (f.exists())
            {
                if (f.isFile())
                {
                    System.out.println("Ngay thay doi file: " + new Date(f.lastModified()));
                }
                else // Folder
                {
                    String[] arr = f.list();
                    for (String string : arr) {
                        System.out.println(string);
                    }
                }
            }
            else
                System.out.println("Wrong name!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
