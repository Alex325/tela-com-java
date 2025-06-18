package com.alex.pessoal.main;

import java.awt.GraphicsEnvironment;

public class Jogo {
    
    private Tela tela;
    private boolean running;
    
    private long lastTime = System.nanoTime();
    private double renderTimer = 0;
    
    private final int refreshRate = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    private final double frameCheck = 1_000_000_000 / refreshRate;

    public Jogo() {
        tela = new Tela("Jogo", 1280, 720);
        running = false;
    }

    public void run() {
        while (running) {
            double dt = getDelta();
            pollInputs();
            tick(dt);
            render(dt);
            running = !tela.getClosed();
        }
    }

    private void pollInputs() {
    }

    private void tick(double dt) {
        
    }
    
    private void render(double dt) {
        renderTimer += dt;
        if (renderTimer >= frameCheck) {
            tela.render(null);
            renderTimer = 0.0;
        }
    }


    private double getDelta() {
        long now = System.nanoTime();
        long dt = now - lastTime;
        lastTime = now;
        return dt;

    }
}
