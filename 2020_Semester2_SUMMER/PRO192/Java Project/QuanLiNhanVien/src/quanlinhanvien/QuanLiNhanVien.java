/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlinhanvien;

import DTO.NVKeToan;
import DTO.NVTaiChinh;
import DTO.NhanVien;
import Manager.DSNhanVien;
import Validation.MyValidation;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class QuanLiNhanVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice=0;
        boolean nhaptiep = true;
        
        DSNhanVien obj=new DSNhanVien();
        do
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("1. Them 1 nhan vien moi");
            System.out.println("2. Xuat DS NV");
            System.out.println("3. Tim kiem NV dua vao Ma");
            System.out.println("4. Xuat Bao Cao");
            System.out.println("5. Chinh sua Thong tin NV");
            System.out.println("6. Xoa NV dua vao ma");
            System.out.println("7. Sap xep theo ten");
            System.out.println("8. Thoat");
            System.out.println("nhap choice:");
            try
            {
                
                choice=sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Vui long nhap so tu 1 den 8!");
                nhaptiep = true;
            }
            switch(choice)
            {
                case 1:
                    System.out.println("1.1 Them NV tai chinh");
                    System.out.println("1.2 them NV ke toan");
                    System.out.println("nhap lua chon:");
                    int loaiNV = 1;
                    nhaptiep = true;
                    do
                    {
                        try {
                            loaiNV = MyValidation.inputIntNumber(1, 2);
                            nhaptiep = false;
                        } catch (Exception ex) {
                            System.out.println("Chi nhap 1 hoac 2!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    NhanVien x=null;
                    if(loaiNV==1)
                    {
                        x=new NVTaiChinh();
                        x.input();
                    }
                    else 
                    {
                        x=new NVKeToan();
                        x.input();
                    }
                    boolean kq = obj.themNV(x);
                    if (kq)
                        System.out.println("Added!");
                    else
                        System.out.println("Falied to add!");
                    break;
                  
                case 2:
                    obj.xuatDSNV();
                    break;
                    
                case 3:
                    System.out.println("Nhap ma nhan vien can tim: ");
                    int maNVcantim = 1;
                    nhaptiep = true;
                    do {
                        try {
                            maNVcantim = MyValidation.inputIntNumber(1, 1000);
                            nhaptiep = false;
                        } catch (Exception ex) {
                            System.out.println("Vui long nhap ma nhan vien tu 1 den 1000!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
//                    int pos = obj.timkiemNVByMa(sc.nextInt());
//                    if (pos == -1)
//                        System.out.println("Khong ton tai nhan vien!");
//                    else
//                    {
//                        System.out.println("Nhan vien ton tai tai vi tri = " + pos);
//                        NhanVien[] tmp = obj.getList();
//                        tmp[pos].output();
//                    }
                    NhanVien iKq = obj.getNVbyMa(maNVcantim);
                    if (iKq != null)
                        iKq.output();
                    break;
                    
                case 5:
                    System.out.println("Nhap ma Nhan Vien can sua: ");
                    int maNVcansua = 1;
                    nhaptiep = true;
                    do {
                        try {
                            maNVcansua = MyValidation.inputIntNumber(1, 1000);
                            nhaptiep = false;
                        } catch (Exception ex) {
                            System.out.println("Vui long nhap ma nhan vien tu 1 den 1000!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    NhanVien kq5 = obj.suaThongTin(maNVcansua);
                    if (kq5 != null)
                    {
                        System.out.println("Day la nhan vien vua sua: ");
                        kq5.output();
                    }
                    else
                        System.out.println("Khong tim thay Nhan vien");
                        
                    break;
                    
                case 6:
                    System.out.println("Nhap ma Nhan Vien can xoa: ");
                    int maNVcanxoa = 1;
                    nhaptiep = true;
                    do {
                        try {
                            maNVcanxoa = MyValidation.inputIntNumber(1, 1000);
                            nhaptiep = false;
                        } catch (Exception ex) {
                            System.out.println("Vui long nhap ma nhan vien tu 1 den 1000!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    NhanVien kq6 = obj.xoaNhanVien(maNVcanxoa);
                    if (kq6 == null)
                        System.out.println("Khong tim thay NV de xoa!");
                    else
                    {
                        System.out.println("Xoa thanh cong!");
                        kq6.output();
                    }
                    break;
                    
                case 7:
                    obj.sapxep();
                    System.out.println("Ket qua sap xep theo ten:");
                    obj.xuatDSNV();
                    break;
                    
                case 8:
                    nhaptiep = false;
                    break;
            }
        }
        while(choice != 8 || nhaptiep == true);
    }
    
}
