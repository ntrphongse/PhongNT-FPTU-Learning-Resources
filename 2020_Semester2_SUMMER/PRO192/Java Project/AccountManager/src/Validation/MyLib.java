/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 *
 * @author Hp
 */
public class MyLib {
    public static boolean isValidNumber(int number)
    {
        return number >= 0;
    }
    
    // Kiểm tra s có rỗng hay không
    public static boolean isValidString(String s)
    {
        return !s.isEmpty();
    }
    
    // Kiểm tra input có giống với pattern bất kì không
    /*
    Input = "SE"
    Pattern = "SExxx", x là 1 số
    => Output: False
    */
    public static boolean isValidString(String input, String pattern)
    {
        return input.matches(pattern);
    }
}
