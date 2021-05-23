/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListClass;

import BasicClass.Subject;
import Validation.MyValidation;
import java.util.ArrayList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class SubjectList extends ArrayList<Subject> {
    
    public ArrayList<Subject> getSubjectList() {
        return this;
    }
    
    public boolean addSubject(Subject newSubject) {
        try {
            return this.add(newSubject);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteSubject(Subject delSubject) {
        try {
            return this.remove(delSubject);
        } catch (Exception e) {
            return false;
        }
    }
    
    public Subject searchSubject(String SubjectID) {
        for (Subject subject : this) {
            if (SubjectID.equalsIgnoreCase(subject.getId()))
                return subject;
        }
        return null;
    }
    
    public boolean updateSubject(Subject oldSubject, Subject newSubject) {
        try {
            if (searchSubject(oldSubject.getId()) == null)
                return false;
            if (!MyValidation.isEmptyString(newSubject.getName()))
                oldSubject.setName(newSubject.getName());
            if (newSubject.getCredit() != -1)
                oldSubject.setCredit(newSubject.getCredit());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
