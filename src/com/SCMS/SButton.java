package com.SCMS;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SButton extends JButton {
    private static final Color DEFAULT_SHADOW_COLOR = new Color(0, 0, 0, 50);
    private static final int SHADOW_OFFSET_X = 2;
    private static final int SHADOW_OFFSET_Y = 2;
    private static final int SHADOW_BLUR_RADIUS = 5;

    private Color shadowColor;

    public SButton(String text) {
        super(text);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(getFont().deriveFont(Font.BOLD, 14f));
        shadowColor = DEFAULT_SHADOW_COLOR;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                shadowColor = DEFAULT_SHADOW_COLOR.brighter();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                shadowColor = DEFAULT_SHADOW_COLOR;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint shadow
        g2d.setColor(shadowColor);
        g2d.fillRoundRect(SHADOW_OFFSET_X, SHADOW_OFFSET_Y, getWidth() - SHADOW_OFFSET_X, getHeight() - SHADOW_OFFSET_Y, getHeight() - SHADOW_OFFSET_Y, getHeight() - SHADOW_OFFSET_Y);

        // Paint button
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - SHADOW_OFFSET_X, getHeight() - SHADOW_OFFSET_Y, getHeight() - SHADOW_OFFSET_Y, getHeight() - SHADOW_OFFSET_Y);

        // Paint text
        g2d.setColor(getForeground());
        g2d.setFont(getFont());
        g2d.drawString(getText(), getWidth() / 2 - g2d.getFontMetrics().stringWidth(getText()) / 2, getHeight() / 2 + g2d.getFontMetrics().getHeight() / 4);

        g2d.dispose();
    }
}
