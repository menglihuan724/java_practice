package Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class test {
    private static final int num=30;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(num);
    private  static Semaphore semaphore=new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i <num ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {

                    }
                    System.out.println("save data");
                    semaphore.release();
                }
            });
        }
        threadPool.shutdown();
    }
}