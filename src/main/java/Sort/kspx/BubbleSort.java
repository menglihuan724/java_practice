package Sort.kspx;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arry=new int[]{1,4,3,7,6,8};
        bubblesort2(arry);
        System.out.println(Arrays.toString(arry));
    }
    public static void bubblesort1(int[] arry){
        int len=arry.length;
        for (int i = 0; i <len ; i++) {
            for (int j = 1; j <len-i ; j++) {
                int x=arry[j-1];
                int y=arry[j];
                if(x>y){
                    int temp=arry[j-1];
                    arry[j-1]=arry[j];
                    arry[j]=temp;
                }
            }
        }
    }
    public static void bubblesort2(int[] arry){
        boolean flag=true;
        int len=arry.length;
        while (flag){
            flag=false;
            for (int i = 0; i <len ; i++) {
                for (int j = 1; j <len-i ; j++) {
                    int x=arry[j-1];
                    int y=arry[j];
                    if(x>y){
                        int temp=arry[j-1];
                        arry[j-1]=arry[j];
                        arry[j]=temp;
                        flag=true;
                    }
                }
            }
        }
    }
}