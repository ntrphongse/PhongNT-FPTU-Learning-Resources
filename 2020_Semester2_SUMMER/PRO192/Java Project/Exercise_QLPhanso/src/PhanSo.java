
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class PhanSo {
    // fields
    int tu;
    int mau;
    
    // constructors
    public PhanSo()
    {
        tu = 0;
        mau = -1;
    }
    public PhanSo(int tu, int mau)
    {
        this.tu = tu;
        this.mau = mau;
    }
    
    // setters
    public void setTu(int tu)
    {
        this.tu = tu;
    }
    
    public void setMau(int mau)
    {
        this.mau = mau;
    }
    
    // getters
    public int getTu()
    {
        return tu;
    }
    
    public int getMau()
    {
        return mau;
    }
    
    // Ham xu ly khac
    void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tu: ");
        tu = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Nhap mau: ");
        mau = sc.nextInt();
    }
    
    void xuat()
    {
        System.out.println(tu + "/" + mau);
    }
    
    // Ham cong
    PhanSo cong(PhanSo B)
    {
        int tukq = tu*B.mau + mau*B.tu;
        int maukq = mau*B.mau;
        PhanSo C = new PhanSo();
        C.tu = tukq;
        C.mau = maukq;
        return C;
    }
    
    // Ham tru
    PhanSo tru(PhanSo B)
    {
        int tukq = tu*B.mau - mau*B.tu;
        int maukq = mau*B.mau;
        PhanSo C = new PhanSo();
        C.tu = tukq;
        C.mau = maukq;
        return C;
    }
    
    PhanSo nhan(PhanSo B)
    {
        int tukq = tu*B.tu;
        int maukq = mau*B.mau;
        PhanSo C = new PhanSo();
        C.tu = tukq;
        C.mau = maukq;
        return C;
    }
    
    PhanSo chia(PhanSo B)
    {
        int tukq = tu*B.mau;
        int maukq = mau*B.tu;
        PhanSo C = new PhanSo();
        C.tu = tukq;
        C.mau = maukq;
        return C;
    }
}
