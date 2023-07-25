/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Sachin Thakur
 */
public final class NotificationMessage {

    Book book;
   
    PanelRound mainpanel;
    JLabel studentdeatil, bookdetail, name, phone, email,totalbook,title,isbn,id,category;
ButtonRound  accept,decline;
    public NotificationMessage(Book book) {
        this.book = book;
//      NotificationMessage1();
    }

    public void NotificationMessage1() {

        mainpanel = new PanelRound();
        mainpanel.setBounds(0, 0, 1080, 60);
        mainpanel.setRoundbottomleft(10);
        mainpanel.setRoundbottomright(10);
        mainpanel.setRoundtopleft(10);
        mainpanel.setRoundtopright(10);
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);//new Color(33, 97, 140)
        book.notificationpanel2.add(mainpanel);

        studentdeatil = new JLabel("STUDENT DETAIL");
        studentdeatil.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        studentdeatil.setHorizontalAlignment(SwingConstants.CENTER);
        studentdeatil.setHorizontalTextPosition(SwingConstants.CENTER);
        studentdeatil.setFont(new Font("Arial", Font.BOLD, 15));
        studentdeatil.setBackground(Color.red);
        studentdeatil.setBounds(0, 0, 280, 20);
        mainpanel.add(studentdeatil);

       

        name = new JLabel("Name");
        name.setBounds(0, 20, 280, 16);
        name.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 2, Color.BLACK));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        name.setFont(new Font("Times New Romans", Font.PLAIN, 14));
        mainpanel.add(name);
        phone = new JLabel("Phone");
        phone.setBounds(0, 36, 280, 12);
        phone.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        phone.setHorizontalAlignment(SwingConstants.CENTER);
        phone.setHorizontalTextPosition(SwingConstants.CENTER);
        phone.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(phone);
        email = new JLabel("Email");
        email.setBounds(0, 48, 280, 12);
        email.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setHorizontalTextPosition(SwingConstants.CENTER);
        email.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(email);
        
        
        
        
         bookdetail = new JLabel("BOOK DETAIL");
        bookdetail.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        bookdetail.setHorizontalAlignment(SwingConstants.CENTER);
        bookdetail.setHorizontalTextPosition(SwingConstants.CENTER);
        bookdetail.setFont(new Font("Arial", Font.BOLD, 15));
        bookdetail.setBackground(Color.red);
        bookdetail.setBounds(280, 0, 480, 20);
        mainpanel.add(bookdetail);

        title = new JLabel("Title");
        title.setBounds(280, 20, 480, 16);
        title.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 2, Color.BLACK));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setFont(new Font("Times New Romans", Font.PLAIN, 14));
        mainpanel.add(title);
        
        
        id = new JLabel("id");
        id.setBounds(280, 36, 240, 12);
        id.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        id.setHorizontalAlignment(SwingConstants.CENTER);
        id.setHorizontalTextPosition(SwingConstants.CENTER);
        id.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(id);
        
        
        isbn = new JLabel("isbn");
        isbn.setBounds(520, 36, 240, 12);
        isbn.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        isbn.setHorizontalAlignment(SwingConstants.CENTER);
        isbn.setHorizontalTextPosition(SwingConstants.CENTER);
        isbn.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(isbn);
        
        category = new JLabel("catery");
        category.setBounds(280, 48, 240, 12);
        category.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        category.setHorizontalAlignment(SwingConstants.CENTER);
        category.setHorizontalTextPosition(SwingConstants.CENTER);
        category.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(category);
        
        
        totalbook = new JLabel("book");
        totalbook.setBounds(520, 48, 240, 12);
        totalbook.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 2, Color.BLACK));
        totalbook.setHorizontalAlignment(SwingConstants.CENTER);
        totalbook.setHorizontalTextPosition(SwingConstants.CENTER);
        totalbook.setFont(new Font("Times New Romans", Font.PLAIN, 10));
        mainpanel.add(totalbook);

        
        accept = new ButtonRound();
        accept.setText("Accept");
        accept.setRoundbottomleft(10);
        accept.setRoundbottomright(10);
        accept.setRoundtopleft(10);
        accept.setRoundtopright(10);
        accept.setBackground(new Color(102, 153, 0));
        accept.setForeground(Color.WHITE);
        accept.setFont(new Font("Times New Romans", Font.BOLD, 15));
        accept.setBounds(770, 15, 145, 30);
        accept.setMouseClickColor(new Color(102, 153, 0));
        accept.setMouseEnterColor(new Color(102, 153, 0));
        accept.setMouseExistColor(new Color(102, 153, 0));
        accept.setTextClickColor(Color.WHITE);
        accept.setTextEnterColor(Color.BLACK);
        accept.setTextExistColor(Color.WHITE);
        mainpanel.add(accept);
//        accept.addActionListener(this);
//        accept.setActionCommand("SUBMIT");
        
        
        decline = new ButtonRound();
        decline.setText("Decline");
        decline.setRoundbottomleft(10);
        decline.setRoundbottomright(10);
        decline.setRoundtopleft(10);
        decline.setRoundtopright(10);
        decline.setBackground(new Color(244, 67, 54));
        decline.setForeground(Color.WHITE);
        decline.setFont(new Font("Times New Romans", Font.BOLD, 15));
        decline.setBounds(920, 15, 145, 30);
        decline.setMouseClickColor(new Color(244, 67, 54));
        decline.setMouseEnterColor(new Color(244, 67, 54));
        decline.setMouseExistColor(new Color(244, 67, 54));
        decline.setTextClickColor(Color.WHITE);
        decline.setTextEnterColor(Color.BLACK);
        decline.setTextExistColor(Color.WHITE);
        mainpanel.add(decline);
//        decline.addActionListener(this);
//        decline.setActionCommand("SUBMIT");
//        
        
        
        
    }

}
