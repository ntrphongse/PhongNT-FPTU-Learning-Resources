/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoio;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class DemoIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String FileName1 = "fpt2.jpg";
//        String FileName2 = "fake.jpg";
//        byte[] data = demoFileInOutStream.readFile(FileName1);
//        demoFileInOutStream.writeFile(data, FileName2);

//        demoFileInOutStream.writeData(100, 'm', "data.dat");
//        demoFileInOutStream.readData("data.dat");

//          Dog d = new Dog(1, "a");
//          demoFileInOutStream.writeObj(d, "cho.dat");
//          demoFileInOutStream.readObj("cho.dat");

            /*
            ArrayList<Dog> list = new ArrayList<>();
            list.add(new Dog(1, "a"));
            list.add(new Dog(2, "b"));
            demoFileInOutStream.writeObj(list, "ds.dat");
            ArrayList<Dog> kq = demoFileInOutStream.readObj2("ds.dat");
            System.out.println(kq);
            */
            
            String name = "E:\\FPTU\\2020_Semester2_SUMMER\\PRO192\\Java Project\\demoIO";
            demoFileInOutStream.getProperties(name);
    }
    
}
