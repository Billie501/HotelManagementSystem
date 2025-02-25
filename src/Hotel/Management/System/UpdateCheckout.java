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
public class UpdateCheckout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpendingamount;
    JButton check, update, back;
    
    UpdateCheckout() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
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
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Checkin In Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30, 240, 100, 20);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        add(tfpaid);
        
        JLabel lblpendingamount = new JLabel("Pending Amount");
        lblpendingamount.setBounds(30, 280, 100, 20);
        add(lblpendingamount);
        
        tfpendingamount = new JTextField();
        tfpendingamount.setBounds(200, 280, 150, 25);
        add(tfpendingamount);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(30, 340, 100, 30);
        add(check);
                
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(150, 340, 100, 30);
        add(back);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(270, 340, 100, 30);
        add(update);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ninth.png"));
        Image i2 = i1.getImage().getScaledInstance(550, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    double priceValue = Double.parseDouble(price);
                    double paidValue = Double.parseDouble(tfpaid.getText());
                    double amountPending = priceValue - paidValue;
                    tfpendingamount.setText(String.format("%.2f", amountPending));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == update) {
            
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customers set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"'");
                
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
        new UpdateCheckout();
    }
    
}
