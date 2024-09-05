package cordingTest.programmers;


public class S0619 {
    public static int solution(int n, int m, int[] section) {
        int roller = section[0];
        int cnt = 1;
        for(int i = 1; i < section.length; i++) {
            // 아래 내용은 길이가 아닌, 커버 범위를 뜻한다.!!
            // 예로는, m이 4이고, 현재 secetion[i]가 6라면,
            // roller는 2이기 때문에 2,3,4,5를 커버할 수 있게 된다. => 2도 같이 커버해주어야 하므로 -1을 해줌
            // -1을 안해주면 5개나 칠할 수 있으므로, -1을 해주어서 정확한 롤러 계산을 해준다.
            if(roller + m - 1 < section[i]) {
                cnt++;
                roller = section[i];
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(solution(5, 4, new int[]{1, 5}));
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}
