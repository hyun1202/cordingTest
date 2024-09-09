package cordingTest.doitCordingTest.sort;

import java.io.*;
import java.util.*;

/**
 * 백준 10989
 * 1. 시간 초과 - Scanner, System.out -> BufferedReader 및 BufferedWriter로 수정
 * 2. 메모리 초과 - Queue -> 기본 배열로 수정 (합 배열 이용)
 */
public class Q22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int maxSize = 5;

//        // 메모리 초과로 Queue 사용 X
//        Queue<Integer>[] bucket = new LinkedList[10];

        int count = 0;
        int radix = 1;
        while (count < maxSize) {
            int[] output = new int[n];
            int[] bucket = new int[10];

            for (int i=0; i<n; i++) {
                bucket[a[i] / radix % 10]++;
            }

            for(int i=1; i<10; i++) {
                // 합배열 이용해 첫 index를 계산한다.
                // 예를들어 bucket[3] = 4, bucket[4] = 7라면
                // 자릿수 3에 해당하는 값들은 인덱스 3부터 시작하고, 자릿수 4에 해당하는 값들은 인덱스 6부터 시작한다는 의미 (배열의 인덱스는 0부터이므로 -1)
                bucket[i] += bucket[i-1];
            }

            // 현재 자리수를 기준으로 정렬
            for (int i=n-1; i>=0; i--) {
                // 위에서 구한 index로 정렬 시작
                // 한번 구하면 index--를 해준다.
                output[bucket[a[i] / radix % 10]-- -1] = a[i];
            }

            for (int i=0; i<n; i++) {
                a[i] = output[i];
            }

            radix *= 10;
            count++;
        }

        for (int i=0; i<n; i++) {
            bw.write(a[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
