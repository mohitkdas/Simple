package multithreading;

import java.io.IOException;

public class MyRunnable implements Runnable {
    private int count = 0;
    ThreadDemo threadDemo = null;

    public MyRunnable() {
    }

    public MyRunnable(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        System.out.println(threadDemo);
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + this.count);
    }
}
