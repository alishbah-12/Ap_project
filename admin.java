/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class admin {
    String user_name;
    String password;
List<customer> lst=new ArrayList<>();
List<movie> list=new ArrayList<>();
 db d=new db();
    public admin( ) {
//        user_name = "Ali Ahmed";
//        password ="123456";
//        d.insertAdmin(user_name,password);
    }
    public void Load_Customer() //loading data from db
    {
        d.LoadCustomers(lst);
    }
    public movie GetMovie(String d)
    {
        movie m;
       
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).date.equals(d))
             {
                m=list.get(i);
                
                return m;
             }
         }
         return null;
    }
    public void Load_movies()
    {
        d.LoadMovies(list);
    }
     public void add_customer()
    {
        customer c1=new customer(1,"Ali","0333-3333333","ali@gmail.com","ali123","123456","faisal town");
        customer c2=new customer(2,"Aliahmed","0333-3333333","ali@gmail.com","al34","1234567","abc,faisal town");
        lst.add(c1);
        lst.add(c2);
    }

    public List<movie> getList() {
        return list;
    }
     public void display()
     {
         for(int i=0;i<lst.size();i++)
         {
             System.out.println(lst.get(i).customer_id + lst.get(i).customer_name + lst.get(i).number + lst.get(i).email + lst.get(i).username + lst.get(i).password + lst.get(i).address);
             System.out.println(lst);
         }
     }
     boolean VerifyAdminInfo(String n,String p)
     {
        
        
       if((d.verify_admin(n,p))==true)
       {
           return true;
       }
       else 
           return false;
     }
    public void delete_customer(int ID)
    {
        boolean find=false;
        for(int i=0;i<lst.size() && find==false;i++)
        {
            if(lst.get(i).customer_id==ID)
            {
                lst.remove(i);
                find=true;
            }
            
        }
    }
    
    
     
    
     public boolean verifyCustomer(String u,String p)
    {
       if(d.verify_customer(u, p)==true)
           return true;
       else
           return false;
        
    }

    
     public void add_movie(String name,String lang,String type,String hour,String descrip,String st,String et,String day,String date,String path,movie m)
    {
        
        show w=new show(st,et,day);
        m.set_movie(name, lang, type, hour, descrip, w,date,path);
        list.add(m);
        db d=new db();
        d.insertMovie( name, lang, type, hour, descrip,st,et,day,w.seat,date,path);
    }

     public void display_movie()
     {
         for(int i=0;i<list.size();i++)
         {
             System.out.println( list.get(i).movie_name + " " +list.get(i).language +" "+ list.get(i).movie_type +" "+ list.get(i).movie_hour +" "+ list.get(i).movie_description+" "+list.get(i).pic+" "+list.get(i).date);
             int val=list.get(i).s.size();
             System.out.println(val);
             for(int j=0;j<val;j++)
             {
                 System.out.println(list.get(i).s.get(j).day+" "+list.get(i).s.get(j).show_start_time+" "+list.get(i).s.get(j).show_end_time);
                 //System.out.println(list.get(i).s.get(j).seat.get(0));
//                 System.out.println("DisplayMovies");
                 for(int k=0;k<list.get(i).s.get(j).seat.size();k++)
                 {
                     System.out.println(list.get(i).s.get(j).seat.get(k).booked);
                 }

             }

             
         }
     }

     
     public String get_detail(String h)
     {
         for(int i=0;i<list.size();i++)
         {
             if(list.get(i).date.equals(h))
             {
                 return list.get(i).pic;
             }
         }
         return null;
     }
     
    }


