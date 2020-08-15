package com.steven;

public class Main {

    public static void main(String[] args) {
        Thread inicio = new GeneracionDeVida();
        inicio.start();
        new GameOfLife();
    }
}