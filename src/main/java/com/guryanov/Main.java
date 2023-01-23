package com.guryanov;

import java.lang.reflect.*;
import java.lang.annotation.*;


interface Drawable {
    void drow();
}

@Retention(RetentionPolicy.RUNTIME)
@Target( ElementType.METHOD)
@interface MyAnno {
    int value();
    int a() default 777;
}

abstract class Figure {
    String figureColor;


    abstract void getSquare();

    abstract void getPerimeter();
}


enum figureType {Square, Rectangle}


public class Main {

    @MyAnno(100)
    public static void main(String[] args) {

        Main ob = new Main();
        try {
            Drawable figure = new myFigure(3, 4, "RED");
            figure.drow();
        } catch (ArithmeticException e) {
            System.out.println("Размер фигуры не определен");
        }

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("main", String[].class);
            if (m.isAnnotationPresent(MyAnno.class)) {
                System.out.println("Аннотация найдена");
                System.out.println(m.getAnnotation(MyAnno.class).a());
            } else System.out.print("Аннотация НЕ найдена");
        } catch (NoSuchMethodException exc) {
            System.out.print("Метод не найден");

        }


    }
}
