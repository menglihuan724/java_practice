package LeetCode;

/**
 * Created by menglihuan on 2017/4/8.
 */
public class ConstructtheRectangle {
    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(5));
        System.out.println(dosomething(5)[0]+","+dosomething(5)[1]);
    }
    public static  int[] dosomething(int area){
        int w=(int)Math.sqrt(area);
        while(area%w!=0){
            w--;
        }
        return new int[]{area/w,w};
    }
}
