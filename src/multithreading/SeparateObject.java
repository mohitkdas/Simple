package multithreading;

public class SeparateObject {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        MyRunnable runnable1 = new MyRunnable(threadDemo);
        MyRunnable runnable2 = new MyRunnable(threadDemo);

        new Thread(runnable1, "Thread 1").start();
        new Thread(runnable2, "Thread 2").start();
    }
}
