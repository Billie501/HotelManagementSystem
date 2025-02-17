/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.Management.System;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author billi
 */
public class Conn {
    
    
    String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem?useSSL=false";
    String user = "root";
    String password = "";
    
    
    Connection c;
    Statement s;
    
    Conn() {
        try {
        c = DriverManager.getConnection(url, user, password);
        s = c.createStatement();
        System.out.println("Database connected successfully!");
    } catch (SQLException e) {
        System.err.println("Database connection failed: " + e.getMessage());
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        new Conn(); // Test connection
    }
    
    
}
