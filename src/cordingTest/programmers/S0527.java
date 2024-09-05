package cordingTest.programmers;

public class S0527 {
    public static boolean solution(String s) {
        if (s.length() < 4 || s.length() > 6){
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!(c > 47  && c < 58))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }
}
