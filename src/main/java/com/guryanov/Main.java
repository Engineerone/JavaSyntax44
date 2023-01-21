package com.guryanov;

interface Drawable {
    void drow();
}

abstract class Figure {
    String figureColor;

    abstract void getSquare();

    abstract void getPerimeter();
}

class Rectangle {
    double figureSide1;
    double figureSide2;

    Rectangle(double figureSide1, double figureSide2) {
        this.figureSide1 = figureSide1;
        this.figureSide2 = figureSide2;
    }

    figureType checkFigureType() {
        if (figureSide1 == figureSide2) return figureType.Square;
        return figureType.Rectangle;
    }
}

enum figureType {Square, Rectangle}


class myFigure extends Figure implements Drawable {

    double figureSide1;
    double figureSide2;
    figureType type;

    myFigure(double figureSide1, double figureSide2, String figureColor) throws ArithmeticException {
        if (figureSide1 == 0 | figureSide2 == 0)
            throw new ArithmeticException();
        this.figureSide1 = figureSide1;
        this.figureSide2 = figureSide2;
        this.figureColor = figureColor;
        Rectangle checkFigureType = new Rectangle(figureSide1, figureSide2);
        this.type = checkFigureType.checkFigureType();
    }

    void getSquare() {
        System.out.println("Площадь фигуры: " + figureSide1 * figureSide2);
    }

    void getPerimeter() {
        System.out.println("Периметр фигуры: " + (figureSide1 + figureSide2) * 2);
    }

    void getColor() {
        String color = "";
        if (figureColor.equals("BLACK")) {
            color = "\u001B[30m";
        } else if (figureColor.equals("RED")) {
            color = "\u001B[31m";
        } else if (figureColor.equals("GREEN")) {
            color = "\u001B[32m";
        } else if (figureColor.equals("YELLOW")) {
            color = "\u001B[33m";
        } else if (figureColor.equals("BLUE")) {
            color = "\u001B[34m";
        } else if (figureColor.equals("PURPLE")) {
            color = "\u001B[35m";
        } else if (figureColor.equals("CYAN")) {
            color = "\u001B[36m";
        } else if (figureColor.equals("WHITE")) {
            color = "\u001B[37m";
        } else {
            color = "\u001B[30m";
            System.out.println("Цвет не определен либо указан не верно. Будет использован цвет по-умолчанию.");
        }

        System.out.println("Цвет " + color + figureColor);
    }

    void drowFigure() {
        figureSide1 = figureSide1 + 2;
        String[][] figureDrowAarray = new String[(int) figureSide1][(int) figureSide2];


        for (int i = 0; i < figureSide1; i++) {
            for (int j = 0; j < figureSide2; j++)

                if (i == 0 | i == figureSide1 - 1)
                    figureDrowAarray[i][j] = "-";
                else if (j == 0 | j == figureSide2 - 1)
                    figureDrowAarray[i][j] = "|";
                else
                    figureDrowAarray[i][j] = " ";
        }

        for (int i = 0; i < figureSide1; i++) {
            for (int j = 0; j < figureSide2; j++) {
                if (i == ((int) figureSide1 / 2) & j == figureSide2 - 1)
                    System.out.print(figureDrowAarray[i][j] + "Цвет фигуры: " + figureColor + " Размер: " + (figureSide1 - 2) + " х " + figureSide2);
                else System.out.print(figureDrowAarray[i][j]);

            }
            System.out.println();
        }
    }

    public void drow() {

        System.out.println("Фигура является: " + type);
        System.out.println("Размер сторооны 1: " + figureSide1);
        System.out.println("Размер сторооны 2: " + figureSide2);
        getSquare();
        getPerimeter();
        getColor();
        drowFigure();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Drawable figure = new myFigure(1, 10, "CYAN");
            figure.drow();
        } catch (ArithmeticException e) {
            System.out.println("Размер фигуры не определен");
        }
    }

}
