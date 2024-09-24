package cordingTest.doitCordingTest.search.bfs;

import java.util.*;

public class BFS {
    static int[][] graph = {{},
            {2, 3},
            {5, 6},
            {4},
            {6},
            {},
            {}};
    static boolean[] visited;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        visited = new boolean[graph.length];
        queue = new LinkedList<>();

        queue.add(1);
        BFS();
    }

    static void BFS() {
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now);

            for (int i : graph[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
