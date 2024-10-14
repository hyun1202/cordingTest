package cordingTest.doitCordingTest.numberTheory.prime;

import java.util.*;

public class Q37 {
    public static void main(String[] args) {
        // "에라토스테네스의 체"를 이용한 소수 구하기
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] A = new int[n+1];

        for (int i=2; i<=n; i++) {
            A[i] = i;
        }

        for (int i=2; i<= Math.sqrt(n); i++) {
            if (A[i] == 0) {
                continue;
            }

            // 배수 탐색
            for (int j=i+i; j<=n; j+=i) {
                A[j] = 0;
            }
        }

        for (int i=m; i<=n; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
