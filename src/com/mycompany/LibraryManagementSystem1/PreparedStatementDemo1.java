///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.LibraryManagementSystem1;
//
//import java.sql.*;
//import java.io.*;
//
//public class PreparedStatementDemo1 {
//
//    PreparedStatement ps;
//    Connection con;
//
//    public PreparedStatementDemo1() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8", "root", "root");
//        } catch (ClassNotFoundException | SQLException e) {
//        }
//    }
//// add customer detail
//
//    public String addCustomer(String custid, String name, String address,
//            String contact) {
//        String status = "";
//        try {
//            ps = con.prepareStatement("insert into Customer values (?,?,?,?)");
//            ps.setString(1, custid);
//            ps.setString(2, name);
//            ps.setString(3, address);
//            ps.setString(4, contact);
//            int i = ps.executeUpdate();
//            if (i != 0) {
//                status = "Inserted";
//            } else {
//                status = "Not Inserted";
//            }
//        } catch (SQLException e) {
//        }
//        return status;
//    }
//// customer record
//
//    public void searchCustomer(String custid) {
//        String sql = ""
//        if (custid.trim().length() == 0) {
//            sql = "select * from Customer";
//        } else {
//            sql = "select * from Customer where custid =" + custid + "";
//        }
//        try {
//            ps = con.prepareStatement(sql);
//            ResultSet res = ps.executeQuery();
//            while (res.next()) {
//                System.out.print(res.getString(1));
//                System.out.print(res.getString(2));
//                System.out.print(res.getString(3));
//                System.out.println(res.getString(4));
//            }
//        } catch (SQLException e) {
//        }
//    }
//
//    public String deleteCustomer(String custId) {
//        String status = "";
//        try {
//            ps = con.prepareStatement("delete from Customer where custid =  ?");
//            ps.setString(1, custId);
//            int i = ps.executeUpdate();
//            if (i != 0) {
//                status = "Customer details deleted";
//            } else {
//                status = "Customer details not deleted";
//            }
//        } catch (SQLException e) {
//        }
//        return status;
//    }
//
//    public void menuDisplay() {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int ch = 0;
//            while (true) {
//                System.out.println("== Customer Management System == \n "1. Add Customer "\n  + "2. Display Customer ’s record \n+ "3. Exit \n
//                " + "Enter Choice \n ");
//           String str1 = br.readLine().toString();
//                ch = Integer.parseInt(str1);
//                switch (ch) {
//                    case 1: {
//                        System.out.println("Enter Customer Id");
//                        String custId = br.readLine();
//                        System.out.println("Enter Customer Name");
//                        String custName = br.readLine();
//                        System.out.println("Enter Customer Address");
//                        String custAddress = br.readLine();
//                        System.out.println("Enter Customer Contact No.");
//                        String custContact = br.readLine();
//                        System.out.println(addCustomer(custId, custName,
//                                custAddress, custContact));
//                        break;
//                    }
//                    case 2: {
//                        System.out.println("Enter Customer Code to display record");
//                        String custId = br.readLine();
//                        searchCustomer(custId);
//                        break;
//                    }
//                    case 3: {
//                        System.exit(0);
//                    }
//                    default:
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        PreparedStatementDemo1 obj = new PreparedStatementDemo1();
//        obj.menuDisplay();
//    }
//}
