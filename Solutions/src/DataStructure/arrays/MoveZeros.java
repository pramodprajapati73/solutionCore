package DataStructure.arrays;

import java.util.Arrays;

public class MoveZeros {

    private static void moveAllZeroes(int[] arr){
        if (arr.length<=1)
            return;
        int st = 0;
        int en = arr.length-1;
        while (st<en){
            if (arr[st]==0 && arr[en]==0){
                while (arr[en]==0){
                    en--;
                }
                swap(arr, st, en);

            }
            else if (arr[st]==0 && arr[en]!=0){
                swap(arr, st, en);
            }
            else if(arr[st]!=0 && arr[en]!=0){
                while (arr[st]!=0){
                    st++;
                }
                swap(arr, st, en);
            }
            st++;
            en--;
        }

    }

    private static void swap(int[] arr, int st, int end){
        int tmp = arr[st];
        arr[st] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        moveAllZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
