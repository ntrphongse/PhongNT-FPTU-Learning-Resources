package MyLib;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Tran Phong - PhongNTSE150974
 */
public class MyValidation {
    //////////////////

    /**
     * Check if string s matches the given pattern
     * @param s String to check
     * @param pattern pattern to compare
     * @return true if s matches the given pattern
     */
    public static boolean checkString(String s, String pattern)
    {
        return s.matches(pattern);
    }

    /**
     * Check if string s and string x are the same
     * @param s String number 1
     * @param x String number 2
     * @return true if s and x is equal
     */
    public static boolean checkEqualString(String s, String x)
    {
        return s.equals(x);
    }
    
    /**
     * Check if a number is in the domain of [min, max]
     * @param num number to check
     * @param min minimum value
     * @param max maximum value
     * @return true if num is in [min, max]
     */
    public static boolean checkIntNumber(int num, int min, int max)
    {
        return num >= min && num <= max;
    }
    
    /**
     * Check if a number is smaller or equal to a maximum value
     * @param num number to check
     * @param max maximum value to compare
     * @return true if num is smaller or equal to max
     */
    public static boolean checkIntNumMax(int num, int max)
    {
        return num <= max;
    }
    
    /**
     * Check if a number is equal or bigger to a minimum value
     * @param num number to check
     * @param min minimum value to compare
     * @return true if num is equal or bigger than min
     */
    public static boolean checkIntNumMin(int num, int min)
    {
        return num >= min;
    }

    /**
     * Check if a string is empty
     * @param s string to check
     * @return true if s is an empty string
     */
    public static boolean checkEmptyString(String s)
    {
        return (s.isEmpty() || s.trim().length() <= 0);
    }
    
    /**
     * Check if a date is valid or not
     * @param year the year
     * @param month the month
     * @param day the day
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
    
    /**
     * Enter a integer number
     * @param min minium value of the number
     * @param max maximum value of the number
     * @return Inputted number or error if the number is out of domain
     * @throws java.lang.Exception
     */
    public static int inputIntNumber(int min, int max) throws Exception
    {
        int result = min;
        Scanner sc = new Scanner(System.in);
        result = sc.nextInt();
        if (result < min || result > max)
            throw new Exception("Domain is invalid");
        return result;
    }
    
    /**
     * Enter a string and check if a string matches a pattern
     * @param pattern Pattern to match
     * @return Matched String or Exception if not match pattern
     * @throws java.lang.Exception
     */
    public static String inputString(String pattern) throws Exception
    {
        String text = "";
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        if (!text.matches(pattern))
            throw new Exception("Text is invalid");
        return text;
    }
    
    /**
     * Check if a title is empty or not
     * @param title
     * @return true if the title is empty
     */
    public static boolean checkTitle(String title)
    {
        return checkEmptyString(title);
    }
    
    /**
     * Enter a not-empty string
     * @return the title or throw exception if it is empty!
     * @throws Exception
     */
    public static String inputTitle() throws Exception
    {
        String title = "";
        Scanner sc = new Scanner(System.in);
        title = sc.nextLine();
        if (checkTitle(title))
            throw new Exception("Empty Title!");
        return title;
    }
    
    /**
     * Check if a year is valid (<= the current year)
     * @param year
     * @return true if the year is valid
     */
    public static boolean checkYear(int year)
    {
        return year <= Calendar.getInstance().get(Calendar.YEAR);
    }
    
    /**
     * Enter a valid year
     * @return the year or throw exception
     * @throws Exception
     */
    public static int inputYear() throws Exception
    {
        int year;
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        if (!checkYear(year))
            throw new Exception("Invalid year!");

        return year;
    }
}
