package cordingTest.doitCordingTest.sort;

import java.io.*;
import java.util.*;

public class Q18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

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
}
