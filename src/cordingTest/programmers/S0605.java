package cordingTest.programmers;


public class S0605 {
    /**
     * 프로그래머스-시저 암호
     * (c - 'A' + n) % 26 + 'A' 뜻
     * (c-'A'+n): 실제 알파벳 위치를 구한다 (0~25)
     * % 26: 마지막 글자일 때 순환 시키기 위함
     * +'A': 실제 아스키 코드로 변환하기 위해 더해줌
     * @param s
     * @param n
     * @return
     */
    public static String solution(String s, int n) {
        String answer = "";
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i);
            if (c == 32) {
                answer += (char) c;
            }else if (c >= 65 && c <= 90) {
                answer += (char) ((c-'A'+n)%26+'A');
            }else if (c >= 97 && c <= 122) {
                answer += (char) ((c-'a'+n)%26+'a');
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int c = 90;
        int n = 2;
        System.out.println((c - 'A' + n) % 26 + 'A');
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }
}
