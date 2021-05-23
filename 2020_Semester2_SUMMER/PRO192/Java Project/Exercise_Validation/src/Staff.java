
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
public class Staff {
    String id;
    String name;
    String email;
    String phone;
    String password;
    String DoB;
    int salary;

    public Staff() {
        id = "";
        name = "";
        email = "";
        phone = "";
        password = "";
        DoB = "";
        salary = 0;
    }

    public Staff(String id, String name, String email, String phone, String password, String DoB, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.DoB = DoB;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (MyValidation.isValidString(id, "S[ESB]{1}[0-9]{3,5}"))
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (MyValidation.isValidString(name, "^([a-z]|[A-Z])[^0-9]*?([a-z]|[A-Z])$"))
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (MyValidation.isValidEmail(email))
            this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (MyValidation.isValidPhoneNumber(phone))
            this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (MyValidation.isValidPassword(password))
            this.password = password;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(int year, int month, int day) {
        if (MyValidation.isValidDate(year, month, day))
            this.DoB = year + "\\" + month + "\\" + day;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary > 0)
            this.salary = salary;
    }
    
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        // id
        String iId;
        do
        {
            System.out.println("Enter ID: ");
            sc = new Scanner(System.in);
            iId = sc.nextLine();
            if (MyValidation.isValidString(iId, "S[ESB]{1}[0-9]{3,5}"))
                setId(iId);
            else
                System.out.println("Wrong format for ID! Please enter again!");
        } while (!MyValidation.isValidString(iId, "S[ESB]{1}[0-9]{3,5}"));
        System.out.println("");
        // name
        String iName;
        do
        {
            System.out.println("Enter Name:");
            sc = new Scanner(System.in);
            iName = sc.nextLine();
            if (MyValidation.isValidString(iName, "[A-Z][a-zA-Z][^#!&<>\\\"~;$^%{}?]{1,30}$"))
                setName(iName);
            else
                System.out.println("Wrong format for Name! Please enter again!");
        } while (!MyValidation.isValidString(iName, "[A-Z][a-zA-Z][^#!&<>\\\"~;$^%{}?]{1,30}$"));
        System.out.println("");
        // email
        String iEmail;
        do
        {
            System.out.println("Enter Email:");
            sc = new Scanner(System.in);
            iEmail = sc.nextLine();
            if (MyValidation.isValidEmail(iEmail))
                setEmail(iEmail);
            else
                System.out.println("Wrong format for Email! Please enter again!");
        } while (!MyValidation.isValidEmail(iEmail));
        System.out.println("");
        //phone
        String iPhone;
        do
        {
            System.out.println("Enter Phone Number:");
            sc = new Scanner(System.in);
            iPhone = sc.nextLine();
            if (MyValidation.isValidPhoneNumber(iPhone))
                setPhone(iPhone);
            else
                System.out.println("Wrong format for Phone Number! Please enter again!");
        } while (!MyValidation.isValidPhoneNumber(iPhone));
        System.out.println("");
        // password
        String iPass;
        do
        {
            System.out.println("Enter Password: ");
            sc = new Scanner(System.in);
            iPass = sc.nextLine();
            if (MyValidation.isValidPassword(iPass))
                setPassword(iPass);
            else
                System.out.println("Wrong format for Password! Please enter again!");
        } while (!MyValidation.isValidPassword(iPass));
        System.out.println("");
        // DoB
        int day, month, year;
        sc = new Scanner(System.in);
        do
        {
            System.out.println("Enter Date of Birth:");
            System.out.println("\tEnter the day: ");
            day = sc.nextInt();
            System.out.println("\tEnter the month: ");
            month = sc.nextInt();
            System.out.println("\tEnter the year: ");
            year = sc.nextInt();
            if (MyValidation.isValidDate(year, month, day))
                setDoB(year, month, day);
            else
                System.out.println("Please enter a Valid Date!");
        } while (!MyValidation.isValidDate(year, month, day));
        System.out.println("");
        // Salary
        int iSalary;
        do
        {
            System.out.println("Enter Salary: ");
            iSalary = sc.nextInt();
            if (iSalary > 0)
                setSalary(iSalary);
            else
                System.out.println("Please enter a Valid Salary!");
        } while (iSalary <= 0);
    }

    @Override
    public String toString() {
        return "ID\t\tNAME\t\tEMAIL\t\t\t\tPHONE\t\tPASSWORD\t\tDoB\t\tSalary\n"
              + getId()+"\t\t"+getName()+"\t\t"+getEmail()+"\t\t"+getPhone()+"\t\t"+getPassword()+"\t\t"+getDoB()+"\t\t"+getSalary();
    }
    
}
