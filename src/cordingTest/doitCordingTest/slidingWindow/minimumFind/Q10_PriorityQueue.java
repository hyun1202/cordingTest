package cordingTest.doitCordingTest.slidingWindow.minimumFind;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q10_PriorityQueue {
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

        // 우선순위 큐 사용
        // 기본형: 우선순위가 낮은 숫자가 먼저 나옴 (작은 숫자)
        /*
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        // 우선순위가 높은 숫자가 먼저 나옴 (큰 숫자)
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
         */

        // 숫자가 아닌 객체가 들어가야하므로, 생성자에 어떠한 값을 우선순위로 먹여줄지 알려주어야한다.
        // 낮은 숫자가 먼저 나온다.
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.value));

        // 위의 내용은 아래와 동일하다.
//        pq = new PriorityQueue<>((p1, p2) -> {
//            return p1.value - p2.value;
//        });

        for (int i = 0; i < N; i++) {
            // 우선순위 큐에 원소를 추가한다.
            pq.add(new Node(i, Integer.parseInt(st.nextToken())));

            // 해당하는 index가 윈도우 범위에 포함이 된다면 제거한다.
            while (pq.peek().index < i - L + 1) {
                // 우선순위 큐에서 첫 번째 값을 반환하고 제거한다. (비어있으면 null)
                // 첫 번째 값을 반환한다 => 작은 숫자가 먼저 나온다.
                pq.poll();
            }

            bw.write(pq.peek().value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
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
