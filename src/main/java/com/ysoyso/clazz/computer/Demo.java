package com.ysoyso.clazz.computer;

public class Demo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        USB usbDisk = new USBDisk();
        USB mouse = new USBMouse();

        computer.insertUSBDevice(usbDisk);
        computer.insertUSBDevice(mouse);


        String data = computer.read("HDMI");
        System.out.println("读取了data " + data);

        computer.write("hello");

        data = computer.read("USB");
        System.out.println("读取了data " + data);

        System.out.println(USB.DESCRIPTION);

        computer.clickLeft();
        computer.checkMouse();
    }
}
