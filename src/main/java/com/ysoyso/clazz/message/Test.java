package com.ysoyso.clazz.message;

public class Test {
    public static void main(String[] args) {
//        TextMessage textMessage = new TextMessage(System.currentTimeMillis());
//        textMessage.setText("hello");
//        System.out.println(textMessage.getTime() + ": " + textMessage.getText());
//
//        ImageMessage imageMessage = new ImageMessage(System.currentTimeMillis(), "/img/haha.png");
//        System.out.println(imageMessage.getTime() + ": " + imageMessage.getPath());

        VoiceMessage voiceMessage = new VoiceMessage(System.currentTimeMillis());
        voiceMessage.setVoice("哈哈");
        voiceMessage.printVoice();
    }
}
