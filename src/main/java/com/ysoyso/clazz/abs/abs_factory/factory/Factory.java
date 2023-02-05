package com.ysoyso.clazz.abs.abs_factory.factory;

import com.ysoyso.clazz.abs.abs_factory.computer.Computer;
import com.ysoyso.clazz.abs.abs_factory.phone.Phone;

public abstract class Factory {
    public abstract Phone makePhone(String type);

    public abstract Computer makeComputer(String type);
}
