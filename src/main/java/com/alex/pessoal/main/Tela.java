package com.alex.pessoal.main;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;

public class Tela extends JFrame {

    private boolean closed = false;
    private Canvas canvas;

    public Tela(String titulo, int width, int height) {
        super(titulo);
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                closed = true;
            }
            
        });

        createBufferStrategy(2);

    }

    public void render(final List<Drawable> toDraw) {
        
        Graphics g = getBufferStrategy().getDrawGraphics();

        g.drawString("str", 1000, 1000);

        if (toDraw != null) {
            for (Drawable drawable : toDraw) {
                drawable.render(g);
            }
        }

        getBufferStrategy().show();
        
    }

    public boolean getClosed() {
        return this.closed;
    }
}
