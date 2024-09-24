package cordingTest.doitCordingTest.search.dfs.dfs;

import java.util.*;
import java.io.*;

/**
 * <a href="https://www.acmicpc.net/problem/13023">https://www.acmicpc.net/problem/13023</a>
 */
public class Q25 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=0; i<n+1; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }


        for (int i=0; i<n; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }

    static void DFS(int v, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                // depth를 넘겨준다.
                DFS(i, depth + 1);
            }
        }

        // 다른 경로도 탐색 가능하도록 false로 설정
        visited[v] = false;
    }
}
