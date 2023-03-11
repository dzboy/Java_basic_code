package com.ysoyso.io;


import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static final String I = File.separator;
    public static final String ROOT_DIR = "D:" + I + "Workspace" + I + "teach" + I + "Java_basic_code" + I + "src" + I + "main" + I + "java" + I + "com" + I + "ysoyso" + I + "io";
    // D:\Workspace\teach\Java_basic_code\src\main\java\com\ysoyso\io
    public static void main(String[] args) {
        System.out.println(ROOT_DIR);
        File file = new File(ROOT_DIR + I + "dir"+ I + "dir"+ I + "dir"+ I + "dir");
        check(file);
        file.mkdirs();
        System.out.println("------------");
        check(file);

        File file1 = new File(ROOT_DIR + I + "dir1"+ I + "dir1"+ I + "dir1"+ I + "dir1" + I + "hello.txt");
        makeFile(file1);
//        System.out.println("------------");
//        file.delete();
//        check(file);

    }

    public static void check(File file) {
        System.out.println(file.getAbsoluteFile());
        System.out.println("is exist :" + file.exists());
        System.out.println("is file :" + file.isFile() + " | is directory :" + file.isDirectory());
        System.out.println("is absolute :" + file.isAbsolute());
        System.out.println("read :" + file.canRead() + " | write :" + file.canWrite() + " | execute :" + file.canExecute());
    }

    public static void makeFile(File file) {
        if (null == file || file.exists()) {
            return;
        }
        if (null != file.getParentFile()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
