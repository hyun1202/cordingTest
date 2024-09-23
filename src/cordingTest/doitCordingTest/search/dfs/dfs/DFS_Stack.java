package cordingTest.doitCordingTest.search.dfs.dfs;

import java.util.*;

/**
 * 스택을 이용한 DFS
 */
public class DFS_Stack {
    public static void main(String[] args) {
        // 인접 리스트
        int n = 6;
        List<Integer>[] list = new ArrayList[n];

        for (int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        // 1 -> 2, 3
        // 2 -> 5, 6
        // 3 -> 4
        // 4 -> 6

        list[0].add(1);
        list[0].add(2);

        list[1].add(4);
        list[1].add(5);

        list[2].add(3);

        list[3].add(5);

        // 방문 배열
        int[] visited = new int[n];

        // 스택
        Stack<Integer> stack = new Stack<>();

        // 1. 스택에 시작점 추가.
        stack.add(0);

        // 반복
        while(!stack.isEmpty()) {
            // 2. pop으로 노드를 꺼내고 탐색 순서에 기입
            int num = stack.pop();
            System.out.println(num+1);

            // 3. 인접 리스트의 인접 노드를 스택에 삽입 (방문 배열 체크)
            for (int i=0; i<list[num].size(); i++) {
                if (visited[list[num].get(i)] != 1) {
                    stack.add(list[num].get(i));
                    // 4. 방문 배열 업데이트.
                    visited[list[num].get(i)] = 1;
                }
            }
        }
    }
}
