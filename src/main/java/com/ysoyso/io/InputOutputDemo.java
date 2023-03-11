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
//            int length = 0;
//            while ((length = bis.read(bytes)) >= 0) {
//                builder.append(new String(bytes, 0, length));
//            }
            char[] chars = new char[1024];
//            int length = 0;
//            while ((length = isr.read(chars)) >= 0) {
//                builder.append(new String(chars, 0, length));
//            }
//            System.out.println(builder);

//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             FileWriter fw = new FileWriter(file);

             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {

//            bos.write("\r\nBufferedOutputStream".getBytes());
//            bos.write("\r\nBufferedOutputStream1".getBytes());
//            bos.flush();

//            fw.append("\r\nBufferedOutputStream2");
//            fw.append("\r\nBufferedOutputStream3");
//            fw.write("\r\nHello");

//            osw.write("\r\nBufferedOutputStream4");
//            osw.write("\r\nBufferedOutputStream5");

//            bw.write("BufferedOutputStream6");
//            bw.newLine();
//            bw.write("BufferedOutputStream7");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
