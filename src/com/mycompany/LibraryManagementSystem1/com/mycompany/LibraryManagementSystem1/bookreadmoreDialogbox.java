
package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sachin Thakur
 */
public final class bookreadmoreDialogbox  extends JDialog  implements ActionListener{

    PanelRound p1, bodypanel, mainpanel, titlepanel, buttonpanel;
    PanelRound p11, mainpanelreadmore,buttonpanelreadmore;
    JButton b1, b4;
    JLabel l1, l2;
     JTextArea bodydialogread;
     JScrollPane scroll;
    Font font8 = new Font("TimesRomans", Font.BOLD, 13);

    public bookreadmoreDialogbox () {

        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        Boxdesign();
        

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

        titlepanel = new PanelRound();
        titlepanel.setBounds(0, 0, 380, 34);
        titlepanel.setRoundbottomright(0);
        titlepanel.setRoundbottomleft(0);
        titlepanel.setRoundtopleft(10);
        titlepanel.setRoundtopright(10);
        titlepanel.setBackground(Color.WHITE);
        mainpanel.add(titlepanel);

        bodypanel = new PanelRound();
        bodypanel.setLayout(null);
        bodypanel.setBounds(0, 41, 380, 100);
        bodypanel.setRoundbottomright(0);
        bodypanel.setRoundbottomleft(0);
        bodypanel.setRoundtopleft(0);
        bodypanel.setRoundtopright(0);
        bodypanel.setBackground(Color.WHITE);
        mainpanel.add(bodypanel);

        buttonpanel = new PanelRound();
        buttonpanel.setBounds(0, 141, 380, 39);
        buttonpanel.setRoundbottomright(10);
        buttonpanel.setRoundbottomleft(10);
        buttonpanel.setRoundtopleft(0);
        buttonpanel.setRoundtopright(0);
        buttonpanel.setBackground(Color.WHITE);
        mainpanel.add(buttonpanel);

        
        JLabel titledialog = new JLabel("Description");
        titledialog.setForeground(new Color(0, 153, 0));
        titledialog.setFont(new Font("Serif", Font.BOLD, 14));
        titlepanel.add(titledialog);
        
        bodydialogread = new JTextArea();
        bodydialogread.setForeground(new Color(21, 101, 192));
        bodydialogread.setFont(new Font("Serif", Font.BOLD, 16));
        bodydialogread.setLineWrap(true);
        bodydialogread.setEditable(false);
        scroll = new JScrollPane(bodydialogread, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.setBounds(0, 0, 380, 100);
        bodypanel.add(scroll);

        JButton okbutton = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton.setFocusable(false);
        okbutton.setContentAreaFilled(false);
        okbutton.setRolloverEnabled(true);
        okbutton.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        buttonpanel.add(okbutton);
        okbutton.addActionListener(this);
        okbutton.setActionCommand("OKK");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   String command = e.getActionCommand();

        switch (command) {

           
            case "OKK":
               dispose();
                break;
                default:
    }

    }

}
