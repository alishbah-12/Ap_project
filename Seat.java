/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

/**
 *
 * @author DELL
 */
public class Seat {
    String booked;
    int seat_id;
    
    int count=0;
    
    public Seat() {
        seat_id=0;
        
        booked="false";
    }
    void book_seat(Seat s)
    {
        s.booked="true";
    }
    public void set_seat(int s,String b)
    {
        seat_id=s;
        booked=b;
    }
}
