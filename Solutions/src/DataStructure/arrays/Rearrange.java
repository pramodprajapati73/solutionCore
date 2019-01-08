package DataStructure.arrays;

import java.util.Arrays;

public class Rearrange {

    private static void arrange(int[] a){
        if(a.length==0)
            return;
        for(int i=0;i<a.length;i++){
            if(a[i]!=-1 && a[i] != i){
                int tmp = a[i];
                a[i] = a[a[i]];
                a[tmp] = tmp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        arrange(a);
        System.out.println(Arrays.toString(a));
    }
}
