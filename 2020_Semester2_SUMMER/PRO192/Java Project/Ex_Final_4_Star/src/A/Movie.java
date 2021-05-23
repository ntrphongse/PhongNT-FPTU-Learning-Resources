/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import MyLib.MyValidation;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hp
 */
public class Movie {
    private String title;
    private ArrayList<Star> list;
    
    public Movie()
    {
        title = "";
        list = new ArrayList<>();
    }
    
    public void input()
    {
        boolean nhaptiep = true;
        String name = "";
        String gender = "";
        String title = "";
        do {
            try {
                System.out.println("Enter the title of the movie:");
                title = MyValidation.inputName();
                nhaptiep = false;
            }
            catch (Exception e) {
                System.out.println("Please enter a not-blank title!");
                nhaptiep = true;
            }
        } while (nhaptiep);
        this.title = title;
        
        System.out.println("-----------------------");
        System.out.println("Enter information for 5 stars in the movie!");
        
        for (int i = 1; i <= 5; i++)
        {
            System.out.println("\tStar number " + i);
            nhaptiep = true;
            do {
                try {
                    System.out.println("Enter the name:");
                    name = MyValidation.inputName();
                    nhaptiep = false;
                }
                catch (Exception e) {
                    System.out.println("Please enter a not-blank name!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            nhaptiep = true;
            do {
                try {
                    System.out.println("Enter the gender:");
                    gender = MyValidation.inputGender();
                    nhaptiep = false;
                }
                catch (Exception e) {
                    System.out.println("Please enter male or female!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            list.add(new Star(name, gender));
            System.out.println("\t-----------------------");
        }
    }
    
    public void output()
    {
        
        System.out.println("\tTitle: " + this.title);
        System.out.println("\tStars:");
        System.out.println("Name\t\tGender");
        for (int i = 0; i <= 4; i++)
        {
            System.out.println(list.get(i).getName() + "\t"
                    + "\t" + list.get(i).getGender());
        }
        for (Star star : list) {
            System.out.println(star.getName() + "\t"
                    + "\t" + star.getGender());
            
        }
    }
    
    public void sortByName()
    {
        Collections.sort(list);
    }
}
