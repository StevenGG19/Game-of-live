package com.steven;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class GeneracionDeVida extends Thread {
    static char[][] arreglo = new char[20][20];
    static final JLabel cantidadVivos = new JLabel();
    static final JLabel noGeneracion = new JLabel();
    static JPanel cuadricula;

    @Override
    public void run() {
        Random random = new Random();
        boolean life;
        cantidadVivos.setBounds(45, 20, 100, 20);
        noGeneracion.setBounds(82, 5, 100, 20);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                life = random.nextBoolean();
                arreglo[i][j] = life ? 'O' : 32;
            }
        }
        for (int p = 0; p < 10; p++) {
            SiguienteVida siguienteVida = new SiguienteVida(arreglo);
            arreglo = siguienteVida.siguienteGeneracion();
            noGeneracion.setText(String.valueOf(p + 1));
            cantidadVivos.setText(String.valueOf(vivos()));

            pintar();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int vivos() {
        int cont = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i][j] == 'O') {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void pintar() {
        cuadricula = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                repaint();
                for (int i = 0, y = 0; i < 20; i++, y += 15) {
                    for (int x = 0, j = 0; j < 20; j++, x += 15) {
                        if (arreglo[i][j] == 'O') {
                            g.fillRect(x, y, 15, 15);
                        }
                    }
                }
            }
        };
    }
}
