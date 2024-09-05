package cordingTest.doitCordingTest.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q17_selectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력이 2143 이런식으로 들어오므로, substring을 이용하여
        // 자릿수 단위로 분리해야한다.
        String input = sc.next();

        int[] A = new int[input.length()];

        for (int i=0; i<A.length; i++) {
            // 자릿수 단위로 분리
            A[i] = Integer.parseInt(input.substring(i, i+1));
        }

        for (int i=0; i<A.length; i++) {
            int max = i;
            for (int j=i+1; j<A.length; j++) {
                // 내림차순이므로 최댓값을 찾는다.
                if (A[j] > A[max]) {
                    max = j;
                }
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int i=0; i<A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
