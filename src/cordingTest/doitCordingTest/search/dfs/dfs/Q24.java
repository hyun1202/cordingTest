package cordingTest.doitCordingTest.search.dfs.dfs;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2023">https://www.acmicpc.net/problem/2023</a>
 */
public class Q24 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int len) {
        if (n == len) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i=1; i<10; i+=2) {
            // a가 짝수인 경우는 항상 2를 약수로 가지므로 a가 짝수인 경우를 제외한다. => 가지치기
            if (isPrime(num * 10 + i)) {
                // 2, 21,22,... ->, 211,212,... 와 같이 자릿수를 늘려서 계산
                DFS(num * 10 + i, len + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i=2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
