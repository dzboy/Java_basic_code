package com.ysoyso.clazz;

import com.ysoyso.clazz.wechat.BasicUserInfo;
import com.ysoyso.clazz.wechat.Friend;

public class Demo {
    public static void main(String[] args) {
//        User boy = new User();
//        boy.nickname = "小男孩";
//        boy.sex = User.BOY;
//        boy.age = 13;
//        boy.des = "开心的小男孩";
//
//        System.out.println(boy.nickname);
//        System.out.println(boy.sex);
//        System.out.println(boy.age);
//        System.out.println(boy.des);
//
//        System.out.println("--------------------");
//        User girl = new User(15, User.GIRL);
//        girl.nickname = "  可爱的小女孩  ";
//        girl.des = "小男孩的姐姐";
//        System.out.println(girl.nickname);
//        girl.setNickname("  可爱的小女孩  ");
//        System.out.println(girl.nickname);
//        System.out.println(girl.sex);
//        System.out.println(girl.age);
//        System.out.println(girl.des);

//        User girl = new User(15, User.GIRL);
//        girl.setNickname("  可爱的小女孩  ");
//        System.out.println(girl.getNickname());


//        BasicUserInfo girl = new BasicUserInfo(15, BasicUserInfo.GIRL);
//        System.out.println(girl.age);
//        BasicUserInfo boy = new BasicUserInfo(16, BasicUserInfo.GIRL);
//        System.out.println(boy.age);
//
//        System.out.println(new BasicUserInfo(17, BasicUserInfo.GIRL).age);

        BasicUserInfo info = new BasicUserInfo();
        info.age = 1;
        info.sex = BasicUserInfo.BOY;
        info.setNickname("昭昭");

        Friend friend = new Friend();
        friend.age = 2;
        friend.sex = BasicUserInfo.GIRL;
        friend.setFirstLetter("A");
        friend.setNickname("小芳");

        System.out.println(friend.getNickname() + " <==> " + info.getNickname());
        System.out.println(friend.getFirstLetter());

//        System.out.println(friend instanceof BasicUserInfo);

    }
}
