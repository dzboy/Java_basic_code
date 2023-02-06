package com.ysoyso.clazz.computer;

public class USBDisk implements USB {
    private String data;
    @Override
    public String read(String path) {
        USB.super.read(path);
        if ("/".equals(path)) {
            return data;
        } else if ("/img".equals(path)) {
            System.out.println("读取了/img的内容");
        } else if ("/video".equals(path)) {
            System.out.println("读取了视频的内容");
        }
        return "没有读取任何内容";
    }

    @Override
    public void write(String data) {
        this.data = data;
    }
}
