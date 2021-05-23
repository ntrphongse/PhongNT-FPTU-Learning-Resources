/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WordManagement;

import DAO.FileDAO;
import java.util.TreeSet;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class WordManager {
    TreeSet<String> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    
    public WordManager()
    {
        list = new TreeSet<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadWord(inFile);
    }
    
    public void getSuggestion(String prefix)
    {
        String write = "";
        if (list.isEmpty())
            write = "No data to progress!";
        else
        {
            for (String word : list) {
                if (word.toLowerCase().startsWith(prefix.toLowerCase()))
                    write += word + ", ";
            }
            if (!write.isEmpty())
                write = write.substring(0, write.length() - 2);
        }
        if (FileDAO.writeData(write, outFile1))
            System.out.println("Print out the words that begin with \"" + prefix + "\" to the file \"" + outFile1 + "\" successfully!");
        else
            System.out.println("Failed to print out!");
    }
    
    public void printWordLength()
    {
        String write = "";
        if (list.isEmpty())
            write = "No data to progress!";
        else
        {
            for (String word : list) {
                write += String.format("%-20s%s\n", word, word.length());
            }
            if (!write.isEmpty())
                write = write.substring(0, write.length() - 1);
        }
        if (FileDAO.writeData(write, outFile2))
            System.out.println("Print out the words and their length to the file \"" + outFile2 + "\" successfully!");
        else
            System.out.println("Failed to print out!");
    }
}
