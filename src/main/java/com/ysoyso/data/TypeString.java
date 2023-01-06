package com.ysoyso.data;

import java.util.Arrays;
import java.util.Locale;

/**
 * 字符串类型</br>
 * <table col=2>
 *     <thead>
 *         <tr><th>方法</th><th>作用</th></tr>
 *     </thead>
 *     <tbody>
 *         <tr><td>+</td><td>字符串拼接</td></tr>
 *         <tr><td>length()</td><td>获取字符串长度</td></tr>
 *         <tr><td>indexOf()</td><td>查找字符位置</td></tr>
 *         <tr><td>substring()</td><td>截取字符串</td></tr>
 *         <tr><td>contains()</td><td>判断是否包含字符串</td></tr>
 *         <tr><td>toUpperCase()</td><td>转大写</td></tr>
 *         <tr><td>toLowerCase()</td><td>转小写</td></tr>
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
        String str = "!@#,0123456789,abCDefg";
        System.out.println(str);
        String a = "$%^&";
        System.out.println(str + a);
        System.out.println(str.length());
        System.out.println(str.indexOf("!"));
        System.out.println(str.indexOf("g"));
        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 21));
        System.out.println(str.substring(2, 22));
        System.out.println(str.contains(")"));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        String[] split = str.split(",");
        System.out.println(Arrays.asList(split));
        for (String res : split) {
            System.out.println(res);
        }
        System.out.println(str.replace('!', '%'));
        System.out.println(str.replace("012", "()"));
        System.out.println(str.replaceAll(",.*,", "+-"));
        System.out.println(str.startsWith("@", 1));
        System.out.println(str.equals("123"));
        System.out.println(str.equals("!@#,0123456789,abCDefg"));

    }
}
