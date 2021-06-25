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
public class booking {
    protected int booking_id;
    protected String booking_date;
    //seats s=new seats();
    public booking(int booking_id, String booking_date) {
        this.booking_id = booking_id;
        this.booking_date = booking_date;
    }
}
