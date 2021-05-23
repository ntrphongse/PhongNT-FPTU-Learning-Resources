/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClass;

import Validation.MyValidation;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Grade {
    private String StudentID;
    private String SubjectID;
    private double labs;
    private double progress;
    private double fe;

    public Grade() {
        StudentID = SubjectID = "";
        labs = progress = fe = 0.0f;
    }

    public Grade(String StudentID, String SubjectID, double labs, double progress, double fe) {
        this.StudentID = StudentID;
        this.SubjectID = SubjectID;
        this.labs = labs;
        this.progress = progress;
        this.fe = fe;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) throws Exception {
        if (!MyValidation.isEmptyString(StudentID))
            this.StudentID = StudentID;
        else
            throw new Exception("Empty Student ID!");
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) throws Exception {
        if (!MyValidation.isEmptyString(SubjectID))
            this.SubjectID = SubjectID;
        else
            throw new Exception("Empty Subject ID!");
    }

    public double getLabs() {
        return labs;
    }

    public void setLabs(double labs) throws Exception {
        if (MyValidation.checkFloatNumber(labs, 0.0f, 10.0f))
            this.labs = labs;
        else
            throw new Exception("Negative Labs Grade!");
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) throws Exception {
        if (MyValidation.checkFloatNumber(progress, 0.0f, 10.0f))
            this.progress = progress;
        else
            throw new Exception("Negative Progress Test Grade!");
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) throws Exception {
        if (MyValidation.checkFloatNumber(fe, 0.0f, 10.0f))
            this.fe = fe;
        else
            throw new Exception("Negative Final Exam Grade!");
    }
}
