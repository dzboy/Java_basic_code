package com.ysoyso.exception;

import java.io.IOException;

public class ResourceDemo implements AutoCloseable{
    public void test() throws IOException {
        throw new FileTooLargeException("文件太大了", 200);
    }
    @Override
    public void close() throws Exception {
        System.out.println("ResourceDemo closed");
    }
}
