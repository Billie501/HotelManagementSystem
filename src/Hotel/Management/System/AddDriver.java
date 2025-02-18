/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author billi
 */
public class AddDriver extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfcarmodel, tflocation;
    JComboBox genderCombo, typeCombo, availableCombo;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoe", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblname.setBounds(60, 80, 120, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblage.setBounds(60, 130, 120, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);
                
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblgender.setBounds(60, 180, 120, 30);
        add(lblgender);
        
        String genderOptions[] = { "Male", "Female" };
        genderCombo = new JComboBox(genderOptions);
        genderCombo.setBounds(200, 180, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);
        
        JLabel lblcarcompany = new JLabel("Car Company");
        lblcarcompany.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblcarcompany.setBounds(60, 230, 120, 20);
        add(lblcarcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 230, 150, 30);
        add(tfcompany);       
        
        JLabel lblcarmodel = new JLabel("Car Model");
        lblcarmodel.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblcarmodel.setBounds(60, 280, 120, 30);
        add(lblcarmodel);
        
        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(200, 280, 150, 30);
        add(tfcarmodel); 
        
        JLabel lblavailablity = new JLabel("Availability");
        lblavailablity.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblavailablity.setBounds(60, 330, 120, 30);
        add(lblavailablity);
        
        String driverOptions[] = { "Available", "Unavailable" };
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(200, 330, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lbllocation.setBounds(60, 380, 120, 30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 380, 150, 30);
        add(tflocation); 
        
        add = new JButton("Add Driver");
        add.setBounds(60, 430, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 430, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 0, 450, 450);
        add(image);
        
        
        setBounds(300, 200, 980, 520);
        setVisible(true);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfcarmodel.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();
            
            
            try {
                Conn conn = new Conn();
               String str = "INSERT INTO driver (name, age, gender, company, model, availability, location) VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + company + "','" + model + "','" + availability + "', '" + location + "')";
               
               conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "New Driver added successfully");
            
            setVisible(false);
               
            } catch (Exception e ) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
        new AddDriver();
    }
    
}
