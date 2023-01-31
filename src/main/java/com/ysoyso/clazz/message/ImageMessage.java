package com.ysoyso.clazz.message;

public class ImageMessage extends BaseMessage{
    private String path;

    public ImageMessage() {
        super(System.currentTimeMillis());
    }

    public ImageMessage(String path) {
        super(System.currentTimeMillis());
        this.path = path;
    }

    public ImageMessage(long time, String path) {
        super(time);
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
