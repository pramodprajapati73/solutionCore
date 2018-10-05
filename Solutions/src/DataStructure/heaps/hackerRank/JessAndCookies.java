package DataStructure.heaps.hackerRank;

import java.util.PriorityQueue;

public class JessAndCookies {
    static int cookies(int k, int[] A) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int aA : A) q.add((long) aA);
        //if minimum is greater than K then no attempt needed;
        if(!q.isEmpty() && q.peek()>k)
            return 0;
        int count = 0;
        while(!q.isEmpty() && q.peek() < (long) k) {
            if (q.size()<2 && q.peek()< (long) k) {
                //if this condition ever passes then expected value of K is not possible
                count =0;
                break;
            }
            count++;
            Long re = q.poll()+(2L *q.poll());
            q.add(re);
        }

        return count==0?-1:count;
    }
}
