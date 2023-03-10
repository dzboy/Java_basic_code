package com.ysoyso.introduction;

/**
 * <H1>标识符命名规则</H1>
 * Java 中标识符是为方法、变量等定义的名称。
 * 规则如下：
 * 标识符可由以下字符构成：
 *  <ul>
 *      <li>数字（0~9）和字母（A~Z 和 a~z）</li>
 *      <li>美元符号（$）</li>
 *      <li>下划线（_）</li>
 *      <li>Unicode 字符集中符号大于等于 0xC0 的所有符号：<a href="https://www.unicode.org/charts/PDF/U0080.pdf" target="_blank">U0080字符集</a></li>
 *  </ul>
 *  标识符的第一个符号必须为<B>字母、下划线和美元符号</B>其中一个
 *  后面可以是任何字母、数字、美元符号或下划线。
 *  <B>注意：</B>
 *  <ul>
 *      <li>Java 区分大小写</li>
 *      <li>不能以数字开头</li>
 *      <li>不能使用任何 Java 关键字作为标识符</li>
 *  </ul>
 *  <H1>java关键字</H1>
 *  Java 语言目前定义了 51 个关键字，这些关键字不能作为变量名、类名和方法名来使用。以下对这些关键字进行了分类。
 *  <table>
 *     <tr><th>类型</th><th>内容</th></tr>
 *     <tr>
 *         <td>数据类型</td>
 *         <td>boolean、int、long、short、byte、
 *         float、double、char、class、interface</td></tr>
 *     <tr>
 *         <td>流程控制</td>
 *         <td>if、else、do、while、for、
 *         switch、case、default、break、continue、return、
 *         try、catch、finally</td></tr>
 *     <tr>
 *         <td>修饰符</td>
 *         <td>public、protected、private、final、void、
 *         static、strict、abstract、transient、
 *         synchronized、volatile、native</td></tr>
 *     <tr>
 *         <td>动作</td>
 *         <td>package、import、throw、throws、extends、
 *         implements、this、supper、instanceof、new</td>
 *     </tr>
 *     <tr>
 *         <td>保留字</td>
 *         <td>true、false、null、goto、const</td>
 *     </tr>
 *  </table>
 */
public class VariableDemo {
    public static void main(String[] args) {
        int hello_1$À = 1;
//        int 1hello = 2;
        String A = "A";
        String a = "a";
        String _boolean = "true";
//        String ¿_ = "?";
    }

    public static void hello_1$À() {

    }

//    public static void 1hello() {
//
//    }
}
