package com.ysoyso.clazz.obj.simple;

import java.util.Objects;

public class Parent {
    protected int age;
    protected String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Parent parent = (Parent) obj;
        return parent.age == this.age
                && (name == parent.name) || (null != name && name.equals(parent.name));

    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * result + this.name.hashCode();
        result += 31 * result + this.age;
        return result;
    }

    @Override
    public String toString() {
        return "name = " + name + ", age = " + age;
    }
}
