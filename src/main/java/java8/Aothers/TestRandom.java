package java8.Aothers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author:menglihuan
 * @data:2019/6/30
 * @ds:
 */
public class TestRandom {
    public static void main(String[] args) {
        int n=2 * (Integer.MAX_VALUE/3);
        int low = 0;
        for (int i = 0; i <1000000 ; i++) {
            if(random(n)<n/2)
                low++;
        }
        System.out.println(low);
    }
    static  ThreadLocalRandom rand=ThreadLocalRandom.current();

    static int random(int n) {
        return Math.abs(rand.nextInt())%n;
    }
}