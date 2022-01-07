package test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSimple  {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, () -> {
            System.out.println("准备完成！");
        });

        for (int i = 0; i < 10; i++) {
            final Integer index = i;
            new Thread(() -> {

                try {
                    System.out.println("index" + index + "start");
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println("index" + index + "DOING");
                    cyclicBarrier.await();
                    System.out.println("index" + index + "PAO");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cyclicBarrier.await();
    }
}
