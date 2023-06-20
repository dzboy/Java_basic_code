package com.ysoyso.annotation.pkg;

import java.lang.annotation.*;

/**
 * <pre>
 * 自定义注解
 * 元注解
 *    {@Documented}：描述在使用 javadoc 工具为类生成帮助文档时是否要保留其注解信息。使用了此注解的类，生成文档后，文档中会显示此注解
 *
 *    {@Target}：描述注解的使用范围
 *              public enum ElementType {
 *                   TYPE,            // 类、接口、枚举类
 *                   FIELD,           // 成员变量（包括：枚举常量）
 *                   METHOD,          // 成员方法
 *                   PARAMETER,       // 方法参数
 *                   CONSTRUCTOR,     // 构造方法
 *                   LOCAL_VARIABLE,  // 局部变量
 *                   ANNOTATION_TYPE, // 注解类
 *                   PACKAGE,         // 可用于修饰：包
 *                   TYPE_PARAMETER,  // 类型参数，JDK 1.8 新增
 *                   TYPE_USE         // 使用类型的任何地方，JDK 1.8 新增
 *               }
 *
 *    {@Retention}：注解的保留策略
 *      SOURCE
 *       注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃
 *      ClASS
 *       注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 *      RUNTIME
 *       注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 *      生命周期
 *       Java源文件(.java文件) -> .class文件 -> 内存中的字节码。
 *      选择合适的注解生命周期
 *          生命周期长度 SOURCE < CLASS < RUNTIME ，所以前者能作用的地方后者一定也能作用
 *          1. 一般如果需要在运行时去动态获取注解信息，那只能用 RUNTIME 注解，比如@Deprecated使用RUNTIME注解
 *          2. 如果要在编译时进行一些预处理操作，比如生成一些辅助代码，就用 CLASS注解；
 *          3. 如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，使用SOURCE 注解。
 *
 *    {@Inherited}：使被它修饰的注解具有继承性
 *    {@Repeatable} Java 8 新增，它允许在相同的程序元素中重复注解，在需要对同一种注解多次使用时，往往需要借助 @Repeatable 注解。
 *    Java 8 版本以前，同一个程序元素前最多只能有一个相同类型的注解，如果需要在同一个元素前使用多个相同类型的注解，则必须使用注解“容器”
 *    {@Native} 表示这个变量可以被本地代码引用，常常被代码生成工具使用。
 *  子类将自动具有父类的注解
 * </pre>
 */
@Documented
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnnDemo {
    /**
     * <pre>
     * 属性定义
     * 数据类型
     *  八种基本数据类型
     *  String
     *  枚举
     *  Class
     *  注解类型
     *  以上类型的一维数组
     *  </pre>
     */
    int intValue() default 0;
    long longValue() default 0;
    // String
    String name() default "";
    // 枚举
    CityEnum cityName() default CityEnum.BEIJING;
    // Class类型
    Class<?> clazz() default Object.class;
    // 注解类型
    Ann annotation() default @Ann;

    // 以上几种类型的数组类型
    int[] intValueArray() default {1, 2};
    String[] names() default {"hello", "world"};

    enum CityEnum {
        BEIJING, SHANGHAI, GUANGZHOU, SHENZHEN
    }

    @interface Ann {
        /**
         * <pre>
         * value属性
         *  如果注解的属性只有一个，且叫value那么使用该注解时，可以不用指定属性名因为默认就是给value赋值
         *  如果存在多个属性：
         *      1. 使用时如果需要传入多个值，所有属性必须写明对应关系
         *      2. 使用时如果只需传value，则不用写明对应关系
         * </pre>
         */
        int value() default 0;
    }
}
