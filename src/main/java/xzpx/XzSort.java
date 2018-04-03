package xzpx;

import java.util.Arrays;

public class XzSort {
        public static void main(String[] args) {
            int[] arry=new int[]{1,3,4,6,7,9,10};
            sort(arry);
            System.out.println( Arrays.toString(arry));
        }
    private static void swap(int[] arr,int j, int i) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void sort(int[] arry) {
        /*最后一个数时不用比较*/
        for (int i = 0; i <arry.length-1 ; i++) {
            int min=i;
            for (int j = i+1; j <arry.length ; j++) {
                    if(arry[j]<arry[min]){
                        min=j;
                    }
            }
            if(min!=i){
                swap(arry,i,min);
            }
        }
    }
}