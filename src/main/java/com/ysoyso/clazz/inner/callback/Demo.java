package com.ysoyso.clazz.inner.callback;

public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        String data = "金额19999";

        PrintListenerImpl printListener = new PrintListenerImpl();
        printListener.setData(data);
        demo.print(printListener);

        demo.print(new PrintListener() {
            @Override
            public String onPrint(String state) {
                System.out.println(state);
                return data;
            }
        });
    }

    static class PrintListenerImpl implements PrintListener {
        private String data;

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String onPrint(String state) {
            System.out.println(state);
            return data;
        }
    }
    public void print(PrintListener listener) {
        System.out.println("打印任务开始");
        String data = listener.onPrint("打印数据获取中");
        System.out.println("打印数据 " + data);
        System.out.println("打印任务结束");
    }

    interface PrintListener {
        String onPrint(String state);
    }
}
