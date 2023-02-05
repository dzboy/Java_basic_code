package com.ysoyso.clazz.abs.device;

public class Test {
    public static void main(String[] args) {
        // 策略设计模式
        Device computer = new Computer();
        Device phone = new Phone();

        Child child = new Child();

        child.giveDevice(computer);
        child.play();
        System.out.println("====================");
        child.giveDevice(phone);
        child.play();
    }
}
