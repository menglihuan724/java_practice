package Thread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class test {
    private static final int num = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("小弟召唤完毕,go");
                callDragon();
            }
        });
        for (int i = 1; i <= num; i++) {
            int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("召集第" + index + "个小弟");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {

                    } catch (BrokenBarrierException e) {

                    }
                }
            }).start();
        }
    }

    private static void callDragon() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤肥龙！");
            }
        });

        for (int i = 1; i <= num; i++) {
            int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "珠子寻找完毕");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {

                    } catch (BrokenBarrierException e) {

                    }
                }
            }).start();
        }
    }
}