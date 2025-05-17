package org.errorsolver.topik8.components;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CustomFrame extends JFrame {
    private final String title;
    private final int width;
    private final int height;
    private final int layout;
    private final JComponent[] components;

    public CustomFrame(String title, int width, int height, int layout, JComponent... components) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.layout = layout;
        this.components = components;

        this._createFrame();
        setVisible(true);
    }

    private void _createFrame() {
        setTitle(this.title);
        setSize(this.width, this.height);

        Container contentPane = this.getContentPane();
        
        this.setLayout(new BoxLayout(contentPane, this.layout));

        for (JComponent component : this.components) {
            contentPane.add(component);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
