package com.steven;

import javax.swing.*;
import java.awt.*;

class GameOfLife extends JFrame {
    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        elementos();
        setLayout(null);
        setVisible(true);
    }

    public void elementos() {
        JLabel GenerationLabel = new JLabel();
        JLabel AliveLabel = new JLabel();

        GenerationLabel.setText("Generation #");
        GenerationLabel.setBounds(10, 5, 100, 20);
        add(GenerationLabel);
        add(GeneracionDeVida.noGeneracion);
        AliveLabel.setBounds(10, 20, 100, 20);
        AliveLabel.setText("Alive: ");
        add(AliveLabel);
        add(GeneracionDeVida.cantidadVivos);

        GeneracionDeVida.cuadricula.setBackground(Color.white);
        GeneracionDeVida.cuadricula.setBounds(0,40,300,220);
        add(GeneracionDeVida.cuadricula);
    }
}
