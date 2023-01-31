package com.ysoyso.clazz.message;

public class BaseMessage {
    protected long time;

    public BaseMessage(long time) {
        System.out.println("父类构造方法");
        this.time = time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
