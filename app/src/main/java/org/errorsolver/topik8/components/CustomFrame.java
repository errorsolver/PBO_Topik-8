package org.errorsolver.topik8.components;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {
    private String title;
    private int width;
    private int height;

    public CustomFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void createFrame() {
        setTitle(this.title);
        setSize(this.width, this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
