package com.ysoyso.lambda;

import java.util.function.*;

public class Demo {

    public static void main(String[] args) {
        run(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        });
        run(() -> System.out.println("running"));
        System.out.println("---------语法：两个参数-------");
        sum(1, 2, (a, b) -> Integer.sum(a, b));
        sum(1, 2, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Integer.sum(integer, integer2);
            }
        });
        System.out.println("-------语法：一个参数--------");
        print(10, a -> "数值是：" + a);
        print(10, new IntFunction<String>() {
            @Override
            public String apply(int value) {
                return "数值是：" + value;
            }
        });
        System.out.println("------语法：多行逻辑-------");
        print(20, value -> {
            System.out.println("准备构造字符串");
            System.out.println("字符串构造完成");
            return "数值是：" + value;
        });
        print(20, new IntFunction<String>() {
            @Override
            public String apply(int value) {
                System.out.println("准备构造字符串");
                System.out.println("字符串构造完成");
                return "数值是：" + value;
            }
        });
        System.out.println("--------方法引用--------");
        sum(10, 20, Integer::sum);
        printInt(100, System.out::println);
        System.out.println("-------构造方法引用-----------");
//        createArray(10, a -> new String[a]);
        createArray(10, String[]::new);
        createPerson(22, Person::new);
        System.out.println("---------柯里化--------");
        int result = sum().apply(100).apply(200);
        System.out.println(result);
        System.out.println("---------柯里化2--------");
        int result2 = sum(x -> y -> x - y).apply(100).apply(200);
        System.out.println(result2);

        int result3 = sum(new IntFunction<IntFunction<Integer>>() {
            @Override
            public IntFunction<Integer> apply(int x) {
                return new IntFunction<Integer>() {
                    @Override
                    public Integer apply(int y) {
                        return x - y;
                    }
                };
            }
        }).apply(200).apply(100);
        System.out.println(result3);
    }

    public static IntFunction<IntFunction<Integer>> sum(IntFunction<IntFunction<Integer>> func) {
        return func;
    }
    public static IntFunction<IntFunction<Integer>> sum() {
//        return new IntFunction<IntFunction<Integer>>() {
//            @Override
//            public IntFunction<Integer> apply(int a) {
//                return new IntFunction<Integer>() {
//                    @Override
//                    public Integer apply(int b) {
//                        return a + b;
//                    }
//                };
//            }
//        };
//        return a -> b -> a + b;
//        return new IntFunction<IntFunction<Integer>>() {
//            @Override
//            public IntFunction<Integer> apply(int a) {
//                return b -> a + b;
//            }
//        };
        return a -> b -> a + b;
    }

    static class Person {
        int age;
        public Person(int age) {
            this.age = age;
        }
    }

    public static void run(Runnable runnable) {
        System.out.println("start run");
        runnable.run();
        System.out.println("end run");
    }

    public static void sum(int a, int b, BiFunction<Integer, Integer, Integer> func) {
        int result = func.apply(a, b);
        System.out.println(result);
    }

    public static void print(int a, IntFunction<String> func) {
        String s = func.apply(a);
        System.out.println(s);
    }

    public static void printInt(int a, IntConsumer func) {
        func.accept(a);
    }

    public static void createArray(int size, Function<Integer, String[]> func) {
        String[] str = func.apply(size);
        System.out.println(str.length);
    }

    public static void createPerson(int age, IntFunction<Person> func) {
        Person person = func.apply(age);
        System.out.println(person.age);
    }

    int x;
    public IntSupplier compute(int x, int y) {
//        return new IntSupplier() {
//            @Override
//            public int getAsInt() {
//                return this.x + y;
//            }
//        };
        return () -> this.x + y;
    }

}
