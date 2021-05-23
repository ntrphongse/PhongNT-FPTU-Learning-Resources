/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListClass;

import BasicClass.Grade;
import Validation.MyValidation;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class GradeList extends ArrayList<Grade>{
    public ArrayList<Grade> getGradeList() {
        return this;
    }
    
    public boolean addGrade(Grade newGrade) {
        try {
            return this.add(newGrade);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteGrade(Grade delGrade) {
        try {
            return this.remove(delGrade);
        } catch (Exception e) {
            return false;
        }
    }
    
    public Grade searchGrade(String StudentID, String SubjectID) {
        for (Grade grade : this) {
            if ((StudentID.equalsIgnoreCase(grade.getStudentID())) && (SubjectID.equalsIgnoreCase(grade.getSubjectID())))
                return grade;
        }
        return null;
    }
    
    public ArrayList<Grade> reportGradeByStu(String StudentID) {
        ArrayList<Grade> resultList = new ArrayList<>();
        for (Grade grade : this) {
            if (MyValidation.checkEqualString(StudentID, grade.getStudentID()))
                resultList.add(grade);
        }
        return resultList;
    }
    
    public ArrayList<Grade> reportGradeBySub(String SubjectID) {
        ArrayList<Grade> resultList = new ArrayList<>();
        for (Grade grade : this) {
            if (MyValidation.checkEqualString(SubjectID, grade.getSubjectID()))
                resultList.add(grade);
        }
        return resultList;
    }
    
    public boolean updateGrade(Grade oldGrade, Grade newGrade) {
        try {
            if (searchGrade(oldGrade.getStudentID(), oldGrade.getSubjectID()) == null)
                return false;
            if (MyValidation.checkFloatNumber(newGrade.getFe(), 0.0f, 10.0f))
                oldGrade.setFe(newGrade.getFe());
            if (MyValidation.checkFloatNumber(newGrade.getLabs(), 0.0f, 10.0f))
                oldGrade.setFe(newGrade.getLabs());
            if (MyValidation.checkFloatNumber(newGrade.getProgress(), 0.0f, 10.0f))
                oldGrade.setFe(newGrade.getProgress());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
