/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import com.sun.org.apache.xpath.internal.operations.Variable;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sachin Thakur
 */
public final class ImageResizer {

    public ImageResizer(int x,int y,JLabel label,String icon) {
       
          try {
                 BufferedImage img= null;
                img=ImageIO.read(new File(icon));
                Image img1=img.getScaledInstance(x,y,Image.SCALE_SMOOTH);
               label.setIcon(new ImageIcon(img1));
            
            } catch (IOException ex) {
           
            }
    }
   
}
