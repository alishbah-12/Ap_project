/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class customer {
    protected int customer_id;
    protected String customer_name;
    protected String number;
    protected String email;
    protected String username;
    protected String password;
    protected String address;
    
    
    customer()
    {
        
    }

    public customer(int customer_id, String customer_name, String number, String email, String username, String password, String address) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.number = number;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
    }
   
}
