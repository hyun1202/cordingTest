package cordingTest.doitCordingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q16_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] A = new Data[n];

        for (int i=0; i<n; i++) {
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(A, Comparator.comparingInt(o -> o.value));

        int max = 0;

        for (int i=0; i<n; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }

        System.out.println(max + 1);
    }
}
