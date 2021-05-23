/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonManager;

import DAO.FileDAO;
import DTO.PersonName;
import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class PersonManager {
    ArrayList<PersonName> list;
    final String inFile = "in.txt";
    final String outFile1 = "out1.txt";
    final String outFile2 = "out2.txt";
    public PersonManager()
    {
        list = new ArrayList<>();
    }
    
    public void loadData()
    {
        list = FileDAO.loadPerson(inFile);
    }
    
    public void printName()
    {
        String write = "";
        if (list.isEmpty())
            write = "No such data to write!";
        else
        {
            int maxMale = 0, maxFemale = 0;
            String male = ""; String female = "";
            for (PersonName personName : list) {
                if (personName.getGender().equals("M") && personName.getNumberUsedPerson() > maxMale)
                    {
                        maxMale = personName.getNumberUsedPerson();
                        male = personName.getName();
                    }
                else if (personName.getGender().equals("F") && personName.getNumberUsedPerson() > maxFemale)
                    if (personName.getNumberUsedPerson() > maxFemale)
                    {
                        maxFemale = personName.getNumberUsedPerson();
                        female = personName.getName();
                    }
            }
            System.out.println(female);
            write = male + ", " + female;
        }
        if (FileDAO.writeData(write, outFile1))
            System.out.println("Print the name that is the most popular name for male and female successfully!");
        else
            System.out.println("Error to Print the name that is the most popular name for male and female!");
    }
    
    public void Increase(String name)
    {
        String write = "";
        for (PersonName personName : list) {
            if (personName.getName().equalsIgnoreCase(name))
            {
                int sNum = personName.getNumberUsedPerson() + 1;
                personName.setNumberUsedPerson(sNum);
                write = personName.getName() + " - " + personName.getGender() + " - "
                        + personName.getNumberUsedPerson() 
                        + " (" + personName.getNumberUsedPerson() + " = "
                        + (personName.getNumberUsedPerson() - 1) + " + 1)";
                break;
            }
        }
        if (write.isEmpty())
            write = "No such a name in the list to increase!";
        if (FileDAO.writeData(write, outFile2))
            System.out.println("Increase successfully!");
        else
            System.out.println("Failed to increase!");
    }
}
