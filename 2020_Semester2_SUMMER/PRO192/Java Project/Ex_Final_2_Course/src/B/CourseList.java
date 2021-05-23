/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import A.Course;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class CourseList {
    ArrayList<Course> list;
    
    public CourseList()
    {
        list = new ArrayList<>();
    }
    
    public boolean addCourse(String Name, int Hours)
    {
        try
        {
            list.add(new Course(Name, Hours));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public void UpdateCourse(int OldHours, int NewHours)
    {
        int count = 0;
        for (Course course : list) {
            if (course.getHours() == OldHours)
                try {
                    course.setHours(NewHours);
                    count++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
        }
        if (count == 0)
            System.out.println("No such a course to update!");
        else
            System.out.println("Updated " + count + " courses successfully!");
    }
}
