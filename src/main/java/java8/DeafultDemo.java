package java8;

public class DeafultDemo {
    public static void main(String[] args) {
        Football football=new Football();
        football.printSelf();
    }
}

class Football implements Sphere,Ball{


    @Override
    public void printSelf() {
        Sphere.super.printSelf();
        Ball.super.printSelf();
        System.out.println("football");
    }
}

interface Sphere{
    default  void printSelf(){
        System.out.println("sphere");
    }
}
interface Ball{
    default void printSelf(){
        System.out.println("ball");
    }
}