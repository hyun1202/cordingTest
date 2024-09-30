package cordingTest.doitCordingTest.search.binary;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1920">https://www.acmicpc.net/problem/1920</a>
 */
public class Q29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];

        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int m = sc.nextInt();

        for (int i=0; i<m; i++) {
            int target = sc.nextInt();
            int left = 0;
            int mid;
            int right = n-1;

            while(true) {
                if (left > right) {
                    System.out.println(0);
                    break;
                }

                mid = (left + right) / 2;

                if (A[mid] > target) {
                    right = mid - 1;
                } else if (A[mid] < target) {
                    left = mid + 1;
                } else {
                    System.out.println(1);
                    break;
                }
            }
        }
    }
}
