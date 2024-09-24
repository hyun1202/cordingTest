package cordingTest.doitCordingTest.search.dfs.dfs;

import java.util.*;
import java.io.*;

/**
 * 백준 11724
 */
public class Q23 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=0; i<n+1; i++) {
            // A[0]은 사용하지 않는다.
            A[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 방향이 없으므로 양방향으로 넣어준다.
            A[u].add(v);
            A[v].add(u);
        }

        int count = 0;

        for (int i=1; i<n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int i : A[v]) {
            // "연결 노드" 방문 여부 탐색
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
