package cordingTest.doitCordingTest.slidingWindow.minimumFind;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 사용한다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 라인을 읽는다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 라인에서 공백 단위로 값을 가져온다.
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        // 또 다시 라인을 읽음
        st = new StringTokenizer(br.readLine());

        // 덱 생성
        Deque<Node> mydeque = new LinkedList<>();

        // O(n)
        for (int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 덱의 마지막 숫자가 현재 숫자보다 크다면 덱의 마지막 값을 날려준다.
            // 최솟값을 구해야하므로
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            // 뒤에 새로운 값을 넣어줌
            mydeque.addLast(new Node(i, now));

            // 범위에서 벗어난 값은 제거한다.
            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
