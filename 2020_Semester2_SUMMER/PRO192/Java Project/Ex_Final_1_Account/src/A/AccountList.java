/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class AccountList {
    ArrayList<Account> list;

    public AccountList()
    {
        list = new ArrayList<>();
    }
    
    public boolean addAccount(Account newAcc)
    {
        try
        {
            list.add(newAcc);
            return true;
        }
        catch (Exception e)
        {
            return false;
        } 
    }
    
    public int login(String email, String password)
    {
        if (list.isEmpty()) return -1;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getEmail().equals(email) && list.get(i).getPassword().equals(password))
                return i;
        }
        return -1;
    }
    
    public boolean UpdatePassword(String newPassword, int UpdateIndex)
    {
        try
        {
            String email = list.get(UpdateIndex).getEmail();
            list.set(UpdateIndex, new Account(email, newPassword));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
        
    }
}
