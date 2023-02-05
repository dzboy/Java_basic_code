package com.ysoyso.clazz.abs.factory;

public class PhoneFactory {

    public Phone produce(String phoneType) {
        if (null != phoneType && phoneType.equals("huawei")) {
            System.out.println("huawei");
        }
        if ("huawei".equals(phoneType)) {
            return new HuaweiPhone();
        } else if ("vivo".equals(phoneType)) {
            return new VivoPhone();
        } else {
            return null;
        }
    }
}
