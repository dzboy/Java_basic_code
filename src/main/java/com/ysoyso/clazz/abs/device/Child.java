package com.ysoyso.clazz.abs.device;

public class Child {
    private Device device;

    public void giveDevice(Device device) {
        this.device = device;
    }

    public void play() {
        String versionNo = device.getVersionNo();
        System.out.println("我看到软件版本是：" + versionNo);
        String serNo = device.getSerNo();
        System.out.println("我看到序列号是：" + serNo);
        device.charge();
    }
}
