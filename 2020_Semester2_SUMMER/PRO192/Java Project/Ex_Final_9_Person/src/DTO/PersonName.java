/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class PersonName {
    String name;
    String gender;
    int numberUsedPerson;

    public PersonName(String name, String gender, int numberUsedPerson) {
        this.name = name;
        this.gender = gender;
        this.numberUsedPerson = numberUsedPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumberUsedPerson() {
        return numberUsedPerson;
    }

    public void setNumberUsedPerson(int numberUsedPerson) {
        this.numberUsedPerson = numberUsedPerson;
    }

    @Override
    public String toString() {
        return "PersonName{" + "name=" + name + ", gender=" + gender + ", numberUsedPerson=" + numberUsedPerson + '}';
    }
    
    
}
