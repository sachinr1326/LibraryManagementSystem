package com.mycompany.LibraryManagementSystem1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sachin Thakur
 */
public class SignUp extends JDialog implements ActionListener {
    
    int pos;
    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, la, lb, ld, lc, le, lf, lg, lh, lm, ln, lemail, lphone;
    ImageIcon icon;
    PanelRound p1, l1, p2;
    JButton b1, b2, b3;
    JTextField t1, t2;
    RoundJTextField tr, tr1, tr2, tr3, tr4;
    JCheckBox box1;
    RoundJComboBox cb, cb1;
    String type[] = {"Select Instituion", "Academy/Training Center", "College", "Pre-School", "School", "University"};
    String type1[] = {"Select Role", "Admin or Principal", "Director", "Other User", "Staff or Faculty", "Student or Parent"};
    boolean over, over1, over2;
    ButtonRound br, br1, br2, br3;
    //========================================FUNCTION
    Loginpage log2 = new Loginpage();
    textDialogbox box = new textDialogbox();
    MySqlConnection obj = new MySqlConnection();
    PhonenumberValidation ph = new PhonenumberValidation();
    UppercaseTextfield uptext = new UppercaseTextfield();

    //=========================================font
    Font font = new Font("Serif", Font.BOLD, 12);
    Font font1 = new Font("Arial", Font.BOLD, 12);
    Font font2 = new Font("serif", Font.BOLD, 50);
    Font font3 = new Font("Arial", Font.BOLD, 15);
    Font font4 = new Font("Arial", Font.PLAIN, 11);
    Font font5 = new Font("serif", Font.PLAIN, 15);
    Font font6 = new Font("TimesRoman", Font.PLAIN, 20);
    Font font7 = new Font("Arial", Font.PLAIN, 9);
    Font font8 = new Font("Arial", Font.PLAIN, 15);
    
    Connection con = null;
    
    public void Signuppage() {
        try {
            con = obj.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        setSize(650, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        requestFocusInWindow();
        addWindowFocusListener(new WindowAdapter() {
            
            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
                
            }
            
        });

        //============================================PANEL
        p1 = new PanelRound();
        p1.setSize(650, 600);
        p1.setRoundbottomleft(40);
        p1.setRoundbottomright(40);
        p1.setRoundtopleft(40);
        p1.setRoundtopright(40);
        p1.setLayout(null);
        p1.setBackground(new Color(21, 101, 192));
        add(p1);
        p2 = new PanelRound() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawLine(10, 85, 620, 85);
                g.drawLine(280, 60, 428, 60);
            }
            
        };
        p2.setBounds(10, 10, 630, 580);
        p2.setRoundbottomleft(20);
        p2.setRoundbottomright(20);
        p2.setRoundtopleft(20);
        p2.setRoundtopright(20);
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);
        p1.add(p2);
        //===============================================LABEL
        l4 = new JLabel("LibSys");
        l4.setBounds(280, 0, 200, 60);
        l4.setForeground(new Color(245, 127, 23));
        l4.setFont(font2);
        p2.add(l4);
        
        l3 = new JLabel(new ImageIcon("images/studying.png"));
        l3.setBounds(200, 10, 95, 65);
        p2.add(l3);
        l3 = new JLabel("A Complete Solution For Institution");
        l3.setBounds(280, 58, 170, 20);
        l3.setFont(font7);
        p2.add(l3);
        
        l5 = new JLabel("Full Name");
        l5.setBounds(110, 130, 100, 35);
        l5.setFont(font5);
        p2.add(l5);
        
        l6 = new JLabel("Email ID");
        l6.setBounds(110, 180, 100, 35);
        l6.setFont(font5);
        p2.add(l6);
        
        l7 = new JLabel("Phone No.");
        l7.setBounds(110, 230, 100, 35);
        l7.setFont(font5);
        p2.add(l7);
        
        l8 = new JLabel("Institution Name");
        l8.setBounds(110, 280, 100, 35);
        l8.setFont(font5);
        p2.add(l8);
        
        l9 = new JLabel("Institution Type");
        l9.setBounds(110, 330, 100, 35);
        l9.setFont(font5);
        p2.add(l9);
        
        l10 = new JLabel("Your Role in Institution?");
        l10.setBounds(110, 380, 150, 35);
        l10.setFont(font5);
        p2.add(l10);
        
        la = new JLabel("Already have an account?");
        la.setBounds(215, 540, 170, 30);
        
        la.setForeground(new Color(75, 79, 74));
        la.setFont(font8);
        p2.add(la);
        
       
        
       
        
       
        
       
        
        lm = new JLabel("Terms of Services");
        lm.setBounds(318, 436, 90, 15);
        lm.setForeground(new Color(0, 102, 255));
        lm.setFont(font4);
        lm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p2.add(lm);
        lm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
                
            }
            
        });
        lemail = new JLabel("Email is Exist");
        lemail.setBounds(310, 215, 250, 10);
        lemail.setForeground(Color.red);
        lemail.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lemail);
        lemail.setVisible(false);
        
        lphone = new JLabel("Phone No. is Exist");
        lphone.setBounds(310, 265, 250, 10);
        lphone.setForeground(Color.red);
        lphone.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lphone);
        lphone.setVisible(false);

        //==============================================TEXTFIELD
        tr = new RoundJTextField(" Full Name");
        tr.setCornersize(10);
        tr.setBounds(280, 130, 250, 35);
        tr.setBackground(new Color(255, 249, 158));
        p2.add(tr);
        uptext.Uppercase(tr);
         lb = new JLabel("Please Enter Full Name");
        lb.setBounds(290, 165, 250, 10);
        lb.setForeground(Color.red);
        lb.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lb);
        lb.setVisible(false);
        tr.setLabelerror(lb);
        
        
        
        tr1 = new RoundJTextField(" Email ID");
        tr1.setCornersize(10);
        tr1.setBounds(280, 180, 250, 35);
        tr1.setBackground(new Color(255, 249, 158));
        p2.add(tr1);
         lc = new JLabel("Please Enter Email ID");
        lc.setBounds(290, 215, 250, 10);
        lc.setForeground(Color.red);
        lc.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lc);
        lc.setVisible(false);
        tr1.setLabelerror(lc);
        
        tr2 = new RoundJTextField(" Phone No.");
        tr2.setCornersize(10);
        tr2.setBounds(280, 230, 250, 35);
        tr2.setBackground(new Color(255, 249, 158));
        p2.add(tr2);
        ph.phone(tr2);
         ld = new JLabel("Please Enter Phone No.");
        ld.setBounds(290, 265, 250, 10);
        ld.setForeground(Color.red);
        ld.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(ld);
        ld.setVisible(false);
        tr2.setLabelerror(ld);
        
        tr3 = new RoundJTextField(" Institution Name");
        tr3.setCornersize(10);
        tr3.setBounds(280, 280, 250, 35);
        tr3.setBackground(new Color(255, 249, 158));
        p2.add(tr3);
         le = new JLabel("Please Enter Institution Name");
        le.setBounds(290, 315, 250, 10);
        le.setForeground(Color.red);
        le.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(le);
        le.setVisible(false);
        tr3.setLabelerror(le);
        //==============================================COMBOBOX
        cb = new RoundJComboBox();
        cb.setFont(font8);
        cb.setBounds(280, 330, 250, 35);
        cb.setForeground(Color.BLUE);
        p2.add(cb);
        for (int i = 0; i <= 5; i++) {
            cb.addItem(type[i]);
        }
        lf = new JLabel("Please Select Institution Type");
        lf.setBounds(290, 365, 250, 10);
        lf.setForeground(Color.red);
        lf.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lf);
        lf.setVisible(false);
        cb.setLabelerror(lf);
        
        cb1 = new RoundJComboBox();
        cb1.setBounds(280, 380, 250, 35);
        cb1.setFont(font8);
        cb1.setForeground(Color.BLUE);
        p2.add(cb1);
       for (int i = 0; i <= 5; i++) {
            cb1.addItem(type1[i]);
        }
        lg = new JLabel("Please Select Role in Institution");
        lg.setBounds(290, 415, 250, 10);
        lg.setForeground(Color.red);
        lg.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lg);
        lg.setVisible(false);
        cb1.setLabelerror(lg);
        //=========================================================CHECKBOX
        box1 = new JCheckBox("I Accept the");
        box1.setBounds(215, 430, 101, 25);
        box1.setForeground(new Color(75, 79, 74));
        box1.setFont(font8);
        box1.setBackground(Color.WHITE);
        box1.setFocusPainted(false);
        p2.add(box1);
        
        lh = new JLabel("Please Accept Term of Services");
        lh.setBounds(250, 455, 250, 10);
        lh.setForeground(Color.red);
        lh.setFont(new Font("Arial", Font.BOLD, 9));
        p2.add(lh);
        lh.setVisible(false);

        //==============================================BUTTON
        b1 = new JButton();
        b1.setBounds(590, 0, 40, 40);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setRolloverEnabled(true);
        b1.setIcon(new ImageIcon("images/book.png"));
        b1.setRolloverIcon(new ImageIcon("images/close.png"));
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        b1.setActionCommand("back");
        p2.add(b1);
        
        ln = new JLabel("Log in!");
        ln.setBounds(385, 549, 35, 15);
        ln.setForeground(new Color(0, 102, 255));
        ln.setFont(font4);
        ln.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p2.add(ln);
        ln.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                log2.login();
            }
            
        });
        
        br = new ButtonRound();
        br.setText("Sign Up");
        br.setFont(new Font("Arial", Font.PLAIN, 20));
        br.setBounds(205, 470, 220, 50);
        br.setRoundbottomleft(50);
        br.setRoundbottomright(50);
        br.setRoundtopleft(50);
        br.setRoundtopright(50);
        br.setForeground(Color.WHITE);
        br.setBackground(new Color(41, 156, 18));
        br.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        br.setMouseEnterColor(new Color(191, 196, 190));
        br.setMouseClickColor(new Color(103, 111, 101));
        br.setTextClickColor(Color.WHITE);
        br.setMouseExistColor(new Color(41, 156, 18));
        br.setTextEnterColor(Color.BLACK);
        br.setTextExistColor(Color.WHITE);
        p2.add(br);
        br.addActionListener(this);
        br.setActionCommand("SIGNUP");
        
    }
    
    public void signupdialog() {
        
        box.titlelabel.setText("Sign Up Successful ");
        box.bodylabel.setText("Please Login To Continue");
        
        JButton okbutton = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton.setFocusable(false);
        okbutton.setContentAreaFilled(false);
        okbutton.setRolloverEnabled(true);
        okbutton.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        box.buttonpanel.add(okbutton);
        okbutton.addActionListener(this);
        okbutton.setActionCommand("right");
        box.setVisible(true);
    }
    
    public void addfontcolor(JTextField jt) {
        jt.setForeground(Color.GRAY);
        jt.setFont(font1);
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
                log2.login();
                break;
            
            case "SIGNUP": {
                if (box1.isSelected()) {
                    lh.setVisible(false);
                    if ((tr.getText().equals(" Full Name") || tr.getText().equals("")) || (tr1.getText().equals(" Email ID") || tr1.getText().equals("")) || (tr2.getText().equals(" Phone No.") || tr2.getText().equals("")) || (tr3.getText().equals(" Institution Name") || tr3.getText().equals("")) || cb.getSelectedItem().equals("Select Instituion") || cb1.getSelectedItem().equals("Select Role")) {
                        if (tr.getText().equals(" Full Name") || tr.getText().equals("")) {
                            lb.setVisible(true);
                        } else {
                            lb.setVisible(false);
                        }
                        if (tr1.getText().equals(" Email ID") || tr1.getText().equals("")) {
                            lc.setVisible(true);
                        } else {
                            lc.setVisible(false);
                        }
                        if (tr2.getText().equals(" Phone No.") || tr2.getText().equals("")) {
                            ld.setVisible(true);
                        } else {
                            ld.setVisible(false);
                        }
                        if (tr3.getText().equals(" Institution Name") || tr3.getText().equals("")) {
                            le.setVisible(true);
                        } else {
                            le.setVisible(false);
                        }
                        if (cb.getSelectedItem().equals("Select Instituion")) {
                            lf.setVisible(true);
                        } else {
                            lf.setVisible(false);
                        }
                        if (cb1.getSelectedItem().equals("Select Role")) {
                            lg.setVisible(true);
                        } else {
                            lg.setVisible(false);
                        }
                        
                    } else {
                        
                        String email1 = tr1.getText();
                        String phone1 = tr2.getText();
                        try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from signup where EmailId=? ");
                            pst.setString(1, email1);
                            ResultSet rs = (ResultSet) pst.executeQuery();
                            over1 = rs.next();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement("select * from signup where PhoneNo=?");
                            pst1.setString(1, phone1);
                            ResultSet rs1 = (ResultSet) pst1.executeQuery();
                            over2 = rs1.next();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (over1) {
                            lemail.setVisible(true);
                        } else {
                            lemail.setVisible(false);
                        }
                        if (over2) {
                            lphone.setVisible(true);
                        } else {
                            lphone.setVisible(false);
                        }
                        
                        if (over1 || over2) {
                            
                        } else {
                            
                            try {
                                String name = tr.getText();
                                String email = tr1.getText();
                                String phone = tr2.getText();
                                String institution = tr3.getText();
                                String insttype = cb.getSelectedItem().toString();
                                String role = cb1.getSelectedItem().toString();
                                PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into signup( FullName, EmailId, PhoneNo, InstitutionName, InstitutionType, YourRole) values(?,?,?,?,?,?)");
                                pst.setString(1, name);
                                pst.setString(2, email);
                                pst.setDouble(3, Double.parseDouble(phone));
                                pst.setString(4, institution);
                                pst.setString(5, insttype);
                                pst.setString(6, role);
                                pst.executeUpdate();
                                
                                signupdialog();
                                dispose();
                                // con.close();
                                tr.setText(" Full Name");
                                addfontcolor(tr);
                                
                                tr1.setText(" Email ID");
                                addfontcolor(tr1);
                                tr2.setText(" Phone No.");
                                addfontcolor(tr2);
                                tr3.setText(" Institution Name");
                                addfontcolor(tr3);
                                cb.setSelectedIndex(0);
                                cb1.setSelectedIndex(0);
                                box1.setSelected(false);
                            } catch (SQLException ex) {
                                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                    
                } else {
                    lh.setVisible(true);
                }
            }
            
            break;
            
            default:
                System.out.print("default");
                break;
        }
    }
    
}
