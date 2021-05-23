/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

/**
 *
 * @author Hp
 */
public class Video implements Comparable<Video> {
    private String title;
    private int year;

    public Video() {
    }

    public Video(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public int compareTo(Video x)
    {
        return (- this.title.compareTo(x.title));
    }
}
