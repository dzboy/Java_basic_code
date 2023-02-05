package com.ysoyso.clazz.abs.device;

public abstract class Device {
    protected String serNo;
    protected String versionNo;

    public abstract String getSerNo();

    public abstract String getVersionNo();

    public void charge() {
        System.out.println("请插入充电器");
    }
}
