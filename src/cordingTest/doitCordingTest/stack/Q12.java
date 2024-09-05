package cordingTest.doitCordingTest.stack;

import java.io.*;
import java.util.*;

/**
 * 오큰수 구하기 - 백준 17298 <br>
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다.<br>
 * 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. <br>
 * Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. <br>
 * 그러한 수가 없는 경우에 오큰수는 -1이다. <br><br>
 *
 * 예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다. <br>
 * <br>
 * 입력 <br>
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. <br>
 * 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다. <br>
 * <br>
 * 출력 <br>
 * 총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.<br>
 * <pre>
 *
 * 예제 입력 1
 * 4
 * 3 5 2 7
 *
 * 예제 출력 1
 * 5 7 7 -1
 *
 * 예제 입력 2
 * 4
 * 9 5 4 8
 *
 * 예제 출력 2
 * -1 8 8 -1
 * </pre>
 */
public class Q12 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        int[] result = new int[n];

        for (int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 스택에는 수열의 값이 아닌 "인덱스"를 저장한다.
        Stack<Integer> stack = new Stack<>();
        // index 0으로 초기화
        stack.push(0);

        for (int i=0; i<n; i++) {
            // 스택이 비어있지 않고, 현재 수열 값이 top에 해당하는 수열보다 클 때까지 진행한다.
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // 정답 배열에 오큰수를 현재 수열로 저장
                result[stack.pop()] = A[i];
            }
            // 현재 수열을 스택에 push()
            stack.push(i);
        }

        // 스택이 빌 때까지 확인한다.
        // -1을 확인하기 위함
        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
