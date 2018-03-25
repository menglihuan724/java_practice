package kspx;

import java.util.Arrays;
/*不稳定,平均性能是最好的。最坏O(2^N),最好O(nlogN)*/
public class QuickSort {
    public static void main(String[] args) {
        int[] arry=new int[]{1,4,3,7,6,8,2,3,30};
        quickSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    private static void quickSort(int[] arry) {
        sort(arry,0, arry.length-1);

    }

    private static void sort(int[] arry, int low, int heg) {
        if(low>heg){
            return;
        }
        int i,j,index;
        i=low;
        j=heg;
        index=arry[i];
        while(i<j){
            //从后向前找比坐标xiao的
            while(i<j&&arry[j]>=index){
                j--;
            }
            if(i<j) {
                arry[i] = arry[j];
                i++;
            }
            //从前往后找比坐标da的
            while(i<j&&arry[i]<index){
                i++;
            }
            if(i<j) {
                arry[j] = arry[i];
                j--;
            }
        }
        arry[i]=index;
        sort(arry,low,i-1);
        sort(arry,i+1,heg);
    }

}