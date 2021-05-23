/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

import Core.User;
import DAO.FileDAO;
import Validation.MyValidation;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UserList extends LinkedList<User> {
    final String file = "user.txt";
    public boolean addUser(User user) {
        try {
            this.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public User search(String username) {
        try {
            Iterator<User> iterator = this.iterator();
            while(iterator.hasNext()) {
                User nUser = iterator.next();
                if (MyValidation.checkEqualString(username, nUser.getUsername()))
                    return nUser;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public User searchByEmail(String email) {
        try {
            Iterator<User> iterator = this.iterator();
            while (iterator.hasNext()) {
                User nUser = iterator.next();
                if (email.equalsIgnoreCase(nUser.getEmail()))
                    return nUser;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public LinkedList<User> searchByName(String name) {
        LinkedList<User> rList = new LinkedList<>();
        try {
            Iterator<User> iterator = this.iterator();
            while (iterator.hasNext()) {
                User nUser = iterator.next();
                if (nUser.getFName().toLowerCase().contains(name.toLowerCase()) || nUser.getLName().toLowerCase().contains(name.toLowerCase()))
                    rList.add(nUser);
            }
            Collections.sort(rList, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getFName().compareTo(o2.getFName());
                }
            });
            return rList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean update(User userToUpdate, String username, String FName, String LName, String password, String phone, String email) {
        if (userToUpdate == null)
            return false;
        try {
            userToUpdate.setFName(FName);
            userToUpdate.setLName(LName);
            userToUpdate.setPassword(password);
            userToUpdate.setPhone(phone);
            userToUpdate.setEmail(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean delete(User user) {
        try {
            this.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean saveAccounts() {
        String write = "";
        for (User user : this) {
            write += user.toString() + "\n";
        }
        if (write.isEmpty())
            write = "The list is empty!";
        return FileDAO.writeUser(write, file);
    }
    
    public boolean login(String username, String password) {
        User sUser = search(username);
        if (sUser == null)
            return false;
        if (sUser.getPassword().equals(password))
            return true;
        return false;
    }
}