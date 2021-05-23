/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Validation.MyValidation;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class NVKeToan extends NhanVien{
    int namKN;

    public NVKeToan() {
        super();
        namKN=0;
    }

    public NVKeToan(int namKN, int ma, String ten, int luongCB, int ngayLV) {
        super(ma, ten, luongCB, ngayLV);
        try {
            if (!MyValidation.checkIntNumber(namKN, 0, 60))
                throw new Exception("Nam kinh nghiem chi tu 0 den 60 nam!");
            this.namKN = namKN;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    public int getNamKN() {
        return namKN;
    }

    public void setNamKN(int namKN) throws Exception {
        if (!MyValidation.checkIntNumber(namKN, 0, 60))
            throw new Exception("Nam kinh nghiem chi tu 0 den 60 nam!");
        this.namKN = namKN;
    }

    @Override
    public void input() {
        super.input(); 
        boolean nhaptiep = true;
        do {
            try {
                System.out.println("nhap nam kn:"); // max: 60 năm
                namKN = MyValidation.inputIntNumber(0, 60);
                nhaptiep = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Vui long nhap so nguyen nam kinh nghiem tu 0 den 60 nam!");
                nhaptiep = true;
            }
            catch (Exception e){
                System.out.println("Vui long nhap nam Kinh nghiem tu 0 den 60 nam!");
                nhaptiep = true;
            }
        } while (nhaptiep);
               
    }

    @Override
    public void output() {
        super.output(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("nam kn:"+ namKN);
    }

    @Override
    public void xepHangNV() {
        if (namKN >= 1 && namKN <= 5)
            System.out.println("NV binh thuong thoi!");
        else
            System.out.println("Trum cuoi!");
    }
    
}
