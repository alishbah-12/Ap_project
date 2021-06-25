/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class movie {
   // static int count=0;
   // protected int movie_id;
    protected String movie_name;
    protected String language;
    protected String movie_type;
    protected String movie_hour;
    protected String movie_description;
    protected String date;
    protected String pic;
    int total_seats;
    protected List<show> s=new ArrayList<>();
    movie()
    {
        
    }

    public movie( String movie_name, String language, String movie_type, String movie_hour, String movie_description,String date,String pic) {
       // count++;
        //this.movie_id = count;
        this.date=date;
        this.movie_name = movie_name;
        this.language = language;
        this.movie_type = movie_type;
        this.movie_hour = movie_hour;
        this.movie_description = movie_description;
        this.pic=pic;

        total_seats=50;
        
        
    }
    
//    public byte[] getImage()
//    {
//        return pic;
//    }
    public void set_movie(String movie_name, String language, String movie_type, String movie_hour, String movie_description,show s1,String date1,String p) {
        //count++;
        //this.movie_id = count;
        this.date=date1;
        this.pic=p;
        this.movie_name = movie_name;
        this.language = language;
        this.movie_type = movie_type;
        this.movie_hour = movie_hour;
        this.movie_description = movie_description;
        s.add(s1);
    }
}
