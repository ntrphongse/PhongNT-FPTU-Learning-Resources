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
public class NVTaiChinh extends NhanVien{
    int trocap;

    public NVTaiChinh() {
        super();
        trocap=0;
    }

    public NVTaiChinh(int trocap, int ma, String ten, int luongCB, int ngayLV) {
        super(ma, ten, luongCB, ngayLV);
        try
        {
            if (!MyValidation.checkIntNumber(trocap, 50000, 5000000))
                throw new Exception("Tro cap chi tu 50000 den 5000000!");
            this.trocap = trocap;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public int getTrocap() {
        return trocap;
    }

    public void setTrocap(int trocap) throws Exception {
        if (!MyValidation.checkIntNumber(trocap, 50000, 5000000))
            throw new Exception("Tro cap chi tu 50000 den 5000000!");
        this.trocap = trocap;
    }

    @Override
    public void input() {
        super.input(); 
        boolean nhaptiep = true;
        do
        {
            try
            {
                System.out.println("Nhap tro cap:"); // max: 50000 - 5000000
                trocap = MyValidation.inputIntNumber(5000, 5000000);
                nhaptiep = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Vui long nhap tro cap so nguyen tu 5000 den 5000000!");
                nhaptiep = true;
            }
            catch (Exception e)
            {
                System.out.println("Tro cap chi tu 50000 den 5000000!");
                nhaptiep = true;
            }
        } while (nhaptiep);
    }

    @Override
    public void output() {
        super.output(); 
        System.out.println("tro cap:"+ trocap);
    }

    @Override
    public void xepHangNV() {
        if (trocap <= 100000)
            System.out.println("NV thuong");
        else
            System.out.println("CEO");
    }
    
}
