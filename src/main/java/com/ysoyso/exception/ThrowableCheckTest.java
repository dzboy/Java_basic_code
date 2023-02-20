package com.ysoyso.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class ThrowableCheckTest {
    public void test(boolean flag) throws FileNotFoundException, FileTooLargeException{
        // 读取文件之前，获取文件地址
        // 读取文件
        // 文件是否存在
        if (!flag) {
            throw new FileNotFoundException("文件不存在");
        } else {
//            throw new FileTooLargeException("文件超过最大限制", 100);
        }
    }

    public void readFile() throws FileTooLargeException, FileNotFoundException{
        try {
            test(true);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (FileTooLargeException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        ThrowableCheckTest test = new ThrowableCheckTest();
        System.out.println("异常捕获前的逻辑");
        try {
            test.readFile();
        } catch (FileTooLargeException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行finally子句");
            // 关闭io流
        }

        System.out.println("异常捕获后的逻辑");
    }
}
