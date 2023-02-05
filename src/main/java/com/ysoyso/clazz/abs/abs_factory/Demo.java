package com.ysoyso.clazz.abs.abs_factory;

import com.ysoyso.clazz.abs.abs_factory.computer.Computer;
import com.ysoyso.clazz.abs.abs_factory.factory.Factory;
import com.ysoyso.clazz.abs.abs_factory.phone.Phone;

public class Demo {
    public static void main(String[] args) {
        FactoryProducer producer = new FactoryProducer();
        Factory computerFactory = producer.getFactory("computer");
        Factory phoneFactory = producer.getFactory("phone");
        if (null != computerFactory) {
            Computer computer = computerFactory.makeComputer("dell");
            if (null != computer) {
                computer.makeComputer();
            }
        }
        if (null != phoneFactory) {
            Phone phone = phoneFactory.makePhone("vivo");
            if (null != phone) {
                phone.makePhone();
            }
        }

    }
}
