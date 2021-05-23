/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteManagement;

import DAO.FileDAO;
import DTO.Website;
import java.util.HashMap;
import java.util.Set;
import javax.swing.text.View;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class WebsiteManager {
    HashMap<String, Website> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    
    public WebsiteManager()
    {
        list = new HashMap<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadWebsite(inFile);
    }
    
    public void printAll()
    {
        String write = "";
        if (list == null)
            write = "No data to print!";
        else {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                write += key + "@" + list.get(key).getDomainName() + "\n";
            }
        }
        FileDAO.writeData(write, outFile1);
    }
    
    public void printWebsite(String username, String password)
    {
        String write = "No data to print!";
        if (list == null)
            write = "No data to print!";
        else {
            Set<String> sKey = list.keySet();
            for (String key : sKey) {
                Website gValue = list.get(key);
                if (gValue.getUsername().equals(username) && gValue.getPassword().equals(password))
                {
                    write = "domainName=" + gValue.getDomainName() + ", posted date: " + key;
                    break;
                }
            }
            if (write.isEmpty())
                write = "Can't find such a username and password!";
        }
        FileDAO.writeData(write, outFile2);
    }
}
