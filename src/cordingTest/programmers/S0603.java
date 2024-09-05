package cordingTest.programmers;


public class S0603 {
    public static int solution(String t, String p) {
        int count = 0;
        int len = p.length();
        for (int i=0; i<=t.length()-len; i++) {
            if (Long.parseLong(p) >= Long.parseLong(t.substring(i, i+len))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
    }
}
