package Thread.Lock;

import java.text.MessageFormat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-10-16
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo=new ReentrantReadWriteLockDemo();
        new Thread(()->reentrantReadWriteLockDemo.read(),"ReadThread").start();
        new Thread(()->reentrantReadWriteLockDemo.read(),"ReadThread2").start();
        Thread.sleep(2000);
        new Thread(()->reentrantReadWriteLockDemo.write(),"WeadThread").start();
        new Thread(()->reentrantReadWriteLockDemo.write(),"WeadThread2").start();
    }

    private void read(){
        lock.readLock().lock();
        System.out.println( MessageFormat.format("ReadLock:{0},time:{1}"
                ,Thread.currentThread().getName(),System.currentTimeMillis()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
    }
    private void write(){
        lock.writeLock().lock();
        System.out.println( MessageFormat.format("WriteLock:{0},time:{1}"
                ,Thread.currentThread().getName(),System.currentTimeMillis()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
    }
}
