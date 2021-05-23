/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Listener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import phongnt.Utils.FileHelper;

/**
 * Web application lifecycle listener.
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Map<String, String> urlList = FileHelper.getUrlList(sce.getServletContext());
            sce.getServletContext().setAttribute("URL_LIST", urlList);
        } catch (IOException ex) {
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
