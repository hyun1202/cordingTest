package cordingTest.doitCordingTest.greedy;

import java.util.*;

// 필요한 동전 개수의 최솟값 구하기
public class Q32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int A[] = new int[n];

        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;

        for (int i=n-1; i>=0; i--) {
            if (A[i] <= k) {
                count += (k / A[i]);
                k = k % A[i];
            }
        }
        System.out.println(count);
    }
}
