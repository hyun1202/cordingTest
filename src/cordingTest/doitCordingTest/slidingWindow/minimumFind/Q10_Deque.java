package cordingTest.doitCordingTest.slidingWindow.minimumFind;

import java.io.*;
import java.util.*;

public class Q10_Deque {
    // 최솟값 찾기
    // N개의 수 A1, A2..... AN과 L이 주어진다, Ai-L+1 ~ Ai중 최솟값을 Di라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오.
    // 이때 i <= 0인 Ai는 무시하고 D를 구해야 한다.

    // 입력 1번째 줄에 N과 L(1<=L<=N<=5,000,000), 2번째 줄에 N개의 수 Ai가 주어진다(-10^9 <= Ai <= 10^9)
    // 출력 1번째 줄에 Di를 공백으로 구분해 순서대로 출력

    // 예제 입력 1
    // 12 3
    // 1 5 2 3 6 2 3 7 3 5 2 6
    // 출력

    // 1 1 1 2 2 2 2 2 3 3 2 2
    public static void main(String[] args) throws IOException {
        // 덱을 이용한 슬라이딩 윈도우 구현
        // 덱을 이용하는 이유: 양방향 삭제 삽입으로 정렬하지 않고도 정렬을 할 수 있는 효과가 있음

        // 입력 및 출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            int now = Integer.parseInt(st.nextToken());

            // 덱에 저장된 값이 현재 값보다 크면 삭제한다.
            while (!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            if (dq.getFirst().index < i - l + 1) {
                dq.removeFirst();
            }

            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
