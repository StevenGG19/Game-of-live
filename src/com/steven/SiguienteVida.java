package com.steven;

class SiguienteVida {
    private char[][] arreglo;
    private int tamano;

    public SiguienteVida(char[][] matriz) {
        this.arreglo = matriz;
        this.tamano = arreglo.length;
    }

    public char[][] siguienteGeneracion() {
        int cantidad;
        char[][] nuevoArreglo = new char[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                cantidad = vidaMuerte(i, j);

                if (arreglo[i][j] == 'O') {
                    nuevoArreglo[i][j] = cantidad < 2 || cantidad > 3 ? ' ' : 'O';
                } else {
                    nuevoArreglo[i][j] = cantidad == 3 ? 'O' : ' ';
                }
            }
        }
        return nuevoArreglo;
    }

    public int vidaMuerte(int x, int y) {
        int num = 0;
        for (int i = -1; i < 2; i++) {
            if (i != 0) {
                if (arreglo[x][(y + i + tamano) % tamano] == 'O') {
                    num++;
                }
                if (arreglo[(x + i + tamano) % tamano][y] == 'O') {
                    num++;
                }
                if (arreglo[(x + i + tamano) % tamano][(y + i + tamano) % tamano] == 'O') {
                    num++;
                }
                if (arreglo[(x - i + tamano) % tamano][(y + i + tamano) % tamano] == 'O') {
                    num++;
                }
            }
        }
        return num;
    }
}
