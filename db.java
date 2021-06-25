/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.sql.ResultSet;



/**
 *
 * @author DELL
 */
public class db {
     Connection con;
    Statement stmt;
    
    db() //cons
    {
        try
        {
             String s = "jdbc:sqlserver://DESKTOP-PKFNL7U;databaseName=ap_proj";
             con=DriverManager.getConnection(s,"new_user","123");


            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
         
            
            System.out.println(e);
        }
    }
    void LoadCustomers(List<customer> list) //for loading customers
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from customer");      
             while(rs.next())
             {
                 int i=rs.getInt(1);
                 String n=rs.getString(2);
                 String num=rs.getString(3);
                 String em=rs.getString(4);
                 String un=rs.getString(5);
                 String p=rs.getString(6);
                 String a=rs.getString(7);
                 customer c=new customer(i,n,num,em,un,p,a);
                 list.add(c);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void LoadMovies(List<movie> list) //for loading customers
    {
        List<show> l1=new ArrayList<>();
        List<Seat> l2=new ArrayList<>();
        try
        {
             Statement stmt1 = con.createStatement(); 
       
               ResultSet rs1=stmt.executeQuery("select * from show "); 
               while(rs1.next())
                 {
                     int id=rs1.getInt(1);
                     String st=rs1.getString(2);
                     String et=rs1.getString(3);
                     String day=rs1.getString(6);
                     ResultSet rs2=stmt1.executeQuery("select * from seat where show_id='"+id+"'");
                      while(rs2.next())
                     {
                            int s_id=rs2.getInt(1);
                            String booked=rs2.getString(2);
                            Seat s=new Seat();
                            s.set_seat(s_id, booked);
                            l2.add(s);
                     }
                     show q=new show();
                     q.set_show(st, et, day, l2);
                     l1.add(q);
                 
                }
        
         
             ResultSet rs=stmt.executeQuery("select * from movie1");   
             int c=0;
             while(rs.next())
             {
                 int i=rs.getInt(1);
                 String name=rs.getString(2);
                 String lang=rs.getString(3);
                 String type=rs.getString(4);
                 String hour=rs.getString(5);
                 String descrip=rs.getString(6);
                 String pic=rs.getString(7);
                
                 String date=rs.getString(8);
                
                 String s_t=l1.get(c).show_start_time;
                
                 String e_t=l1.get(c).show_end_time;
               
                 String da=l1.get(c).day;
                
                 c++;
                movie m=new movie(name,lang,type,hour,descrip,date,pic);
                show s1=new show(s_t,e_t,da);
                m.set_movie(name, lang, type, hour, descrip, s1,date,pic);
                list.add(m);
             }
                 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     void insertAdmin(String name,String pass)
    {
        
        try
        {
           String s="insert into Admin1(username,password) values('"+name+ "' , '"+pass+"')";
            int rs=stmt.executeUpdate(s);    
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }
    }
     
     Boolean verify_admin(String uname,String p)
      {
          
        boolean b=false;
        try
        {
           String s="select * from Admin1 where Admin1.username='"+uname+"' AND Admin1.password='"+p+"'" ;
            ResultSet rs=stmt.executeQuery(s);
            if(rs.next())
            {
                String j = rs.getString(1);
                return true;
            }
          return false;
        }
        catch(Exception e)
        {
            System.out.println(e);
          return false;
        }


        
      }
     
      void displayAdmin()
    {
        
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Admin1");
             while(rs.next())
             {
                 
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    //MOVIE
    void insertMovie(String name,String lang, String type, String h,String d,String st,String et,String da,List<Seat> seats,String date,String path)
    {
        int id=0;
        int show_id=0;
        try
        {
           String f="insert into movie1(name,language,type,hour,description,pic,date) values( '"+name+"' , '"+lang+"' ,'"+type+"','"+h+"' , '"+d+"','"+path+"','"+date+"')";
            int rs=stmt.executeUpdate(f);
            ResultSet rs1=stmt.executeQuery("select * from movie1 where movie1.name='"+name+"'");
            while(rs1.next())
             {
                 
                id=rs1.getInt(1);
             }
             String s1="insert into show(start_time,end_time,total_seats,movie_id,day) values( '"+st+"' , '"+et+"' ,'"+50+"', '"+id+"' , '"+da+"')";
             int rs2=stmt.executeUpdate(s1);
             ResultSet rss=stmt.executeQuery("select * from show where show.movie_id='"+id+"'");
             while(rss.next())
             {
                 show_id=rss.getInt(1);
             }
             for(int i=0;i<seats.size();i++)
             {
             String ss="insert into seat(seat_id,booked,show_id) values('"+seats.get(i).seat_id+ "' , '"+seats.get(i).booked+"' , '"+show_id+"')";
             int rs3=stmt.executeUpdate(ss);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
    
    void DeleteMovie(String name)
    {
        int movie_id=0;
        
        
        try
        {
            
            String s1="Select * from movie1 where movie1.name='"+name+"'";
            ResultSet rs1=stmt.executeQuery(s1);
            while(rs1.next())
            {
                movie_id=rs1.getInt(1);
            }
            
            
             
             
           String s=("delete from movie1 where movie1.name='"+name+"'") ;
            int rs=stmt.executeUpdate(s);
            DeleteShow(movie_id);
           
              
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
    
    void DeleteShow(int m_id)
    {
        int show_id=0;
       try
       {
           String s2="Select * from show where show.movie_id='"+m_id+"'";
            ResultSet rs2=stmt.executeQuery(s2);
            while(rs2.next())
            {
                show_id=rs2.getInt(1);
            }
            String s3=("delete from show where show.movie_id='"+m_id+"'") ;
            int rs3=stmt.executeUpdate(s3);
            DeleteSeat(show_id);
       }
        catch(Exception e)
        {
            System.out.println(e);
          
        }
    }
    
    void DeleteSeat(int s_id)
    {
        try
        {
            String s4=("delete from seat where seat.show_id='"+s_id+"'") ;
            int rs4=stmt.executeUpdate(s4);
        }
         catch(Exception e)
        {
            System.out.println(e);
          
        }
    }
    
    void UpdateMovie(String name,String day,String date)
    {
        int id=0;
        try
        {
            String s=("Update movie1 Set date='"+date+"'  where movie1.name='"+name+"'");
            int rs=stmt.executeUpdate(s);
            String s1=("Select * from movie1 where movie1.name='"+name+"'");
            ResultSet rs1=stmt.executeQuery(s1);
            while(rs1.next())
            {
                id=rs1.getInt(1);
            }
            String s2=("Update show Set day='"+day+"' where show.movie_id='"+id+"'");
            int rs2=stmt.executeUpdate(s2);
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }
    }
    
    void UpdateShowTimings(String name,String st,String et)
    {int id=0;
        try
        {
         String s1=("Select * from movie1 where movie1.name='"+name+"'");
            ResultSet rs1=stmt.executeQuery(s1);
            while(rs1.next())
            {
                id=rs1.getInt(1);
            }
            
            String s2=("Update show Set start_time='"+st+"',end_time='"+et+"' where show.movie_id='"+id+"'");
            int rs2=stmt.executeUpdate(s2);
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }
    }
    
     void displayAll()
    {
        
        try
        {
            ResultSet rs=stmt.executeQuery("select * from movie1");
             while(rs.next())
             {
                 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //Customer
     void insertCustomer(String name,String num, String email, String uname,String pass,String add)
    {
        
        try
        {
           String s="insert into customer(customer_name,number,email,username,password,address) values( '"+name+"' , '"+num+"' ,'"+email+"','"+uname+"' , '"+pass+"','"+add+"')";
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
     
     void DeleteCustomer(String id)
    {
        
        try
        {
           String s=("delete from customer where customer.customer_id='"+id+"'") ;
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
     
     void displayAllCustomers()
    {
        
        try
        {
            ResultSet rs=stmt.executeQuery("select * from customer");
             while(rs.next())
             {
                 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6) +" "+rs.getString(7) );
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
     
     void UpdateCustomerByName(int id, String u_name)
    {
        
        try
        {
           String s=("update customer Set username='"+u_name+"'  where customer.customer_id='"+id+"'") ;
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
      void UpdateCustomerByPass(String id, String pass)
    {
        
        try
        {
           String s=("update customer Set password='"+pass+"'  where customer.customer_id='"+id+"'") ;
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
      
      void UpdateCustomer(int id, String u_name,String pass)
    {
        
        try
        {
           String s=("update customer Set username='"+u_name+"', password='"+pass+"'  where customer.customer_id='"+id+"'") ;
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
      
      Boolean verify_customer(String uname,String p)
      {
          
        boolean b=false;
        try
        {
          
           String s="select * from customer where customer.username='"+uname+"' AND customer.password='"+p+"'" ;
            ResultSet rs=stmt.executeQuery(s);
             if(rs.next())
            {
                String j = rs.getString(1);
                return true;
            }
          return false;
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          return false;
        }


        
      }
      
      void insertShow(int id,String s_t,String e_t, String d,int m_id)
    {
        
        try
        {
           String s="insert into show(show_id,start_time,end_time,total_seats,movie_id) values('"+id+ "' , '"+s_t+"' , '"+e_t+"' ,'"+50+"', '"+m_id+"')";
            int rs=stmt.executeUpdate(s);
             
        }
        catch(Exception e)
        {
            System.out.println(e);
          
        }


    } 
      Boolean updateSeats(String name,int i)
      {
          int movie_id=0;
          int show_id=0;
          String book;
       try
       {
            String s=("Select * from movie1 where movie1.name='"+name+"'")  ;
            ResultSet rs=stmt.executeQuery(s);
            while(rs.next())
            {
                movie_id=rs.getInt(1);
            }
            String s1=("Select * from show where show.movie_id='"+movie_id+"'");
            ResultSet rs1=stmt.executeQuery(s1);
            while(rs1.next())
            {
                show_id=rs1.getInt(1);
            }
            String s3=("Select * from seat where seat.show_id='"+show_id+"' AND seat.seat_id='"+i+"' ");
            ResultSet rs3=stmt.executeQuery(s3);
            if(rs3.next())
            {
                   book=rs3.getString(2);
                   if(book.equals("true"))
                   {
                       return false;
                   }
                   else
                   {
                        String s2=("Update seat Set booked='"+true+"' where seat.show_id='"+show_id+"' AND seat.seat_id='"+i+"'");
                        int rs2=stmt.executeUpdate(s2);
                        return true;
                   }
            }
           return null;
       }
       catch(Exception e)
        {
            System.out.println(e);
          return null;
        }
      }
     
      List<Seat> getSeatDetails(String mname)
      {
          List<Seat> seat=new ArrayList<>();
          int movie_id=0;
          int show_id=0;
          try
          {
            String s=("Select * from movie1 where movie1.name='"+mname+"'")  ;
            ResultSet rs=stmt.executeQuery(s);
            while(rs.next())
            {
                movie_id=rs.getInt(1);
            }
            String s1=("Select * from show where show.movie_id='"+movie_id+"'");
            ResultSet rs1=stmt.executeQuery(s1);
            while(rs1.next())
            {
                show_id=rs1.getInt(1);
            }
            String s3=("Select * from seat where seat.show_id='"+show_id+"' ");
            ResultSet rs3=stmt.executeQuery(s3);
            while(rs3.next())
              {
                           int s_id=rs3.getInt(1);
                            String booked=rs3.getString(2);
                            Seat s4=new Seat();
                            s4.set_seat(s_id, booked);
                            seat.add(s4);
              }
            return seat;
          }
        catch(Exception e)
        {
            System.out.println(e);
          return null;
        }
      }
}
