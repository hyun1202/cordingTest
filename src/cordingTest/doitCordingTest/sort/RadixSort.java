package cordingTest.doitCordingTest.sort;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] a = new int[] {11,215,15,344,372,294,100,8,145,24,198,831};
        int n = a.length;

        // 최대 자릿수
        int maxSize = 3;

        Queue<Integer>[] bucket = new LinkedList[10];
        int radix = 1;

        for (int i=0; i<10; i++) {
            bucket[i] = new LinkedList<>();
        }

        int count = 0;
        while (count != maxSize){
            for (int i=0; i<n; i++) {
                // 각 자리수에 맞도록 데이터 삽입 (LSD: 최하위 자리수 정렬)
                bucket[(a[i] / radix) % 10].add(a[i]);
            }

            // 순차적으로 정렬
            for (int i=0, j=0; i<bucket.length; i++) {
                while(!bucket[i].isEmpty()) {
                    a[j++] = bucket[i].poll();
                }
            }

            // 다음 자리수로 이동
            radix *= 10;
            count++;
        }

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }
}
