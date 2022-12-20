package com.ysoyso.data;

/**
 * 字符串类型</br>
 * <table col=2>
 *     <thead>
 *         <tr><th>方法</th><th>作用</th></tr>
 *     </thead>
 *     <tbody>
 *         <tr><td>+</td><td>字符串拼接</td></tr>
 *         <tr><td>length()</td><td>获取字符串长度</td></tr>
 *         <tr><td>substring()</td><td>截取字符串</td></tr>
 *         <tr><td>indexOf()</td><td>查找字符位置</td></tr>
 *         <tr><td>contains()</td><td>判断是否包含字符串</td></tr>
 *         <tr><td>toUpperCase()</td><td>转大写</td></tr>
 *         <tr><td>toLowerCase()</td><td>转小写</td></tr>
 *         <tr><td>startsWith()</td><td>判断字符串开始</td></tr>
 *         <tr><td>startsWith()</td><td>判断字符串开始</td></tr>
 *         <tr><td>split()</td><td>分割字符串</td></tr>
 *         <tr><td>replace()</td><td>替换字符串</td></tr>
 *         <tr><td>startsWith()</td><td>判断字符串开始</td></tr>
 *         <tr><td>endsWith()</td><td>判断字符串结尾</td></tr>
 *         <tr><td>equals()</td><td>比较字符串</td></tr>
 *     </tbody>
 * </table>
 */
public class TypeString {

    public static void main(String[] args) {
        String name = "老郝不太老";
        String realName = "其实很年轻";
        System.out.println(name + realName);
        System.out.println(name.length());
    }
}
