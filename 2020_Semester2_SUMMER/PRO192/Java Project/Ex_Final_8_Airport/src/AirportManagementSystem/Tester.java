/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirportManagementSystem;

import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        boolean nhaptiep = true;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        AirportManager obj = new AirportManager();
        obj.loadData();
        obj.printCountries();
        obj.LargesAirport();
    }
}
