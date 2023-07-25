
package com.mycompany.LibraryManagementSystem1;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;


public class EyePasswordButton  extends JButton {
boolean over;
JPasswordField pass;
ImageIcon icon1;
ImageIcon icon2;

    public EyePasswordButton(JPasswordField pass,ImageIcon icon1,ImageIcon icon2) {
   this.pass=pass;
   this.icon1=icon1;
   this.icon2=icon2;
     setContentAreaFilled(false);
    setFocusable(false);
       
        
      setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(over){
                     pass.setEchoChar('#');
                    setIcon(icon1);
                  
                  over=false;
                }else{
                
               pass.setEchoChar((char)0);
                 setIcon(icon2);
                over=true;
                }
            }
    
             
});
}
}
