package com.ysoyso.clazz.wechat;

public class Friend extends BasicUserInfo {
    private String firstLetter = "--";

    public void setFirstLetter(String firstLetter) {
        if (null == firstLetter) {
            return;
        }
        this.firstLetter = firstLetter.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    @Override
    public String getNickname() {
        return super.getNickname();
    }
}
