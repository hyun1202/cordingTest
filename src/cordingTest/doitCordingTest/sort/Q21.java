package cordingTest.doitCordingTest.sort;

import java.io.*;
import java.util.*;

public class Q21 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        // 버블 소트를 수행할 때 swap이 총 몇 번 발생했는지 알아내는 프로그램 작성.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(a, 0, n-1);

        System.out.println(result);
    }

    static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);

        merge(a, start, mid, end);
    }

    static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end+1];
        int idx = start;
        int left = start;
        int right = mid+1;

        while (left <= mid && right <= end) {
            if (a[left] < a[right]) {
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
