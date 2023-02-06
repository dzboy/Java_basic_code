package com.ysoyso.clazz.computer;

public class Computer implements USB, HDMI{
    private USBDisk disk;
    private USBMouse mouse;

    public void insertUSBDevice(USB usb) {
        if (usb instanceof USBDisk) {
            this.disk = (USBDisk) usb;
        } else if (usb instanceof USBMouse) {
            this.mouse = (USBMouse) usb;
        }
    }

    public void clickLeft() {
        if (null != mouse) {
            mouse.clickLeft();
        } else {
            System.out.println("没有插入鼠标");
        }
    }

    public void clickRight() {
        if (null != mouse) {
            mouse.clickRight();
        } else {
            System.out.println("没有插入鼠标");
        }

    }

    public void checkMouse() {
        if (null != mouse) {
            String state = mouse.read("");
            System.out.println(state);
        } else {
            System.out.println("没有插入鼠标");
        }

    }

    @Override
    public String read(String path) {
        System.out.println("读取数据，区分USB 还是 HDMI");
        if ("USB".equals(path)) {
            return USB.super.read(path);
        } else {
            return HDMI.super.read(path);
        }
    }

    @Override
    public void write(String data) {
        if (null == disk) {
            System.out.println("没有插入U盘");
            return;
        }
        disk.write(data);
    }
}
