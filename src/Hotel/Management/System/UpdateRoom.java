/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author billi
 */
public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpendingamount;
    JButton check, update, back;
    
    UpdateRoom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.BLUE);
        add(text);
              
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customers");
            while (rs.next()) {
                ccustomer.add(rs.getString("custNumber"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Availablility");
        lblname.setBounds(30, 180, 100, 20);
        add(lblname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200, 180, 150, 25);
        add(tfavailable);
        
        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);
               
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(30, 300, 100, 30);
        add(check);
                
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(150, 300, 100, 30);
        add(back);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(270, 300, 100, 30);
        add(update);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 350);
        add(image);
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customers where custNumber = '"+id+"'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()) {
                    tfroom.setText(rs.getString("room"));
          
                }
                
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == update) {
            
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String availability = tfavailable.getText();
            String cleaningstatus = tfstatus.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availability = '"+availability+"', cleaning_status = '"+cleaningstatus+"' where roomnumber = '"+room+"' ");
                
                JOptionPane.showMessageDialog(null, "Data updated Successfully");
                
                setVisible(false);
                new Reception();
                
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else {
            
            setVisible(false);
            new Reception();
            
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoom();
    }
    
}