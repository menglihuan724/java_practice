package LeetCode;

/**
 * Created by menglihuan on 2017/4/3.
 */
public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(dosomething("mengliHuan"));
    }
    public static  boolean dosomething(String input){
        return  input.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
