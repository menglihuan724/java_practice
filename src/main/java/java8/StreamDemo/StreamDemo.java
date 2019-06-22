package java8.StreamDemo;

import java.math.BigInteger;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class StreamDemo {
    public static void main(String[] args) {
        final long start=System.currentTimeMillis();
        testMersenne();
        final long end=System.currentTimeMillis();
        System.out.println((end-start)/1000);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
    }

    static void testMersenne() {
        primes().map(p -> BigInteger.valueOf(2).pow(p.intValueExact()).subtract(ONE)).filter(m -> m.isProbablePrime(50)).limit(20).forEach(System.out::println);
    }

    static void testBasicStream() {
        Random random = new Random();
        List<Integer> list = random.ints(2, 24).limit(10).boxed().collect(Collectors.toList());
        System.out.println("初始化数组" + list);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------");
        list.stream().distinct().map(i -> i * i).sorted((x, y) -> y - x).forEach(System.out::println);
        System.out.println("---------------------");
        String z = list.stream().distinct().map(i -> i * i).sorted((x, y) -> y - x).filter(x -> x > 100).map(n -> n.toString()).collect(Collectors.joining(","));
        System.out.println(z);
        IntSummaryStatistics intSummaryStatistics = list.stream().distinct().map(i -> i * i).sorted((x, y) -> y - x).filter(x -> x > 100).mapToInt(x -> x).summaryStatistics();
        System.out.printf("max:%s\n min:%s \n sum:%s \n", intSummaryStatistics.getMax(), intSummaryStatistics.getMin(), intSummaryStatistics.getCount());
        System.out.printf("最终数组 %s", list);
    }
}