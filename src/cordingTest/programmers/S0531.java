package cordingTest.programmers;


public class S0531 {
    public static int solution(int n) {
        String answer = "";

        while(n > 0) {
            answer = answer + n % 3;
            n /= 3;
        }

        return Integer.parseInt(answer, 3);
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
