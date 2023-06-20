package com.ysoyso.annotation.orm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = DatabaseManager.getInstance();
        boolean con = db.connect("localhost", "6606", "root", "", "test");
        System.out.println(con);
        db.createTable(User.class);

//        User user = new User();
//        user.setAge(1);
//        user.setFriend(new User());
//        user.setName("老王2");
//        user.setSex((byte) 1);
//        user.setCreateTime(System.currentTimeMillis());
//        user.setUpdateTime(System.currentTimeMillis());
//        db.insert(user);

        User user = new User();
        user.setAge(1);
        user.setFriend(new User());
        user.setName("老王100");

        User where = new User();
        where.setId(1);

        db.update(user, where);

        List<User> data = db.queryAll(new User());
        System.out.println(data);
        db.disconnect();
    }
}
