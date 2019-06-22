package java8.LambdaDemo;

import java.util.function.DoubleBinaryOperator;

/**
 * @author:menglihuan
 * @data:2019/6/22
 * @ds:
 */
public class LambdaEnum {
    public static void main(String[] args) {
        double apply = Operation.PLUS.apply(2, 3);
        System.out.println(apply);
    }
    enum Operation{
        PLUS ("+",(x,y)->x+y),
        MINUS ("-",(x,y)->x-y);
        private final String symbol;
        private final DoubleBinaryOperator op;

        Operation(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public double apply(double x,double y){
            return op.applyAsDouble(x,y);
        }
    }



}