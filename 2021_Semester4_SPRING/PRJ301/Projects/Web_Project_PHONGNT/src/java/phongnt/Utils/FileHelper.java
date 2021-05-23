/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class FileHelper implements Serializable {
    private static final String URL_LIST_FILE = "/URL_LIST.dat";
    
    public static Map<String, String> getUrlList(ServletContext sc) 
        throws IOException {
//        FileReader f = null;
        InputStream input = null;
        BufferedReader bf = null;
        Map<String, String> urlList = null;
        try {
            input = sc.getResourceAsStream(URL_LIST_FILE);
            if (input != null) {
            bf = new BufferedReader(new InputStreamReader(input));
                while (bf.ready()) {
                    String s = bf.readLine();
                    String [] urlArr = s.split("=");
                    if (urlArr.length == 2) {
                        if (urlList == null) {
                            urlList = new HashMap<>();
                        }
                        urlList.put(urlArr[0], urlArr[1]);
                    }
                }
            }
        } finally {
            if (bf != null) {
                bf.close();
            }
            if (input != null) {
                input.close();
            }
        }
        return urlList;
    }
}
