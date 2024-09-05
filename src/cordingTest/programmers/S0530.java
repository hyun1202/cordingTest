package cordingTest.programmers;

import java.util.Arrays;

public class S0530 {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = n > m? m : n;
        for (int i=1; i<=min; i++) {
            if (n%i == 0 && m%i == 0) {
                answer[0] = i;
            }
        }
        answer[1] = (n * m) / answer[0];
        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(solution(3, 12)).forEach(n -> System.out.println("n = " + n));
        Arrays.stream(solution(2, 5)).forEach(n -> System.out.println("n = " + n));
    }
}
