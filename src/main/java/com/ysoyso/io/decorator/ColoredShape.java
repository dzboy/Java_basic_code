package com.ysoyso.io.decorator;

public class ColoredShape implements Shape{
    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }
    @Override
    public String display() {
        return color + "的" + shape.display();
    }
}
