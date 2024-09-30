package cordingTest.doitCordingTest.search.binary;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2343">https://www.acmicpc.net/problem/2343</a>
 */
public class Q30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();   // 블루레이 개수

        int[] A = new int[n];

        int start = 0;
        int end = 0;

        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
            // 최댓값을 시작값으로 저장
            if (A[i] > start) {
                start = A[i];
            }
            // 마지막 값은 레슨의 총합이다.
            end += A[i];
        }

        // 총 블루레이에 모든 레슨을 담되, 모두 같은 크기로 만들어야한다.

        // => 아이디어
        // 모두 저장할 수 있다면, 블루레이 크기를 줄이고
        // 저장할 수 없다면 블루레이 크기를 늘린다.

        while (start <= end) {
            int mid = (start + end) / 2;  // 블루레이 크기 지정
            int sum = 0;
            int count = 0;  // 블루레이 개수

            for (int i=0; i<n; i++) {
                // 블루레이 크기 확인
                if (sum + A[i] > mid) {
                    // 한개의 블루레이 크기를 넘어갔으므로 다른 블루레이에 저장
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0) {
                count++;
            }

            // 블루레이 개수가 더 많다 = 수가 작다
            // 블루레이 개수가 더 적다 = 수가 크다

            // 블루레이 개수가 더 많으면 줄이기 위해 오른쪽을 선택한다.
            if (count > m) {
                start = mid + 1;
            } else {    // 블루레이 개수가 더 적으면 늘리기 위해 왼쪽을 선택한다.
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
