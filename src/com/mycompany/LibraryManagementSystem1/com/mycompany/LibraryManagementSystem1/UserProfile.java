/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sachin Thakur
 */
public final class UserProfile implements ActionListener {

    MainhomePage mp;
//    Loginpage login;
    JLabel username, logindetail1, camera, camera1, backlabel, namelabel, phonelabel, emaillabel, namebutton, phonebutton, emailbutton;
    ButtonRound b1, b, b2;
    PanelRound mainpanel;
    JTextField nametext, phonetext, emailtext;
    ImageIcon icon1, icon;
    int userid = 0;
    ImageAvatar avtar = new ImageAvatar();
    ImageAvatar avtar1 = new ImageAvatar();
    textDialogbox profiedialog = new textDialogbox();
    File f;
    JDialog box;
    byte[] image=null;
     FileInputStream file = null;
    MySqlConnection obj = new MySqlConnection();
    Connection con = null;
     String profilename="";
     String profilephone="";
     String profileEmail="";

    public UserProfile(MainhomePage mp) {
        this.mp = mp;
        try {
            con = obj.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        userdtail();
        ProfileDetail();
        Profiledialog();
    }

    public void userdtail() {

        camera = new JLabel();
        camera.setBounds(62, 50, 12, 12);
        icon1 = new ImageIcon(new ImageIcon("images/camera2.png").getImage().getScaledInstance(camera.getWidth(), camera.getHeight(), Image.SCALE_SMOOTH));
        camera.setIcon(icon1);
        mp.Userprofilepanel.add(camera);

        avtar.setBounds(5, 5, 70, 70);
        avtar.setBorderSize(0);
        mp.Userprofilepanel.add(avtar);
        icon = new ImageIcon(new ImageIcon("images/userprofile.png").getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
        avtar.setIcon(icon);

        username = new JLabel();
        username.setBounds(75, 30, 110, 20);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setHorizontalTextPosition(SwingConstants.CENTER);
        username.setFont(new Font("Arial", Font.BOLD, 12));
        mp.Userprofilepanel.add(username);

        b1 = new ButtonRound();
        b1.setRoundbottomleft(220);
        b1.setRoundbottomright(220);
        b1.setRoundtopleft(220);
        b1.setRoundtopright(220);
        b1.setBackground(new Color(0, 0, 0, 0));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Serif", Font.BOLD, 28));
        b1.setBounds(5, 5, 65, 65);
        b1.setMouseClickColor(new Color(102, 153, 0, 0));
        b1.setMouseEnterColor(new Color(102, 153, 0, 0));
        b1.setMouseExistColor(new Color(33, 97, 140, 0));
        b1.setTextClickColor(new Color(245, 127, 23));
        b1.setTextEnterColor(Color.WHITE);
        b1.setTextExistColor(Color.WHITE);
        mp.Userprofilepanel.add(b1);
        b1.addActionListener(this);
        b1.setActionCommand("UPDATE");

    }

    public void ProfileDetail() {
        box = new JDialog();
        box.setSize(400, 600);
        box.setLocationRelativeTo(null);
        box.setLayout(null);
        box.setUndecorated(true);
        box.setBackground(new Color(0, 0, 0, 0));

        PanelRound p1 = new PanelRound();
        p1.setLayout(null);
        p1.setSize(400, 600);
        p1.setRoundbottomright(20);
        p1.setRoundbottomleft(20);
        p1.setRoundtopleft(20);
        p1.setRoundtopright(20);
        p1.setBackground(new Color(21, 101, 192));
        box.add(p1);

        mainpanel = new PanelRound();
        mainpanel.setLayout(null);
        mainpanel.setBounds(10, 10, 380, 580);
        mainpanel.setRoundbottomright(10);
        mainpanel.setRoundbottomleft(10);
        mainpanel.setRoundtopleft(10);
        mainpanel.setRoundtopright(10);
        mainpanel.setBackground(Color.WHITE);
        p1.add(mainpanel);

        backlabel = new JLabel(new ImageIcon("images/backuserarrow1.png"));
        backlabel.setBounds(5, 10, 40, 30);
        backlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainpanel.add(backlabel);
        backlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                box.dispose();

            }
        });

        camera1 = new JLabel();
        camera1.setBounds(247, 150, 40, 40);
        ImageIcon campho = new ImageIcon(new ImageIcon("images/camera2.png").getImage().getScaledInstance(camera1.getWidth(), camera1.getHeight(), Image.SCALE_SMOOTH));
        camera1.setIcon(campho);
        mainpanel.add(camera1);

        avtar1.setBounds(90, 20, 200, 200);
        avtar1.setBorderSize(0);
        mainpanel.add(avtar1);
        ImageIcon photo = new ImageIcon(new ImageIcon("images/userprofile1.png").getImage().getScaledInstance(avtar1.getWidth(), avtar1.getHeight(), Image.SCALE_SMOOTH));
        avtar1.setIcon(photo);

        b = new ButtonRound();
        b.setRoundbottomleft(220);
        b.setRoundbottomright(220);
        b.setRoundtopleft(220);
        b.setRoundtopright(220);
        b.setBackground(new Color(0, 0, 0, 0));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Serif", Font.BOLD, 28));
        b.setBounds(90, 20, 200, 200);
        b.setMouseClickColor(new Color(102, 153, 0, 0));
        b.setMouseEnterColor(new Color(102, 153, 0, 0));
        b.setMouseExistColor(new Color(33, 97, 140, 0));
        b.setTextClickColor(new Color(245, 127, 23));
        b.setTextEnterColor(Color.WHITE);
        b.setTextExistColor(Color.WHITE);
        mainpanel.add(b);
        b.addActionListener(this);
        b.setActionCommand("profile");

        namelabel = new JLabel("Name");
        namelabel.setBounds(30, 255, 100, 20);
        namelabel.setForeground(Color.GRAY);
        namelabel.setFont(new Font("Times New Romans", Font.BOLD, 12));
        mainpanel.add(namelabel);
        nametext = new JTextField();
        nametext.setBounds(30, 270, 320, 30);
        nametext.setEditable(false);
        nametext.setBackground(Color.WHITE);
        nametext.setFont(new Font("Times New Romans", Font.BOLD, 15));
        nametext.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        mainpanel.add(nametext);
        namebutton = new JLabel("Edit");
        namebutton.setBounds(325, 250, 25, 20);
        namebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        namebutton.setForeground(new Color(30, 136, 229));
        namebutton.setFont(new Font("Times New Romans", Font.BOLD, 13));
        mainpanel.add(namebutton);
        namebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nametext.setEditable(true);
 b2.setEnabled(true);
            }
        });

        emaillabel = new JLabel("Email Address");
        emaillabel.setBounds(30, 315, 100, 20);
        emaillabel.setForeground(Color.GRAY);
        emaillabel.setFont(new Font("Times New Romans", Font.BOLD, 12));
        mainpanel.add(emaillabel);
        emailtext = new JTextField();
        emailtext.setBounds(30, 330, 320, 30);
        emailtext.setEditable(false);
        emailtext.setBackground(Color.WHITE);
        emailtext.setFont(new Font("Times New Romans", Font.BOLD, 15));
        emailtext.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        mainpanel.add(emailtext);
        emailbutton = new JLabel("Update");
        emailbutton.setBounds(305, 310, 45, 20);
        emailbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        emailbutton.setForeground(new Color(30, 136, 229));
        emailbutton.setFont(new Font("Times New Romans", Font.BOLD, 13));
        mainpanel.add(emailbutton);
        emailbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emailtext.setEditable(true);
 b2.setEnabled(true);
            }
        });

        phonelabel = new JLabel("Phone No.");
        phonelabel.setBounds(30, 375, 100, 20);
        phonelabel.setForeground(Color.GRAY);
        phonelabel.setFont(new Font("Times New Romans", Font.BOLD, 12));
        mainpanel.add(phonelabel);
        phonetext = new JTextField("anuj");
        phonetext.setBounds(30, 390, 320, 30);
        phonetext.setEditable(false);
        phonetext.setBackground(Color.WHITE);
        phonetext.setFont(new Font("Times New Romans", Font.BOLD, 15));
        phonetext.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        mainpanel.add(phonetext);
        phonebutton = new JLabel("Change");
        phonebutton.setBounds(300, 370, 50, 20);
        phonebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        phonebutton.setForeground(new Color(30, 136, 229));
        phonebutton.setFont(new Font("Times New Romans", Font.BOLD, 13));
        mainpanel.add(phonebutton);
        phonebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                phonetext.setEditable(true);
                
             b2.setEnabled(true);
            }
        });

        b2 = new ButtonRound();
        b2.setText("Update");
        b2.setRoundbottomleft(10);
        b2.setRoundbottomright(10);
        b2.setRoundtopleft(10);
        b2.setRoundtopright(10);
        b2.setBackground(new Color(102, 153, 0));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Times New Romans", Font.BOLD, 15));
        b2.setBounds(120, 530, 150, 40);
        b2.setMouseClickColor(new Color(33, 97, 140));
        b2.setMouseEnterColor(new Color(33, 97, 140));
        b2.setMouseExistColor(new Color(102, 153, 0));
        b2.setTextClickColor(new Color(245, 127, 23));
        b2.setTextEnterColor(Color.WHITE);
        b2.setTextExistColor(Color.WHITE);
        mainpanel.add(b2);
        b2.addActionListener(this);
        b2.setActionCommand("SUBMIT");

        logindetail1 = new JLabel();
        logindetail1.setBounds(120, 500, 150, 40);
        mainpanel.add(logindetail1);

    }

    public void Profiledialog() {

        profiedialog.titlelabel.setText("Profile");
        profiedialog.bodylabel.setText("Update Successfull");

        JButton okbutton = new JButton(new ImageIcon("images/check-mark1.png"));
        okbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okbutton.setFocusable(false);
        okbutton.setContentAreaFilled(false);
        okbutton.setRolloverEnabled(true);
        okbutton.setRolloverIcon(new ImageIcon("images/check-mark.png"));
        profiedialog.buttonpanel.add(okbutton);
        okbutton.addActionListener(this);
        okbutton.setActionCommand("right");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {

            case "UPDATE":
                box.setVisible(true);
//                
                break;
            case "right":

                profiedialog.dispose();
                ;
//                
                break;

            case "profile":

                JFileChooser chooser = new JFileChooser();
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
                    ImageIcon icon2 = new ImageIcon(new ImageIcon(f.toString()).getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
                    avtar.setIcon(icon2);

                    ImageIcon photo = new ImageIcon(new ImageIcon(f.toString()).getImage().getScaledInstance(avtar1.getWidth(), avtar1.getHeight(), Image.SCALE_SMOOTH));
                    avtar1.setIcon(photo);

                } else {
                    ImageIcon ico = new ImageIcon(new ImageIcon("images/userprofile.png").getImage().getScaledInstance(avtar.getWidth(), avtar.getHeight(), Image.SCALE_SMOOTH));
                    avtar.setIcon(ico);
                    ImageIcon photo = new ImageIcon(new ImageIcon("images/userprofile1.png").getImage().getScaledInstance(avtar1.getWidth(), avtar1.getHeight(), Image.SCALE_SMOOTH));
                    avtar1.setIcon(photo);
                }

                break;

            case "SUBMIT":
                
                if(nametext.getText().equals(profilename) && emailtext.getText().equals(profileEmail) && phonetext.getText().equals(profilephone)&& f==null){
                            profiedialog.bodylabel.setText("Already Updated");
                            profiedialog.setVisible(true);
                
                }else{
                     String name = nametext.getText();
                   String email = emailtext.getText();
                   String phone = phonetext.getText();
                     int x = 0;
                    if(!nametext.getText().equals(profilename) && !emailtext.getText().equals(profileEmail) && !phonetext.getText().equals(profilephone)&& f!=null){
                         try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set FullName=?, EmailId=?, PhoneNo=? ,profileimage=? where id=" + userid + "");
                            pst.setString(1, name);
                            pst.setString(2, email);
                            pst.setString(3, phone);
                            file = new FileInputStream(f);
                           pst.setBinaryStream(4, file, file.available());
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException | IOException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }else if(!(nametext.getText().equals(profilename)|| emailtext.getText().equals(profileEmail))||file==null){
                     try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set FullName=?, EmailId=?, PhoneNo=?  where id=" + userid + "");
                            pst.setString(1, name);
                            pst.setString(2, email);
                            pst.setString(3, phone);
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else if(!emailtext.getText().equals(profileEmail)){
                         try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set EmailId=? where id=" + userid + "");
                           pst.setString(1, email);
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    }else if(!phonetext.getText().equals(profilephone)){
                        
                         try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set  PhoneNo=?  where id=" + userid + "");
                            pst.setString(1, phone);
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    
                    }else if(!nametext.getText().equals(profilename)){
                         try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set FullName=?  where id=" + userid + "");
                            pst.setString(1, name);
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }else if(f!=null){
                 try {
                            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Update signup set profileimage=? where id=" + userid + "");
                           
                            file = new FileInputStream(f);
                           pst.setBinaryStream(1, file, file.available());
                           x = pst.executeUpdate();
                             if (x != 0) {
                                profiedialog.setVisible(true);
                                username.setText(nametext.getText());
                                nametext.setEditable(false);
                                emailtext.setEditable(false);
                                phonetext.setEditable(false);
                                b2.setEnabled(false);
                                
                            } else {
                                profiedialog.bodylabel.setText("Update not Successfull");
                                profiedialog.setVisible(true);
                            }
                    } catch (SQLException | IOException ex) {
                            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                }else{
                 
                     profiedialog.bodylabel.setText("Already Updated");
                            profiedialog.setVisible(true);
                
                
                }
                        
                        //id, FullName, EmailId, PhoneNo, InstitutionName, InstitutionType, YourRole
                        
                       
                          
                        
                        
                   
                    }

                break;


            default:

        }

    }
}
