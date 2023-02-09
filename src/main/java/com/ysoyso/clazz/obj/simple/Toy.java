package com.ysoyso.clazz.obj.simple;

public class Toy {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Toy toy = (Toy) obj;
        return weight == toy.weight
                && (name == toy.name) || (name != null && name.equals(toy.name));
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * result + this.name.hashCode();
        result += 31 * result + this.weight;
        return result;
    }
}
