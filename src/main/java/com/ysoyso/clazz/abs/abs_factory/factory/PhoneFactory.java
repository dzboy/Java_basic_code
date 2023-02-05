package com.ysoyso.clazz.abs.abs_factory.factory;

import com.ysoyso.clazz.abs.abs_factory.computer.Computer;
import com.ysoyso.clazz.abs.abs_factory.phone.HuaweiPhone;
import com.ysoyso.clazz.abs.abs_factory.phone.Phone;
import com.ysoyso.clazz.abs.abs_factory.phone.VivoPhone;

public class PhoneFactory extends Factory{
    @Override
    public Phone makePhone(String type) {
        if ("huawei".equals(type)) {
            return new HuaweiPhone();
        } else if ("vivo".equals(type)){
            return new VivoPhone();
        }
        return null;
    }

    @Override
    public Computer makeComputer(String type) {
        return null;
    }
}
