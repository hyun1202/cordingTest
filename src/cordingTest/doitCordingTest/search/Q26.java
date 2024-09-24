package cordingTest.doitCordingTest.search;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1260">https://www.acmicpc.net/problem/1260</a>
 */
public class Q26 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=0; i<n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        // 번호가 작은 것을 먼저 방문하기 위해 정렬이 필요함
        for (int i=1; i<n+1; i++) {
            Collections.sort(A[i]);
        }

        DFS(v);
        bw.flush();

        System.out.println();
        queue.add(v);

        visited = new boolean[n+1];
        visited[v] = true;

        BFS();
        bw.flush();
    }

    static void DFS(int v) throws IOException {
        if (visited[v]) {
            return;
        }
        bw.write(v + " ");
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS() throws IOException {
        while(!queue.isEmpty()) {
            int v = queue.poll();
            bw.write(v + " ");
            for (int i : A[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
