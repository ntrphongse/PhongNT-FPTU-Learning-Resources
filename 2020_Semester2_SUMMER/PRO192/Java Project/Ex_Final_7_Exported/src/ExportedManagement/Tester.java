/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportedManagement;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        ExportedGoodManager obj = new ExportedGoodManager();
        obj.loadData();
        String goodName1 = "chemicals";
        obj.printCountries(goodName1);
        String goodName2 = "seafood";
        obj.CountCountry(goodName2);
    }
}
