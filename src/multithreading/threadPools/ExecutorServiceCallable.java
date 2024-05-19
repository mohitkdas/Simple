package multithreading.threadPools;

import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Future future = executorService.submit(newCallable("Task 1.1"));
        Future<String> future = executorService.submit(callableLambda("Task 1.2"));

        System.out.println(future.isDone());

        try {
            String msg = (String) future.get();
            System.out.println(msg);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    public static Callable newCallable(String msg) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String completedMsg = Thread.currentThread().getName() + ": " + msg;
                return completedMsg;
            }
        };
    }

    public static Callable<String> callableLambda(String msg) {
        return () -> Thread.currentThread().getName() + ": " + msg;
    }
}
