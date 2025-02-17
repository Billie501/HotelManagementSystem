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
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfsalary, tfemail, tfphone, tfage, tfid;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbrole;
    
    AddEmployee() {
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblrole = new JLabel("Role");
        lblrole.setBounds(60, 180, 120, 30);
        lblrole.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblrole);
        
        String str[] = { "Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Chef", "Waiter/Waitress", "Manager", "Accountant" };
        cbrole = new JComboBox(str);
        cbrole.setBounds(200, 180, 150, 30);
        cbrole.setBackground(Color.WHITE);
        add(cbrole);
        
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(60, 380, 120, 30);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(200, 380, 150, 30);
        add(tfid);
        
        submit = new JButton("Submit");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
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
        
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String id = tfid.getText();
        
        String gender = null;
        
        if(name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your name");
            return;
        }

        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }
        
        String role = (String) cbrole.getSelectedItem();
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"','"+role+"', '"+salary+"', '"+phone+"', '"+email+"', '"+id+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        new AddEmployee();
    }
    
}