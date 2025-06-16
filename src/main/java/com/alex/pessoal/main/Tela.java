package com.alex.pessoal.main;

import javax.swing.JFrame;

public class Tela extends JFrame {

    public Tela(String titulo, int width, int height) {
        super(titulo);
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
