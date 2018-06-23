package java8;

public class LamdaDemo {

    public static void main(String[] args) {
        MathOpeartion add=(a,b)->a+b;
        MathOpeartion sub=(a,b)->a-b;
        MathOpeartion muti=(int a,int b)->{return a*b;};

        LamdaDemo test=new LamdaDemo();
        System.out.println(test.doOperation(5,6,add));

        System.out.println(test.doOperation(5,6,sub));

        System.out.println(test.doOperation(5,6,muti));
    }

    private int doOperation(int a,int b,MathOpeartion fun){
            return fun.operation(a,b);
    }

    interface MathOpeartion{
        int operation(int a,int b);
    }
}


