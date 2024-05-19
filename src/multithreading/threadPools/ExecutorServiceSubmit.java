package multithreading.threadPools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSubmit {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(newRunnable("Task 1.1"));

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    public static Runnable newRunnable(String msg) {
        return () -> System.out.println(Thread.currentThread().getName() + ": " + msg);

    }
}
