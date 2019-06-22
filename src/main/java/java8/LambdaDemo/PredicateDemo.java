package java8.LambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        dosomething(list,n->true);
        System.out.println("-----------------------");
        dosomething(list,n->n%2==0);
        System.out.println("-----------------------");
        dosomething(list,n->n>5);
        System.out.println("-----------------------");
    }

    static void dosomething(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(var1->{
            if(predicate.test(var1)){
                System.out.println(var1);
            }
        });
    }
}