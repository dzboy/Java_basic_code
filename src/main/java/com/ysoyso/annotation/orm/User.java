package com.ysoyso.annotation.orm;

import com.ysoyso.annotation.orm.runtime.Column;
import com.ysoyso.annotation.orm.runtime.Table;

@Table(name = "bz_user", description = "这是用户表")
public class User {
    @Column(identity = true, autoincrement = true)
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    private User friend;
    /**
     * 性别
     */
    @Column(index = true)
    private Byte sex;
    @Column(index = true, nullable = true)
    private Integer age;
    /**
     * 签名
     */
    @Column(nullable = true, description = "签名")
    private String signature;
    /**
     * 对象占用控件
     */
    @Column(skip = true)
    private Long memory;

    private Long createTime;
    private Long updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "\r\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friend=" + friend +
                ", sex=" + sex +
                ", age=" + age +
                ", signature='" + signature + '\'' +
                ", memory=" + memory +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
