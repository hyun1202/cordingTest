package cordingTest.programmers;


public class S0604 {
    /**
     * 프로그래머스-최소직사각형
     * 이 문제의 key는 "가로"는 입력받은 가로,세로 크기의 최댓값이 가로이며, 세로는 그 외의 값
     * 가로, 세로를 찾고 가장 큰 가로 값과 세로 값을 찾아서 반환.
     *
     * @param sizes
     * @return
     * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86491"></a>
     */
    public static int solution(int[][] sizes) {
        int max = 0, min = 0;
        for (int i = 0; i < sizes.length; i++) {
            int maxWidth = Math.max(sizes[i][0], sizes[i][1]);
            int minHeight = Math.min(sizes[i][0], sizes[i][1]);

            max = Math.max(max, maxWidth);
            min = Math.max(min, minHeight);
        }
        return max * min;
    }

    public static void main(String[] args) {
        System.out.println(solution( new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}} ));
        System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
