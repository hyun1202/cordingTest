package cordingTest.doitCordingTest.numberTheory.EulersPhi;

import java.util.Scanner;

public class EulersPhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n+1];

        for (int i=1; i<=n; i++) {
            A[i] = i;
        }

        for (int i=2; i<=n; i++) {
            // 현재 배열의 값과 인덱스가 같을 때 = 즉, 소수일 때 배수의 값을 업데이트 해준다.
            // 배열의 값과 인덱스가 같다라는 뜻은 업데이트가 되지 않았다 => 배수가 아니다, 즉 소수라는 뜻
            if (A[i] == i) {
                for (int j=i; j<=n; j+=i) {
                    // 이미 탈락된 후보의 중복삭제를 막기 위함
                    A[j] = A[j] - A[j] / i;
                }
            }
        }
        System.out.println(A[n]);
    }
}
