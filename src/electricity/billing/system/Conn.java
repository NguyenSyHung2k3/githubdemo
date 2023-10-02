/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "123456789");
            if(c != null){
                System.out.println("Connected Successfully");
            }
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        
    }
}
