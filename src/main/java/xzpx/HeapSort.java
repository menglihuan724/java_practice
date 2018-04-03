package xzpx;

import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void main(String[] args) {
        int[] arry=new int[]{1,3,4,6,7,9,10};
        sort(arry);
        System.out.println( Arrays.toString(arry));
    }
    public static void sort(int[] arry){
        for (int i = arry.length/2-1; i>=0 ; i--) {
            adujst(arry,i,arry.length);
        }
        for (int j = arry.length-1; j>0 ; j--) {
            swap(j,0,arry);
            //
            adujst(arry,0,j);
        }
    }
    /*交换头尾*/
    private static void swap(int j, int i,int[] arry) {
            int temp=arry[j];
            arry[i]=temp;
    }
    /*构造堆*/
    public static  void adujst(int[] arry,int i,int len){
        int temp=arry[i];
        for (int x =i*2+1 ; x <len ; x=x*2+1) {
            //判断是否为最后一个非叶节点,同时判断其子节点的左右大小
            if(x+1<len&&arry[x]<arry[x+1]){
                x++;
            }
            //如果子节点大于父节点则交换
            if(arry[x]>temp){
                arry[i]=arry[x];
                i=x;

            }else {
                break;
            }
        }
        arry[i]=temp;
    }
}
