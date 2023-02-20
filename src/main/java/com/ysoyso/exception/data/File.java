package com.ysoyso.exception.data;

public class File {
    /**
     * open file by path
     * @param path path is not empty
     */
    public void open(String path) {
        assert path != null && !"".equals(path) : "path = " + path;
        System.out.println(path);
    }
}
