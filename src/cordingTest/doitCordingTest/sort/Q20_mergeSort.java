package cordingTest.doitCordingTest.sort;

import java.util.*;

public class Q20_mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        mergeSort(a, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
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
        int[] tmp = new int[end + 1];

        int left = start;
        int right = mid + 1;

        int idx = start;

        while (left <= mid && right <= end) {
            if (a[left] < a[right]) {
                tmp[idx++] = a[left++];
            } else {
                tmp[idx++] = a[right++];
            }
        }

        // 정리
        while (left <= mid) {
            tmp[idx++] = a[left++];
        }

        while (right <= end) {
            tmp[idx++] = a[right++];
        }

        // 이후 정렬된 데이터로 덮어 씌운다.
        for (int i=start; i<=end; i++) {
            a[i] = tmp[i];
        }
    }
}
