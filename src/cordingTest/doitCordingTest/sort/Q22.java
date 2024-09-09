package cordingTest.doitCordingTest.sort;

import java.util.*;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int maxSize = 5;

        Queue<Integer>[] bucket = new LinkedList[10];

        for (int i=0; i<10; i++) {
            bucket[i] = new LinkedList<>();
        }

        int count = 0;
        int radix = 1;
        while (count < maxSize) {
            for (int i=0; i<n; i++) {
                bucket[a[i] / radix % 10].add(a[i]);
            }

            for (int i=0, j=0; i<bucket.length; i++) {
                while (!bucket[i].isEmpty()) {
                    a[j++] = bucket[i].poll();
                }
            }

            radix *= 10;
            count++;
        }

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }
}
