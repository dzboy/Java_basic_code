package com.ysoyso.io.serializable;

public class Cat extends Animal {
    public static final long serialVersionUID = 1L;

//    public Cat(String name, int age, double weight) {
//        super(name, age, weight);
//    }

    private String nickname;

    public Cat(String name, int age, double weight, String nickname) {
        super(name, age, weight);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
