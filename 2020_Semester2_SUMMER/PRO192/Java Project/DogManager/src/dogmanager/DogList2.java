/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogmanager;

import DTO.Dog;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Hp
 */
public class DogList2 {
    TreeSet<Dog> list;
    
    public DogList2()
    {
        list = new TreeSet<>();
    }
    
    // Thêm một con chó mới vào list
    public void addDog(Dog x)
    {
        list.add(x);
        // Nếu tên trùng nhau thì phần tử sau sẽ được bỏ qua!
    }
    
    // Xuất các con chó trong list
    public void displayAll()
    {        
        // Cach 1: Dung iterrator
        // Duyệt LNR theo tên
        if (!list.isEmpty())
            for (Dog dog : list) {
                System.out.println(dog);
            }
        
        // Cach 1+ (LNR)
        Iterator<Dog> tmp = list.iterator();
        while (tmp.hasNext())
        {
            Dog x = tmp.next();
            // Đọc và di chuyển con trỏ tmp tới node tiếp theo
            System.out.println(x);
        }
        
    }
    
    // Xuất danh sách giảm dần
    public void displayDecDog()
    {
        Iterator<Dog> tmp = list.descendingIterator();
        while (tmp.hasNext())
        {
            Dog x = tmp.next();
            System.out.println(x);
        }
    }
    
    // Tìm 1 con chó dựa vào mã
    public Dog findDog(int id)
    {
        if (list.isEmpty()) return null;
        for (Dog dog : list) {
            if (dog.getId() == id)
                return dog;
        }
        return null;
    }
}
