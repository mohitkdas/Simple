package multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread Running");
    }
}

public class ThreadDemo implements Runnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread Running");
            }
        };
        thread.start();
        Thread threadDemo = new Thread(new ThreadDemo());
        threadDemo.start();
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyRunnable running...");
            }
        };
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.start();
        Runnable runnable = () -> System.out.println("Runnable Running...");
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        for (int i = 1; i <= 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }

    @Override
    public void run() {
        System.out.println("ThreadDemo Runnable Running..");
    }
}
