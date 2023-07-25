package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class LibraryManagementsystem extends JFrame implements ActionListener {

    JFrame frame;
    JPanel framepanel, p1, p2, p3;
    ImageIcon icon, icon2;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    Font fonta, font1, font2, font3, font4, font5, font6, font7, font8, font9;
    JScrollPane scroll;
    JButton b11, b12, b13, b4, b5, b6, b7, b8, b9;
    JScrollPane scrool;
    ButtonRound b1, b2, b3, br, br1, br2, br3, br4, br5, br6;
    
    //=========================================function call
   
    SignUp signup = new SignUp();
    textDialogbox td = new textDialogbox();
      MainhomePage main = new MainhomePage();
   Loginpage log;
    //===========================================MAIN CLASS
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LibraryManagementsystem.class.getName()).log(Level.SEVERE, null, ex);
        }
//LibraryManagementsystem lms=new LibraryManagementsystem();
        new LibraryManagementsystem().setVisible(true);
 
        // lms.setVisible(true);
    }

    public LibraryManagementsystem() {
       
        frameedit();
        componentFont();
        homepage();
        actionlistener();
    log = new Loginpage();
    }

    public void componentFont() {
        fonta = new Font("Serif", Font.BOLD, 18);
        font1 = new Font("Arial", Font.PLAIN, 8);
        font2 = new Font("serif", Font.BOLD, 50);
        font3 = new Font("Arial", Font.BOLD, 15);
        font4 = new Font("Arial", Font.PLAIN, 11);
        font5 = new Font("serif", Font.BOLD, 44);
        font6 = new Font("Arial", Font.PLAIN, 25);
        font7 = new Font("Arial", Font.PLAIN, 9);
        font8 = new Font("Arial", Font.BOLD, 12);
    }

    public void frameedit() {

        setTitle("Library Management Software");
        icon = new ImageIcon("images/studying.png");
        setIconImage(icon.getImage());
        setSize(1100, 700);
        setLayout(null);
        setUndecorated(true);
        //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(true);

    }
      
    public void actionlistener() {
       
        br.addActionListener(this);
        br.setActionCommand("LOGIN");
        br5.addActionListener(this);
        br5.setActionCommand("sign");
        br1.addActionListener(this);
        br1.setActionCommand("sign");
        b3.addActionListener(this);
        b3.setActionCommand("CLOSE");
        b2.addActionListener(this);
        b2.setActionCommand("MAXI");
        b1.addActionListener(this);
        b1.setActionCommand("MINI");
    }

    public void homepage() {

        //=====================================================================PANEL
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 1100, 90);
        add(p2);

        framepanel = new JPanel();
        framepanel.setBackground(Color.WHITE);
        framepanel.setLayout(null);
        add(framepanel);

        JMenuBar menubar = new JMenuBar();
        menubar.setBounds(0, 0, 1100, 100);
        p2.add(menubar);

        scroll = new JScrollPane(framepanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0, 90, 1100, 610);
       
        framepanel.setPreferredSize(new Dimension(1000, 1080));
        add(scroll);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1100, 90);
        p1.setBackground(new Color(1, 87, 155));
        menubar.add(p1);

        p3 = new JPanel();
        p3.setBackground(new Color(33, 97, 140));
        p3.setLayout(null);
        p3.setBounds(0, 0, 1100, 450);
        framepanel.add(p3);
        
         
      
//=====================================================================LABEL
        l1 = new JLabel(new ImageIcon("images/studying.png"));
        l1.setBounds(5, 8, 95, 65);
        p1.add(l1);
        l2 = new JLabel("LibSys");
        l2.setBounds(90, 0, 200, 60);
        l2.setForeground(new Color(245, 127, 23));
        l2.setFont(font2);
        p1.add(l2);

        l6 = new JLabel("+91 9557587998 | +91 7017268984");
        l6.setBounds(480, 8, 198, 20);
        l6.setForeground(Color.WHITE);
        l6.setFont(font8);
        l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(l6);
        l6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);

            }

        });

        l7 = new JLabel("info@libsys.co");
        l7.setBounds(745, 7, 88, 20);
        l7.setForeground(Color.WHITE);
        l7.setFont(font8);
        l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(l7);
        l7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
           
            }

        });

        l2 = new JLabel("ERP");
        l2.setBounds(30, 20, 25, 15);
        l2.setForeground(Color.WHITE);
        l2.setFont(font8);
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p3.add(l2);
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                td.setVisible(true);

            }

        });

        l1 = new JLabel("Library Management System");
        l1.setBounds(60, 20, 163, 15);
        l1.setForeground(Color.WHITE);
        l1.setFont(font8);
        l1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p3.add(l1);
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               main.setVisible(true);
                dispose();
            }

        });

        l3 = new JLabel(new ImageIcon("images/homelib2.png"));
        l3.setBounds(630, 30, 400, 400);
        p3.add(l3);

        l4 = new JLabel("Library Management System");
        l4.setBounds(20, 150, 550, 53);
        l4.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        l4.setForeground(Color.WHITE);
        l4.setFont(font5);
        p3.add(l4);

        l5 = new JLabel("Easy-to-use, Affordable, and Complete Library Automation System");
        l5.setBounds(30, 230, 530, 20);
        l5.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        l5.setForeground(Color.WHITE);
        l5.setFont(fonta);
        p3.add(l5);

//=====================================================================BUTTON
        b3 = new ButtonRound();
        b3.setIcon(new ImageIcon("images/blackcross.png"));
        b3.setRoundbottomleft(5);
        b3.setRoundbottomright(5);
        b3.setRoundtopleft(5);
        b3.setRoundtopright(5);
        b3.setBackground(Color.WHITE);
        b3.setRolloverEnabled(true);
        b3.setRolloverIcon(new ImageIcon("images/whitecross.png"));
        b3.setBounds(1055, 5, 40, 25);
        b3.setMouseClickColor(new Color(244, 67, 54));
        b3.setMouseEnterColor(new Color(244, 67, 54));
        b3.setMouseExistColor(Color.WHITE);
        b3.setTextClickColor(new Color(245, 127, 23));
        b3.setTextEnterColor(Color.WHITE);
        b3.setTextExistColor(Color.WHITE);
        p1.add(b3);

        b2 = new ButtonRound();
        b2.setIcon(new ImageIcon("images/maxi.png"));
        b2.setRoundbottomleft(5);
        b2.setRoundbottomright(5);
        b2.setRoundtopleft(5);
        b2.setRoundtopright(5);
        b2.setBackground(Color.WHITE);
        b2.setBounds(1012, 5, 40, 25);
        b2.setMouseClickColor(new Color(236, 240, 241));
        b2.setMouseEnterColor(new Color(236, 240, 241));
        b2.setMouseExistColor(Color.WHITE);
        b2.setTextClickColor(new Color(245, 127, 23));
        b2.setTextEnterColor(Color.WHITE);
        b2.setTextExistColor(Color.WHITE);
        p1.add(b2);

        b1 = new ButtonRound();
        b1.setIcon(new ImageIcon("images/mini.png"));
        b1.setRoundbottomleft(5);
        b1.setRoundbottomright(5);
        b1.setRoundtopleft(5);
        b1.setRoundtopright(5);
        b1.setBackground(Color.WHITE);
        b1.setBounds(969, 5, 40, 25);
        b1.setMouseClickColor(new Color(236, 240, 241));
        b1.setMouseEnterColor(new Color(236, 240, 241));
        b1.setMouseExistColor(Color.WHITE);
        b1.setTextClickColor(new Color(245, 127, 23));
        b1.setTextEnterColor(Color.WHITE);
        b1.setTextExistColor(Color.WHITE);
        p1.add(b1);


        b13 = new JButton("A Complete Solution For Institution");
        b13.setForeground(new Color(11, 219, 240));
        b13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b13.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
        b13.setContentAreaFilled(false);
        b13.setFocusPainted(false);
        b13.setBounds(90, 58, 150, 20);
        b13.setFont(font7);
        p1.add(b13);

        b12 = new JButton(new ImageIcon("images/phone2.png"));
        b12.setBounds(457, 5, 20, 25);
        b12.setIcon(new ImageIcon("images/phone2.png"));
        b12.setContentAreaFilled(false);
        b12.setFocusPainted(false);
        p1.add(b12);

        b4 = new JButton(new ImageIcon("images/gmail.png"));
        b4.setBounds(713, 5, 25, 25);
        b4.setForeground(Color.WHITE);
        b4.setContentAreaFilled(false);
        b4.setFocusPainted(false);
        p1.add(b4);

        br = new ButtonRound();
        br.setText("Login");
        br.setBounds(850, 8, 95, 25);
        br.setBackground(Color.BLACK);
        br.setForeground(Color.WHITE);
        br.setFont(font3);
        br.setIcon(new ImageIcon("images/login.png"));
        br.setRolloverEnabled(true);
        br.setRolloverIcon(new ImageIcon("images/login1.png"));
        br.setRoundbottomleft(30);
        br.setRoundbottomright(30);
        br.setRoundtopleft(30);
        br.setRoundtopright(30);
        br.setMouseClickColor(Color.BLACK);
        br.setMouseEnterColor(new Color(102, 153, 0));
        br.setMouseExistColor(Color.BLACK);
        br.setTextClickColor(Color.WHITE);
        br.setTextEnterColor(Color.WHITE);
        br.setTextExistColor(Color.WHITE);
        p1.add(br);

        br4 = new ButtonRound();
        br4.setText("Overview");
        br4.setForeground(Color.WHITE);
        br4.setBackground(new Color(1, 87, 155));
        br4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 180, 99)));
        br4.setRoundbottomleft(0);
        br4.setRoundbottomright(0);
        br4.setRoundtopleft(0);
        br4.setRoundtopright(0);
        br4.setMouseClickColor(new Color(1, 87, 155));
        br4.setMouseEnterColor(new Color(6, 159, 13));
        br4.setMouseExistColor(new Color(1, 87, 155));
        br4.setTextClickColor(Color.WHITE);
        br4.setTextEnterColor(new Color(124, 179, 66));
        br4.setTextExistColor(Color.WHITE);
        br4.setBounds(609, 55, 95, 35);
        br4.setFont(font3);
        p1.add(br4);

        br3 = new ButtonRound();
        br3.setText("Features");
        br3.setForeground(Color.WHITE);
        br3.setBackground(new Color(1, 87, 155));
        br3.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 180, 99)));
        br3.setRoundbottomleft(0);
        br3.setRoundbottomright(0);
        br3.setRoundtopleft(0);
        br3.setRoundtopright(0);
        br3.setMouseClickColor(new Color(1, 87, 155));
        br3.setMouseEnterColor(new Color(6, 159, 13));
        br3.setMouseExistColor(new Color(1, 87, 155));
        br3.setTextClickColor(Color.WHITE);
        br3.setTextEnterColor(new Color(124, 179, 66));
        br3.setTextExistColor(Color.WHITE);
        br3.setBounds(706, 55, 95, 35);
        br3.setFont(font3);
        p1.add(br3);

        br2 = new ButtonRound();
        br2.setText("Contact");
        br2.setForeground(Color.WHITE);
        br2.setBackground(new Color(1, 87, 155));
        br2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 180, 99)));
        br2.setRoundbottomleft(0);
        br2.setRoundbottomright(0);
        br2.setRoundtopleft(0);
        br2.setRoundtopright(0);
        br2.setMouseClickColor(new Color(1, 87, 155));
        br2.setMouseEnterColor(new Color(6, 159, 13));
        br2.setMouseExistColor(new Color(1, 87, 155));
        br2.setTextClickColor(Color.WHITE);
        br2.setTextEnterColor(new Color(124, 179, 66));
        br2.setTextExistColor(Color.WHITE);
        br2.setBounds(803, 55, 95, 35);
        br2.setFont(font3);
        p1.add(br2);

        br1 = new ButtonRound();
        br1.setText("Sign Up");
        br1.setForeground(Color.WHITE);
        br1.setBackground(new Color(30, 136, 229));
        br1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(40, 180, 99)));
        br1.setRoundbottomleft(0);
        br1.setRoundbottomright(0);
        br1.setRoundtopleft(0);
        br1.setRoundtopright(0);
        br1.setMouseClickColor(new Color(30, 136, 229));
        br1.setMouseEnterColor(new Color(30, 136, 229));
        br1.setMouseExistColor(new Color(30, 136, 229));
        br1.setTextClickColor(Color.WHITE);
        br1.setTextEnterColor(new Color(124, 179, 66));
        br1.setTextExistColor(Color.WHITE);
        br1.setBounds(900, 55, 120, 35);
        br1.setFont(font3);
        p1.add(br1);

        br5 = new ButtonRound();
        br5.setText("Sign up for free");
        br5.setBounds(30, 320, 230, 70);
        br5.setBackground(new Color(102, 153, 0));
        br5.setForeground(Color.WHITE);
        br5.setFont(font6);
        br5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        br5.setRoundbottomleft(10);
        br5.setRoundbottomright(10);
        br5.setRoundtopleft(10);
        br5.setRoundtopright(10);
        br5.setMouseClickColor(new Color(102, 153, 0));
        br5.setMouseEnterColor(new Color(102, 153, 0));
        br5.setMouseExistColor(new Color(102, 153, 0));
        br5.setTextClickColor(Color.WHITE);
        br5.setTextEnterColor(Color.BLACK);
        br5.setTextExistColor(Color.WHITE);
        p3.add(br5);

        br6 = new ButtonRound();
        br6.setText("Learn More");
        br6.setBounds(322, 320, 230, 70);
        br6.setBackground(new Color(33, 97, 140));
        br6.setForeground(Color.WHITE);
        br6.setFont(font6);
        br6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        br6.setRoundbottomleft(10);
        br6.setRoundbottomright(10);
        br6.setRoundtopleft(10);
        br6.setRoundtopright(10);
        br6.setMouseClickColor(new Color(33, 97, 140));
        br6.setMouseEnterColor(new Color(102, 153, 0));
        br6.setMouseExistColor(new Color(33, 97, 140));
        br6.setTextClickColor(Color.WHITE);
        br6.setTextEnterColor(Color.WHITE);
        br6.setTextExistColor(Color.WHITE);
        p3.add(br6);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "LOGIN":
                log.login();
                
                break;
            case "sign":
                signup.Signuppage();
                break;
            case "CLOSE":
                System.exit(0);
                break;
                 case "MAXI":
              
                break;
                 case "MINI":
                 setState(JFrame.ICONIFIED);
                break;
            default:
        }

    }

}
