/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


/**
 *
 * @author billi
 */
public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    ManagerInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
               
        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Role");
        l4.setBounds(400, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone Number");
        l6.setBounds(670, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Email Address");
        l7.setBounds(790, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("ID");
        l8.setBounds(930, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where role = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120,30);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new ManagerInfo();
    }
    
}

