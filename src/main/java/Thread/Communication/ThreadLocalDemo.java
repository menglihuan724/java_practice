package Thread.Communication;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:线程变量
 * @Author:TERRY_MENG
 * @Date:2018-10-16
 */
public class ThreadLocalDemo {
    public static ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();

    public  void getLocal() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(local.get());

    }

    public void setLocal(Map<String, Object> param) {
        local.set(param);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Map<String, Object> mapA = getMap("terry", 99, 28);
        Thread a = getThread(mapA,threadLocalDemo);
        Map<String,Object> mapB=getMap("zj",100,27);
        Thread b=getThread(mapB,threadLocalDemo);
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();


    }

    @NotNull
    private static Map<String, Object> getMap(String name, Integer score, Integer age) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("name", name);
        map.put("age", age);
        map.put("score", score);
        return map;
    }

    @NotNull
    private static Thread getThread( Map<String, Object> params, ThreadLocalDemo threadLocalDemo) {
        return new Thread(() -> {
           threadLocalDemo.setLocal(params);
           threadLocalDemo.getLocal();
        });
    }
}
