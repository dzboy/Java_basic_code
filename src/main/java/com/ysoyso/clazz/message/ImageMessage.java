package com.ysoyso.clazz.message;

public class ImageMessage extends Message {
    private String path;

    @Override
    public void setTime(long time) {
        System.out.println("传入了long类型时间");
        setTime(time, "no body");
    }

    public void setTime(String time) {
        System.out.println("传入了String类型时间，转换成long类型");
        setTime(Long.parseLong(time));
    }

    public void setTime(long time, String sendBy) {
        System.out.println("通用逻辑处理");
        super.setTime(time);
        System.out.println("SendBy : " + sendBy);
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
