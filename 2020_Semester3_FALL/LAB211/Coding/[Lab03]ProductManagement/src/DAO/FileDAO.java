/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Core.Category;
import Core.Product;
import List.CategoryList;
import List.ProductList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileDAO {
    public static CategoryList loadCategory(String fileName) {
        File f = new File(fileName);
        FileReader fr = null;
        BufferedReader bf = null;
        if (!f.exists()) {
            System.out.println("File does not exist!");
            return null;
        }
        try {
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            CategoryList cateList = new CategoryList();
            while (bf.ready()) {
                String cateInfo = bf.readLine();
                String[] iCateInfo = cateInfo.split(",");
                if (iCateInfo.length == 2) {
                    String id = iCateInfo[0];
                    String name = iCateInfo[1];
                    Category nCate = new Category(id, name);
                    cateList.addCategory(nCate);
                }
            }
            if (fr != null)
                fr.close();
            if (bf != null)
                bf.close();
            return cateList;
        } catch (Exception e) {
            try {
                if (fr != null)
                    fr.close();
                if (bf != null)
                    bf.close();
            } catch (Exception ex) {
                return null;
            }
            return null;
        }
    }
    
    public static ProductList loadProduct(String fileName, CategoryList categoryList) {
        File f = new File(fileName);
        FileReader fr = null;
        BufferedReader bf = null;
        if (!f.exists()) {
            System.out.println("File does not exist!");
            System.exit(0);
        }
        try {
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            ProductList proList = new ProductList(categoryList);
            while (bf.ready()) {
                String proInfo = bf.readLine();
                String[] iProInfo = proInfo.split(",");
                if (iProInfo.length == 5) {
                    String id = iProInfo[0];
                    String name = iProInfo[1];
                    double price = Double.parseDouble(iProInfo[2]);
                    int quantity = Integer.parseInt(iProInfo[3]);
                    String cateID = iProInfo[4];
                    if (categoryList.searchCategory(cateID) != null) {
                        Product nPro = new Product(id, name, price, quantity, cateID);
                        proList.addProduct(nPro);  
                    }              
                }
            }
            if (fr != null)
                fr.close();
            if (bf != null)
                bf.close();
            return proList;
        } catch (Exception e) {
            try {
                if (fr != null)
                    fr.close();
                if (bf != null)
                    bf.close();
            } catch (Exception ex) {
                return null;
            }
            return null;
        }
    }
    
    public static boolean saveCategory(String fileName, CategoryList cateList) {
        File f = new File(fileName);
        PrintWriter w = null;
        if (!f.exists()) {
            System.out.println("File does not exist!");
            System.exit(0);
        }
        try {
            w = new PrintWriter(f);
            w.write(cateList.toString());
            w.flush();
            if (w != null)
                w.close();
            return true;
        } catch (Exception e) {
            try {
                if (w != null)
                    w.close();
            } catch (Exception ex) {
                return false;
            }
            return false;
        }
    }
    
    public static boolean saveProduct(String fileName, ProductList proList) {
        File f = new File(fileName);
        PrintWriter w = null;
        if (!f.exists()) {
            System.out.println("File does not exist!");
            System.exit(0);
        }
        try {
            w = new PrintWriter(f);
            w.write(proList.toString());
            w.flush();
            if (w != null)
                w.close();
            return true;
        } catch (Exception e) {
            try {
                if (w != null)
                    w.close();
            } catch (Exception ex) {
                return false;
            }
            return false;
        }
    }
}