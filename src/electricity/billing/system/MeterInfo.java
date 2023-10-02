/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author pv
 */
public class MeterInfo extends JFrame implements ActionListener{
    
    JButton submit;
    Choice meterlocation, metertype, phasecode, billtype;
    String meternumber;
    
    MeterInfo(String meternumber){
        this.meternumber = meternumber;
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel meter_number = new JLabel("Meter Number");
        meter_number.setBounds(100, 80, 100, 20);
        p.add(meter_number);
        
        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(240, 80, 100, 20);
        p.add(lblmeternumber);
        
        JLabel lblmeterlocation = new JLabel("Meter Location");
        lblmeterlocation.setBounds(100, 120, 100, 20);
        p.add(lblmeterlocation);
        
        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240, 120, 200, 20);
        p.add(meterlocation);

        
        JLabel lblmetertype = new JLabel("Meter Type");
        lblmetertype.setBounds(100, 160, 100, 20);
        p.add(lblmetertype);
       
        metertype = new Choice();
        metertype.setBounds(240, 160, 200, 20);
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        p.add(metertype);
        
        JLabel lblphasecode = new JLabel("Phase Code");
        lblphasecode.setBounds(100, 200, 100, 20);
        p.add(lblphasecode);
        
        phasecode = new Choice();
        phasecode.setBounds(240, 200, 200, 20);
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.add("000");
        p.add(phasecode);
        
        JLabel lblbilltype = new JLabel("Bill Type");
        lblbilltype.setBounds(100, 240, 100, 20);
        p.add(lblbilltype);
        
        billtype = new Choice();
        billtype.setBounds(240, 240, 200, 20);
        billtype.add("Normal");
        billtype.add("Industrial");
        p.add(billtype);
        
        JLabel lblday = new JLabel("Days");
        lblday.setBounds(100, 280, 100, 20);
        p.add(lblday);
        
        JLabel day = new JLabel("30 Days");
        day.setBounds(240, 280, 100, 20);
        p.add(day);
        
        JLabel lblnote = new JLabel("Note");
        lblnote.setBounds(100, 320, 100, 20);
        p.add(lblnote);
        
        JLabel note = new JLabel("By default Bill is calculated for 30 days only");
        note.setBounds(240, 320, 250, 20);
        p.add(note);
        
        submit = new JButton("Submit");
        submit.setBounds(220, 390, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
        
        setLayout(new BorderLayout());
        add(p, "Center");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String meter = meternumber;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";
            
            try {
                Conn c = new Conn(); 
                String query = "insert into meter_info values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                setVisible(false);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
        
    }
    
    public static void main(String[] args){
        new MeterInfo("");
    }

}
