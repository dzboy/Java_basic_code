package com.ysoyso.clazz.message;

public class VoiceMessage extends BaseMessage {

    private String voice;
    private long time;

    public VoiceMessage(long time) {
        super(time);
        this.time = time + 10;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    @Override
    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getTime() {
        return time;
    }

    public void printVoice() {
        System.out.println(voice);
        System.out.println("发送时间" + this.getTime());
        System.out.println("发送时间" + super.getTime());
    }
}
