package Insert;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class InsetSort {
    public static void main(String[] args) {
        int[] arry=new int[]{1,4,3,7,6,8,2,3,30};
        InsertSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    private static void InsertSort(int[] arry) {
        int i=1,j,index;
        for ( ; i <arry.length ; i++) {
            index=arry[i];
            j=i-1;
            while (j >= 0 && arry[j]> index) {
                    arry[j+1]=arry[j];
                    j--;
            }
            arry[j+1]=index;
        }
    }

}