package gbpx;

import java.util.Arrays;
//归并排序是一种比较占内存，但却效率高且稳定的算法,注解非递归方法效率更高,且不容易出现溢出,O(nlogn)
public class MergeSort {
    public static void main(String[] args) {
        int[] arry=new int[]{1,4,3,7,6,8,2,3,30};
        mergeSort(arry,0,arry.length-1);
        System.out.println(Arrays.toString(arry));
    }

    private static void mergeSort(int[] arry, int low, int heg) {
        int mid=(low+heg)/2;
        if(low<heg){
            mergeSort(arry,low,mid);
            mergeSort(arry,mid+1,heg);
            recSort(arry,low,mid,heg);
        }
    }

    private static void recSort(int[] arry, int low, int mid, int heg) {
        int[] temp=new int[heg-low+1];
        int i,j,k;
        i=low;//left point
        j=mid+1;//right point
        k=0;
        while(i<=mid&&j<=heg){
            if(arry[i]<arry[j]){
                temp[k++]=arry[i++];
            }else {
                temp[k++]=arry[j++];
            }
        }
        //左边数组剩余
        while(i<=mid){
            temp[k++]=arry[i++];
        }
        //右边数组剩余
        while(j<=heg){
            temp[k++]=arry[j++];
        }
        //把临时数组放回原数组
        for (k = 0; k <temp.length ; k++) {
            //从分割数组的最低位开始
            arry[k+low]=temp[k];
        }
    }

}