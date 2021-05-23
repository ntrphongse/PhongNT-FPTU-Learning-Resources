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
public abstract class NhanVien {
     int ma;
     String ten;
     int luongCB;
     int ngayLV;

    public NhanVien() {
        ma=0;
        ten="";
        luongCB=0;
        ngayLV=0;
    }

    public NhanVien(int ma, String ten, int luongCB, int ngayLV) {
        try {
            if (!MyValidation.checkIntNumber(ma, 1, 1000))
                throw new Exception("Ma chi duoc trong pham vi tu 1 den 1000!");
            if (!MyValidation.checkString(ten, "^[a-zA-Z]+((\\s)[a-zA-Z]+)*$"))
                throw new Exception("Sai ten!");
            if (!MyValidation.checkIntNumber(luongCB, 1000, 100000))
                throw new Exception("Luong co ban chi tu 1000 den 100000!");
            if (!MyValidation.checkIntNumber(ngayLV, 1, 30))
                throw new Exception("Ngay lam viec tu 1 den 30!");
            this.ma = ma;
            this.ten = ten;
            this.luongCB = luongCB;
            this.ngayLV = ngayLV;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) throws Exception{
        if (!MyValidation.checkIntNumber(ma, 1, 1000))
            throw new Exception("Ma chi duoc trong pham vi tu 1 den 1000!");
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) throws Exception {
        if (!MyValidation.checkString(ten, "^[a-zA-Z]+((\\s)[a-zA-Z]+)*$"))
            throw new Exception("Sai ten. Vui long nhap lai!");
        this.ten = ten;        
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) throws Exception {
        if (!MyValidation.checkIntNumber(luongCB, 1000, 100000))
            throw new Exception("Vui long nhap luong co ban chi tu 1000 den 100000!");
        this.luongCB = luongCB;
    }

    public int getNgayLV() {
        return ngayLV;
    }

    public void setNgayLV(int ngayLV) throws Exception {
        if (!MyValidation.checkIntNumber(ngayLV, 1, 30))
            throw new Exception("Vui long nhap ngay lam viec tu 1 den 30!");
        this.ngayLV = ngayLV;
    }
    public void output()
    {
        System.out.println("ma:"+ ma);
        System.out.println("ten:" + ten);
        System.out.println("luongCB:"+ luongCB);
        System.out.println("ngayLV:"+ ngayLV);
    }
    public void input()
    {
        Scanner sc=new Scanner(System.in);
        boolean nhaptiep = true;
        do {
            try {
                System.out.println("nhap ma:");
                ma=MyValidation.inputIntNumber(1, 1000);
                nhaptiep = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Vui long nhap so nguyen!\n");
                nhaptiep = true;
            }
            catch (Exception e)
            {
                System.out.println("Vui long nhap so trong khoang tu 1 den 1000!\n");
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        do {
            try {
                System.out.println("Nhap ten:");
                ten = MyValidation.inputString("^[a-zA-Z]+((\\s)[a-zA-Z]+)*$");
                nhaptiep = false;
            }
            catch (Exception e)
            {
                System.out.println("Ten sai. Vui long nhap lai!\n");
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        do {
            try {
                System.out.println("Nhap luong co ban: ");
                luongCB = MyValidation.inputIntNumber(1000, 100000);
                nhaptiep = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Vui long nhap so nguyen!\n");
                nhaptiep = true;
            }
            catch (Exception e)
            {
                System.out.println("Luong CB chi tu 1000 - 100000! Vui long nhap lai.");
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        do
        {
            try {
                System.out.println("Nhap so ngay lam viec: ");
                ngayLV = MyValidation.inputIntNumber(1,30);
                nhaptiep = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Vui long nhap so nguyen tu 1 den 30!\n");
                nhaptiep = true;
            }
            catch (Exception e)
            {
                System.out.println("Ngay lam viec chi tu 1 - 30! Vui long nhap lai.");
                nhaptiep = true;                
            }
        } while (nhaptiep);
    }
    
    // Hàm này để xếp hạng Nhân viên dựa vào thông tin như Trợ cấp / Năm Kinh nghiệm
    public abstract void xepHangNV();
}
