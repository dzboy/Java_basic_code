package com.ysoyso.clazz.abs.abs_factory;

import com.ysoyso.clazz.abs.abs_factory.factory.ComputerFactory;
import com.ysoyso.clazz.abs.abs_factory.factory.Factory;
import com.ysoyso.clazz.abs.abs_factory.factory.PhoneFactory;

public class FactoryProducer {
    public Factory getFactory(String type) {
        if ("phone".equals(type)) {
            return new PhoneFactory();
        } else if ("computer".equals(type)) {
            return new ComputerFactory();
        } else {
            return null;
        }
    }
}
