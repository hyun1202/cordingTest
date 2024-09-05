package cordingTest.programmers;

public class S0521 {
    public static String solution(String s) {
        int mid = s.length() / 2;

        return s.length() % 2 == 0? s.substring(mid-1, mid+1) : s.substring(mid, mid+1);
    }

    public static void main(String[] args) {

        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }
}

