package cordingTest.doitCordingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q19_quickSort {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a, 0, n-1, k-1);

        System.out.println(a[k-1]);

    }

    static void quickSort(int[] a, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(a, start, end);
            if (pivot == k) {
                return;
            }
            else if (k < pivot) {
                quickSort(a, start, pivot-1, k);
            } else {
                quickSort(a, pivot+1, end, k);
            }
        }
    }

    static int partition(int[] a, int start, int end) {
        // 이 조건은 무엇?
        if (start + 1 == end) {
            if (a[start] > a[end]) {
                swap(a, start, end);
            }
            return end;
        }

        int m = (start + end) / 2;
        int pivot = a[m];
        int pivot_index = start;

        swap(a, start, m);

        start++;

        while (start < end) {
            while (pivot < a[end]) {
                end--;
            }

            while (pivot > a[start] && start <= end) {
                start++;
            }

            if (start <= end) {
                swap(a, start, end);
                start++;
                end--;
            }
        }
        swap(a, pivot_index, end);
        return end;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}