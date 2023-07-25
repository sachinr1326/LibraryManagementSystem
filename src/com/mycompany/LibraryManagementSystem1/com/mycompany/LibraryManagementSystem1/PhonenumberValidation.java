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
public class PhonenumberValidation {

//    public PhonenumberValidation() {
//         
//    }
    public void phone(JTextField test){
    test.addKeyListener(new KeyAdapter() {
        
            @Override
            public void keyPressed(KeyEvent e) {
            int phonenumber=test.getText().length();
            
            char c=e.getKeyChar();
            if(Character.isLetter(c)){ test.setEditable(true);}else{ test.setEditable(false);}
            if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
                 
                if(phonenumber<10){
                test.setEditable(true);
                }else{
                test.setEditable(false);
                }
                
            }else{
            if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
            
            test.setEditable(true);
            }else{
             test.setEditable(false);
            }
            
            }
            
            }
      
        });
    
    }
    
   
    
}
