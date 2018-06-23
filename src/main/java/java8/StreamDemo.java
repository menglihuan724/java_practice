package java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> list= random.ints(2,24).limit(10).boxed().collect(Collectors.toList());
        System.out.println("初始化数组"+list);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------");
        list.stream().distinct().map(i->i*i).sorted((x,y)->y-x).forEach(System.out::println);
        System.out.println("---------------------");
        String z=list.stream().distinct().map(i->i*i).sorted((x,y)->y-x).filter(x->x>100).map(n->n.toString()).collect(Collectors.joining(","));
        System.out.println(z);
        IntSummaryStatistics intSummaryStatistics=list.stream().distinct().map(i->i*i).sorted((x, y)->y-x).filter(x->x>100).mapToInt(x->x).summaryStatistics();
        System.out.printf("max:%s\n min:%s \n sum:%s \n",intSummaryStatistics.getMax(),intSummaryStatistics.getMin(),intSummaryStatistics.getCount());
        System.out.printf("最终数组 %s",list);

    }
}