package cordingTest.doitCordingTest.numberTheory.prime;

import java.util.*;

public class Q38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        int max = 10000001;
        long[] A = new long[max];

        for (int i=2; i<max; i++) {
            A[i] = i;
        }

        // 에라토스테네스의 체를 이용한 소수 구하기
        // 제곱근까지만 값을 구한다.
        for (int i=2; i<=Math.sqrt(max); i++) {
            if (A[i] == 0) {
                continue;
            }

            for (int j=i+i; j<max; j+=i) {
                A[j] = 0;
            }
        }

        int count = 0;
        for (int i=2; i<max; i++) {
            if (A[i] != 0) {
                // 제곱 수
                double tmp = A[i];
                // 오버플로우 방지를 위해 이항정리를 이용한다.
                // ex) 7^7 <= 10^14  -> 7 <= 10^14 / 7^6
                while ((double)A[i] <= b/tmp) {
                    if ((double)A[i] >= a/tmp) {
                        count++;
                    }
                    // 거듭제곱으로 늘어남
                    tmp *= A[i];
                }
            }
        }
        System.out.println(count);
    }
}
