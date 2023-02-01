package com.ysoyso.clazz.message;

public class FileMessage {
    protected final Message message = new Message();

    public FileMessage() {
    }

    public static void main(String[] args) {
        final Message message;
        message = new Message();

        message.setTime(System.currentTimeMillis());
        System.out.println(message.getTime() + " " + message.hashCode());
        message.setTime(System.currentTimeMillis() + 100);
        System.out.println(message.getTime() + " " + message.hashCode());
    }


}
