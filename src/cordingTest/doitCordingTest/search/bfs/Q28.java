package cordingTest.doitCordingTest.search.bfs;

import java.io.*;
import java.util.*;

public class Q28 {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for (int i=1; i<n+1; i++) {
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                A[s].add(new Edge(e, v));
            }
        }

        BFS(1);
        int max = 1;

        // 거리가 가장 먼 인덱스를 찾는다.
        // = 임의의 노드에서 가장 긴 경로로 연결되어 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나
        for (int i=2; i<n+1; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        // 초기화
        distance = new int[n+1];
        visited = new boolean[n+1];

        // 다시 BFS 실행
        BFS(max);

        // 가장 긴 경로를 찾기 위해 정렬
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Edge edge : A[now]) {
                int e = edge.e;
                int v = edge.value;
                if (!visited[e]) {
                    visited[edge.e] = true;
                    queue.add(e);
                    // 거리 계산
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;  // 가중치

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
