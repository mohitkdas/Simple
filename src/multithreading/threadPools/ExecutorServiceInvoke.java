package multithreading.threadPools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceInvoke {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(() -> Thread.currentThread().getName() + ": " + "Task 1.3");

        try {
//            String result = executorService.invokeAny(callables);
//            System.out.println(result);

            List<Future<String>> results = executorService.invokeAll(callables);
            for (Future<String> future : results) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    public static Callable<String> newCallable(String msg) {
        return () -> Thread.currentThread().getName() + ": " + msg;
    }
}
