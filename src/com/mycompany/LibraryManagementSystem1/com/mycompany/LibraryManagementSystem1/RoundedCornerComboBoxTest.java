package com.mycompany.LibraryManagementSystem1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;

public class RoundedCornerComboBoxTest {

    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.WHITE;
    private static final Color SELECTIONFOREGROUND = Color.ORANGE;
 String type[] = {"Select Instituion", "Academy/Training Center", "College", "Pre-School", "School", "University"};
   
    private JComponent makeUI() {
        UIManager.put("ComboBox.foreground", FOREGROUND);
        UIManager.put("ComboBox.background", BACKGROUND);
        UIManager.put("ComboBox.selectionForeground", SELECTIONFOREGROUND);
        UIManager.put("ComboBox.selectionBackground", BACKGROUND);

        UIManager.put("ComboBox.buttonDarkShadow", FOREGROUND);
        UIManager.put("ComboBox.buttonBackground", BACKGROUND);
        UIManager.put("ComboBox.buttonHighlight", BACKGROUND);
        UIManager.put("ComboBox.buttonShadow", BACKGROUND);

        UIManager.put("ComboBox.border", new RoundedCornerBorder());
        
        
        
        
        
        JComboBox combo1 = new JComboBox(type);
        combo1.setUI(new BasicComboBoxUI());
        Object o = combo1.getAccessibleContext().getAccessibleChild(0);
        if (o instanceof JComponent) {
            JComponent c = (JComponent) o;
            c.setBorder(new RoundedCornerBorder());
            c.setForeground(FOREGROUND);
            c.setBackground(BACKGROUND);
        }
        //combo1.addPopupMenuListener(new HeavyWeightContainerListener());

//   
        JPanel p = new JPanel();
        p.add(combo1);
        // p.add(combo2);
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        return p;
    }

    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.getContentPane().add(new RoundedCornerComboBoxTest().makeUI());
            f.setSize(320, 240);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
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
        g2.setPaint(c.getForeground());
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


