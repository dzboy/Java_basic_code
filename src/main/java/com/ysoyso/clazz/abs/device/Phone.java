package com.ysoyso.clazz.abs.device;

public class Phone extends Device {
    @Override
    public String getSerNo() {
        System.out.println("手机开始获取序列号...");
        System.out.println("获取中...");
        return "5678324";
    }

    @Override
    public String getVersionNo() {
        System.out.println("手机开始获取系统版本...");
        System.out.println("获取中...");
        return "8.0";
    }

    @Override
    public void charge() {
        super.charge();
        System.out.println("放在无线充电座上");
    }
}
