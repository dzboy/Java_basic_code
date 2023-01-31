package com.ysoyso.clazz.wechat;

public class BasicUserInfo {
    public static final int BOY = -1;
    public static final int GIRL = 1;
    protected String nickname;
    public int age;
    public int sex;
    public String des;

    public BasicUserInfo() {
        System.out.println("无参构造函数被执行");
    }

    public BasicUserInfo(int age, int sex) {
        System.out.println("有参构造函数被执行");
        this.age = age;
        this.sex = sex;
    }

    public void setNickname(String nickname1) {
        nickname = nickname1.trim();
    }

    public String getNickname() {
        return nickname;
    }

}
