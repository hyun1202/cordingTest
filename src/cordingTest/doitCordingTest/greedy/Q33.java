package cordingTest.doitCordingTest.greedy;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1715">https://www.acmicpc.net/problem/1715</a>
 */
public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            pq.add(sc.nextInt());
        }

        int sum = 0;
        while(pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a+b);
        }

        System.out.println(sum);
    }
}
