package com.ysoyso.thread.attribute.volatiles;

/**
 * 77248100
 * 33671100
 * 28424400
 */
public class FalseSharing  implements Runnable {
    public final static int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    public final static long ITERATIONS = 1000L * 1000L;
    private final int arrayIndex;

    public FalseSharing(final int arrayIndex){
        this.arrayIndex = arrayIndex;
    }

    //用于比较访问数据的时间
    public void run(){
        long i = ITERATIONS + 1;
        while (0 != --i){
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
    }

    // long padding避免false sharing
    // 按理说jdk7以后long padding应该被优化掉了，但是从测试结果看padding仍然起作用
    public final static class VolatileLongPadding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
        public volatile long value = 0L;
        public volatile long q1, q2, q3, q4, q5, q6, q7;
    }

    //jdk8新特性，Contended注解避免false sharing
    @sun.misc.Contended
    // jdk11
//    @jdk.internal.vm.annotation.Contended
    public final static class VolatileLongAnno {
        public volatile long value = 0L;
    }

    //数组里存放的是类
//    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
//        private static VolatileLongPadding[] longs = new VolatileLongPadding[NUM_THREADS];
    private static VolatileLongAnno[] longs = new VolatileLongAnno[NUM_THREADS];
    static{
        /*将数组初始化*/
        for (int i = 0; i < longs.length; i++){
//            longs[i] = new VolatileLong();
//            longs[i] = new VolatileLongPadding();
            longs[i] = new VolatileLongAnno();
        }
    }



    public static void main(final String[] args) throws Exception{
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }

    private static void runTest() throws InterruptedException{

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread t : threads){
            t.start();
        }

        //等待所有线程执行完成,避免主线程在其它线程前结束
        for (Thread t : threads){
            t.join();
        }
    }
}
