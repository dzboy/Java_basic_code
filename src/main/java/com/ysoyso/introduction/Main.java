package com.ysoyso.introduction;

/**
 * 正式说明：
 * - 代码必须跟着写一遍
 * 正式认识第一行代码
 * 1. 类、类的组成(包、import、修饰符、类名、属性、方法)
 * 2. main 方法、main方法的作用
 * 3. 代码怎么写，写第一行代码：System.out.println("Hello World"); // 类、变量、方法的调用，分号结束
 * 4. 变量定义、类型、变量名、赋值、变量的使用、复用
 * 5. 方法定义、形式参数、实际参数、返回值
 * 6. 变量调用
 * 7. 方法调用
 * 8. 类的定义、文件名
 * 9. package和import
 *
 * @author dzboy
 * @version 1.0
 * @since 1.0
 */
import com.ysoyso.generic.Hello;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int age = 1;
        System.out.println(age);

        String name = "老好不太老";
        System.out.println(name);

        name = "老好特别好";
        System.out.println(name);

        int realAge = getAge("老好");
        System.out.println(realAge);
        realAge = getAge("小好");
        System.out.println(realAge);

        Hello.say();
    }

    /**
     *
     * @param name 形式参数
     * @return
     */
    public static int getAge(String name) {
        System.out.println(name);
        if ("老好".equals(name)) {
            return 18;
        } else {
            return 28;
        }
    }

}
