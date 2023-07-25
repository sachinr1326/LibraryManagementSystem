package com.mycompany.LibraryManagementSystem1;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;



public class BookTextArea extends JTextArea {
    
    private int radius;
   private  String word;
   int pos = 0, p = 0;
   JLabel label;
    private JLabel labelerror;
  
   
    public BookTextArea(String Txt) {
      // super(10, 20);
      
        word=Txt;
        setText(word);
        
          label=new JLabel(word);
       label.setFont(new Font("Times New Romans", Font.BOLD, 12));
       label.setForeground(Color.WHITE);
        label.setVisible(false);
        
         setFont(new Font("Arial", Font.BOLD, 12));
       // setOpaque(false);
         setForeground(Color.GRAY);
        setBorder(null);
        //setRadius(10);
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
                if (getText().equals(word)) {
                    setText("");
                    labelerror.setVisible(false);
                    removePlaceholder();
                    label.setVisible(true);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                 if(getText().length()==0){
                     setText(word);
                 addPlaceholder();
                 label.setVisible(false);
                 }
            }
        });   
    }
      public void addPlaceholder() {
       
        setFont( new Font("Arial", Font.BOLD, 12));
        setForeground(Color.GRAY);
    }
        public void removePlaceholder() {
     
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.BLACK);
    }

    /**
     * @return the labelerror
     */
    public JLabel getLabelerror() {
        return labelerror;
    }

    /**
     * @param labelerror the labelerror to set
     */
    public void setLabelerror(JLabel labelerror) {
        this.labelerror = labelerror;
    }

    /**
     *
     */
   
// 
}
