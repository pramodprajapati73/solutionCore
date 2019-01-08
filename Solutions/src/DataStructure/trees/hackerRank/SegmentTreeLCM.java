package DataStructure.trees.hackerRank;

public class SegmentTreeLCM {

    int[] segTree;

    public SegmentTreeLCM(int n){
        int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int size = (int) (2*Math.pow(2,x));
        segTree = new int[size];
    }
    public void constructLCMSegTree(int[] arr){
        LCMUtil(arr,0, arr.length-1,0);
    }
    private int LCMUtil(int[] arr, int st, int end, int node){
        if (st==end){
            segTree[node] = arr[st];
            return arr[st];
        }

        int mid = st+((end-st)/2);
        segTree[node] = lcm(LCMUtil(arr,st,mid,2*node+1), LCMUtil(arr,mid+1,end,2*node+2));
        return segTree[node];
    }
    private int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    private int gcd(int a, int b){
            if (a==0)
                return b;
            return gcd(b%a, a);
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 5, 4, 5, 2, 6};
        SegmentTreeLCM lcm = new SegmentTreeLCM(a.length);
        lcm.constructLCMSegTree(a);
        System.out.println(lcm.segTree[0]);
    }


}
