package com.ysoyso.collection.enumdemo;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumDemo {
    public static void main(String[] args) {
        Color red = Color.RED;
        System.out.println(red);
        System.out.println(red.hex);
        System.out.println(red.name());
        System.out.println(red.ordinal());
        System.out.println(red.toString());
        System.out.println(Arrays.toString(Color.values()));

        System.out.println("------------");
        EnumSet<Color> setNone = EnumSet.noneOf(Color.class);
        System.out.println(setNone);
        EnumSet<Color> setAll = EnumSet.allOf(Color.class);
        System.out.println(setAll);
        EnumSet<Color> set = EnumSet.of(Color.RED, Color.BLUE);
        System.out.println(set);

        EnumMap<Color, String> map = new EnumMap<>(Color.class);
        map.put(Color.RED, "red");
        map.put(Color.GREEN, "green");
        System.out.println(map);

        Iterator<Color> iterator = setAll.iterator();
        iterator.next();
        Color color = iterator.next();
        System.out.println(color.ordinal());
        System.out.println(color.name());
        color = iterator.next();
        System.out.println(color.ordinal());
        System.out.println(color.name());

        Color color1 = Color.BLACK;
        if (color1 == Color.BLACK) {
            System.out.println("true");
        }
        switch (color1) {
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case WHITE:
                System.out.println("white");
                break;
            default:
                System.out.println("default");
        }

    }

    enum Color {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        WHITE,
        BLACK;

        private int hex;

        Color() {

        }
        Color(int hex) {
            this.hex = hex;
        }

        @Override
        public String toString() {
            return hex + "";
        }

    }

}
