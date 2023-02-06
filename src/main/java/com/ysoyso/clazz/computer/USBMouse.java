package com.ysoyso.clazz.computer;

public class USBMouse implements Mouse, USB{
    @Override
    public void clickLeft() {
        System.out.println("鼠标左键点击");
    }

    @Override
    public void clickRight() {
        System.out.println("鼠标右键点击");
    }

    @Override
    public void write(String data) {
        System.out.println("不支持写入功能");
    }

    @Override
    public String read(String path) {
        return "一切正常";
    }

    @Override
    public void putBattery() {
        System.out.println("放入了一截5号电池");
    }
}
