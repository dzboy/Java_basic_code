package com.ysoyso.clazz.obj.simple;

public class Child extends Parent{
    private Toy toy;

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Child child = (Child) obj;
        return (child.toy == this.toy) || (toy != null && toy.equals(child.toy))
                && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * result + toy.hashCode();
        result += super.hashCode();
        return result;
    }
}