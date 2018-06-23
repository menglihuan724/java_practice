package java8;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
       //final
       People people=People.create(People::new);
        System.out.println(people);
        List<People> list= Arrays.asList(people);
        list.forEach(People::doEat);
        list.forEach(People::doDrink);
        list.forEach(people::doEat);
        list.forEach(System.out::print);

    }
}
class People{
    public static People create(final Supplier<People> supplier) {
        return supplier.get();
    }

    public void doEat(){
        System.out.println("eat");
    }
    static void doDrink(People people){
        System.out.println(people.toString()+"drink");
    }


    public void doEat(People people) {
        System.out.println(people.toString()+"eat");
    }
}
@FunctionalInterface
 interface Supplier<T> {
    T get();
}