/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Sachin Thakur
 */
public final class textDialogbox extends JDialog {

    PanelRound p1, mainpanel, buttonpanel;
 JLabel  bodylabel,titlelabel;
    Font font8 = new Font("TimesRomans", Font.BOLD, 13);

    public textDialogbox() {

        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        Boxdesign();
         addWindowFocusListener(new WindowAdapter() {

            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();

            }

        });      

    }

    public void Boxdesign() {
        p1 = new PanelRound();
        p1.setLayout(null);
        p1.setSize(400, 200);
        p1.setRoundbottomright(20);
        p1.setRoundbottomleft(20);
        p1.setRoundtopleft(20);
        p1.setRoundtopright(20);
        p1.setBackground(new Color(0, 153, 0));
        add(p1);

        mainpanel = new PanelRound() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(21, 101, 192));
                g.drawLine(5, 35, 370, 35);

            }
        };

        mainpanel.setLayout(null);
        mainpanel.setBounds(10, 10, 380, 180);
        mainpanel.setRoundbottomright(10);
        mainpanel.setRoundbottomleft(10);
        mainpanel.setRoundtopleft(10);
        mainpanel.setRoundtopright(10);
        mainpanel.setBackground(Color.WHITE);
        p1.add(mainpanel);

        titlelabel = new JLabel();
        titlelabel.setBounds(0, 0, 380, 34);
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setHorizontalTextPosition(SwingConstants.CENTER);
         titlelabel.setFont(new Font("Serif", Font.BOLD, 14));
        titlelabel.setForeground(new Color(0, 153, 0));
       mainpanel.add(titlelabel);

        bodylabel = new JLabel();
        bodylabel.setLayout(null);
        bodylabel.setBounds(0, 41, 380, 100);
        bodylabel.setHorizontalAlignment(SwingConstants.CENTER);
        bodylabel.setHorizontalTextPosition(SwingConstants.CENTER);
        bodylabel.setFont(new Font("Serif", Font.BOLD, 16));
        bodylabel.setForeground(new Color(21, 101, 192));
        mainpanel.add(bodylabel);

        buttonpanel = new PanelRound();
        buttonpanel.setBounds(0, 141, 380, 39);
        buttonpanel.setRoundbottomright(10);
        buttonpanel.setRoundbottomleft(10);
        buttonpanel.setRoundtopleft(0);
        buttonpanel.setRoundtopright(0);
        buttonpanel.setBackground(Color.WHITE);
        mainpanel.add(buttonpanel);

    }

  

}
