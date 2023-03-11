package com.ysoyso.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleInputOutputDemo {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/simple/data.txt");
        FileUtils.makeFile(file);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("民心所向众望所归".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            byte[] bytes = fileInputStream.readAllBytes();

//            int b = 0;
//            byte[] bytes = new byte[fileInputStream.available()];
//            int index = 0;
//            while ((b = fileInputStream.read()) >= 0) {
//                bytes[index++] = (byte) b;
//            }

            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
