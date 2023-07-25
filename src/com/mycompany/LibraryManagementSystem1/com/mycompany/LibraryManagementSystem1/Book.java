/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sachin Thakur
 */
public final class Book implements ActionListener {

    int booksequence = 0;

    PanelRound messagepanel,notificationpanel2, messagepanel1, p1, p11, p22, p2, showbookpanel, showdetailpanel, showdetailpanel1,notificationpanel;
    MainhomePage mp;
    JLabel arrow, poplabel, arrow1, labelbook, addbook, l2, profilelabel, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
    JLabel bookidlabel, notification, notificationNumber,readmorelabel, isbnlabel, booktitlelabel, bookauthorlabel, publisherlabel, datelabel, editionlabel, categorylabel, languagelabel, numberofbooklabel, imagelabel;
    JPanel readmorePanel;
    TitledBorder bdtitle;
    BookTextField tr, t1, t2, t3, t4, t5, t6, t7, t8, t9;
    RoundJComboBox cb, cb1, cb2;
    JScrollPane scroll;
    BookTextArea ta;
    JTextArea descriptionlabel;
    ButtonRound b1, b2, b3,br;
    String path = null;
    ImageAvatar avtar = new ImageAvatar();
    ImageResizer resizer;
    JFileChooser chooser;
    File f;
    int userid=0;
    int a, b,s, value=1,num=0, x = 0, y = 0,m=0,s12=0;
    boolean over, over1 = true,over2=true,over3=true;
    PhonenumberValidation wordchanger = new PhonenumberValidation();
    UppercaseTextfield uptext = new UppercaseTextfield();
    MySqlConnection obj = new MySqlConnection();
    textDialogbox successdialog1 = new textDialogbox();
 NotificationMessage noty;
    Connection con = null;

    public Book(MainhomePage mp) {
        this.mp = mp;
        try {
            con = obj.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddBook();
        ShowBook();
        Notificationbell();
        Successdialog();
        noty=new NotificationMessage(this);
         
//        noty.NotificationMessage1();
    }

    public void AddBook() {

        messagepanel = new PanelRound();
        messagepanel.setLayout(null);
        messagepanel.setBounds(35, 90, 1155, 610);
        messagepanel.setRoundbottomleft(10);
        messagepanel.setRoundbottomright(10);
        messagepanel.setRoundtopleft(10);
        messagepanel.setRoundtopright(10);
        messagepanel.setBackground(new Color(0, 0, 0, 0));
        mp.mainpanel.add(messagepanel);
        messagepanel.setVisible(false);

        p1 = new PanelRound();
        p1.setBounds(35, 0, 1120, 600);
        p1.setRoundbottomleft(10);
        p1.setRoundbottomright(10);
        p1.setRoundtopleft(10);
        p1.setRoundtopright(10);
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);//new Color(33, 97, 140)
        messagepanel.add(p1);

        arrow = new JLabel(new ImageIcon("images/arrow6.png"));
        arrow.setBounds(15, 43, 33, 33);
        messagepanel.add(arrow);
        p2 = new PanelRound() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawLine(10, 50, 1095, 50);
            }
        };
        p2.setBounds(5, 5, 1110, 590);
        p2.setRoundbottomleft(10);
        p2.setRoundbottomright(10);
        p2.setRoundtopleft(10);
        p2.setRoundtopright(10);
        p2.setLayout(null);
        p2.setBackground(new Color(33, 97, 140, 100));//new Color(33, 97, 140)
        p1.add(p2);
        addbook = new JLabel();
        addbook.setBounds(100, 5, 900, 590);
        p1.add(addbook);
        ImageIcon campho = new ImageIcon(new ImageIcon("images/booktab.png").getImage().getScaledInstance(addbook.getWidth(), addbook.getHeight(), Image.SCALE_SMOOTH));
        addbook.setIcon(campho);

        //=======================================================LABEL    
        l2 = new JLabel("ADD BOOK");
        l2.setBounds(440, 5, 275, 40);
        l2.setForeground(new Color(33, 97, 140));
        l2.setFont(new Font("serif", Font.BOLD, 50));
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p2.add(l2);

        profilelabel = new JLabel(new ImageIcon("images/check.png"));
        profilelabel.setBounds(635, 235, 30, 30);
        p2.add(profilelabel);
        profilelabel.setVisible(false);

//====================================================================TEXTFIELD
        tr = new BookTextField(" Book Id");
        tr.setCornersize(10);
        tr.setBounds(75, 310, 200, 40);
        tr.setBackground(new Color(255, 249, 158));
        tr.setSelectionColor(new Color(21, 101, 192));
        tr.setSelectedTextColor(Color.white);
        tr.setForeground(Color.GRAY);
        tr.setToolTipText("Please fill Book Id");
        p2.add(tr);
        BookidLetter(tr);
        tr.label.setBounds(75, 290, 150, 20);
        p2.add(tr.label);
        label1 = new JLabel("Please Enter book ID");
        label1.setBounds(75, 290, 150, 20);
        label1.setForeground(Color.red);
        label1.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label1);
        label1.setVisible(false);
        tr.setLabelerror(label1);
        labelbook = new JLabel("Bookid is Exist");
        labelbook.setBounds(125, 350, 150, 20);
        labelbook.setForeground(Color.red);
        labelbook.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(labelbook);
        labelbook.setVisible(false);

        t1 = new BookTextField(" ISBN");
        t1.setCornersize(10);
        t1.setBounds(325, 310, 200, 40);
        t1.setBackground(new Color(255, 249, 158));
        t1.setSelectionColor(new Color(21, 101, 192));
        t1.setSelectedTextColor(Color.white);
        t1.setForeground(Color.GRAY);
        t1.setToolTipText("Please Fill out the ISBN");
        p2.add(t1);
        t1.label.setBounds(325, 290, 150, 20);
        p2.add(t1.label);
        label2 = new JLabel("Please Enter ISBN");
        label2.setBounds(325, 290, 150, 20);
        label2.setForeground(Color.red);
        label2.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label2);
        label2.setVisible(false);
        t1.setLabelerror(label2);

        t2 = new BookTextField(" Book Title");
        t2.setCornersize(10);
        t2.setBounds(575, 310, 200, 40);
        t2.setBackground(new Color(255, 249, 158));
        t2.setSelectionColor(new Color(21, 101, 192));
        t2.setSelectedTextColor(Color.white);
        t2.setForeground(Color.GRAY);
        t2.setToolTipText("Please fill out the Title");
        p2.add(t2);
        t2.label.setBounds(575, 290, 150, 20);
        p2.add(t2.label);
        label3 = new JLabel("Please Enter Book Title");
        label3.setBounds(575, 290, 150, 20);
        label3.setForeground(Color.red);
        label3.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label3);
        label3.setVisible(false);
        t2.setLabelerror(label3);
        BookidChar(t2);
        uptext.Uppercase(t2);

        t3 = new BookTextField(" Book Auther");
        t3.setCornersize(10);
        t3.setBounds(825, 310, 200, 40);
        t3.setBackground(new Color(255, 249, 158));
        t3.setSelectionColor(new Color(21, 101, 192));
        t3.setSelectedTextColor(Color.white);
        t3.setForeground(Color.GRAY);
        t3.setToolTipText("Please fill out the Author");
        p2.add(t3);
        BookidChar(t3);
        t3.label.setBounds(825, 290, 150, 20);
        p2.add(t3.label);
        label4 = new JLabel("Please Enter Book Author");
        label4.setBounds(825, 290, 150, 20);
        label4.setForeground(Color.red);
        label4.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label4);
        label4.setVisible(false);
        t3.setLabelerror(label4);

        t4 = new BookTextField(" Publisher");
        t4.setCornersize(10);
        t4.setBounds(75, 380, 200, 40);
        t4.setBackground(new Color(255, 249, 158));
        t4.setSelectionColor(new Color(21, 101, 192));
        t4.setSelectedTextColor(Color.white);
        t4.setForeground(Color.GRAY);
        t4.setToolTipText("Please fill out the Publisher");
        p2.add(t4);
        BookidChar(t4);
        t4.label.setBounds(75, 360, 150, 20);
        p2.add(t4.label);
        label5 = new JLabel("Please Enter Publisher");
        label5.setBounds(75, 360, 150, 20);
        label5.setForeground(Color.red);
        label5.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label5);
        label5.setVisible(false);
        t4.setLabelerror(label5);

        t5 = new BookTextField(" Publication Date");
        t5.setCornersize(10);
        t5.setBounds(325, 380, 200, 40);
        t5.setBackground(new Color(255, 249, 158));
        t5.setSelectionColor(new Color(21, 101, 192));
        t5.setSelectedTextColor(Color.white);
        t5.setForeground(Color.GRAY);
        t5.setToolTipText("Please fill out the Date");
        p2.add(t5);
        BookidLetter(t5);
        t5.label.setBounds(325, 360, 150, 20);
        p2.add(t5.label);
        label6 = new JLabel("Please Enter publication Date");
        label6.setBounds(325, 360, 150, 20);
        label6.setForeground(Color.red);
        label6.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label6);
        label6.setVisible(false);
        t5.setLabelerror(label6);

        cb1 = new RoundJComboBox();
        cb1.setBounds(575, 380, 200, 40);
        p2.add(cb1);
        label7 = new JLabel("Please Select Edition");
        label7.setBounds(575, 360, 150, 20);
        label7.setForeground(Color.red);
        label7.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label7);
        label7.setVisible(false);
        cb1.setLabelerror(label7);
        Edition();

        cb2 = new RoundJComboBox();
        cb2.setBounds(825, 380, 200, 40);
        p2.add(cb2);
        label8 = new JLabel("Please Select Catgory");
        label8.setBounds(825, 360, 150, 20);
        label8.setForeground(Color.red);
        label8.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label8);
        label8.setVisible(false);
        cb2.setLabelerror(label8);
        Cateogory();

        t8 = new BookTextField("Number oF Book");
        t8.setCornersize(10);
        t8.setBounds(825, 450, 200, 40);
        t8.setBackground(new Color(255, 249, 158));
        t8.setSelectionColor(new Color(21, 101, 192));
        t8.setSelectedTextColor(Color.white);
        t8.setForeground(Color.GRAY);
        t8.setToolTipText("Please fill out the Title");
        p2.add(t8);
        BookidLetter(t8);
        t8.label.setBounds(825, 430, 150, 20);
        p2.add(t8.label);
        label9 = new JLabel("Please Enter Number oF Book");
        label9.setBounds(825, 430, 150, 20);
        label9.setForeground(Color.red);
        label9.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label9);
        label9.setVisible(false);
        t8.setLabelerror(label9);
        cb = new RoundJComboBox();
        cb.setBounds(75, 450, 200, 40);
        cb.addItem("Select Language");
        cb.addItem("Hindi");
        cb.addItem("English");
        p2.add(cb);
        label10 = new JLabel("Please Select Language");
        label10.setBounds(75, 430, 200, 20);
        label10.setForeground(Color.red);
        label10.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label10);
        label10.setVisible(false);
        cb.setLabelerror(label10);

        ta = new BookTextArea("                                                                 Description");
        ta.setLineWrap(true);
        ta.setBackground(new Color(255, 249, 158));
        scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(new RoundBorder(10));
        scroll.setBounds(325, 450, 450, 100);
        scroll.setBackground(new Color(255, 249, 158));
        p2.add(scroll);
        ta.label.setBounds(325, 430, 450, 20);
        p2.add(ta.label);
        label11 = new JLabel("Please Enter Description");
        label11.setBounds(325, 430, 450, 20);
        label11.setForeground(Color.red);
        label11.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(label11);
        label11.setVisible(false);
        ta.setLabelerror(label11);
//==============================================================BUTTON

        b1 = new ButtonRound();
        b1.setText("Update Image");
        b1.setRoundbottomleft(220);
        b1.setRoundbottomright(220);
        b1.setRoundtopleft(220);
        b1.setRoundtopright(220);
        b1.setBackground(new Color(0, 0, 0, 0));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Serif", Font.BOLD, 28));
        b1.setBounds(465, 75, 200, 200);
        b1.setMouseClickColor(new Color(102, 153, 0, 0));
        b1.setMouseEnterColor(new Color(102, 153, 0, 0));
        b1.setMouseExistColor(new Color(33, 97, 140, 0));
        b1.setTextClickColor(new Color(245, 127, 23));
        b1.setTextEnterColor(Color.WHITE);
        b1.setTextExistColor(Color.WHITE);
        p2.add(b1);
        b1.addActionListener(this);
        b1.setActionCommand("profile");

        b2 = new ButtonRound();
        b2.setText("Submit");
        b2.setRoundbottomleft(10);
        b2.setRoundbottomright(10);
        b2.setRoundtopleft(10);
        b2.setRoundtopright(10);
        b2.setBackground(new Color(33, 97, 140));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Times New Romans", Font.BOLD, 15));
        b2.setBounds(920, 540, 100, 30);
        b2.setMouseClickColor(new Color(102, 153, 0));
        b2.setMouseEnterColor(new Color(102, 153, 0));
        b2.setMouseExistColor(new Color(33, 97, 140));
        b2.setTextClickColor(new Color(245, 127, 23));
        b2.setTextEnterColor(Color.WHITE);
        b2.setTextExistColor(Color.WHITE);
        p2.add(b2);
        b2.addActionListener(this);
        b2.setActionCommand("SUBMIT");

        //===========================================================BOOK IMAGE       
        avtar.setBounds(455, 70, 220, 220);
        avtar.setBorderSize(4);
        avtar.setForeground(new Color(245, 127, 23));
        p2.add(avtar);
        ImageIcon icon = new ImageIcon(new ImageIcon("images/profilebook1.png").getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
        avtar.setIcon(icon);

    }

    public void ShowBook() {
        messagepanel1 = new PanelRound();
        messagepanel1.setLayout(null);
        messagepanel1.setBounds(35, 90, 1155, 610);
        messagepanel1.setRoundbottomleft(10);
        messagepanel1.setRoundbottomright(10);
        messagepanel1.setRoundtopleft(10);
        messagepanel1.setRoundtopright(10);
        messagepanel1.setBackground(new Color(0, 0, 0, 0));
        mp.mainpanel.add(messagepanel1);
        messagepanel1.setVisible(false);

        p11 = new PanelRound();
        p11.setBounds(35, 0, 1120, 600);
        p11.setRoundbottomleft(10);
        p11.setRoundbottomright(10);
        p11.setRoundtopleft(10);
        p11.setRoundtopright(10);
        p11.setLayout(null);
        p11.setBackground(Color.WHITE);//new Color(33, 97, 140)
        messagepanel1.add(p11);

        arrow1 = new JLabel(new ImageIcon("images/arrow6.png"));
        arrow1.setBounds(15, 83, 33, 33);
        messagepanel1.add(arrow1);
        p22 = new PanelRound();
        p22.setBounds(5, 5, 1110, 52);
        p22.setRoundbottomleft(0);
        p22.setRoundbottomright(0);
        p22.setRoundtopleft(10);
        p22.setRoundtopright(10);
        p22.setLayout(null);
        p22.setBackground(new Color(33, 97, 140, 100));//new Color(33, 97, 140)
        p11.add(p22);
        //===========================================================LABEL 
        l2 = new JLabel("SHOW BOOK");
        l2.setBounds(430, 5, 350, 40);
        l2.setForeground(new Color(33, 97, 140));
        l2.setFont(new Font("serif", Font.BOLD, 50));
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p22.add(l2);
        //=============================================================panel
        showbookpanel = new PanelRound();
        showbookpanel.setLayout(null);
        showbookpanel.setBackground(new Color(33, 97, 140, 100));
        showbookpanel.setRoundbottomleft(10);
        showbookpanel.setRoundbottomright(10);
        scroll = new JScrollPane(showbookpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.setBounds(5, 58, 1110, 537);
        showbookpanel.setPreferredSize(new Dimension(1100, 1000));
        p11.add(scroll);

    }

    public void Showbookdetail() {

        showdetailpanel = new PanelRound();
        showdetailpanel.setLayout(null);
        showdetailpanel.setBackground(new Color(0, 153, 0));
        showdetailpanel.setRoundbottomleft(10);
        showdetailpanel.setRoundbottomright(10);
        showdetailpanel.setRoundtopleft(10);
        showdetailpanel.setRoundtopright(10);
        showbookpanel.add(showdetailpanel);

        showdetailpanel1 = new PanelRound();
        showdetailpanel1.setLayout(null);
        showdetailpanel1.setBackground(Color.WHITE);
        showdetailpanel1.setBounds(5, 5, 520, 110);
        showdetailpanel1.setRoundbottomleft(5);
        showdetailpanel1.setRoundbottomright(5);
        showdetailpanel1.setRoundtopleft(5);
        showdetailpanel1.setRoundtopright(5);
        showdetailpanel.add(showdetailpanel1);

        booktitlelabel = new JLabel();
        booktitlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        booktitlelabel.setHorizontalTextPosition(SwingConstants.CENTER);
        booktitlelabel.setFont(new Font("Arial", Font.BOLD, 20));
        booktitlelabel.setBounds(130, 0, 400, 20);
        showdetailpanel1.add(booktitlelabel);

        poplabel = new JLabel(new ImageIcon("images/popup.png"));
        poplabel.setBounds(110, 5, 20, 20);
        showdetailpanel1.add(poplabel);
        poplabel.setToolTipText("borrow");
               
                
                int r=s12;
                 
        poplabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  
                  if(value==0){
                         JOptionPane.showMessageDialog(null, "Allready Borrow");
                  
               
                  }else{
                      notificationNumber.setVisible(true);
                      num++;
                      notificationNumber.setText("("+num+")");
                 noty.NotificationMessage1();
                 noty.mainpanel.setBounds(0, m, 1080, 60);
                 m=65+m;
           //bookid, isbn, booktitle, bookauthor, publisher, date, edition, category, language, description, numberofbook, image, booksequence
                      try {
                       PreparedStatement   pst = con.prepareStatement("Select * from addbook where booksequence=" + r + "");
                       ResultSet rs = (ResultSet) pst.executeQuery();
                       while(rs.next()){
                       noty.title.setText(rs.getString(3));
                       noty.id.setText(rs.getString(1));
                       noty.isbn.setText(rs.getString(2));
                      noty.category.setText(rs.getString(8));
                      noty.totalbook.setText(rs.getString(11));
                       }
           //id, FullName, EmailId, PhoneNo, InstitutionName, InstitutionType, YourRole, profileimage            
                       PreparedStatement   pst1 = con.prepareStatement("Select * from signup where id=" + userid + "");
                       ResultSet rs1 = (ResultSet) pst1.executeQuery();
                       while(rs1.next()){
                      noty.name.setText(rs1.getString(2));
                      noty.phone.setText(rs1.getString(4));
                      noty.email.setText(rs1.getString(3));
                              
                       }
                       
                       
                       
                      } catch (SQLException ex) {
                          Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      value=1;
                 }
                
            }
            
        
        });
    

        bookauthorlabel = new JLabel();
        bookauthorlabel.setBounds(110, 20, 140, 15);
        bookauthorlabel.setHorizontalAlignment(SwingConstants.CENTER);
        bookauthorlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        bookauthorlabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(bookauthorlabel);

        bookidlabel = new JLabel();
        bookidlabel.setBounds(250, 20, 140, 15);
        bookidlabel.setHorizontalAlignment(SwingConstants.CENTER);
        bookidlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        bookidlabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(bookidlabel);

        isbnlabel = new JLabel();
        isbnlabel.setBounds(390, 20, 140, 15);
        isbnlabel.setHorizontalAlignment(SwingConstants.CENTER);
        isbnlabel.setHorizontalTextPosition(SwingConstants.CENTER);

        isbnlabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(isbnlabel);

        publisherlabel = new JLabel();
        publisherlabel.setBounds(110, 35, 140, 15);
        publisherlabel.setHorizontalAlignment(SwingConstants.CENTER);
        publisherlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        publisherlabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(publisherlabel);

        datelabel = new JLabel();
        datelabel.setBounds(250, 35, 140, 15);
        datelabel.setHorizontalAlignment(SwingConstants.CENTER);
        datelabel.setHorizontalTextPosition(SwingConstants.CENTER);
        datelabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(datelabel);

        editionlabel = new JLabel();
        editionlabel.setBounds(390, 35, 140, 15);
        editionlabel.setHorizontalAlignment(SwingConstants.CENTER);
        editionlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        editionlabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(editionlabel);

        categorylabel = new JLabel();
        categorylabel.setBounds(110, 50, 140, 15);
        categorylabel.setHorizontalAlignment(SwingConstants.CENTER);
        categorylabel.setHorizontalTextPosition(SwingConstants.CENTER);
        categorylabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(categorylabel);

        languagelabel = new JLabel();
        languagelabel.setBounds(250, 50, 140, 15);
        languagelabel.setHorizontalAlignment(SwingConstants.CENTER);
        languagelabel.setHorizontalTextPosition(SwingConstants.CENTER);
        languagelabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(languagelabel);

        numberofbooklabel = new JLabel();
        numberofbooklabel.setBounds(390, 50, 140, 15);
        numberofbooklabel.setHorizontalAlignment(SwingConstants.CENTER);
        numberofbooklabel.setHorizontalTextPosition(SwingConstants.CENTER);
        numberofbooklabel.setFont(new Font("Arial", Font.BOLD, 10));
        showdetailpanel1.add(numberofbooklabel);

        descriptionlabel = new JTextArea();
        descriptionlabel.setBounds(130, 60, 370, 45);
        descriptionlabel.setLineWrap(true);
        descriptionlabel.setEditable(false);
        descriptionlabel.setFont(new Font("Arial", Font.BOLD, 12));
        showdetailpanel1.add(descriptionlabel);

        readmorePanel = new JPanel();
        readmorePanel.setBounds(291, 30, 77, 16);
        readmorePanel.setLayout(null);
        readmorePanel.setBackground(Color.WHITE);
        descriptionlabel.add(readmorePanel);
        readmorePanel.setVisible(false);
        readmorelabel = new JLabel("....Read more");
        readmorelabel.setBounds(2, 0, 77, 16);
        readmorelabel.setForeground(Color.BLUE);
        readmorelabel.setFont(new Font("Arial", Font.BOLD, 12));
        readmorePanel.add(readmorelabel);

        imagelabel = new JLabel();
        imagelabel.setBounds(5, 5, 100, 100);
        imagelabel.setBackground(Color.GRAY);
        imagelabel.setForeground(Color.BLACK);
        ImageIcon icon = new ImageIcon(new ImageIcon("images/addbook1.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        imagelabel.setIcon(icon);
        imagelabel.setBorder(BorderFactory.createBevelBorder(10, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        showdetailpanel1.add(imagelabel);
        imagelabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//UpdateBookdetail();

    }
   

    public void UpdateBookdetail() {
        try {
            PreparedStatement pst = con.prepareStatement("Select * from addbook where booksequence > " + booksequence + " order by booksequence");
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                booksequence++;
                 s = rs.getInt(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);
                String s6 = rs.getString(7);
                String s7 = rs.getString(8);
                String s8 = rs.getString(9);
                String s9 = rs.getString(10);
                String s10 = rs.getString(11);
                byte[] s11 = rs.getBytes(12);
                s12=rs.getInt(13);
                if (over1) {

                    a = 5 + x;
                    Showbookdetail();
                    showdetailpanel.setBounds(10, a, 530, 120);
                  
                    x = 120 + a;
                    over1 = false;

                } else {
                    b = 5 + y;
                    Showbookdetail();
                    showdetailpanel.setBounds(550, b, 530, 120);
                
                    y = 120 + b;
                    over1 = true;

                }
                bookidlabel.setText("" + s);
                isbnlabel.setText(s1);
                booktitlelabel.setText(s2);
                bookauthorlabel.setText(s3);
                publisherlabel.setText(s4);
                datelabel.setText(s5);
                editionlabel.setText(s6);
                categorylabel.setText(s7);
                languagelabel.setText(s8);
                descriptionlabel.setText(s9);
                numberofbooklabel.setText(s10);
                ImageIcon image = new ImageIcon(new ImageIcon(s11).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                imagelabel.setIcon(image);
                System.out.println(descriptionlabel.getText().lastIndexOf("") + "=cart? ");

                Readmore();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
    
    
    public void Notificationbell() {
        
         notificationpanel = new PanelRound();
        notificationpanel.setLayout(null);
        notificationpanel.setBounds(70, 70, 1120, 630);
        notificationpanel.setRoundbottomleft(10);
        notificationpanel.setRoundbottomright(10);
        notificationpanel.setRoundtopleft(10);
        notificationpanel.setRoundtopright(10);
        notificationpanel.setBackground(new Color(0, 0, 0, 0));
        mp.mainpanel.add(notificationpanel);
        notificationpanel.setVisible(false);

        p11 = new PanelRound();
        p11.setBounds(0, 20, 1120, 600);
        p11.setRoundbottomleft(10);
        p11.setRoundbottomright(10);
        p11.setRoundtopleft(10);
        p11.setRoundtopright(10);
        p11.setLayout(null);
        p11.setBackground(Color.WHITE);//new Color(33, 97, 140)
        notificationpanel.add(p11);

          arrow = new JLabel(new ImageIcon("images/notificationarrow.png"));
        arrow.setBounds(1037, 0, 33, 33);
        notificationpanel.add(arrow);
        
        
        p2 = new PanelRound();
        p2.setBounds(5, 5, 1110, 590);
        p2.setRoundbottomleft(10);
        p2.setRoundbottomright(10);
        p2.setRoundtopleft(10);
        p2.setRoundtopright(10);
        p2.setLayout(null);
        p2.setBackground(new Color(33, 97, 140));//new Color(33, 97, 140)
        p11.add(p2);
        
         notificationpanel2 = new PanelRound();
         notificationpanel2.setBackground(new Color(33, 97, 140));
        notificationpanel2.setLayout(null);
        notificationpanel2.setRoundbottomleft(10);
        notificationpanel2.setRoundbottomright(10);
        scroll = new JScrollPane(notificationpanel2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.setBounds(5, 5, 1100, 580);
        
        notificationpanel2.setPreferredSize(new Dimension(1100, 1000));
         
       
        p2.add(scroll);
        
        
        
        
        //===========================================================LABEL
        
        
        
        notificationNumber=new JLabel("("+num+")");
        notificationNumber.setBounds(1125, 45, 20, 20);
        notificationNumber.setForeground(Color.RED);
        notificationNumber.setFont(new Font("Arial", Font.BOLD, 12));
        mp.mainpanel2.add(notificationNumber);
        notificationNumber.setVisible(false);
        notification = new JLabel(new ImageIcon("images/notificationbell.png"));
        notification.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        notification.setBounds(1101, 40, 25, 25);
        mp.mainpanel2.add(notification);
        notification.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(over2){notificationpanel.setVisible(true);
                 notificationNumber.setVisible(false);
                 num=0;
                 over2=false;
                 
                 }else{
                     notificationpanel.setVisible(false);
                 over2=true;
                 }
                messagepanel1.setVisible(false);
                messagepanel.setVisible(false);
             }
       
        });//1125, 45, 20, 20
   
  
        
        
        
        
        
        
    }

    
    
    
    
    
    public void Readmore() {
        if (descriptionlabel.getText().lastIndexOf("") >= 164) {
            readmorePanel.setVisible(true);
            int i = 0;
            bookreadmoreDialogbox boxi = new bookreadmoreDialogbox();
            boxi.bodydialogread.setText(descriptionlabel.getText());
            readmorelabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boxi.setVisible(true);
                }

            });
            i++;
        } else {
            readmorePanel.setVisible(false);

        }
    }

    public void Edition() {

        try {
            PreparedStatement pst = con.prepareStatement("Select editionName from edition order by editionsequence");
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                cb1.addItem(rs.getString("editionName"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Cateogory() {

        try {
            PreparedStatement pst = con.prepareStatement("Select categoryname from category order by sequence");
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                cb2.addItem(rs.getString("categoryname"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Successdialog() {

        successdialog1.titlelabel.setText("Add Book");
        successdialog1.bodylabel.setText("Please Ok To Continue");

        JButton okbutton = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton.setFocusable(false);
        okbutton.setContentAreaFilled(false);
        okbutton.setRolloverEnabled(true);
        okbutton.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        successdialog1.buttonpanel.add(okbutton);
        okbutton.addActionListener(this);
        okbutton.setActionCommand("right");

    }

    public void addfontcolor(JTextField jt) {
        jt.setForeground(Color.GRAY);
        jt.setFont(new Font("Arial", Font.BOLD, 12));

    }

    public void addfontcolor(JTextArea jt) {
        jt.setForeground(Color.GRAY);
        jt.setFont(new Font("Arial", Font.BOLD, 12));

    }

    public void BookidChar(JTextField text1) {
        text1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e2) {

                char c = e2.getKeyChar();
                if (Character.isDigit(c)) {
                    e2.consume();
                }

            }

        });

    }

    public void BookidLetter(JTextField text) {
        text.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e1) {

                char c = e1.getKeyChar();
                if (Character.isLetter(c)) {
                    e1.consume();
                }

            }

        });

    }

    public void Resetdata() {

        tr.setText(" Book Id");
        addfontcolor(tr);
        tr.label.setVisible(false);
        t1.setText(" ISBN");
        addfontcolor(t1);
        t1.label.setVisible(false);
        t2.setText(" Book Title");
        addfontcolor(t2);
        t2.label.setVisible(false);

        t3.setText(" Book Auther");
        addfontcolor(t3);
        t3.label.setVisible(false);

        t4.setText(" Publisher");
        addfontcolor(t4);
        t4.label.setVisible(false);

        t5.setText(" Publication Date");
        addfontcolor(t5);
        t5.label.setVisible(false);

        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        t8.setText("Number oF Book");
        addfontcolor(t8);
        t8.label.setVisible(false);

        ta.setText("                                                                 Description");
        addfontcolor(ta);
        ta.label.setVisible(false);

        cb.setSelectedIndex(0);
        b1.setText("Update Image");
        avtar.setForeground(new Color(245, 127, 23));
        profilelabel.setVisible(false);
        ImageIcon icon = new ImageIcon(new ImageIcon("images/profilebook1.png").getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
        avtar.setIcon(icon);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {

            case "right":
                successdialog1.dispose();
                break;

            case "profile":
                chooser = new JFileChooser();
                FileNameExtensionFilter textfilter = new FileNameExtensionFilter("Image (*.png)", "png");
                FileNameExtensionFilter textfilter1 = new FileNameExtensionFilter("Image (*.jpg)", "jpg");
                FileNameExtensionFilter textfilter2 = new FileNameExtensionFilter("Image (*.jpeg)", "jpeg");
                chooser.addChoosableFileFilter(textfilter);
                chooser.addChoosableFileFilter(textfilter1);
                chooser.addChoosableFileFilter(textfilter2);
                chooser.setAcceptAllFileFilterUsed(true);
                int i = chooser.showOpenDialog(null);
                f = chooser.getSelectedFile();

                if (i == JFileChooser.APPROVE_OPTION) {
                    ImageIcon icon = new ImageIcon(new ImageIcon(f.toString()).getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
                    avtar.setIcon(icon);
                    b1.setText("");
                    avtar.setForeground(new Color(33, 218, 108));
                    profilelabel.setVisible(true);
                } else {
                    b1.setText("Update Image");
                    avtar.setForeground(new Color(245, 127, 23));
                    profilelabel.setVisible(false);
                    ImageIcon icon = new ImageIcon(new ImageIcon("images/profilebook1.png").getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
                    avtar.setIcon(icon);
                }

                break;

            case "SUBMIT":
                if ((tr.getText().equals(" Book Id") || tr.getText().equals(""))
                        || (t1.getText().equals(" ISBN") || t1.getText().equals(""))
                        || (t2.getText().equals(" Book Title") || t2.getText().equals(""))
                        || (t3.getText().equals(" Book Auther") || t3.getText().equals(""))
                        || (t4.getText().equals(" Publisher") || t4.getText().equals(""))
                        || (t5.getText().equals(" Publication Date") || t5.getText().equals(""))
                        || (cb1.getSelectedIndex() == 0)
                        || (cb2.getSelectedIndex() == 0)
                        || (t8.getText().equals("Number oF Book") || t8.getText().equals(""))
                        || (ta.getText().equals("                                                                 Description") || ta.getText().equals(""))
                        || (cb.getSelectedIndex() == 0)
                        || (f == null)) {
                    if (tr.getText().equals(" Book Id") || tr.getText().equals("")) {
                        label1.setVisible(true);
                    } else {
                        label1.setVisible(false);
                    }
                    if (t1.getText().equals(" ISBN") || t1.getText().equals("")) {
                        label2.setVisible(true);
                    } else {
                        label2.setVisible(false);
                    }
                    if (t2.getText().equals(" Book Title") || t2.getText().equals("")) {
                        label3.setVisible(true);
                    } else {
                        label3.setVisible(false);
                    }
                    if (t3.getText().equals(" Book Auther") || t3.getText().equals("")) {
                        label4.setVisible(true);
                    } else {
                        label4.setVisible(false);
                    }
                    if (t4.getText().equals(" Publisher") || t4.getText().equals("")) {
                        label5.setVisible(true);
                    } else {
                        label5.setVisible(false);
                    }
                    if (t5.getText().equals(" Publication Date") || t5.getText().equals("")) {
                        label6.setVisible(true);
                    } else {
                        label6.setVisible(false);
                    }
                    if (cb1.getSelectedIndex() == 0) {
                        label7.setVisible(true);
                    } else {
                        label7.setVisible(false);
                    }
                    if (cb2.getSelectedIndex() == 0) {
                        label8.setVisible(true);
                    } else {
                        label8.setVisible(false);
                    }
                    if (t8.getText().equals("Number oF Book") || t8.getText().equals("")) {
                        label9.setVisible(true);
                    } else {
                        label9.setVisible(false);
                    }
                    if (ta.getText().equals("                                                                 Description") || ta.getText().equals("")) {
                        label11.setVisible(true);
                    } else {
                        label11.setVisible(false);
                    }
                    if (cb.getSelectedIndex() == 0) {
                        label10.setVisible(true);
                    } else {
                        label10.setVisible(false);
                    }
                    if (f == null) {
                        b1.setForeground(Color.red);
                        b1.setTextEnterColor(Color.red);
                        b1.setTextExistColor(Color.red);
                        avtar.setForeground(Color.red);
                    } else {
                        b1.setForeground(Color.WHITE);
                        b1.setTextEnterColor(Color.WHITE);
                        b1.setTextExistColor(Color.WHITE);
                        avtar.setForeground(new Color(245, 127, 23));
                    }

                } else {

                    String bookid1 = tr.getText();
                    try {
                        com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("select * from addbook where bookid=? ");
                        pst.setString(1, bookid1);
                        ResultSet rs = (ResultSet) pst.executeQuery();
                        over = rs.next();

                    } catch (SQLException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (!over) {
                        labelbook.setVisible(false);
                        try {
                            String bookid = tr.getText();
                            String ISBN = t1.getText();
                            String title = t2.getText();
                            String author = t3.getText();
                            String publisher = t4.getText();
                            String date = t5.getText();
                            String edition = (String) cb1.getSelectedItem();
                            String category = (String) cb2.getSelectedItem();
                            String numberbook = t8.getText();
                            String language = (String) cb.getSelectedItem();
                            String description = ta.getText();

                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into addbook(bookid, isbn, booktitle, bookauthor, publisher, date, edition, category, language, description, numberofbook, image) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                            pst.setString(1, bookid);
                            pst.setString(2, ISBN);
                            pst.setString(3, title);
                            pst.setString(4, author);
                            pst.setString(5, publisher);
                            pst.setString(6, date);
                            pst.setString(7, edition);
                            pst.setString(8, category);
                            pst.setString(9, language);
                            pst.setString(10, description);
                            pst.setString(11, numberbook);
                            FileInputStream file = new FileInputStream(f);
                            pst.setBinaryStream(12, file, file.available());
                            pst.executeUpdate();

                            successdialog1.setVisible(true);
                            Resetdata();

                        } catch (SQLException | FileNotFoundException ex) {
                            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {

                        labelbook.setVisible(true);

                    }
                }
                break;

            default:
        }

    }
}
