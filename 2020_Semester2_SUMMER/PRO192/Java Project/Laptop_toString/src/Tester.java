
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
public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        
        sc = new Scanner(System.in);
        System.out.println("Enter CPU generation:");
        int gen = sc.nextInt();
        
        sc = new Scanner(System.in);
        System.out.println("Enter Screen size:");
        float size = sc.nextFloat();
        
        sc = new Scanner(System.in);
        System.out.println("Enter Serial (0 - 9, Enter after each number):");
        int[] serial = new int[9];
        for (int i = 0; i <= 8; i++)
            serial[i] = sc.nextInt();
        
        Laptop lap = new Laptop(name, size, gen, serial);
        System.out.println("");
        System.out.println(lap);
    }
}
