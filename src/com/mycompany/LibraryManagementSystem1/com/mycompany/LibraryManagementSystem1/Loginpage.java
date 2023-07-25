package com.mycompany.LibraryManagementSystem1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Loginpage extends JDialog implements ActionListener {

    int pos;
    JLabel l2, l3, l4, l7, l8, l9, l10, lb, lc;
    ImageIcon icon;
    PanelRound p1, l1, p2;
    JButton b1;
    JLabel ld, le, lf, lg;
    RoundJTextField t1, t2;
    RoundJPassword pf;
    boolean over;
    ButtonRound br, br1, br2, br3, br4;

    //=========================================font
    Font font = new Font("Serif", Font.BOLD, 12);
    Font font1 = new Font("Arial", Font.BOLD, 12);
    Font font2 = new Font("serif", Font.BOLD, 50);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.PLAIN, 9);
    Font font5 = new Font("Serif", Font.BOLD, 20);
    textDialogbox box = new textDialogbox();
    textDialogbox box1 = new textDialogbox();
    MySqlConnection obj = new MySqlConnection();
    MainhomePage main = new MainhomePage();
    Connection con = null;

    public void login() {
        try {
            con = obj.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Loginpage.class.getName()).log(Level.SEVERE, null, ex);
        }
        setSize(420, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        requestFocusInWindow();

        setAlwaysOnTop(true);
        addWindowFocusListener(new WindowAdapter() {

            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();

            }

        });
        //====================================================PANEL
        p1 = new PanelRound();
        p1.setRoundbottomleft(50);
        p1.setRoundbottomright(50);
        p1.setRoundtopleft(50);
        p1.setRoundtopright(50);
        p1.setLayout(null);
        p1.setBounds(0, 100, 420, 500);
        p1.setBackground(new Color(21, 101, 192));
        add(p1);

        PanelRound pr3 = new PanelRound();
        pr3.setLayout(null);
        pr3.setRoundbottomleft(20);
        pr3.setRoundbottomright(20);
        pr3.setRoundtopleft(20);
        pr3.setRoundtopright(20);
        pr3.setBackground(Color.WHITE);
        pr3.setBounds(205, 60, 20, 20);
        add(pr3);

        PanelRound pr = new PanelRound();
        pr.setLayout(null);
        pr.setRoundbottomleft(10);
        pr.setRoundbottomright(10);
        pr.setRoundtopleft(50);
        pr.setRoundtopright(50);
        pr.setBackground(new Color(21, 101, 192));
        pr.setBounds(190, 50, 50, 80);
        add(pr);
        PanelRound pr1 = new PanelRound();
        pr1.setLayout(null);
        pr1.setRoundbottomleft(10);
        pr1.setRoundbottomright(60);
        pr1.setRoundtopleft(60);
        pr1.setRoundtopright(200);
        pr1.setBackground(new Color(21, 101, 192));
        pr1.setBounds(226, 70, 60, 60);
        add(pr1);
        PanelRound pr2 = new PanelRound();
        pr2.setLayout(null);
        pr2.setRoundbottomleft(60);
        pr2.setRoundbottomright(0);
        pr2.setRoundtopleft(200);
        pr2.setRoundtopright(60);
        pr2.setBackground(new Color(21, 101, 192));
        pr2.setBounds(144, 70, 60, 60);
        add(pr2);

        //------------------------------------------------label 
        l1 = new PanelRound();
        l1.setRoundbottomleft(40);
        l1.setRoundbottomright(40);
        l1.setRoundtopleft(40);
        l1.setRoundtopright(40);
        l1.setBounds(15, 15, 390, 470);
        l1.setLayout(null);
        l1.setBackground(Color.WHITE);
        p1.add(l1);

        l2 = new JLabel("  Library  Management  System.  ");
        Timer t = new Timer(400, (e) -> {
            String oldtext = l2.getText();
            String newtext = oldtext.substring(1) + oldtext.substring(0, 1);
            l2.setText(newtext);
        });
        t.start();
        l2.setBounds(115, 0, 200, 20);
        l2.setFont(font);
        l2.setForeground(new Color(231, 76, 60));
        l1.add(l2);

        l4 = new JLabel("LibSys");
        l4.setBounds(120, 30, 200, 60);
        l4.setForeground(new Color(245, 127, 23));
        l4.setFont(font2);
        l1.add(l4);

        l3 = new JLabel(new ImageIcon("images/studying.png"));
        l3.setBounds(145, 100, 95, 65);
        l1.add(l3);

        l7 = new JLabel("or");
        l7.setBounds(190, 360, 50, 20);
        l7.setForeground(new Color(69, 90, 100));
        l7.setFont(font1);
        l1.add(l7);

        l8 = new JLabel("<html><u>Login With</u></html>");
        l8.setBounds(160, 370, 90, 30);
        l8.setForeground(new Color(41, 45, 41));
        l8.setFont(font3);
        l1.add(l8);

       

        lc = new JLabel("Please Enter Password");
        lc.setBounds(105, 270, 250, 10);
        lc.setForeground(Color.red);
        lc.setFont(new Font("Arial", Font.BOLD, 9));
        l1.add(lc);
        lc.setVisible(false);

        ld = new JLabel("Forget Password?");
        ld.setBounds(18, 340, 105, 13);
        ld.setForeground(new Color(0, 102, 255));
        ld.setFont(font1);
        ld.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l1.add(ld);
        AddMouseListenerLabel(ld);

        le = new JLabel("Request For Demo");
        le.setBounds(275, 340, 105, 13);
        le.setForeground(new Color(0, 102, 255));
        le.setFont(font1);
        le.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l1.add(le);
        AddMouseListenerLabel(le);

        lf = new JLabel("Don't have an account?");
        lf.setBounds(115, 450, 145, 15);
        lf.setForeground(new Color(69, 90, 100));
        lf.setFont(new Font("Arial", Font.BOLD, 12));
        l1.add(lf);
        lg = new JLabel("Sign Up!");
        lg.setBounds(251, 453, 43, 11);
        lg.setForeground(new Color(0, 102, 255));
        lg.setFont(new Font("Arial", Font.BOLD, 10));
        lg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l1.add(lg);
        AddMouseListenerLabelLogin(lg);
        //-----------------------------------------------------textfield
        t2 = new RoundJTextField(" Email/Phone");
        t2.setCornersize(10);
        t2.setBounds(95, 185, 250, 35);
        t2.setBackground(new Color(255, 249, 158));
        t2.setSelectionColor(new Color(21, 101, 192));
        t2.setSelectedTextColor(Color.white);
        t2.setForeground(Color.GRAY);
        t2.setToolTipText("Please fill out the field");
        l1.add(t2);
         lb = new JLabel("Please Enter Email/Phone");
        lb.setBounds(105, 220, 250, 10);
        lb.setForeground(Color.red);
        lb.setFont(new Font("Arial", Font.BOLD, 9));
        l1.add(lb);
        lb.setVisible(false);
        t2.setLabelerror(lb);

        pf = new RoundJPassword("  Password");
        pf.setCornersize(10);
        pf.setForeground(Color.GRAY);
        pf.setFont(font1);
        pf.setSelectionColor(new Color(21, 101, 192));
        pf.setSelectedTextColor(Color.white);
        pf.setToolTipText("Please fill out the field");
        pf.setEchoChar((char) 0);
        pf.setBounds(95, 235, 250, 35);
        pf.setBackground(new Color(255, 249, 158));

        l1.add(pf);

        //--------------------------------------------------------------button
        br4 = new ButtonRound();
        br4.setText("Login");
        br4.setFont(font5);
        br4.setBackground(new Color(1, 87, 155));
        br4.setForeground(Color.WHITE);
        br4.setRoundbottomleft(10);
        br4.setRoundbottomright(10);
        br4.setRoundtopleft(10);
        br4.setRoundtopright(10);
        br4.setBounds(125, 290, 150, 40);
        br4.setMouseClickColor(new Color(6, 131, 103));
        br4.setMouseEnterColor(new Color(6, 159, 13));
        br4.setMouseExistColor(new Color(1, 87, 155));
        br4.setTextClickColor(Color.WHITE);
        br4.setTextEnterColor(Color.WHITE);
        br4.setTextExistColor(Color.WHITE);
        l1.add(br4);
        br4.addActionListener(this);
        br4.setActionCommand("LOGIN");

        b1 = new JButton();
        b1.setBounds(350, 0, 40, 40);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setRolloverEnabled(true);
        b1.setIcon(new ImageIcon("images/book.png"));
        b1.setRolloverIcon(new ImageIcon("images/close.png"));
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        b1.setActionCommand("back");
        l1.add(b1);

        br = new ButtonRound();
        br.setText("Google");
        br.setBackground(new Color(244, 67, 54));
        br.setForeground(Color.WHITE);
        br.setIcon(new ImageIcon("images/google.png"));
        br.setRoundbottomleft(25);
        br.setRoundbottomright(0);
        br.setRoundtopleft(0);
        br.setRoundtopright(25);
        br.setBounds(50, 400, 110, 30);
        br.setMouseClickColor(new Color(244, 67, 54));
        br.setMouseEnterColor(new Color(244, 67, 54));
        br.setMouseExistColor(new Color(244, 67, 54));
        br.setTextClickColor(Color.WHITE);
        br.setTextEnterColor(Color.WHITE);
        br.setTextExistColor(Color.WHITE);
        l1.add(br);

        br1 = new ButtonRound();
        br1.setText("Linkedin");
        br1.setBackground(new Color(41, 99, 189));
        br1.setForeground(Color.WHITE);
        br1.setIcon(new ImageIcon("images/linkedin.png"));
        br1.setRoundbottomleft(25);
        br1.setRoundbottomright(0);
        br1.setRoundtopleft(0);
        br1.setRoundtopright(25);
        br1.setBounds(240, 400, 110, 30);
        br1.setMouseClickColor(new Color(41, 99, 189));
        br1.setMouseEnterColor(new Color(41, 99, 189));
        br1.setMouseExistColor(new Color(41, 99, 189));
        br1.setTextClickColor(Color.WHITE);
        br1.setTextEnterColor(Color.WHITE);
        br1.setTextExistColor(Color.WHITE);
        l1.add(br1);

        br2 = new ButtonRound();
        br2.setBackground(Color.GRAY);
        br2.setIcon(new ImageIcon("images/user2.png"));
        br2.setRoundbottomleft(10);
        br2.setRoundbottomright(0);
        br2.setRoundtopleft(10);
        br2.setRoundtopright(0);
        br2.setMouseClickColor(Color.GRAY);
        br2.setMouseEnterColor(Color.GRAY);
        br2.setMouseExistColor(Color.GRAY);
        br2.setBounds(48, 185, 50, 35);
        l1.add(br2);

        br3 = new ButtonRound();
        br3.setBackground(Color.GRAY);
        br3.setIcon(new ImageIcon("images/password1.png"));
        br3.setRoundbottomleft(10);
        br3.setRoundbottomright(0);
        br3.setRoundtopleft(10);
        br3.setRoundtopright(0);
        br3.setMouseClickColor(Color.GRAY);
        br3.setMouseEnterColor(Color.GRAY);
        br3.setMouseExistColor(Color.GRAY);
        br3.setBounds(48, 235, 50, 35);
        l1.add(br3);
        ImageIcon image1 = new ImageIcon("images/eye.png");
        ImageIcon image2 = new ImageIcon("images/visibility.png");
        EyePasswordButton ep = new EyePasswordButton(pf, image1, image2);
        ep.setIcon(new ImageIcon("images/eye.png"));
        ep.setBounds(215, 4, 30, 23);
        pf.add(ep);
//------------------======================================================login Successfill

        box.titlelabel.setText("Login Successful");
        box.bodylabel.setText("Please Ok To Continue");

        JButton okbutton = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton.setFocusable(false);
        okbutton.setContentAreaFilled(false);
        okbutton.setRolloverEnabled(true);
        okbutton.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        box.buttonpanel.add(okbutton);
        okbutton.addActionListener(this);
        okbutton.setActionCommand("right");
        //======================================================================Alert

        box1.titlelabel.setText("Login");
        box1.bodylabel.setText("Email or Password is Incorrect");

        JButton okbutton1 = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton1.setFocusable(false);
        okbutton1.setContentAreaFilled(false);
        okbutton1.setRolloverEnabled(true);
        okbutton1.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        box1.buttonpanel.add(okbutton1);
        okbutton1.addActionListener(this);
        okbutton1.setActionCommand("right1");

//=========================================================================
    }

    public void AddMouseListenerLabel(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                label.setForeground(new Color(0, 153, 0));
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(0, 102, 255));
                over = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                label.setForeground(Color.BLACK);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    label.setForeground(new Color(0, 153, 0));

                } else {
                    label.setForeground(new Color(0, 102, 255));
                }
            }

        });
    }

    public void AddMouseListenerLabelLogin(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                label.setForeground(new Color(0, 153, 0));
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(0, 102, 255));
                over = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                label.setForeground(Color.BLACK);
                SignUp signup1 = new SignUp();
                dispose();
                signup1.Signuppage();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    label.setForeground(new Color(0, 153, 0));

                } else {
                    label.setForeground(new Color(0, 102, 255));
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "back":
                dispose();
                break;
            case "right":
                box.dispose();
                break;
            case "right1":
                box1.bodylabel.setText("");
                box1.dispose();
                break;

            case "LOGIN": {
                if ((t2.getText().equals(" Email/Phone") || t2.getText().equals("")) || (pf.getText().equals("  Password") || pf.getText().equals(""))) {

                    if (t2.getText().equals(" Email/Phone") || t2.getText().equals("")) {
                        lb.setVisible(true);
                    } else {
                        lb.setVisible(false);
                    }
                    if (pf.getText().equals("  Password") || pf.getText().equals("")) {
                        lc.setVisible(true);
                    } else {
                        lc.setVisible(false);
                    }

                } else {
                    String sql = null;
                    String sql2 = null;
                        sql = "select * from signup where (PhoneNo=? or EmailID=?) and id=?";
                        box1.bodylabel.setText("Phone or Password is Incorrect");
                        sql2 = "select * from signup where PhoneNo='" + t2.getText() + "' or EmailID='"+ t2.getText()+"';";
                    try {
                        String user = t2.getText();
                        String pass = String.valueOf(pf.getPassword());
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        pst.setString(1, user);
                        pst.setString(2, user);
                        pst.setString(3, pass);
                        ResultSet rst = (ResultSet) pst.executeQuery();

                        if (rst.next()) {
                            //id, FullName, EmailId, PhoneNo, InstitutionName, InstitutionType, YourRole  
                            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql2);
                            ResultSet rs = (ResultSet) pst1.executeQuery();
                            while (rs.next()) {
                                  dispose();
                                main.setVisible(true);
                                main.user.userid = rs.getInt(1);
                                main.book.userid = rs.getInt(1);
                                main.user.username.setText(rs.getString(2));
                                main.user.nametext.setText(rs.getString(2));
                                main.user.profilename=rs.getString(2);
                                main.user.emailtext.setText(rs.getString(3));
                                main.user.profileEmail=rs.getString(3);
                                main.user.phonetext.setText(rs.getString(4));
                                main.user.profilephone=rs.getString(4);
                                byte[] im = rs.getBytes(8);
                                if(im==null){dispose();
                                 main.setVisible(true);}else{
                                    main.user.image=im;
                                ImageIcon ico = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(main.user.avtar.getWidth(), main.user.avtar.getHeight(), Image.SCALE_SMOOTH));
                                main.user.avtar.setIcon(ico);
                                ImageIcon photo = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(main.user.avtar1.getWidth(), main.user.avtar1.getHeight(), Image.SCALE_SMOOTH));
                                main.user.avtar1.setIcon(photo);
                               
                                }
                            }
                            

                        } else {
                            box1.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Loginpage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            break;

            default:

        }
    }

}
