package test;

import java.util.concurrent.Exchanger;

public class ExchangerSimple {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        for (int i = 0; i < 10; i++) {
            final Integer num = i;
            new Thread(() -> {
                try {
                    Object exchangerNum = exchanger.exchange(num);
                    Thread.sleep(1000);
                    System.out.println("" + Thread.currentThread().getName() + "原来" + num + "现在" + exchangerNum );
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
