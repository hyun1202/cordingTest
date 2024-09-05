package cordingTest.programmers;


import java.util.Arrays;
import java.util.Comparator;

public class S0607 {
    /**
     * 문자열 내 마음대로 정렬하기
     * compare s1, s2
     * 사전적으로 뒤에있는 것이 더 <b>크다</b>
     *
     * s1.charAt(n) > s2.charAt(n)의 뜻은, s2가 s1보다 <b>뒤에 있음</b>을 뜻한다.
     * s1.charAt(n) == s2.charAt(n)의 뜻은, 해당 '문자'는 사전적으로 같다.
     * > 그러므로 전체 문자열을 비교한다.
     * > s1.compareTo(s2)의 뜻은 s1이 더 클경우 (뒤에 있을 경우) 양수 (1)을 return, 더 작을 경우 (앞에 있을 경우) 음수 (-1)을 return, 같을 경우 0을 return
     * retrurn 0의 뜻은 사전적으로 같다.
     */
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                //
                if(s1.charAt(n) > s2.charAt(n)) return 1;
                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if(s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"sun", "bed", "car"}, 1));
        System.out.println(solution(new String[] {"abce", "abcd", "cdx"}, 2));
    }
}
