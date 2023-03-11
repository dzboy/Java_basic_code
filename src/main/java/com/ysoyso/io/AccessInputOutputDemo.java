package com.ysoyso.io;

import java.io.*;

public class AccessInputOutputDemo {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/data/AccessData.txt");
        FileUtils.makeFile(file);
        try (RandomAccessFile af = new RandomAccessFile(file, "rw")) {
            new Animal("kitty111kitty111kitty111kitty111", 1, 12.3).save(af);
            new Animal("donald11", 100000, 14.3).save(af);
            new Animal("mickey", 300000, 16.3).save(af);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (RandomAccessFile af = new RandomAccessFile(file, "r")) {
            af.seek(Animal.SEEK_STEP);
            Animal animal = Animal.read(af);
            System.out.println(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Animal {
        static final int SEEK_STEP = 76;
        static final int NAME_SIZE = 32;
        String name; // 64
        int age; // 4
        double weight; // 8

        public Animal(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public void save(DataOutput output) throws IOException {
            for (int i = 0; i < NAME_SIZE; i++) {
                char c = 0;
                if (name.length() > i) {
                    c = name.charAt(i);
                }
                output.writeChar(c);
            }
            output.writeInt(age);
            output.writeDouble(weight);
        }

        public static Animal read(DataInput input) throws IOException {
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < NAME_SIZE; i++) {
                char c = input.readChar();
                if (c == 0) {
                    input.skipBytes((NAME_SIZE - i - 1) * 2);
                    break;
                } else {
                    name.append(c);
                }
            }
            return new Animal(name.toString(), input.readInt(), input.readDouble());
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
