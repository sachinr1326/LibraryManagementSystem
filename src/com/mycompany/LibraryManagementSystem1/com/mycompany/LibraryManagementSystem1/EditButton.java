package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EditButton extends JButton {

   
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    
//    
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    
//    public void setHeight(int height) {
//        this.height = height;
//    }

    
    public void setBtntextfont(String btntextfont) {
        this.btntextfont = btntextfont;
    }

    
    public void setBtntextsize(int btntextsize) {
        this.btntextsize = btntextsize;
    }

   
    public void setBtntextfontstyle(int btntextfontstyle) {
        this.btntextfontstyle = btntextfontstyle;
    }

    
    public void setBtntextcolor(Color btntextcolor) {
        this.btntextcolor = btntextcolor;
        btntext.setForeground(btntextcolor);
    }
   

    public boolean isOver() {
        return over;
    }

    
    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorover() {
        return colorover;
    }

    public void setColorover(Color colorover) {
        this.colorover = colorover;
    }

    public Color getColorclick() {
        return colorclick;
    }

    public void setColorclick(Color colorclick) {
        this.colorclick = colorclick;
    }

    public Color getBordercolor() {
        return bordercolor;
    }

    public void setBordercolor(Color bordercolor) {
        this.bordercolor = bordercolor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
 public void setbtntext(JLabel btntext ) {
        this.btntext=btntext;
    }
 public void setbtnBound(int x, int y,int width,int height){
     this.x=x;
     this.y=y;
     this.width=width;
     this.height=height;
     btntext.setBounds(x, y, width,height);
 
 }

    public void setBtntextfont(String btntextfont,int btntextfontstyle ,int btntextsize) {
        this.setBtntextfont(btntextfont);
        this.setBtntextfontstyle(btntextfontstyle);
        this.setBtntextsize(btntextsize);
        btntext.setFont(new Font(btntextfont, btntextfontstyle, btntextsize));
    }

   

    public EditButton(String kit) {
        //super(kit);
       
       btntext = new JLabel(kit);
      
       btntext.setFont(new Font(btntextfont, btntextfontstyle, btntextsize));
        btntext.setForeground(btntextcolor);
        add(btntext,JButton.CENTER);
        //init color

        color = new Color(66, 144, 232);
        colorover = new Color(223, 94, 66);
        colorclick = new Color(76, 232, 66);
        bordercolor = new Color(232, 66, 225);
        setContentAreaFilled(false);
        //add mouse event
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorover);

                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);

                over = false;

            }

            @Override
            public void mousePressed(MouseEvent e) {

                setBackground(colorclick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(colorover);

                } else {
                    setBackground(color);

                }
            }

        });

    }
    private boolean over;
    private Color color;
    private Color colorover;
    private Color colorclick;
    private Color bordercolor;
    private int radius = 0;
    private  JLabel btntext;
     private String btntextfont="";
    private Color btntextcolor;
    private int btntextsize=0;
    private int btntextfontstyle=0;
    private int x;
    private int y;
    private int width;
    private int height;
   

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // paint border 
        g2.setColor(bordercolor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //border set 2 pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponents(g);
    }

}
