/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLib;

/**
 *
 * @author Hp
 */
public class MyValidation {
    //////////////////

    /**
     *
     * @param s
     * @param pattern
     * @return true if s matches the pattern given
     */
    public static boolean checkString(String s, String pattern)
    {
        return s.matches(pattern);
    }
    
    /**
     *
     * @param s
     * @param x
     * @return true if s and x is equal
     */
    public static boolean checkEqualString(String s, String x)
    {
        return s.equals(x);
    }
    
    /**
     *
     * @param num
     * @param min
     * @param max
     * @return true if num is in [min, max]
     */
    public static boolean checkIntNumber(int num, int min, int max)
    {
        return num >= min && num <= max;
    }
    
    /**
     *
     * @param num
     * @param max
     * @return true if num is smaller or equal to max
     */
    public static boolean checkIntNumMax(int num, int max)
    {
        return num <= max;
    }
    
    /**
     *
     * @param num
     * @param min
     * @return true if num is equal or bigger than min
     */
    public static boolean checkIntNumMin(int num, int min)
    {
        return num >= min;
    }

    /**
     *
     * @param s
     * @return true if s is an empty string
     */
    public static boolean checkEmptyString(String s)
    {
        return s.isEmpty();
    }
    
    /**
     *
     * @param year
     * @param month
     * @param day
     * @return true if the given date is valid
     */
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
}
