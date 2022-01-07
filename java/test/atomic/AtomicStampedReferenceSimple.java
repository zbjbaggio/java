package test.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceSimple {

    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 0);

        Thread main = new Thread(() -> {
           int stamp = atomicStampedReference.getStamp();// 读取当前标识
            System.out.println(Thread.currentThread().getName() + "stamp:" + stamp + ",初始值 a=" + atomicStampedReference.getReference());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isCASSuccess = atomicStampedReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "samp:" + atomicStampedReference.getStamp() + ", CAS操作结果：" + isCASSuccess);
        }, "主线程");

        Thread other = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "stamp :" + atomicStampedReference.getStamp() + "值" + atomicStampedReference.getReference());
            stamp = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(2, 1, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "stamp :" + atomicStampedReference.getStamp() + "值" + atomicStampedReference.getReference());
        }, "干扰线程");

        main.start();
        other.start();

    }

}
