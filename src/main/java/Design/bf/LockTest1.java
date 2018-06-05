package Design.bf;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 extends FLockTest1 implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    public synchronized void methodA(){
        System.out.println(Thread.currentThread().getName()+"this is Method A start" );
        //此时访问
        methodB();
        System.out.println(Thread.currentThread().getName()+"this is Method A end");
    }
    public synchronized void methodB(){
        System.out.println(Thread.currentThread().getName()+"this is Method B start");
        System.out.println(Thread.currentThread().getName()+"this is Method B end");
    }
    public synchronized void test(){
        System.out.println("this is childrenTest started");
        super.test();
        System.out.println("this is childrenTest end");
    }
    public void run() {
        //测试本类中的同步方法
        methodA();
        //测试父类和子类的重入
        test();
        //测试ReentrantLock
        reentrantLockTest1();

    }
    public static void main(String[] args) {
        LockTest1 t1 = new LockTest1();
        Thread t = new Thread(t1);
        t.start();
        t1.methodB();
    }

    public void reentrantLockTest1(){
        lock.lock();
        System.out.println("this is reentrantLockTest1");
        reentrantLockTest2();
        lock.unlock();
    }
    public void reentrantLockTest2(){
        lock.lock();
        System.out.println("this is reentrantLockTest2");
        lock.unlock();
    }

}
class FLockTest1 {
    public synchronized void test(){
        System.out.println("this is Father Class test started");
        System.out.println("this is Father Class test end");
    }
}