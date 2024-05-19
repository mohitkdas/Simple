package multithreading;

public class EvenOdd7 implements Runnable {

    private static int count = 1;

    final Object object;

    public EvenOdd7(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count <= 100) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + ", value: " + count);
                    count++;
                    object.notify();
                }
            }

            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + ", value: " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new EvenOdd7(lock);
        Runnable r2 = new EvenOdd7(lock);
        new Thread(r1, "even").start();
        new Thread(r2, "odd").start();
    }

}
