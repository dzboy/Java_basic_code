package com.ysoyso.io.decorator;

public class Demo {
    public static void main(String[] args) {
        Square square = new Square();
        Triangle triangle = new Triangle();
        System.out.println(square.display());
        System.out.println(triangle.display());

        ColoredShape shape = new ColoredShape(triangle, "红色");
        System.out.println(shape.display());

        MaterialShape materialShape = new MaterialShape(shape, "木头");
        System.out.println(materialShape.display());

        Shape s = new ColoredShape(new MaterialShape(new Square(), "铁"), "黑色");
        System.out.println(s.display());
    }
}
