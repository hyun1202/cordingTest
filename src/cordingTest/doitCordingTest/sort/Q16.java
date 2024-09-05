package cordingTest.doitCordingTest.sort;

import java.io.*;
import java.util.*;

public class Q16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] A = new Data[n];

        for (int i=0; i<n; i++) {
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬, 시간복잡도는 O(nlogn) (merge sort)
        Arrays.sort(A, Comparator.comparingInt(o -> o.value));

        // 이 문제의 "아이디어"는, 정렬 이후의 최대 index값을 찾는 것이다.
        int max = 0;
        // i = 정렬 후의 index 값
        for (int i=0; i<n; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        //swap이 일어나지 않은 반복문이 한 번 더 실행되는 횟수가 있으므로 +1
        System.out.println(max + 1);
    }
}

//class Data implements Comparable<Data>{
    class Data {
    int index;  // 정렬 전 index 값.
    int value;

    Data(int index, int value) {
//        super();
        this.index = index;
        this.value = value;
    }

//    @Override
//    public int compareTo(Data o) {
//        return this.value - o.value;
//    }
}
