package Collections;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:menglihuan
 * @data:2018/10/13
 * @ds:
 */
public class SetDemo {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add("zende");
        set.add(2);
        System.out.printf(set.toString());
    }
}