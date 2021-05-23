/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicineManager;

import DTO.Medicine;

/**
 *
 * @author Hp
 */
public class Tester {
    public static void main(String[] args) {
        MedicineManager obj = new MedicineManager();
        obj.loadData();
        String mName = "influenza";
        obj.printDiseaseName(new Medicine(mName));
        String dName = "Flu";
        obj.printMedicine(dName);
    }
}
