package com.ysoyso.io;

import java.io.*;

public class InputOutputDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File file = new File("src/main/java/com/ysoyso/io/Executor.txt");
        try (FileInputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is);
             InputStreamReader isr = new InputStreamReader(is);
             FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(isr)) {

            StringBuilder builder = new StringBuilder();

            byte[] bytes = new byte[1024];
//            while (bis.read(bytes) >= 0) {
//                builder.append(new String(bytes));
//            }
            char[] chars = new char[1024];
//            while (isr.read(chars) >= 0) {
//                builder.append(new String(chars));
//            }
//            System.out.println(builder);

//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
