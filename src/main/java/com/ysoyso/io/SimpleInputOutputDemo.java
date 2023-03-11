package com.ysoyso.io;

import java.io.*;

public class SimpleInputOutputDemo {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/simple/data.txt");
        FileUtils.makeFile(file);

//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            byte[] bytes = "FileInputStream fileInputStream = new FileInputStream(file)".getBytes();
////            fileOutputStream.write();
//            fileOutputStream.write(bytes, 10, bytes.length - 10);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != fileOutputStream) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            byte[] bytes = fileInputStream.readAllBytes();
//            System.out.println(new String(bytes));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != fileInputStream) {
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("FileInputStream fileInputStream = new FileInputStream(file)".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)){
//            byte[] bytes = fileInputStream.readAllBytes();

            int b = 0;
            byte[] bytes = new byte[fileInputStream.available()];
            int index = 0;
            while ((b = fileInputStream.read()) >= 0) {
                bytes[index++] = (byte) b;
            }

            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
