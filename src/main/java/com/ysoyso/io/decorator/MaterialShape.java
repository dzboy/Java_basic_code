package com.ysoyso.io.decorator;

public class MaterialShape implements Shape {
    private Shape shape;
    private String material;

    public MaterialShape(Shape shape, String material) {
        this.shape = shape;
        this.material = material;
    }
    @Override
    public String display() {
        return material + "材质的" + shape.display();
    }
}
