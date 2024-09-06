package cordingTest.doitCordingTest.sort;

import java.io.*;
import java.util.*;

/**
 * 시간 초과 이유
 * 1. result는 정답의 최댓값이 N*(N-1)/2 이므로 long형으로 선언해야한다.
 * 2. tmp 배열의 크기는 맞게 생성해야한다. 지역변수 => static으로 변경
 * 3. 배열의 크기도 이와 맞게 long형으로 선언.
 *
 * 문제 틀린 이유
 * 1. swap한 횟수 계산 시, 같은 값은 swap 횟수를 계산할 이유가 없으므로 <에서 <=로 변경
 */
public class Q21 {
    static long result = 0;
    static long[] a, tmp;
    public static void main(String[] args) throws IOException {
        // 버블 소트를 수행할 때 swap이 총 몇 번 발생했는지 알아내는 프로그램 작성.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new long[n];
        tmp = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n-1);

        System.out.println(result);
    }

    static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);

        merge(start, mid, end);
    }

    static void merge(int start, int mid, int end) {
        int idx = start;
        int left = start;
        int right = mid+1;

        while (left <= mid && right <= end) {
            // 같은 값은 result값을 계산할 이유가 없음.
            if (a[left] <= a[right]) {
                tmp[idx++] = a[left++];
            } else {
                // 뒤 쪽 그룹이 이동할 때 swap이 일어난 것과 동일하다.
                // 이동한 거리 만큼 result를 더한다.
                result = result + right - idx;
                tmp[idx++] = a[right++];
            }
        }

        while (left <= mid) {
            tmp[idx++] = a[left++];
        }

        while (right <= end) {
            tmp[idx++] = a[right++];
        }

        for (int i=start; i<=end; i++) {
            a[i] = tmp[i];
        }
    }
}
