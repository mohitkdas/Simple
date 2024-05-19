package multithreading;

public class SharedObject {
    public static void main(String[] args) {
        ThreadDemo th = new ThreadDemo();
        MyRunnable runnable = new MyRunnable(th);
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 =  new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
