/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author billi
 */
public class AddRooms extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox availableCombo, cleanCombo, typeCombo;
    
    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoe", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblroomno.setBounds(60, 80, 120, 20);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = { "Available", "Occupied" };
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOptions[] = { "Clean", "Dirty" };
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 20);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);       
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoe", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        
        String typeOptions[] = { "Single King", "Double Queen" };
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);
        
        add = new JButton("Add Room");
        add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 0, 450, 450);
        add(image);
        
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            String roomnumber = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String cleaning_status = (String) cleanCombo.getSelectedItem();
            String price = tfprice.getText();
            String bedtype = (String) typeCombo.getSelectedItem();
            
            try {
                Conn conn = new Conn();
               String str = "INSERT INTO room (roomnumber, availability, cleaning_status, price, bedtype) VALUES ('" + roomnumber + "', '" + availability + "', '" + cleaning_status + "', '" + price + "', '" + bedtype + "')";
               
               conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "New Room added successfully");
            
            setVisible(false);
               
            } catch (Exception e ) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
        new AddRooms();
    }
    
}
