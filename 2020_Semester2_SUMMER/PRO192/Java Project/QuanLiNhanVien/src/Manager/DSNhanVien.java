/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.NVKeToan;
import DTO.NVTaiChinh;
import DTO.NhanVien;
import Validation.MyValidation;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Hp
 */
public class DSNhanVien {
    NhanVien[] list;
    int n;
    final int MAX = 100;
    
    public DSNhanVien() {
        // Mảng muốn xài phải NEW
        list = new NhanVien[MAX]; // List là 1 con trỏ đang trỏ tới ô đầu tiên trong mảng
        n = 0;
    }

    public DSNhanVien(NhanVien[] list, int n) {
        try {
            if (list == null)
                throw new Exception("List bi null");
            this.list = list; // list != null
            this.n = n;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public NhanVien[] getList() {
        return list;
    }

    public void setList(NhanVien[] list) {
        try {
            if (list == null)
                throw new Exception("List bi null");
            this.list = list;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    // Hàm này để thêm 1 nhân viên mới vào list
    /*
    Input: Nhân viên cần thêm
    Output > True: Thêm thành công / False: Thêm thất bại
    
    */
    public boolean themNV(NhanVien x)
    {
        boolean result = false;
        try
        {
            if (x == null)
                throw new Exception("Nhan Vien chua duoc khoi tao!");
            if (n >= MAX)
                throw new Exception("Da qua so nhan vien toi da!");
            list[n] = x;
            n++;
            result = true;
        }
        catch (Exception e)
        {
            result = false;
        }
        return result;
    }
    
    // Hàm này để xuất thông tin các nhân viên đang chứa trong list
    public void xuatDSNV()
    {
        for (int i = 0; i < n; i++)
        {
            list[i].output();
        }
    }
    
    // Hàm này chỉ in NHÂN VIÊN TÀI CHÍNH
    public void xuatDSNVTaiChinh()
    {
        for (int i = 0; i < n; i++)
        {
            if (list[i] instanceof NVTaiChinh)
                list[i].output();
            
        }
    }
    
    // Hàm này để tìm VỊ TRÍ nhân viên trong list
    /*
    Input: maNV
    Output: Vị trí tìm thấy
    */
    public int timkiemNVByMa(int maNVcantim)
    {
        for (int i = 0; i < n; i++)
            if (list[i].getMa() == maNVcantim)
                return i;
        return -1;
    }
    
    // Hàm này để tìm địa chỉ bộ nhớ của Nhân viên trong list
    /*
    Input: maNVcantim
    Output: Địa chỉ bộ nhớ của nhân viên tìm thấy / NULL
    */
    public NhanVien getNVbyMa(int maNVcantim)
    {
        for (int i = 0; i < n; i++)
            if (list[i].getMa() == maNVcantim)
                return list[i];
        return null;
    }
    
    // Hàm này để chỉnh sửa thông tin Nhân viên
    /*
    Input: maNVcansua
    Output: Địa chỉ Nhân viên đã sửa
    */
    public NhanVien suaThongTin(int maNVcansua)
    {
        NhanVien kq = getNVbyMa(maNVcansua);
        if (kq == null)
            return null;
        
        Scanner sc = new Scanner(System.in);
        
        boolean nhaptiep = true;
        do
        {
            try {
                System.out.println("Nhap ten moi: ");
                kq.setTen(sc.nextLine());
                nhaptiep = false;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        do
        {
            try
            {
                System.out.println("Nhap luong can ban moi: ");
                kq.setLuongCB(sc.nextInt());
                nhaptiep = false;
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        do
        {
            try
            {
                System.out.println("Nhap ngay lam viec moi: ");
                kq.setNgayLV(sc.nextInt());
                nhaptiep = false;
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                nhaptiep = true;
            }
        } while (nhaptiep);
        
        nhaptiep = true;
        if (kq instanceof NVTaiChinh)
        {
            do {
                try
                {
                    System.out.println("Nhap tro cap moi: ");
                    ((NVTaiChinh) kq).setTrocap(sc.nextInt());
                    nhaptiep = false;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
        }
        else if (kq instanceof NVKeToan)
        {
            do
            {
                try
                {
                    System.out.println("Nhap nam kinh nghiem moi: ");
                    ((NVKeToan) kq).setNamKN(sc.nextInt());
                    nhaptiep = false;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    nhaptiep = true;
                }
            } while (nhaptiep);
        }
        return kq;
    }
    
    // Hàm này để xóa Nhân viên ra khỏi list
    /*
    Input: maNVcanxoa
    Output: Địa chỉ của Nhân viên bị xóa
    */
    public NhanVien xoaNhanVien(int maNVcanxoa)
    {
        int pos = timkiemNVByMa(maNVcanxoa);
        if (pos == -1)
            return null;
        NhanVien tmp = list[pos];
        for (int i = pos; i < n; i++)
            list[pos] = list[pos + 1];
        n--;
        return tmp;
    }
    
    // Hàm này để sắp xếp tăng dần theo Tên
    public void sapxep()
    {
        for (int i = 0; i < n-1; i++)
            for (int j = n-1; j > i; j--)
                if (list[j].getTen().compareTo(list[j-1].getTen()) < 0)
                {
                    NhanVien tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
    }
}
