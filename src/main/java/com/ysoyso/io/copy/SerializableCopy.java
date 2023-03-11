package com.ysoyso.io.copy;

import java.io.*;

public class SerializableCopy {
    public static void main(String[] args) {

        Animal animal = new Animal("小猫", 1, 5.5);
        Animal animal2 = new Animal("小猫2", 1, 5.5);
        Dog dog = new Dog("小狗D", 1, 23.2, animal);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(dog);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bais)) {
                Dog dog1 = (Dog) ois.readObject();
//                dog1.age = 100;
//                dog1.name = "小狗E";
//                dog1.friend.age = 50;
//                dog1.friend.name = "小猫1";
                System.out.println(dog);
                System.out.println(dog1);
                System.out.println(dog == dog1);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
