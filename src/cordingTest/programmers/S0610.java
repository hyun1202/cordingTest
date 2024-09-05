package cordingTest.programmers;


import java.util.HashMap;
import java.util.Map;

public class S0610 {
    public static int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                answer[i] = i - map.get(c);
            } else {
                answer[i] = -1;
            }
            map.put(c, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("foobar"));
    }
}
