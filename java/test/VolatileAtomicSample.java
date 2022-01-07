package test;

public class VolatileAtomicSample {

    private static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                  //  synchronized (VolatileAtomicSample.class) {
                        count++; // 不是原子操作，使用volatile也没用
                   // }
                }
            }, "threadname:" + i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(count);
    }
}
