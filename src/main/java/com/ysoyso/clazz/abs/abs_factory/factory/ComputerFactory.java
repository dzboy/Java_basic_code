package com.ysoyso.clazz.abs.abs_factory.factory;

import com.ysoyso.clazz.abs.abs_factory.computer.AcerComputer;
import com.ysoyso.clazz.abs.abs_factory.computer.Computer;
import com.ysoyso.clazz.abs.abs_factory.computer.DellComputer;
import com.ysoyso.clazz.abs.abs_factory.phone.Phone;

public class ComputerFactory extends Factory{
    @Override
    public Phone makePhone(String type) {
        return null;
    }

    @Override
    public Computer makeComputer(String type) {
        if ("dell".equals(type)) {
            return new DellComputer();
        } else if ("acer".equals(type)) {
            return new AcerComputer();
        }
        return null;
    }
}
