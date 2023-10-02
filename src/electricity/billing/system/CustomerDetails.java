/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author pv
 */
public class CustomerDetails extends JFrame implements ActionListener{
    
    Choice meternumber, cmonth;
    JTable table;
    JButton search, print;
    
    CustomerDetails(){
        super("Customer Details");
        setSize(1200, 650);
        setLocation(200, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
     
        table = new JTable();
        
        try {
            Conn c = new Conn();
            String query = "select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");
        print.addActionListener(this);
        add(print, "South");
        
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            table.print();
        } catch (Exception e){
            e.printStackTrace();
        } 
    }
}

