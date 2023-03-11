package com.ysoyso.io;

import java.io.*;

public class DataInputOutputDemo {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/data/Data.txt");
        FileUtils.makeFile(file);
        try (FileOutputStream os = new FileOutputStream(file);
             DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeByte(127);
            dos.writeChar('c');
            dos.writeBoolean(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream is = new FileInputStream(file);
             DataInputStream dis = new DataInputStream(is)) {
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readBoolean());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
