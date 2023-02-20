package com.ysoyso.exception;

import java.io.IOException;

public class FileTooLargeException extends IOException {
    public FileTooLargeException(String message, int maxSize) {
        super(message + "最大文件 " + maxSize);
    }
}
