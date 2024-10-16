package cordingTest.doitCordingTest.numberTheory.EulersPhi;

import java.util.*;

public class EulersPhi2 {
    public static void main(String[] args) {
        // N값이 클 때는 배열을 이용하지 못한다.
        // 그러므로 소인수 분해를 이용해서 구현한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rp = n;
        int p = n;
        // 소수는 주어진 값의 제곱근까지만 돌려보면 알 수 있으므로 루트 N까지만 돌려준다.

        for (int k=2; k<=Math.sqrt(n); k++) {
            // 소인수로 구성된 수가 K로 나눠 떨어진다면, K는 소인수 중 하나이다.
            if (p % k == 0) {
                // 오일러의 피 함수 연산
                rp = rp - rp / k;

                // 소인수 분해로 해당 회차에서 사용한 소인수 제거
                while (p % k == 0) {
                    p /= k;
                }
            }
        }

        // 소인수가 1보다 크면 소인수가 아직 남아있으므로 연산 진행
        if (p > 1) {
            rp = rp - rp / p;
        }

        System.out.println(rp);
    }
}
