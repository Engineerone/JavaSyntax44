package com.guryanov;

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