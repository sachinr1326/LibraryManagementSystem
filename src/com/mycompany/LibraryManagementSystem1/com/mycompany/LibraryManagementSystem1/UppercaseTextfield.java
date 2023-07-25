/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LibraryManagementSystem1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Sachin Thakur
 */
public class UppercaseTextfield {

    public UppercaseTextfield() {
    }
    public void Uppercase(JTextField text){
    
    text.addKeyListener(new KeyAdapter() {
       

        @Override
        public void keyReleased(KeyEvent e) {
        int position =text.getCaretPosition();
       text.setText(text.getText().toUpperCase());
       text.setCaretPosition(position);
        }
        
    });
    
    }
}
