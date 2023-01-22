package com.guryanov;

interface Drawable {
    void drow();
}

abstract class Figure {
    String figureColor;

    abstract void getSquare();

    abstract void getPerimeter();
}



enum figureType {Square, Rectangle}




public class Main {
    public static void main(String[] args) {
        try {
            Drawable figure = new myFigure(1, 10, "PURPLE");
            figure.drow();
        } catch (ArithmeticException e) {
            System.out.println("Размер фигуры не определен");
        }
    }

}
