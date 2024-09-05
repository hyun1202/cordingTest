package cordingTest.programmers;

public class S0522 {
    public static String solution(int n) {
        String answer = "";
        for (int i = 1; i <= n; i++) {
            answer += i % 2 == 1 ? "수" : "박";
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
