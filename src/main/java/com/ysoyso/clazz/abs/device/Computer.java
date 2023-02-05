package com.ysoyso.clazz.abs.device;

public class Computer extends Device{
    @Override
    public String getSerNo() {
        System.out.println("电脑正在获取序列号...");
        return "987239847";
    }

    @Override
    public String getVersionNo() {
        System.out.println("电脑正在读取系统版本");
        return "7.12.45";
    }

    @Override
    public void charge() {
        super.charge();
        System.out.println("插入充电器");
    }
}
