package cordingTest.doitCordingTest.search.dfs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 재귀 함수를 이용한 DFS
 */
public class DFS_Recursive {
    // 인접 리스트
    static int n = 8;
    // 방문 배열
    static boolean[] visited = new boolean[n+1];

    public static int[][] graph = {{},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};

    public static void main(String[] args) {
      DFS(1);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }

        System.out.println(v);

        visited[v] = true;

        for (int i : graph[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}

