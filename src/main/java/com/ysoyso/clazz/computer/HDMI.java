package com.ysoyso.clazz.computer;

public interface HDMI {
    default String read(String display) {
        System.out.println("开始读取HDMI数据");
        return "";
    }
}
