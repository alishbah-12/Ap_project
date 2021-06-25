/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class show {
    //static int count=0;
    //protected int show_id;
    protected String show_start_time;
    protected String show_end_time;
    protected String day;
    int total_seats;
    List<Seat> seat=new ArrayList<>();
    public show()
    {
       
    }
    public show(String show_start_time, String show_end_time, String day) {
       //count++;
       //this.show_id=count;
        this.show_start_time = show_start_time;
        this.show_end_time = show_end_time;
        this.day = day;
        total_seats=50;
        int seat_id=1;
        for(int i=0;i<50;i++)//make 50 new seats for each show
        {
                Seat s1=new Seat();
                s1.seat_id=seat_id;
                seat_id++;
                seat.add(s1);
        }
    }
    public void set_show(String show_start_time, String show_end_time, String day,List<Seat> store_seat)
    {
        this.show_start_time = show_start_time;
        this.show_end_time = show_end_time;
        this.day = day;
        seat=store_seat;
        //System.out.println("SetShow");
        for(int i=0;i<store_seat.size();i++)
        {
            seat.get(i).seat_id=store_seat.get(i).seat_id;
            //System.out.println(seat.get(i).booked);
            seat.get(i).booked=store_seat.get(i).booked;
           //sSystem.out.println(seat.get(i).booked);
        }
    }
}
