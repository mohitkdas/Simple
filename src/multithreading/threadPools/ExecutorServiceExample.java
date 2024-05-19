package multithreading.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ": " + "Task 3"));

        executorService.shutdown();
    }

    public static Runnable newRunnable(String msg) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + msg);
            }
        };
    }
}
