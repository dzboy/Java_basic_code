package com.ysoyso.exception;

import com.ysoyso.exception.data.Data;
import com.ysoyso.exception.data.File;

public class AssertDemo {
    public static void main(String[] args) {
//        int a = 0;
//        assert a > 0 : "输入参数不合法 ： a = " + a;


        Data data = new Data();
        data.put(1);
        File file = new File();
        file.open("D:/text.txt");
    }
}
