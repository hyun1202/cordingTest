package cordingTest.programmers;

/**
 * 프로그래머스-문자열 나누기
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=java"></a>
 */
public class S0625 {
    public static int solution(String s) {
        int answer = 0;
        char cur = '0';
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            if(count == 0) {
                answer++;
                cur = s.charAt(i);
                count = 1;
            } else {
                // 현재 문자를 카운트할 필요가 없음, 앞문자를 기준으로 count를 해서 문자열을 분리함
                if (cur != s.charAt(i)) {
                    count--;
                }else {
                    count++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution("banana"));
//        System.out.println(solution("abracadabra"));
//        System.out.println(solution("aaabbaccccabba"));
        System.out.println(solution("aaabbccccddare")); // aaabbc / cccdda / re
    }
}