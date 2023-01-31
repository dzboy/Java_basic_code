package com.ysoyso.clazz.message;

public class TextMessage extends BaseMessage {
    private String text;

    public TextMessage(long time) {
        super(time);
        System.out.println("子类构造方法");
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
