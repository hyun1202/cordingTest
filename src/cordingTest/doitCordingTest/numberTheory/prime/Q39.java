package cordingTest.doitCordingTest.numberTheory.prime;

import java.util.*;

public class Q39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 문제에서 조건은 n의 범위를 10^6으로 제한한 것이지, 출력 값의 범위를 제한한 것이 아니다.
        // n보다 크거나 같고 소수이면서 팰린드롬인 수 중에서 가장 작은 수 이므로 출력값은 10^6을 초과할 수 있다.
        // 따라서 크기를 1003001 + 1 이상으로 설정해주어야 한다. => 소수이면서 팰린드롬인 수에서 10^6다음으로 가장 작은 수는 1003001이다
        int len = 10000001;
        int[] A = new int[len];

        for (int i=2; i<len; i++) {
            A[i] = i;
        }

        for (int i=2; i<=Math.sqrt(len); i++) {
            if (A[i] == 0) {
                continue;
            }

            for (int j=i+i; j<len; j+=i) {
                A[j] = 0;
            }
        }

        for (int i=n; i<len; i++) {
            if (A[i] != 0) {
                //  팰린드롬인지 확인
                char[] ch = String.valueOf(A[i]).toCharArray();

                // 투포인터를 이용하여 팰린드롬인지 확인한다.
                int s = 0;
                int e = ch.length-1;
                boolean flag = false;
                while (s <= e) {
                    if (ch[s++] != ch[e--]) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }

                if (flag) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }
    }
}
