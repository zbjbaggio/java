package test.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSimple {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                atomicInteger.incrementAndGet();
            }).start();
        }
    }

}
