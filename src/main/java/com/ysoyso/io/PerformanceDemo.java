package com.ysoyso.io;

import java.io.*;

public class PerformanceDemo {
    public static void main(String[] args) {
        File file = new File("D:\\Download\\chess.mp4");
        try (FileInputStream is = new FileInputStream(file);) {

            long time = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            while (is.read(bytes) >= 0) {

            }
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is);) {

            long time = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) >= 0) {

            }
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
