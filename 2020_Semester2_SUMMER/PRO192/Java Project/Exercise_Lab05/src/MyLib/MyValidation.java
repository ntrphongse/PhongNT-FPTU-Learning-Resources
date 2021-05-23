/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLib;

import PkgBasic.Book;
import PkgExtend.BookList;

/**
 *
 * @author Hp
 */
public class MyValidation {
    public static boolean checkCode(String Code)
    {
        return checkString(Code, "^B[0-9]*[0-9]$");
    }
    
    public static boolean checkType(String type)
    {
        return checkString(type, "physical|mathematic|chemistry");
    }
    
    public static boolean checkUniqueCode(BookList obj, String Code)
    {
        int cCount = obj.getCount();
        Book[] arr = obj.getArr();
        for (int i = 0; i < cCount; i++)
            if (checkEqualString(Code, arr[i].getCode()))
                return false;
        return true;
    }
    
    //////////////////
    public static boolean checkString(String s, String pattern)
    {
        return s.matches(pattern);
    }
    
    public static boolean checkEqualString(String s, String x)
    {
        return s.equals(x);
    }
    
    public static boolean checkIntNumber(int num, int min, int max)
    {
        return num >= min && num <= max;
    }
    
    public static boolean checkIntNumMax(int num, int max)
    {
        return num <= max;
    }
    
    public static boolean checkIntNumMin(int num, int min)
    {
        return num >= min;
    }

    public static boolean checkEmptyString(String s)
    {
        return s.isEmpty();
    }
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
