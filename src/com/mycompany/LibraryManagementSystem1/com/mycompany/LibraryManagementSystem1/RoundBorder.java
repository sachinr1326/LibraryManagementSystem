/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

/**
 *
 * @author Sachin Thakur
 */
    public class RoundBorder implements Border {

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

        private int radius;
       
        public RoundBorder(int radius) {
                  this.radius=radius;
        }

   

        public int getRadius() {
            return radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
          Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, width - 1, height - 1, getRadius(), getRadius());
      
     
        }

        @Override
        public Insets getBorderInsets(Component c) {
            int value = getRadius() / 2;
            return new Insets(value, value, value, value);
        }

    @Override
    public boolean isBorderOpaque() {
   return false;
    }

  
   

    }

