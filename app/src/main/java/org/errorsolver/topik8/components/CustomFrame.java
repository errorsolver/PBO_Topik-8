package org.errorsolver.topik8.components;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class CustomFrame extends JFrame {
    private final String title;
    private final int width;
    private final int height;
    private final int layout;

    public CustomFrame(String title, int width, int height, int layout) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.layout = layout;

        this._createFrame();
    }

    private void _createFrame() {
        setTitle(this.title);
        setSize(this.width, this.height);
        this.setLayout(new BoxLayout(getContentPane(), this.layout));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
