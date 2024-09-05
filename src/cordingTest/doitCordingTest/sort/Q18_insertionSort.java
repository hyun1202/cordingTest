package cordingTest.doitCordingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18_insertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Q18_insertionSort.sort(A);
        int[] S = new int[n];

        S[0] = A[0];
        // 합배열 구하기.
        for (int i=1; i<n; i++) {
            S[i] += A[i] + S[i-1];
        }

        int result = 0;

        for (int i=0; i<n; i++) {
            result += S[i];
        }

        System.out.println(result);
    }

    static void sort(int[] A) {
        int n = A.length;
        // 삽입 정렬 시작
        // 맨 앞의 데이터는 정렬이 되어있다고 생각하기 때문에 1부터 시작
        for (int i=1; i<n; i++) {
            int target = A[i];
            // 정렬된 index
            int j = i-1;

            // 선택한 데이터를 삽입하기 위해 shift 연산 수행
            while (j >= 0 && target < A[j]) {
                A[j+1] = A[j];
                j--;
            }

            // 위 반복문에서 탈출 하는 경우는 원소가 타겟보다 작다는 의미이다.
            // 그러므로 +1을 해준다.
            A[j+1] = target;
        }
    }
}
