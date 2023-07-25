package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;


public class ButtonRound extends JButton {

    /**
     * @return the textClickColor
     */
    public Color getTextClickColor() {
        return textClickColor;
    }

    /**
     * @param textClickColor the textClickColor to set
     */
    public void setTextClickColor(Color textClickColor) {
        this.textClickColor = textClickColor;
    }

    /**
     * @return the textEnterColor
     */
    public Color getTextEnterColor() {
        return textEnterColor;
    }

    /**
     * @param textEnterColor the textEnterColor to set
     */
    public void setTextEnterColor(Color textEnterColor) {
        this.textEnterColor = textEnterColor;
    }

    /**
     * @return the textExistColor
     */
    public Color getTextExistColor() {
        return textExistColor;
    }

    /**
     * @param textExistColor the textExistColor to set
     */
    public void setTextExistColor(Color textExistColor) {
        this.textExistColor = textExistColor;
    }

    /**
     * @return the mouseEnterColor
     */
    public Color getMouseEnterColor() {
        return mouseEnterColor;
    }

    /**
     * @param mouseEnterColor the mouseEnterColor to set
     */
    public void setMouseEnterColor(Color mouseEnterColor) {
        this.mouseEnterColor = mouseEnterColor;
    }

    /**
     * @return the mouseExistColor
     */
    public Color getMouseExistColor() {
        return mouseExistColor;
    }

    /**
     * @param mouseExistColor the mouseExistColor to set
     */
    public void setMouseExistColor(Color mouseExistColor) {
        this.mouseExistColor = mouseExistColor;
    }

    /**
     * @return the mouseClickColor
     */
    public Color getMouseClickColor() {
        return mouseClickColor;
    }

    /**
     * @param mouseClickColor the mouseClickColor to set
     */
    public void setMouseClickColor(Color mouseClickColor) {
        this.mouseClickColor = mouseClickColor;
    }

    public int getRoundtopleft() {
        return roundtopleft;
    }

    public void setRoundtopleft(int roundtopleft) {
        this.roundtopleft = roundtopleft;
        repaint();
    }

    public int getRoundtopright() {
        return roundtopright;
    }

    public void setRoundtopright(int roundtopright) {
        this.roundtopright = roundtopright;
        repaint();
    }

    public int getRoundbottomleft() {
        return roundbottomleft;
    }

    public void setRoundbottomleft(int roundbottomleft) {
        this.roundbottomleft = roundbottomleft;
        repaint();
    }

    public int getRoundbottomright() {
        return roundbottomright;
    }

    public void setRoundbottomright(int roundtopbottomright) {
        this.roundbottomright = roundtopbottomright;

        repaint();
    }
    private int roundtopleft = 0;
    private int roundtopright = 0;
    private int roundbottomleft = 0;
    private int roundbottomright = 0;
     boolean over;
 private Color mouseEnterColor;
 private Color mouseExistColor;
 private Color mouseClickColor;
private Color textClickColor;
  private Color textEnterColor;
   private Color textExistColor;
    public ButtonRound() {
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            setForeground(getTextEnterColor());
               setBackground(getMouseEnterColor());
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(getTextExistColor());
                setBackground(getMouseExistColor());
                over = false;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setForeground(getTextClickColor());
                setBackground(getMouseClickColor());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(getMouseEnterColor());

                } else {
                   setBackground(getMouseExistColor());
                }
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area =new Area(createroundtopleft());
        if(roundtopright>0){
        area.intersect(new Area(createroundtopright()));
        }
        if(roundbottomleft>0){
        area.intersect(new Area(createroundbottomleft()));
        }
        if(roundbottomright>0){
        area.intersect(new Area(createroundbottomright()));
        }
        g2.fill(area);
        g2.dispose();
        

        super.paintComponent(g);

    }
    
     private Shape createroundtopleft(){
    int width= getWidth();
    int height=getHeight();
    int roundx=Math.min(width,roundtopleft);
    int roundy=Math.min(height,roundtopleft);
    Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,roundx,roundy));
    area.add(new Area(new Rectangle2D.Double(roundx/2,0,width-roundx/2,height)));
    area.add(new Area(new Rectangle2D.Double(0,roundy/2,width,height-roundy/2)));
    return area;
    }
    private Shape createroundtopright(){
    int width= getWidth();
    int height=getHeight();
    int roundx=Math.min(width,roundtopright);
    int roundy=Math.min(height,roundtopright);
    Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,roundx,roundy));
    area.add(new Area(new Rectangle2D.Double(0,0,width-roundx/2,height)));
    area.add(new Area(new Rectangle2D.Double(0,roundy/2,width,height-roundy/2)));
    return area;
    }
     private Shape createroundbottomleft(){
    int width= getWidth();
    int height=getHeight();
    int roundx=Math.min(width,roundbottomleft);
    int roundy=Math.min(height,roundbottomleft);
    Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,roundx,roundy));
    area.add(new Area(new Rectangle2D.Double(roundx/2,0,width-roundx/2,height)));
    area.add(new Area(new Rectangle2D.Double(0,0,width,height-roundy/2)));
    return area;
    }
       private Shape createroundbottomright(){
    int width= getWidth();
    int height=getHeight();
    int roundx=Math.min(width,roundbottomright);
    int roundy=Math.min(height,roundbottomright);
    Area area=new Area(new RoundRectangle2D.Double(0,0,width,height,roundx,roundy));
    area.add(new Area(new Rectangle2D.Double(0,0,width-roundx/2,height)));
    area.add(new Area(new Rectangle2D.Double(0,0,width,height-roundy/2)));
    return area;
    }

}
