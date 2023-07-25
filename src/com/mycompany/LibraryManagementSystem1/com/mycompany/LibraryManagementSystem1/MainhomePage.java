/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class MainhomePage extends JFrame implements ActionListener {

    PanelRound mainpanel, messagepanel, mainpanel2, slidepanel, Userprofilepanel, slidepanel2, p1, p2, p3;
    JLabel l1, l2, l3, arrow,notification;
    
    ButtonRound br, b3, br1, b1, b2, br2, br3, br4, br5, br6, br7, br8, br9, br0, br01, br02, br03, br04, br05, br06, br07, br08, br09;
    
    boolean over = true;
    Book book;
  UserProfile user;
    public MainhomePage() {
         
        Mainframework();
        
        book = new Book(this);
        book.AddBook();
        mainpanel.add(slidepanel2);
         mainpanel.add(mainpanel2);
        user=new UserProfile(this);
      
    }

    public void Mainframework() {
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
//       setSize(1000,500);
//        setLayout(null);
//       setUndecorated(true);
//        setBackground(new Color(0,0,0,0));
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));

        mainpanel = new PanelRound();//main=1
        mainpanel.setBounds(0, 0, 1200, 700);
        mainpanel.setRoundbottomleft(20);
        mainpanel.setRoundbottomright(20);
        mainpanel.setRoundtopleft(20);
        mainpanel.setRoundtopright(20);
        mainpanel.setBackground(new Color(245, 127, 23));//new Color(0, 153, 0)
        mainpanel.setLayout(null);
        add(mainpanel);

        mainpanel2 = new PanelRound();//titlemain
        mainpanel2.setLayout(null);
        mainpanel2.setBounds(10, 10, 1180, 75);
        mainpanel2.setRoundbottomleft(10);
        mainpanel2.setRoundbottomright(10);
        mainpanel2.setRoundtopleft(10);
        mainpanel2.setRoundtopright(10);
        mainpanel2.setBackground(new Color(33, 97, 140));   //new Color(33, 97, 140)
       

        slidepanel = new PanelRound();
        slidepanel.setBounds(10, 90, 200, 600);
        slidepanel.setRoundbottomleft(10);
        slidepanel.setRoundbottomright(10);
        slidepanel.setRoundtopleft(10);
        slidepanel.setRoundtopright(10);
        slidepanel.setLayout(null);
        slidepanel.setBackground(new Color(33, 97, 140));
        mainpanel.add(slidepanel);
        slidepanel.setVisible(false);

        Userprofilepanel = new PanelRound();//slide panel m
        Userprofilepanel.setBounds(5, 5, 190, 80);
        Userprofilepanel.setLayout(null);
        Userprofilepanel.setRoundbottomleft(10);
        Userprofilepanel.setRoundbottomright(10);
        Userprofilepanel.setRoundtopleft(10);
        Userprofilepanel.setRoundtopright(10);
        Userprofilepanel.setBackground(Color.WHITE);
        slidepanel.add(Userprofilepanel);

        slidepanel2 = new PanelRound();
        slidepanel2.setBounds(10, 90, 55, 600);
        slidepanel2.setRoundbottomleft(10);
        slidepanel2.setRoundbottomright(10);
        slidepanel2.setRoundtopleft(10);
        slidepanel2.setRoundtopright(10);
        slidepanel2.setLayout(null);
        slidepanel2.setBackground(new Color(33, 97, 140));//

        br0 = new ButtonRound();
        br0.setText("Bk");
        br0.setRoundbottomleft(10);
        br0.setRoundbottomright(10);
        br0.setRoundtopleft(10);

        br0.setRoundtopright(10);
        br0.setBackground(new Color(33, 97, 140));
        br0.setForeground(Color.WHITE);
        br0.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br0.setBounds(0, 0, 55, 40);
        br0.setMouseClickColor(new Color(102, 153, 0));
        br0.setMouseEnterColor(new Color(102, 153, 0));
        br0.setMouseExistColor(new Color(33, 97, 140));
        br0.setTextClickColor(Color.WHITE);
        br0.setTextEnterColor(Color.WHITE);
        br0.setTextExistColor(Color.WHITE);
        slidepanel2.add(br0);

        br01 = new ButtonRound();
        br01.setIcon(new ImageIcon("images/paneladdbook.png"));
        br01.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
      br01.setRoundbottomleft(10);
        br01.setRoundbottomright(10);
        br01.setRoundtopleft(10);
        br01.setRoundtopleft(10);
        br01.setRoundtopright(10);
        br01.setBackground(new Color(33, 97, 140));
        br01.setForeground(Color.WHITE);
        br01.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br01.setBounds(0, 40, 55, 40);
        br01.setMouseClickColor(new Color(102, 153, 0));
        br01.setMouseEnterColor(new Color(102, 153, 0));
        br01.setMouseExistColor(new Color(33, 97, 140));
       slidepanel2.add(br01);
        br01.addActionListener(this);
        br01.setActionCommand("addbook");

        br02 = new ButtonRound();
        br02.setText("B2");
        br02.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
        br02.setRoundbottomleft(10);
        br02.setRoundbottomright(10);
        br02.setRoundtopleft(10);
        br02.setRoundtopleft(10);
        br02.setRoundtopright(10);
        br02.setBackground(new Color(33, 97, 140));
        br02.setForeground(Color.WHITE);
        br02.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br02.setBounds(0, 80, 55, 40);
        br02.setMouseClickColor(new Color(102, 153, 0));
        br02.setMouseEnterColor(new Color(102, 153, 0));
        br02.setMouseExistColor(new Color(33, 97, 140));
        slidepanel2.add(br02);
        br02.addActionListener(this);
        br02.setActionCommand("showbook");

        br03 = new ButtonRound();
        br03.setText("B3");
        br03.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));

        br03.setRoundbottomleft(10);
        br03.setRoundbottomright(10);
        br03.setRoundtopleft(10);
        br03.setRoundtopleft(10);
        br03.setRoundtopright(10);
        br03.setBackground(new Color(33, 97, 140));
        br03.setForeground(Color.WHITE);
        br03.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br03.setBounds(0, 120, 55, 40);
        br03.setMouseClickColor(new Color(102, 153, 0));
        br03.setMouseEnterColor(new Color(102, 153, 0));
        br03.setMouseExistColor(new Color(33, 97, 140));
        slidepanel2.add(br03);

        br04 = new ButtonRound();
        br04.setText("B4");
        br04.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
        br04.setRoundbottomleft(10);
        br04.setRoundbottomright(10);
        br04.setRoundtopleft(10);
        br04.setRoundtopleft(10);
        br04.setRoundtopright(10);
        br04.setBackground(new Color(33, 97, 140));
        br04.setForeground(Color.WHITE);
        br04.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br04.setBounds(0, 160, 55, 40);
        br04.setMouseClickColor(new Color(102, 153, 0));
        br04.setMouseEnterColor(new Color(102, 153, 0));
        br04.setMouseExistColor(new Color(33, 97, 140));
        slidepanel2.add(br04);

        
//       
//        p2 = new PanelRound();
//        p2.setBounds(50, 0, 350,300);
//        p2.setRoundbottomleft(10);
//        p2.setRoundbottomright(10);
//        p2.setRoundtopleft(10);
//        p2.setRoundtopright(10);
//        p2.setBackground(Color.blue);
//        p1.add(p2);
        //==================================================================BUTTON
        b3 = new ButtonRound();
        b3.setIcon(new ImageIcon("images/blackcross.png"));
        b3.setRoundbottomleft(5);
        b3.setRoundbottomright(5);
        b3.setRoundtopleft(5);
        b3.setRoundtopright(5);
        b3.setBackground(Color.WHITE);
        b3.setRolloverEnabled(true);
        b3.setRolloverIcon(new ImageIcon("images/whitecross.png"));
        b3.setBounds(1135, 5, 40, 25);
        b3.setMouseClickColor(new Color(244, 67, 54));
        b3.setMouseEnterColor(new Color(244, 67, 54));
        b3.setMouseExistColor(Color.WHITE);
        b3.setTextClickColor(new Color(245, 127, 23));
        b3.setTextEnterColor(Color.WHITE);
        b3.setTextExistColor(Color.WHITE);
        mainpanel2.add(b3);
        b3.addActionListener(this);
        b3.setActionCommand("CLOSE");

        b2 = new ButtonRound();
        b2.setIcon(new ImageIcon("images/maxi.png"));
        b2.setRoundbottomleft(5);
        b2.setRoundbottomright(5);
        b2.setRoundtopleft(5);
        b2.setRoundtopright(5);
        b2.setBackground(Color.WHITE);
        b2.setBounds(1093, 5, 40, 25);
        b2.setMouseClickColor(new Color(236, 240, 241));
        b2.setMouseEnterColor(new Color(236, 240, 241));
        b2.setMouseExistColor(Color.WHITE);
        b2.setTextClickColor(new Color(245, 127, 23));
        b2.setTextEnterColor(Color.WHITE);
        b2.setTextExistColor(Color.WHITE);
        mainpanel2.add(b2);
        b2.addActionListener(this);
        b2.setActionCommand("MAXI");

        b1 = new ButtonRound();
        b1.setIcon(new ImageIcon("images/mini.png"));
        b1.setRoundbottomleft(5);
        b1.setRoundbottomright(5);
        b1.setRoundtopleft(5);
        b1.setRoundtopright(5);
        b1.setBackground(Color.WHITE);
        b1.setBounds(1051, 5, 40, 25);
        b1.setMouseClickColor(new Color(236, 240, 241));
        b1.setMouseEnterColor(new Color(236, 240, 241));
        b1.setMouseExistColor(Color.WHITE);
        b1.setTextClickColor(new Color(245, 127, 23));
        b1.setTextEnterColor(Color.WHITE);
        b1.setTextExistColor(Color.WHITE);
        mainpanel2.add(b1);
        b1.addActionListener(this);
        b1.setActionCommand("MINI");

        br = new ButtonRound();
        br.setText("Book");
        br.setRoundbottomleft(10);
        br.setRoundbottomright(10);
        br.setRoundtopleft(10);
        br.setRoundtopleft(10);
        br.setRoundtopright(10);
        br.setBackground(Color.WHITE);
        br.setForeground(Color.BLACK);
        br.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br.setBounds(5, 90, 190, 40);
        br.setMouseClickColor(new Color(102, 153, 0));
        br.setMouseEnterColor(new Color(102, 153, 0));
        br.setMouseExistColor(Color.WHITE);
        br.setTextClickColor(Color.WHITE);
        br.setTextEnterColor(Color.WHITE);
        br.setTextExistColor(Color.BLACK);
        slidepanel.add(br);

        br1 = new ButtonRound();
        br1.setText("Book1");
        br1.setRoundbottomleft(10);
        br1.setRoundbottomright(10);
        br1.setRoundtopleft(10);
        br1.setRoundtopleft(10);
        br1.setRoundtopright(10);
        br1.setBackground(Color.WHITE);
        br1.setForeground(Color.BLACK);
        br1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br1.setBounds(5, 135, 190, 40);
        br1.setMouseClickColor(new Color(102, 153, 0));
        br1.setMouseEnterColor(new Color(102, 153, 0));
        br1.setMouseExistColor(Color.WHITE);
        br1.setTextClickColor(Color.WHITE);
        br1.setTextEnterColor(Color.WHITE);
        br1.setTextExistColor(Color.BLACK);
        slidepanel.add(br1);

        br2 = new ButtonRound();
        br2.setText("Book2");
        br2.setRoundbottomleft(10);
        br2.setRoundbottomright(10);
        br2.setRoundtopleft(10);
        br2.setRoundtopleft(10);
        br2.setRoundtopright(10);
        br2.setBackground(Color.WHITE);
        br2.setForeground(Color.BLACK);
        br2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br2.setBounds(5, 180, 190, 40);
        br2.setMouseClickColor(new Color(102, 153, 0));
        br2.setMouseEnterColor(new Color(102, 153, 0));
        br2.setMouseExistColor(Color.WHITE);
        br2.setTextClickColor(Color.WHITE);
        br2.setTextEnterColor(Color.WHITE);
        br2.setTextExistColor(Color.BLACK);
        slidepanel.add(br2);

        br3 = new ButtonRound();
        br3.setText("Book3");
        br3.setRoundbottomleft(10);
        br3.setRoundbottomright(10);
        br3.setRoundtopleft(10);
        br3.setRoundtopleft(10);
        br3.setRoundtopright(10);
        br3.setBackground(Color.WHITE);
        br3.setForeground(Color.BLACK);
        br3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br3.setBounds(5, 225, 190, 40);
        br3.setMouseClickColor(new Color(102, 153, 0));
        br3.setMouseEnterColor(new Color(102, 153, 0));
        br3.setMouseExistColor(Color.WHITE);
        br3.setTextClickColor(Color.WHITE);
        br3.setTextEnterColor(Color.WHITE);
        br3.setTextExistColor(Color.BLACK);
        slidepanel.add(br3);

        br4 = new ButtonRound();
        br4.setText("Book4");
        br4.setRoundbottomleft(10);
        br4.setRoundbottomright(10);
        br4.setRoundtopleft(10);
        br4.setRoundtopleft(10);
        br4.setRoundtopright(10);
        br4.setBackground(Color.WHITE);
        br4.setForeground(Color.BLACK);
        br4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        br4.setBounds(5, 270, 190, 40);
        br4.setMouseClickColor(new Color(102, 153, 0));
        br4.setMouseEnterColor(new Color(102, 153, 0));
        br4.setMouseExistColor(Color.WHITE);
        br4.setTextClickColor(Color.WHITE);
        br4.setTextEnterColor(Color.WHITE);
        br4.setTextExistColor(Color.BLACK);
        slidepanel.add(br4);
//=====================================================================LABEL
       
        l1 = new JLabel(new ImageIcon("images/studying.png"));
        l1.setBounds(480, 5, 95, 65);
        mainpanel2.add(l1);
        l2 = new JLabel("LibSys");
        l2.setBounds(560, 5, 200, 60);
        l2.setForeground(new Color(245, 127, 23));
        l2.setFont(new Font("serif", Font.BOLD, 50));
        mainpanel2.add(l2);

        l3 = new JLabel(new ImageIcon("images/menu.png"));
        l3.setBounds(10, 22, 28, 28);
        l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainpanel2.add(l3);
       l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (over) {
                    slidepanel.setVisible(true);
                    over = false;
                } else {

                    slidepanel.setVisible(false);
                    over = true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                l3.setIcon(new ImageIcon("images/menu1.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                l3.setIcon(new ImageIcon("images/menu.png"));
            }

        });
       
       
       
       

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "CLOSE":
                System.exit(0);

                break;
            case "MINI":

                setState(JFrame.ICONIFIED);

                break;
            case "addbook":

                book.messagepanel.setVisible(true);//if(book.messagepanel1!=null) 
               book.messagepanel1.setVisible(false);
              book.notificationpanel.setVisible(false);
              book.over2=true;
                break;
            case "showbook":
                book.UpdateBookdetail();
                book.messagepanel1.setVisible(true);
                book.messagepanel.setVisible(false);
                 book.notificationpanel.setVisible(false);
                  book.over2=true;
                 break;
            default:
        }

    }

}
