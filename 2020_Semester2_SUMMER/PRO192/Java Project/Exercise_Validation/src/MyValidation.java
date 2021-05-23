/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class MyValidation {
    public static boolean isValidDate(int year, int month, int day)
    {
        int dayMax = 31;
        if (year <= 0 || month <= 0 || month > 12 || day <= 0)
            return false;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            dayMax = 30;
        else if (month == 2)
        {
            if (year%400 == 0 || (year%4 == 0 && year%100 != 0))
                dayMax = 29;
            else
                dayMax = 28;
        }
        return day <= dayMax;
            
    }
    
    // True: Input parameter contains from 9 to 12 digits
    public static boolean isValidPhoneNumber(String s)
    {
        return isValidString(s, "[0-9]{9,12}");
    }
    
    public static boolean isValidEmail(String s)
    {
        return isValidString(s, "^[a-z][a-z[A-Za-z0-9_.-]+(?:.[A-Za-z0-9!_.-]*)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?.)+[A-Za-z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
    }
    
    // True: Input parameter s matches to pattern
    public static boolean isValidString(String s, String pattern)
    {
        return s.matches(pattern);
    }
    
    // True: Input parameter matches:
    /*
    - Contains a-z
    - Contains A-Z
    - Contains any character: !~@#$%&*()<>-
    - Length from 8-12
    */
    public static boolean isValidPassword(String password)
    {
        return isValidString(password, "^(?=.*[a-z])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,12}$");
    }
}
