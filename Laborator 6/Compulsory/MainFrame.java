package org.example;

import org.example.ConfigPanel;
import org.example.ControlPanel;
import org.example.DrawingPanel;

import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingConstants.CENTER;


public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

         canvas = new DrawingPanel(this);
         configPanel = new ConfigPanel(this);
         controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        add(canvas, CENTER); //this is BorderLayout.CENTER

        //invoke the layout manager
        pack();
    }

}
