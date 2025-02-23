/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import Hotel.Management.System.Conn;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author billi
 */
public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    JButton addCust, back;
    JComboBox idtype, roomNumber;
    Choice croom;
    JLabel checkin;
    
    AddCustomer() {
        
        setLayout(null);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblidtype = new JLabel("Identification");
        lblidtype.setBounds(60, 30, 120, 30);
        lblidtype.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblidtype);
        
        String options[] = { "Passport", "Drivers Liscense" };
        idtype = new JComboBox(options);
        idtype.setBounds(200, 30, 150, 30);
        idtype.setBackground(Color.WHITE);
        add(idtype);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(60, 80, 120, 30);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 80, 150, 30);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 130, 150, 30);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 180, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 180, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 180, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 230, 120, 30);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 230, 150, 30);
        add(tfcountry);
        
        JLabel lblroomNumber = new JLabel("Room Number");
        lblroomNumber.setBounds(60, 280, 120, 30);
        lblroomNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblroomNumber);
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        croom.setBounds(200, 280, 150, 30);
        add(croom);
        
                
        JLabel lbltime = new JLabel("Check-in Time");
        lbltime.setBounds(60, 330, 200, 30);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbltime);
        
        Date date = new Date();
        
        
        
        checkin = new JLabel("" + date);
        checkin.setBounds(200, 330, 200, 30);
        checkin.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(checkin);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(60, 380, 120, 30);
        lbldeposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 380, 150, 30);
        add(tfdeposit);
        
           
        addCust = new JButton("Add Customer");
        addCust.setBounds(50, 430, 150, 30);
        addCust.setBackground(Color.BLACK);
        addCust.setForeground(Color.WHITE);
        addCust.addActionListener(this);
        add(addCust);
        
        back = new JButton("Back");
        back.setBounds(250, 430, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 450, 450);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == addCust) {
            String idType = (String) idtype.getSelectedItem(); 
            String custNumber = tfnumber.getText();
            String name = tfname.getText();
            
            String gender = null;
        
            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbfemale.isSelected()) {
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkin.getText();
            String deposit = tfdeposit.getText();
            
            try {
                
                Conn conn = new Conn();
                
                String query = "insert into customers values('"+idType+"', '"+custNumber+"', '"+name+"','"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber - '"+room+"'";
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "New Customer added successfully");
            
            setVisible(false);
            new Reception();
            
            setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if( ae.getSource() == back) {
            setVisible(false);
            new Reception();
            
        }
                
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }
    
}
