package com.ysoyso.clazz.computer;

public interface USB {

    String DESCRIPTION = "这是一个金士顿U盘";

    default String read(String path) {
        System.out.println("USB开始读取了...");
        return "";
    }

    void write(String data);
}
