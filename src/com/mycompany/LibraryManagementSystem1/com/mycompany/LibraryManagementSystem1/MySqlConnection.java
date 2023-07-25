/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sachin Thakur
 */
public class MySqlConnection {

    public MySqlConnection() {
        try {  
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Connection getConnection() throws SQLException
    {
        
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8","root","root");  
        return con;
    }    
    
//    public static void main(String[] args) {
//        MySqlConnection obj=new MySqlConnection();
//        try {
//            Connection con=obj.getConnection();
//            Statement stmt=(Statement) con.createStatement();
//            ResultSet rs=(ResultSet) stmt.executeQuery("Select * from employee;");
//            while(rs.next())  {
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//            }
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
