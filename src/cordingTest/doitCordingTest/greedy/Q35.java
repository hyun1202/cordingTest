package cordingTest.doitCordingTest.greedy;

import java.util.*;

public class Q35 {
    public static void main(String[] args) {
        // 아래와 같이 4가지의 그리디 알고리즘을 생각할 수 있다.
        // 빠른 시작시간 작업을 우선
        // 빠른 종료시간 작업을 우선
        // 짧은 작업을 우선
        // 긴 작업을 우선

        // 그 중, 종료시간이 빠를 수록 다음 회의와 겹치지 않게 시작하는 데에 유리하므로 2번을 이용
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] A = new int[n][2];

        for (int i=0; i<n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같으면
                if (o1[1] == o2[1]) {
                    // 시작 시간이 더 빠른 순으로 정렬
                    return o1[0] - o2[0];
                }
                // 종료 시간이 더 빠른 순으로 정렬
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1;

        for (int i=0; i<n; i++) {
            // 시작시간이 종료시간보다 "동일하거나" 큰 경우에는 회의가 겹치지 않는다.
            if (A[i][0] >= end) {
                // 종료시간을 업데이트 해준다.
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
