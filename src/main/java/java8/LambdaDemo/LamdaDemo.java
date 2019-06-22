package java8.LambdaDemo;

import org.apache.storm.shade.com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaDemo {

    public static void main(String[] args) {
        MathOpeartion add = (a, b) -> a + b;
        MathOpeartion sub = (a, b) -> a - b;
        MathOpeartion muti = (int a, int b) -> {
            return a * b;
        };

        LamdaDemo lamdaDemo = new LamdaDemo();
        System.out.println(lamdaDemo .doOperation(5, 6, add));

        System.out.println(lamdaDemo .doOperation(5, 6, sub));

        System.out.println(lamdaDemo .doOperation(5, 6, muti));

        lamdaDemo .test();
    }

    public void test() {
        List<String> list = Lists.newArrayList();
        list.add("terry");
        list.add("meng");
        Collections.sort(list,Comparator.comparingInt(String::length) );
        list.add("xiao");
        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list);
    }

    private int doOperation(int a, int b, MathOpeartion fun) {
        return fun.operation(a, b);
    }

    interface MathOpeartion {
        int operation(int a, int b);
    }
}


