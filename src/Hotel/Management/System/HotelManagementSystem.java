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
public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem() {
       //setSize(1366, 665);
       //setLocation(100, 100);
       setBounds(100, 100, 1366, 665);
       setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newfirstfirst.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(0, 0, 1366, 665);
       add(image);
       
       JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
       text.setBounds(180, 340, 1000, 90);
       text.setForeground(Color.BLACK);
       text.setFont(new Font("serif", Font.PLAIN, 50));
       image.add(text);
       
       JButton next = new JButton("Next");
       next.setBounds(1000, 360, 150, 50);
       next.setBackground(Color.WHITE);
       next.setForeground(Color.BLACK);
       next.addActionListener(this);
       next.setFont(new Font("serif", Font.PLAIN, 24));
       image.add(next);
              
       setVisible(true);
       
//       while(true) {
//           text.setVisible(false);
//           try {
//               //Thread.sleep(1000);
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//           text.setVisible(true);
//           try {
//               //Thread.sleep(1000);
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//       }
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
