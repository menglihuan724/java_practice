package Thread.CAS;

import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description:ABA问题
 * @Author:TERRY_MENG
 * @Date:2018-10-17
 */
public class AtomicStampedReferenceDemo {
    private static AtomicStampedReference<Integer> atomicStampedReference
            =
            new AtomicStampedReference(9, 0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int timestap = atomicStampedReference.getStamp();
            /*charger*/
            new Thread(() -> {
                while (true) {
                    int money = atomicStampedReference.getReference();
                    if (money < 20) {
                        if (atomicStampedReference.compareAndSet(
                                money, money + 20, timestap, timestap + 1)) {
                            System.out.println(MessageFormat
                                    .format("less than 20,after charage:{0}", money + 20));
                            break;
                        }
                    } else {
                        System.out.println("more than 20,no need to charage");
                        break;
                    }
                }
            },"charger:"+i).start();
        }
        new Thread(() -> {
            //模拟多次消费
            for (int i = 0; i < 10; i++) {
                while (true) {
                    Integer m = atomicStampedReference.getReference();
                    int timeStamp = atomicStampedReference.getStamp();
                    if (m > 10) {
                        System.out.println("大于10元，可以进行消费！");
                        if (atomicStampedReference.compareAndSet(m, m - 10, timeStamp, timeStamp + 1)) {
                            System.out.println("消费成功，余额为：" + atomicStampedReference.getReference());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }, "userConsumeThread").start();
    }
}
