package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
    }


    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }


    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
        graphics.fillOval(94, 294, 15, 15);
        graphics.fillOval(294, 94, 15, 15);
        graphics.fillOval(294, 494, 15, 15);
        graphics.fillOval(494, 94, 15, 15);
        graphics.fillOval(494, 494, 15, 15);
        graphics.fillOval(694, 294, 15, 15);

        graphics.drawLine(300, 100, 100, 300);
        graphics.drawLine(300, 100, 300, 500);
        graphics.drawLine(300, 100, 500, 100);
        graphics.drawLine(300, 100, 500, 500);
        graphics.drawLine(300, 100, 700, 300);

        graphics.drawLine(100, 300, 300, 100);
        graphics.drawLine(100, 300, 300, 500);
        graphics.drawLine(100, 300, 500, 100);
        graphics.drawLine(100, 300, 500, 500);
        graphics.drawLine(100, 300, 700, 300);

        graphics.drawLine(300, 500, 300, 100);
        graphics.drawLine(300, 500, 100, 300);
        graphics.drawLine(300, 500, 500, 100);
        graphics.drawLine(300, 500, 500, 500);
        graphics.drawLine(300, 500, 700, 300);

        graphics.drawLine(500, 100, 300, 100);
        graphics.drawLine(500, 100, 300, 500);
        graphics.drawLine(500, 100, 100, 300);
        graphics.drawLine(500, 100, 500, 500);
        graphics.drawLine(500, 100, 700, 300);

        graphics.drawLine(500, 500, 300, 100);
        graphics.drawLine(500, 500, 300, 500);
        graphics.drawLine(500, 500, 500, 100);
        graphics.drawLine(500, 500, 100, 300);
        graphics.drawLine(500, 500, 700, 300);

        graphics.drawLine(700, 300, 300, 100);
        graphics.drawLine(700, 300, 300, 500);
        graphics.drawLine(700, 300, 500, 100);
        graphics.drawLine(700, 300, 500, 500);
        graphics.drawLine(700, 300, 100, 300);



    }



}
