package com.ysoyso.clazz;

import com.ysoyso.clazz.message.ImageMessage;
import com.ysoyso.clazz.message.Message;
import com.ysoyso.clazz.message.VoiceMessage;

public class Chat {

    public void sendMessage(ImageMessage message) {
        System.out.println("发送图片消息");
    }

    public void sendMessage(VoiceMessage message) {
        System.out.println("发送语音消息");
    }

    public void sendMessage(Message message) {
        System.out.println("发送消息message");
    }

    public static void main(String[] args) {
        // 向上转型
        Message imageMessage = new ImageMessage();
        Message voiceMessage = new VoiceMessage();


        imageMessage.setTime(System.currentTimeMillis());
        voiceMessage.setTime(System.currentTimeMillis());

        // 向下转型
        ImageMessage im = (ImageMessage) imageMessage;
        im.setPath("/d/h.png");

        VoiceMessage vm = (VoiceMessage) voiceMessage;
        vm.setVoice("hello");

        // 向下转型失败
        if (voiceMessage instanceof VoiceMessage) {
            VoiceMessage voiceMess = (VoiceMessage) voiceMessage;
            voiceMess.setVoice("haha");
            System.out.println("imageMessage 是 VoiceMessage 类型");
        } else {
            System.out.println("imageMessage 不是 VoiceMessage 类型");
        }
    }
}
