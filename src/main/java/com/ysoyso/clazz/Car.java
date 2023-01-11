package com.ysoyso.clazz;

/**
 * 类：分类、归类
 * 对象
 */
public class Car {

    public static boolean hasWheel;

    public String color;

    public static void openInstallWheel() {
        hasWheel = true;
    }

    public static void closeInstallWheel() {
        hasWheel = false;
    }

    public void run(String owner) {
        System.out.println(owner + " " + color + "汽车开动了 是否有轮子：" + hasWheel);
    }

    public static void main(String[] args) {
        Car.closeInstallWheel();

        Car car1 = new Car();
        car1.color = "红色";
        car1.run("小明的：");

        Car car2 = new Car();
        car2.color = "白色";
        car2.run("小栏的：");


    }
}
