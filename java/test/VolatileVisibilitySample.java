package test;

public class VolatileVisibilitySample {

    // private volatile boolean aa = true;
    // 多线程之间公用变量是不可见的
    private boolean aa = true;

    static Object object = new Object();

    public void fresh() {
        aa = false;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程：" + threadName + "修改了共享变量aa");
    }

    public void load() {
        while (aa) {
            // 同步锁，上下文切换同步主内存数据，也会停下来
//            synchronized (object) {
//
//            }
        }
        String threadName = Thread.currentThread().getName();
        System.out.println("线程：" + threadName + "状态改变了");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileVisibilitySample volatileVisibilitySample =  new VolatileVisibilitySample();
        Thread a = new Thread(() -> {
            volatileVisibilitySample.fresh();
        }, "threadA");

        Thread b = new Thread(() -> {
            volatileVisibilitySample.load();
        }, "threadB");

        b.start();

        Thread.sleep(1000);

        a.start();
        // 直接改变主内存中变量也是一样的
        // volatileVisibilitySample.aa = false;


//        int i = 1;
//        while (volatileVisibilitySample.aa) {
//            System.out.println(i++);
//        }
//        System.out.println("end" + volatileVisibilitySample.aa);

    }

}
