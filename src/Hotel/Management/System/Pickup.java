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
public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice cartype;
    JCheckBox available;

    Pickup() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50, 100, 100, 30);
        add(lblbed);

        cartype = new Choice();
        cartype.setBounds(200, 100, 150, 25);
        add(cartype);
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while(rs.next()) {
                cartype.add(rs.getString("model"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Driver Name");
        l1.setBounds(10, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(160, 160, 100, 20);
        add(l2);
        
        JLabel l7 = new JLabel("Gender");
        l7.setBounds(330, 160, 100, 20);
        add(l7);

        JLabel l3 = new JLabel("Car Make");
        l3.setBounds(460, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Car Model");
        l4.setBounds(610, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Availability");
        l5.setBounds(740, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Location");
        l6.setBounds(870, 160, 100, 20);
        add(l6);

        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String query = "select * from driver where model = '" + cartype.getSelectedItem() + "'";
                

                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Pickup();
    }

}