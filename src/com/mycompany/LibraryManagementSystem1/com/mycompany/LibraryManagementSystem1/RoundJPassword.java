package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;

public class RoundJPassword extends JPasswordField {

    public int getCornersize() {
        return Cornersize;
    }

   
    public void setCornersize(int Cornersize) {
        this.Cornersize = Cornersize;
    }


    
   
  
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }



        private Shape shape;
       int pos=0,p=0;
          private int Cornersize;
      private   String word;
     // private   String text;
    
        Font font1 = new Font("Arial", Font.BOLD, 12);
        Font font8 = new Font("Arial", Font.PLAIN, 15);
        public RoundJPassword(String txt ) {
            super(txt);
          word=txt;
           // setBordercolor(bordercolor);
            setOpaque(false); // As suggested by @AVD in comment.
             setForeground(Color.GRAY);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
              
                }

                @Override
                public void keyPressed(KeyEvent e) {
               
                }

                @Override
                public void keyReleased(KeyEvent e) {
                pos = getCaretPosition();
                  
                if (pos == 0) {
                 
                    
                 setForeground(Color.GRAY);
                   

                } else {
                setForeground(Color.BLACK);
             
                  

                }
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  setForeground(Color.BLUE);
                }
           
            });
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if(getText().equals(word)){
                   setText("");
                   
                    requestFocus();
                    setEchoChar('#'); 
                    removePlaceholder();
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                 if (getText().length() == 0) {
                    addPlaceholder();
                setText(getWord());
              
                setEchoChar((char) 0);
                }
                }
            });
           
         
}    
        
        
        public void addPlaceholder() {
       
        setFont(font1);
        setForeground(Color.GRAY);
    }
        public void removePlaceholder() {
     
        setFont(font8);
        setForeground(Color.BLACK);
    }

        
  @Override
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getCornersize(), getCornersize());
            super.paintComponent(g);
            
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getCornersize(), getCornersize());
        }

        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(5, 5, getWidth() - 1, getHeight() - 1,getCornersize(),getCornersize());
            }
            return shape.contains(x, y);
        }
}
 