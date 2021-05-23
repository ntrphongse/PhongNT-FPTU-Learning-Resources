
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

public class SinhVien extends DanOng {
    // fields
    // Su dung cu phap khai bao bien de khai bao fields
    
    private int ma; // Cu phap: [Kieu du lieu] [Ten bien]
    // private: Che đậy field không muốn người dùng sử dụng trực tiếp
    
    private String ten;
    
    // methods
    
        // constructors  => Gan gia tri ban dau cho cac fields
    
    // Gán chết giá trị mặc định là 0 và ""
    public SinhVien()  // Khong co kieu tra ve // Default constructor
    {
        ma = 0;
        ten = "";
    }
    /*
        Constructors khởi tạo giá trị ban đầu cho các fields sau khi new theo dữ liệu
        thỏa mãn nhu cầu sử dụng.
        Các giá trị mặc định thay đổi theo từng dòng new...
    */
    public SinhVien(int ma, String ten) // constructors with parameters
    {
        this.ma = ma;
        this.ten = ten; 
        // Tên parameter và tên fields trùng nhau ==> Dùng this. để chỉ fields
        
    }
    
    // Cách khác
    public SinhVien(SinhVien SV)
    {
        ma = SV.ma;
        ten = SV.ten;
    }
    
        // getters
    
    // Hàm này trả về thông tin Ma
    int getMa()
    {
        return ma;
    }
    
    String getTen()
    {
        return ten.toUpperCase();
    }
    
    
        // setters
    
    void setTen(String tenmoi)
    {
        if (!tenmoi.isEmpty())
           // or if(!tenmoi.equals(""))
            ten = tenmoi;
    }
    
    void setMa(int mamoi)
    {
        if (mamoi > 0)
            ma = mamoi;
    }
    
        // nhom ham xu li khac
    // Ham nay de nhap ma, ten tu ban phim
    void nhap()
    {
        Scanner sc=new Scanner(System.in); // Moi lan nhap tu BAN PHIM
        // ---------------------------
        // Scanner: Class thu vien
        // sc: bien thu vien / Bien con tro
        // System.in : BAN PHIM ------ System.out: MAN HINH
        // ---------------------------
        
        // Go "sout" Tab
        System.out.println("Nhap ma: ");  // Xuat ra man hinh
        ma = sc.nextInt();
        // nextInt: Nhap so nguyen tu ban phim
        
        sc=new Scanner(System.in); // Tao lai cong cu nhap se xoa ki tu rac
        System.out.println("Nhap ten: ");
        ten = sc.nextLine(); // Nhap Chuoi
    }
    
    // Ham nay de xuat ma, ten ra man hinh
    void xuat()
    {
        System.out.println("Ma: " + ma);
        System.out.println("Ten: " + ten);
    }
    
}
