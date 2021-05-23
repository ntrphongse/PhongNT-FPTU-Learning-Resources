/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebsiteManagement;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        WebsiteManager obj = new WebsiteManager();
        obj.loadData();
        obj.printAll();
        obj.printWebsite("John", "9999");
    }
}
