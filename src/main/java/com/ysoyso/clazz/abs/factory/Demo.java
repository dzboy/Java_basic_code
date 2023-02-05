package com.ysoyso.clazz.abs.factory;

public class Demo {
    public static void main(String[] args) {
        // 工厂设计模式
        PhoneFactory factory = new PhoneFactory();

        Phone vivoPhone = factory.produce("vivo");
        if (null != vivoPhone) {
            vivoPhone.produce();
        }

        Phone huaweiPhone = factory.produce("huawei");
        if (null != vivoPhone) {
            huaweiPhone.produce();
        }
    }
}
