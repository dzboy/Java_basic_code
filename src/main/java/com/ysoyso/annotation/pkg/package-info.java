/**
 * <pre>
 * 提供包级别注释：
 * package-info.java是一个Java文件，可以放到任意Java源码包执行。
 * 不过里面的内容有特定的要求，其主要目的是为了提供包级别相关的操作，比如包级别的注解、注释及公共变量。
 * </pre>
 */
@AnnDemo
@Deprecated // 表示此源码包已经过时
package com.ysoyso.annotation.pkg;

/**
 * 包级别的常量
 */
class Constant {
    static final String PACKAGE_NAME = "com.ysoyso.annotation.pkg";
}

/**
 * 包类
 */
class PACKAGE_CLASS{
    public void test(){
        System.out.println("包内类");
    }
}
