package test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSimple {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long start = System.currentTimeMillis();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();

        }).start();
        countDownLatch.await();
        System.out.println("一块"+ (System.currentTimeMillis() - start));
    }

}
