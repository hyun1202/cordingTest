package cordingTest.doitCordingTest.greedy;

import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1541">https://www.acmicpc.net/problem/1541</a>
 */
public class Q36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // -를 기준으로 split하면 더하기만 있는 값들이 추출된다.
        String[] plusStr = input.split("-");

        int result = 0;
        boolean start = false;
        for (String str : plusStr) {
            // 이후 +할 값들 추출
            String[] nStr = str.split("\\+");

            int tmp = 0;

            for (String tmpStr : nStr) {
                tmp += Integer.parseInt(tmpStr);
            }
            // 가장 앞에 있는 값은 더한다
            if (!start) {
                result += tmp;
                start = true;
            } else {
                // 그 외의 값은 빼준다
                result -= tmp;
            }
        }
        System.out.println(result);
    }
}
