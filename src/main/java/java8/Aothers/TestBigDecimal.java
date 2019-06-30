package java8.Aothers;

import java.math.BigDecimal;

/**
 * @author:menglihuan
 * @data:2019/6/30
 * @ds:
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS=new BigDecimal(".10");
        int items = 0;
        BigDecimal funds=new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price.add(TEN_CENTS)) {
            funds=funds.subtract(TEN_CENTS);
            items++;
        }
        System.out.println(items);
        System.out.println(funds);
    }
}