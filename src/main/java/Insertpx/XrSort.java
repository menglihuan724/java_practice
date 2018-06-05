package Insertpx;

import java.util.Arrays;

public class XrSort {
    public static void main(String[] args) {
        int []arr ={1,4,2,7,9,8,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr,int j, int i) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void sort(int[] arr) {
        for (int gap = arr.length/2; gap>0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                    int j=i;
                    while (j-gap>=0&&arr[j]<arr[j-gap]){
                        swap(arr,j,j-gap);
                        j-=gap;
                    }
            }
        }
    }
}