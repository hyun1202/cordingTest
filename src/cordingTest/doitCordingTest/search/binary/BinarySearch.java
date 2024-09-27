package cordingTest.doitCordingTest.search.binary;

import java.util.*;

public class BinarySearch {
    // 1, 3, 5, 6, 10, 30, 43, 84, 90
    static int[] A = {1, 3, 6, 5, 10, 90, 30, 43, 84};
    public static void main(String[] args) {
        int x = 91;

        // 이진탐색은 데이터가 반드시 정렬되어져 있어야 함
        Arrays.sort(A);
        bs(x);
    }

    static void bs(int x) {
        int start = 0;
        int mid;
        int end = A.length - 1;

        while (start <= end) {
            // mid 구하기
            mid = (start + end) / 2;
            System.out.println("mid: " + mid);

            // x가 중앙값보다 작을 경우, 왼쪽 데이터셋을 선택
            if (A[mid] > x) {
                end = mid - 1;
            } else if (A[mid] < x) {    // 중앙값보다 작을 경우, 오른쪽 데이터셋을 선택
                start = mid + 1;
            } else {    // 데이터를 찾음
                System.out.println(A[mid]);
                break;
            }
        }
    }
}
