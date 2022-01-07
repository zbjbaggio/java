package test;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            // new Thread(new Task(semaphore, "1111"), "threadname" + i).start();
            new Task(semaphore, "name" + i).start();

        }

    }

    static class Task extends Thread {

        private Semaphore semaphore;

        public Task(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.setName(name);
        }

        public void run() {
            try {
                semaphore.acquire();//获取公共资源
                System.out.println(Thread.currentThread().getName() + ": acquire time:" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": release time:" + System.currentTimeMillis());
                semaphore.release();//释放公共资源
            } catch (Exception e) {

            }
        }

    }
}
