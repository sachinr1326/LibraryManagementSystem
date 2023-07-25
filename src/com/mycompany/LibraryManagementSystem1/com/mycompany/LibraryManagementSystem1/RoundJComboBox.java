package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class RoundJComboBox extends JComboBox {

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

    private static final Color BACKGROUND = new Color(255, 249, 158);
    private static final Color FOREGROUND = new Color(21, 101, 192);
    private static final Color SELECTIONFOREGROUND = Color.BLACK;
    private static Color Bordercolor;
  private JLabel labelerror;
  
    public RoundJComboBox() {
         
        UIManager.put("ComboBox.foreground", FOREGROUND);
        UIManager.put("ComboBox.background", BACKGROUND);
        UIManager.put("ComboBox.selectionForeground", SELECTIONFOREGROUND);
        UIManager.put("ComboBox.selectionBackground", BACKGROUND);

        UIManager.put("ComboBox.buttonDarkShadow", Color.GRAY);
        UIManager.put("ComboBox.buttonBackground", BACKGROUND);
        UIManager.put("ComboBox.buttonHighlight", BACKGROUND);
        UIManager.put("ComboBox.buttonShadow", BACKGROUND);

        UIManager.put("ComboBox.border", new RoundedCornerBorder());

        setUI(new BasicComboBoxUI());
        Object o = getAccessibleContext().getAccessibleChild(0);
        if (o instanceof JComponent) {

            JComponent c = (JComponent) o;
            c.setBorder(new RoundedCornerBorder());
            c.setForeground(FOREGROUND);
            c.setBackground(BACKGROUND);
            c.setFocusable(false);

        }
 //setOpaque(false);
        addItemListener((ItemEvent e) -> {
            if (getSelectedIndex() >= 1) {
                Bordercolor = Color.BLACK;
                setFont(new Font("Arial", Font.PLAIN, 14));
              labelerror.setVisible(false);
                setForeground(Color.BLACK);
            } else {
                Bordercolor = Color.GRAY;
                
                setFont(new Font("Arial", Font.BOLD, 12));

                setForeground(Color.GRAY);
            }
        });
    }

    class RoundedCornerBorder extends AbstractBorder {

        protected static final int ARC = 12;

        @Override
        public void paintBorder(
                Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int r = ARC;
            int w = width - 1;
            int h = height - 1;

            Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
            if (c instanceof JPopupMenu) {
                g2.setPaint(c.getBackground());
                
                g2.fill(round);
            } else {
                Container parent = c.getParent();
                if (Objects.nonNull(parent)) {
                    g2.setPaint(parent.getBackground());
                   Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
                    corner.subtract(round);
                    g2.fill(corner);
                }
            }
            
            g2.setPaint(Bordercolor);
            g2.draw(round);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(4, 8, 4, 8);
            return insets;
        }
    }

}
