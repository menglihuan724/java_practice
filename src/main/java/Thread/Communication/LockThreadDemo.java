package Thread.Communication;

import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @Description:Re
 * @Author:TERRY_MENG
 * @Date:2018-10-16
 */
public class LockThreadDemo {
    private  Lock lock = new ReentrantLock();
    private Condition conditionOne = lock.newCondition();
    private Condition conditionTwo = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        LockThreadDemo lockThreadDemo=new LockThreadDemo();
        Thread terry1 = new Thread(()->lockThreadDemo.runMethod(7, lockThreadDemo.conditionOne),"terry_1_one");
        Thread terry2 = new Thread(()->lockThreadDemo.runMethod( 24, lockThreadDemo.conditionTwo),"terry_2_two");
        Thread terry3 =new Thread(()->lockThreadDemo.wake( lockThreadDemo.conditionOne),"terry_3_one");
        terry1.start();
        terry2.start();
        terry3.start();
        Thread.sleep(5000);
        System.out.println("finish sleep 5 secs");
        Thread terry4=new Thread(()->lockThreadDemo.wake(lockThreadDemo.conditionTwo),"terry_4_two");
        terry4.start();
    }
    @NotNull
    private  void wake(Condition condition) {
        lock.lock();
        System.out.println(MessageFormat.format("{0} start wake up"
                , Thread.currentThread().getName()));
        condition.signalAll();
        lock.unlock();
    }

    @NotNull
    private  void runMethod(Integer num, Condition condition) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start wait");
            condition.await();
            for (int i = 0; i < num; i++) {
                System.out.println(MessageFormat.format("{0}:{1}", Thread.currentThread().getName(), i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
