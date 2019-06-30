package java8.Aothers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * @author:menglihuan
 * @data:2019/6/30
 * @ds:
 */
public class TestRflection {
    private String name;

    public TestRflection(String name) {
        this.name=name;
    }

    public static void main(String[] args) {
        Class<? extends Set<String>> c1=null;
        try {
            c1 = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor< ?extends  Set<String>> cons=null;
        try {
            cons=c1.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Set<String> s = null;
        try {
            s=cons.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        s.addAll(Arrays.asList(args).subList(1,args.length));
        System.out.println(s);
    }
}