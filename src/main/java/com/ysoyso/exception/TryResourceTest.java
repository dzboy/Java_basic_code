package com.ysoyso.exception;

public class TryResourceTest {
    public static void main(String[] args) {
        try (ResourceDemo demo = new ResourceDemo()) {
            demo.test();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResourceDemo demo = new ResourceDemo();
        try {
            demo.test();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                demo.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
