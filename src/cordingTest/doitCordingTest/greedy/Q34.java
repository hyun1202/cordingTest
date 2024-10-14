package cordingTest.doitCordingTest.greedy;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1744">https://www.acmicpc.net/problem/1744</a>
 */
public class Q34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 내림차순
        PriorityQueue<Integer> plusQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i=0; i<n; i++) {
            int input = sc.nextInt();
            if (input > 1) {
                plusQ.add(input);
            } else if (input == 1) {
                one++;
            } else if (input == 0) {
                zero++;
            } else {
                minusQ.add(input);
            }
        }

        int sum = 0;
        while (!plusQ.isEmpty()) {
            if (plusQ.size() == 1) {
                sum += plusQ.poll();
                break;
            }

            int a = plusQ.poll();
            int b = plusQ.poll();

            sum += a * b;
        }

        while (!minusQ.isEmpty()) {
            if (minusQ.size() == 1) {
                int c = minusQ.poll();
                if (zero == 0) {
                    sum += c;
                }
                break;
            }

            int a = minusQ.poll();
            int b = minusQ.poll();

            sum += a * b;
        }

        System.out.println(sum + one);
    }
}
