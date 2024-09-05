package cordingTest.doitCordingTest.sort;

import java.util.*;

public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력이 2143 이런식으로 들어오므로, substring을 이용하여
        // 자릿수 단위로 분리해야한다.
        String input = sc.next();

        // Comparator을 이용하기 위해서는 Primitive 타입은 적용이 불가능하므로 Integer wrapper 클래스를 이용한다.
        Integer[] A = new Integer[input.length()];

        for (int i=0; i<A.length; i++) {
            // 자릿수 단위로 분리
            A[i] = Integer.parseInt(input.substring(i, i+1));
        }

        // 내림차순 정렬
        Arrays.sort(A, Comparator.reverseOrder());

        for (int i=0; i<A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
