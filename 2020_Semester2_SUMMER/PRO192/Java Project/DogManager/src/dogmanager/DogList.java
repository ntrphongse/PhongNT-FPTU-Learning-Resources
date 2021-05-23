/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogmanager;

import DTO.Dog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Hp
 */

// Dùng thư viện của COLLECTION để quản lí danh sách các Dog
public class DogList {
//    Dog[] list;
//    int n;
    ArrayList<Dog> list;
    
    public DogList()
    {
        list = new ArrayList<>();
    }
    
    // Thêm một con chó mới vào list
    public void addDog(Dog x)
    {
        list.add(x);
    }
    
    // Xuất các con chó trong list
    public void displayAll()
    {
        // Cach 1
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        
        // Cach 2: Dung iterrator
        if (!list.isEmpty())
            for (Dog dog : list) {
                System.out.println(dog);
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
    
    // Sắp xếp list theo name
    public void sortByName()
    {
        Collections.sort(list);
    }
    
    // Sắp xếp list theo ma
    public void sortById()
    {
        Collections.sort(list, Dog.basedID);
    }
    
    // Chỉnh sửa
    public Dog editById(int id)
    {
        int index = -1;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getId() == id)
            {
                index = i;
                break;
            }
        if (index == -1) return null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new id: ");
        int nId = sc.nextInt();

        sc = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String nName = sc.nextLine();
        Dog nDog = new Dog(nId, nName);
        if (list.set(index, nDog) != null)
            return list.get(index);
        else
            return null;
    }
    
    // Xóa
    public boolean deleteById(int id)
    {
        Dog sdResult = findDog(id);
        if (sdResult == null)
            return false;
        return list.remove(sdResult);
    }
}
