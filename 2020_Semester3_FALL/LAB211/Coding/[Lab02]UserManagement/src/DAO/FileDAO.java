/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    public static LinkedList<User> loadUser(String filename) {
        FileReader f = null;
        BufferedReader bf = null;
        LinkedList<User> rList = new LinkedList();
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] arr = s.split(",");
                if (arr.length == 6) {
                    try {
                        User nUser = new User(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                        rList.add(nUser);
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
        }
        finally {
            try {
                if (f != null)
                    f.close();
                if (bf != null)
                    bf.close();
            } catch (IOException ex) {
            }
        }
        Collections.sort(rList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getFName().compareTo(o2.getFName());
            }
        });
        return rList;
    }
    
    public static boolean checkExist(String filename, String username) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] arr = s.split(",");
                if (arr.length == 6) {
                    if (arr[0].equals(username)) {
                        if (f != null)
                            f.close();
                        if (bf != null)
                            bf.close();
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            try {
                if (f != null)
                    f.close();
                if (bf != null)
                    bf.close();
                return false;
            } catch (IOException ex) {
                return false;
            }
        }
    }
    
    public static boolean writeUser(String data, String filename) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            w.write(data);
            w.flush();
            if (w != null)
                w.close();
            return true;
        } catch (Exception e) {
            if (w != null)
                w.close();
            return false;
        }
    }
}
