/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import A.Video;
import java.util.TreeSet;

/**
 *
 * @author Hp
 */
public class VideoList {
    TreeSet<Video> list;
    
    public VideoList()
    {
        list = new TreeSet<>();
    }
    
    public boolean addVideo(Video x)
    {
        try
        {
            list.add(x);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public Video searchByTitle(String mtitle)
    {
        for (Video video : list) {
            if (video.getTitle().equals(mtitle))
                return video;
        }
        return null;
    }
    
}
